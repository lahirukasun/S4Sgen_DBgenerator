package s4sgen_DBgen_algo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class get_sample_db {

    public static void main(String[] args) throws IOException, ParseException {
        get_sample_db1();
    }

    public static void get_sample_db1() throws IOException, ParseException {
        String create_sample_db1 = create_sample_db.create_sample_db1();
        char t[] = create_sample_db1.toCharArray();
        int no = 0;
        for (int i = 0; i < t.length; i++) {
            if (t[i] == '+') {
                no++;
                System.out.println(i);
            }
        }
        String arr[] = new String[++no];
        arr = create_sample_db1.split("\\+");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }

        try {

            FileReader reader = new FileReader("G:\\S4Sgen\\DBgenerator\\json\\aish.json");

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            String lName = (String) jsonObject.get("last_name");
            String gender = (String) jsonObject.get("gender");

            if (lName.equals("false")) {
                System.out.println(lName);

                Path path = Paths.get("G:\\S4Sgen\\DBgenerator\\Sample-SQL-File-10-Rows.sql");
                Charset charset = StandardCharsets.UTF_8;

                String content = new String(Files.readAllBytes(path), charset);

                if (content.contains("last_name")) {

                    System.out.println("up to now....");

                    content = content.replaceAll("last_name", "--");
                    Files.write(path, content.getBytes(charset));

                }

            }
            if (gender.equals("false")) {
                System.out.println(gender);

                Path path = Paths.get("G:\\S4Sgen\\DBgenerator\\Sample-SQL-File-10-Rows.sql");
                Charset charset = StandardCharsets.UTF_8;

                String content = new String(Files.readAllBytes(path), charset);

                if (content.contains("gender")) {

                    System.out.println("up to now....");

                    content = content.replaceAll("gender", "--");
                    Files.write(path, content.getBytes(charset));

                }

            }

        } catch (FileNotFoundException ex) {
        } catch (IOException | ParseException ex) {
        }
    }
}
