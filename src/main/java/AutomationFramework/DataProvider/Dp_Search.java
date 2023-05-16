package AutomationFramework.DataProvider;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class Dp_Search {
//    @DataProvider(name = "invalidLogin")
//    public static Object[][] getInvalidLoginData() throws IOException {
//        return getDataByScript("Login", "invalid_login");
//    }

    @DataProvider(name = "invalidSearch")
    public static Object[][] getInValidSearchData() throws IOException {
        return Dp_commons.getDataByScript("Search", "invalid_search");
    }
    @DataProvider(name="validSearch")
    public static Object[][] getValidSearchData() throws IOException {
        return Dp_commons.getDataByScript("Search", "valid_search");
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





