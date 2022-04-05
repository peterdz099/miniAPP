import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Reader{
    public Reader() {
    }

    public JSONArray readFile() {
        JSONArray jsonArray = new JSONArray();
        try {
            JSONParser jsonParser = new JSONParser();
            jsonArray = (JSONArray) jsonParser.parse(new FileReader("data.json"));
            return jsonArray;
        } catch (ParseException | IOException ex) {
            ex.printStackTrace();
        }
        return jsonArray;
    }

    public JSONArray readScores() {
        JSONArray jsonArray = new JSONArray();
        try {
            JSONParser jsonParser = new JSONParser();
            jsonArray = (JSONArray) jsonParser.parse(new FileReader("dataScores.json"));
            return jsonArray;
        } catch (ParseException | IOException ex) {
            ex.printStackTrace();
        }
        return jsonArray;
    }
}
