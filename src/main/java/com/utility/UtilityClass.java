package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilityClass {

    private static final String data_file_path = "C:\\Users\\indum\\eclipse-workspace\\Assignment\\resources\\Datas.xlsx";

    private Map<String, String> loadData() throws IOException {

        Map<String, String> configMap = new HashMap<>();

        try (FileInputStream file = new FileInputStream(data_file_path);

             Workbook workbook = new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {

                Cell keyCell = row.getCell(0);
                Cell valueCell = row.getCell(1);

                if (keyCell != null && valueCell != null) {

                    String key = getCellValueAsString(keyCell);
                    String value = getCellValueAsString(valueCell);

                    configMap.put(key, value);
                }
            }
        }

        return configMap;
    }

    private String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }

        String cellValue = "";
        
        switch (cell.getCellType()) {
            case STRING:
                cellValue = cell.getStringCellValue().trim();
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    
                    cellValue = cell.getDateCellValue().toString();
                } else {
                    
                    cellValue = String.format("%.0f", cell.getNumericCellValue()).trim();
                }
                break;
            case BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue()).trim();
                break;
            default:
                cellValue = "";
                break;
        }

        return cellValue;
    }


    private String getDataValue(String fieldName) throws IOException {
        Map<String, String> configMap = loadData();
        return configMap.getOrDefault(fieldName, "Field not found");
    }

    public String getCurrentAge() throws IOException {
        return getDataValue("Current Age");
    }

    public String getRetirementAge() throws IOException {
        return getDataValue("Retirement Age");
    }

    public String getCurrentAnnualIncome() throws IOException {
        return getDataValue("Current annual income");
    }

    public String getSpouseAnnualIncome() throws IOException {
        return getDataValue("Spouse’s annual income");
    }

    public String getCurrentRetirementSavings() throws IOException {
        return getDataValue("Current retirement savings");
    }

    public String getCurrentRetirementContribution() throws IOException {
        return getDataValue("Current retirement contribution");
    }

    public String getAnnualRetirementContributionIncrease() throws IOException {
        return getDataValue("Annual retirement contribution increase");
    }

    public String getSocialSecurityIncome() throws IOException {
        return getDataValue("Social Security Income");
    }

    public String getRelationshipStatus() throws IOException {
        return getDataValue("Relationship status");
    }

    public String getSocialSecurityOverride() throws IOException {
        return getDataValue("Social Security Override");
    }
    
    public String getAdditionalIncome() throws IOException {
        return getDataValue("Additional/other income");
    }
    
    public String getNoYrs() throws IOException {
        return getDataValue("Number of years retirement needs to last");
    }
    
    public String getExpectedInflation() throws IOException {
        return getDataValue("Expected inflation rate");
    }
    
    public String getFinalIncome() throws IOException {
        return getDataValue("Percent of final annual income desired");
    }
    
    public String getPreRetire() throws IOException {
        return getDataValue("Pre-retirement investment return");
    }
    
    public String getPostRetireInv() throws IOException {
        return getDataValue("Post-retirement investment return");
    }

}
