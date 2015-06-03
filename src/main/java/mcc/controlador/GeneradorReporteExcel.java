package mcc.controlador;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mcc.beans.Reparaciones;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class GeneradorReporteExcel extends AbstractExcelView {

	private List<String> construirTitulos(){
		List<String> titulosList= new ArrayList<String>();
		titulosList.add("Id Reparacion");
		titulosList.add("Tipo de equipo");
		titulosList.add("Responsable Equipo");
		titulosList.add("Fecha de Reparacion");
		return titulosList;
	}
	
	private CellStyle construirEstiloTitulo(HSSFWorkbook wb){
		CellStyle style;
        Font titleFont = wb.createFont();
        titleFont.setFontHeightInPoints((short)18);
        titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFont(titleFont);
        return style;
	}
	
	private CellStyle construirEstiloHeader(HSSFWorkbook wb){
		CellStyle style;
		Font monthFont = wb.createFont();
        monthFont.setFontHeightInPoints((short)11);
        monthFont.setColor(IndexedColors.WHITE.getIndex());
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFont(monthFont);
        style.setWrapText(true);
        return style;
	}
	private CellStyle construirEstiloCelda(HSSFWorkbook wb)
	{
		CellStyle style;
		style = wb.createCellStyle();
	    style.setAlignment(CellStyle.ALIGN_CENTER);
	    style.setWrapText(true);
	    style.setBorderRight(CellStyle.BORDER_THIN);
	    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
	    style.setBorderLeft(CellStyle.BORDER_THIN);
	    style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
	    style.setBorderTop(CellStyle.BORDER_THIN);
	    style.setTopBorderColor(IndexedColors.BLACK.getIndex());
	    style.setBorderBottom(CellStyle.BORDER_THIN);
	    style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
	    return style;
	}
	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest arg2, HttpServletResponse arg3)
			throws Exception {
		@SuppressWarnings("unchecked")
		List<Reparaciones> reparacionesList = (List<Reparaciones>) model.get("reparacionesList");
		HSSFSheet sheet = workbook.createSheet("INVENTARIOS");
		
	    
	    Row titleRow = sheet.createRow(0);
        titleRow.setHeightInPoints(45);
        Cell titleCell = titleRow.createCell(0);
        titleCell.setCellValue("Reporte Reparaciones");
        titleCell.setCellStyle(construirEstiloTitulo(workbook));
        sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$D$1"));
        
        Row headerRow = sheet.createRow(1);
        headerRow.setHeightInPoints(40);
        Cell headerCell;
        int i=0;
        CellStyle estiloHeader =construirEstiloHeader(workbook);
        for(String titulo: this.construirTitulos())
        {
            headerCell = headerRow.createCell(i);
            headerCell.setCellValue(titulo);
            headerCell.setCellStyle(estiloHeader);
            sheet.setColumnWidth(i, 5000);

            i++;
		
        }
        CellStyle estiloCelda =  construirEstiloCelda(workbook);
        int rownum = 2;
        	for(Reparaciones reparaciones : reparacionesList){
            	 Row row = sheet.createRow(rownum++);
            	 Cell celdaIdEquipo = row.createCell(0);
            	 celdaIdEquipo.setCellValue(reparaciones.getIdReparaciones());
            	 celdaIdEquipo.setCellStyle(estiloCelda);
            	 
            	 Cell celdaIdEquipo1 = row.createCell(1);
            	 celdaIdEquipo1.setCellValue(reparaciones.getEquipos().getTipo());
            	 celdaIdEquipo1.setCellStyle(estiloCelda);
            	 
             	 Cell celdaIdEquipo2 = row.createCell(2);
            	 celdaIdEquipo2.setCellValue(reparaciones.getUsuario().getNombre()+ " "+reparaciones.getUsuario().getApellido());
            	 celdaIdEquipo2.setCellStyle(estiloCelda);
            	 SimpleDateFormat simpleDateFormatFecha = 
            	            new SimpleDateFormat( "dd 'de' MMMM 'de' yyyy",new Locale("es"));
            	 
            	 Cell celdaIdEquipo3 = row.createCell(3);
            	 celdaIdEquipo3.setCellValue(simpleDateFormatFecha.format(reparaciones.getFechaReparacion().getTime()));
            	 celdaIdEquipo3.setCellStyle(estiloCelda);
        	}
	}
 
}
