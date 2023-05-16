package AutomationFramework.DataProvider;

import day14.ExcelRW;

import java.io.IOException;

public class Dp_commons {
    public static Object[][] getDataByScript(String Sheetname, String ScriptName) throws IOException {

        ExcelRW excelRW = new ExcelRW("D:\\\\New folder\\\\code\\\\awq.xlsx");
        int irows = excelRW.getRowCount(Sheetname);
        int icols = excelRW.getColumnCount(Sheetname);
        int count = 0;
        //        find the number of rows required
        for (int ireq_row = 1; ireq_row <= irows; ireq_row++) {
            if (excelRW.readCellValue(Sheetname, ireq_row, 1).equals(ScriptName)) {
                count++;
            }
        }
        Object[][] objarr = new Object[count][icols];
        int rowindex = 0;
        //        iterate through each row
        for (int irow = 1; irow <= irows; irow++) {
            if (excelRW.readCellValue(Sheetname, irow, 1).equals(ScriptName)) {
                //            iterate through each column
                for (int icol = 0; icol < icols; icol++) {
                    objarr[rowindex][icol] = excelRW.readCellValue(Sheetname, irow, icol);

                }
                rowindex++;
            }
        }
        return objarr;
    }
}
