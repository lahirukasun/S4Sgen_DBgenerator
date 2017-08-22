
package s4sgen_DBgen_algo;


public class save_generated_db {
    
    public static void main(String[] args) {
        readDBQuery();
    }
    
    
    
    public static void readDBQuery(){
     String create_sample_db1 = create_sample_db.create_sample_db1();
        char t[] = create_sample_db1.toCharArray();
        int no = 0;
        for (int i = 0; i < t.length; i++) {
            if (t[i] == '+') {
                no++;
            }
        }
        String arr[] = new String[++no];
        arr = create_sample_db1.split("\\+");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
