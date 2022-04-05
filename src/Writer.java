import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    private Reader reader = new Reader();

    public Writer() {
    }

    public void writeUser(JSONArray usersList, JSONObject newUser ){

        usersList.add(newUser);
        try {
            FileWriter file = new FileWriter("data.json");
            file.write(usersList.toJSONString());
            file.flush();
            file.close();

        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public void writeScores(String login, int scoreP,int scoreMM, int scoreSnake){
        JSONArray usersToWrite = reader.readScores();
        JSONObject userObj = new JSONObject();
        boolean isThere =false;

        for (int i = 0; i < usersToWrite.size(); i++) {
            JSONObject o = (JSONObject) usersToWrite.get(i);
            if (o.get("login").equals(login)) {
                userObj = o;
                isThere = true;
            }
        }
        if(!isThere) {
            userObj.put("login", login);
            userObj.put("scoreP", String.valueOf(scoreP));
            userObj.put("scoreMM", String.valueOf(scoreMM));
            userObj.put("scoreSnake", String.valueOf(scoreSnake));
            usersToWrite.add(userObj);
        }

        if(isThere){
            userObj.remove("scoreP");
            userObj.remove("scoreSnake");
            userObj.remove("scoreMM");
            userObj.put("scoreP", String.valueOf(scoreP));
            userObj.put("scoreMM", String.valueOf(scoreMM));
            userObj.put("scoreSnake", String.valueOf(scoreSnake));
        }

        try {
            FileWriter file = new FileWriter("dataScores.json");
            file.write(usersToWrite.toJSONString());
            file.flush();
            file.close();

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
