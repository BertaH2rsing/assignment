package com.nortal.assignment;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
    public void getCoordinatesCombination() throws IOException {
        HttpResponse response = client.execute(mazePieceRequest);
        InputStream content = response.getEntity().getContent();

        File mazeMap = new File("maze-map.xlsx");
        mapCoordinatesToExcel(content, mazeMap);
        System.out.println(content);
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
    private void mapCoordinatesToExcel(InputStream responseBody, File mazeMap) throws IOException {
        String responseString = IOUtils.toString(responseBody);
        LOG.info("Writing map piece {} to file {}", responseString, mazeMap.getAbsolutePath());
        List<String> cells = Arrays.asList(responseString.split(","));
        for (int i = 0; i < cells.size(); i++) {
            System.out.println(cells.get(i));
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
