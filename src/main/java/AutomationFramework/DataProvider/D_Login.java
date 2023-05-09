package AutomationFramework.DataProvider;


import AutomationFramework.commons.ExcelRW;
import org.testng.annotations.DataProvider;

import java.io.IOException;
public class D_Login {
    @DataProvider(name = "invalidLogin")
    public static Object[][] getInvalidLoginData() throws IOException {
        return getDataByScript("Login", "invalid_login");
    }

    @DataProvider(name = "validLogin")
    public static Object[][] getValidLoginData() throws IOException {
        return getDataByScript("Login", "valid_login");
    }

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
//    public static int getRowCountBasedonScriptName(ExcelRW excelRW,String Sheetname,String ScriptName){
//        int count=0;
//        int irows = excelRW.getRowCount(Sheetname);
//        //        find the number of rows required
//
//        for(int ireq_row=1;ireq_row<=irows;ireq_row++){
//            if (excelRW.readCellValue(Sheetname,ireq_row,1).equals(ScriptName)){
//                count++;            }      }    return count;    }
//    public static Object[][] getObjArray(ExcelRW excelRW, String Sheetname, String ScriptName, Object[][] objarr){
//        int rowindex=0;
//        int irows = excelRW.getRowCount(Sheetname);
//        int icols=excelRW.getColumnCount(Sheetname);
//
//        //        iterate through each row
//
//        for(int irow=1;irow<=irows;irow++){
//
//
//            if (excelRW.readCellValue(Sheetname,irow,1).equals(ScriptName))
//            {
//                //       iterate through each column
//                for(int icol=0;icol<icols;icol++){
//                    objarr[rowindex][icol]=excelRW.readCellValue(Sheetname,irow,icol);
//                }
//
//                rowindex++;
//            }
//        }
//        return objarr;
//    }
//}
//
//
//





