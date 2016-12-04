package com.nortal.assignment;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Joosep Lall.
 */
@Component
@EnableScheduling
public class ScheduledTasks {
    private static final Logger LOG = LoggerFactory.getLogger(ScheduledTasks.class);

    private HttpClient client = HttpClientBuilder.create().build();
    private HttpGet mazePieceRequest = new HttpGet("http://localhost:8080/maze");

    /**
     * TODO: This method should be executed periodically with fixed delay of at least 1 second
     * Spring Scheduler should be used to achieve this
     */
    @Scheduled(fixedDelay = 2000)
    public void getCoordinatesCombination() throws IOException, InvalidFormatException {
        HttpResponse response = client.execute(mazePieceRequest);
        InputStream content = response.getEntity().getContent();
        File mazeMap = new File("java-framework-scheduler-rest/maze-mapper/src/main/java/com/nortal/assignment/maze-map.xlsx");
        mapCoordinatesToExcel(content, mazeMap);
        content.close();
    }

    /**
     * Parse REST response body and mark cells in provided mazeMap Excel file
     * The algorithm to mark the cells could be following
     * <ol>
     *     <li>Load workbook</li>
     *     <li>For each cell reference in responseBody find cell in sheet (create if missing)</li>
     *     <li>Set cell style obtained from createCellStyle()</li>
     * </ol>
     *
     * @param responseBody - comma separated Excel cell references (A1, B3, V5, etc.)
     *                     References are within A1:Z100
     * @param mazeMap      - xlsx file reference where map should be created
     */
    private void mapCoordinatesToExcel(InputStream responseBody, File mazeMap) throws IOException, InvalidFormatException {
        String responseString = IOUtils.toString(responseBody);
        LOG.info("Writing map piece {} to file {}", responseString, mazeMap.getAbsolutePath());
        List<String> cells = Arrays.asList(responseString.split(","));
        XSSFWorkbook workbook = new XSSFWorkbook (new FileInputStream(mazeMap));
        XSSFSheet sheet = workbook.getSheetAt(0);

        XSSFCellStyle style = createCellStyle(workbook);
        addDataToCells(sheet, cells, style);
        writeDataToExcel(mazeMap, workbook);
    }

    /**
     * Method that writes new data to excel file.
     * */
    private void writeDataToExcel(File mazeMap, XSSFWorkbook workbook) {
        try {
            FileOutputStream output_file = new FileOutputStream(mazeMap);
            workbook.write(output_file);
            workbook.close();
            System.out.println("Excel written successfully..");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Method that marks cells in sheet
     * */
    private void addDataToCells(XSSFSheet sheet, List<String> cells, XSSFCellStyle style) {
        for (String cell : cells) {
            int rowNumber = Integer.parseInt(cell.substring(1));
            int column = cell.charAt(0)-65;
            Row row = sheet.getRow(rowNumber);
            if (row == null) {
                row = sheet.createRow(rowNumber);
            }
            Cell cellToInsert = row.getCell(column);
            if (cellToInsert == null) {
                cellToInsert = row.createCell(column);
                cellToInsert.setCellStyle(style);
            }
            setRowHeight(row);
            setColumnWidth(sheet, (short)column);
        }
    }

    /**
     * Cells should be marked with the following style
     */
    private XSSFCellStyle createCellStyle(XSSFWorkbook workbook) {
        XSSFCellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.BLACK.getIndex());
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        return style;
    }

    /**
     * Sets Column to proper width so that maze would look nice. Call whenever seems appropriate.
     */
    private void setColumnWidth(XSSFSheet sheet, short columnIndex) {
        sheet.setColumnWidth(columnIndex, 3 * 256);
    }

    /**
     * Sets Row to proper height so that maze would look nice. Call whenever seems appropriate.
     */
    private void setRowHeight(Row row) {
        row.setHeightInPoints(15);
    }

}
