package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class QueryParser {

    public static JSONObject callQuery(String query){
        InputStream input;

        try{
            input = new URL(query).openStream();
        } catch (Exception e){
            System.out.println("No connection");
            return null;
        }

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject;

        try {
            jsonObject = (JSONObject) jsonParser.parse(
                    new InputStreamReader(input, "UTF-8"));
        } catch (Exception e){
            System.out.println("JSON object improperly formed.");
            return null;
        }
        return jsonObject;
    }
}
