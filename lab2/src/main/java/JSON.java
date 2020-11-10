import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class JSON {
    public static String getDataFromFile(String src) {
        StringBuilder jsonStrBuilder = new StringBuilder();
        Scanner inputScanner;
        try{
            inputScanner = new Scanner(new FileReader(src));
            while(inputScanner.hasNext()) {
                jsonStrBuilder.append(inputScanner.next()).append(" ");  // Цикл чтения из файла
            }
            inputScanner.close();
        }
        catch(FileNotFoundException e){
            System.err.println(e.toString());
        }
        return jsonStrBuilder.toString();
    }

    public static JSONObject getJSON(String data) {
        JSONParser jsonParser = new JSONParser();
        JSONObject resultJson = new JSONObject();
        try {
            resultJson = (JSONObject) jsonParser.parse(data);
        } catch (ParseException e) {
            System.err.println(e.toString());
        }
        return resultJson;
    }
}
