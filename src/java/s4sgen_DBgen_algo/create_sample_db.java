package s4sgen_DBgen_algo;

import java.io.BufferedReader;
import java.io.FileReader;

public class create_sample_db {


    public static String create_sample_db1() {
        try {
            BufferedReader in = new BufferedReader(new FileReader("G:\\S4Sgen\\DBgenerator\\Sample-SQL-File-10-Rows.sql"));
            String str;
            String qry = "";
            StringBuffer sb = new StringBuffer();
            while ((str = in.readLine()) != null) {
                    int a = str.length();
                    sb.append(str + "\n ");
                    if(str.charAt(a-1) == ';'){
                        if(qry != ""){
                            qry =sb.toString()+ "+"+ qry  ;
                        }else{
                            qry = sb.toString();
                        }
                        sb = new StringBuffer() ;
//                        System.out.println(""+qry);
                    }   
            }
            in.close();
            return qry;
        } catch (Exception e) {
            System.err.println("Failed to Execute. The error is" + e.getMessage());
        }
    return "";
}
}
