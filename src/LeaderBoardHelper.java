import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;


public class LeaderBoardHelper {

    private Reader reader = new Reader();
    private JSONArray usersList = new JSONArray();

    public LeaderBoardHelper() {

    }
    public void snakeLeaders(JTextField t1, JTextField t2, JTextField t3, JTextField t4, JTextField t5){
        usersList = reader.readScores();
        System.out.println(usersList.toJSONString());
        String[] messages = {"", "", "", "",""};
        ArrayList<Integer> snakeScores = new ArrayList<Integer>();


        for (int i = 0; i < usersList.size(); i++) {
            JSONObject o = (JSONObject) usersList.get(i);
            snakeScores.add(Integer.parseInt((String)o.get("scoreSnake")));
            }
        Collections.sort(snakeScores);
        Collections.reverse(snakeScores);

        System.out.println(snakeScores);
        if(snakeScores.size()>5) {
            for (int j = 0; j < 5; j++) {
                for (int i = 0; i < usersList.size(); i++) {
                    JSONObject o = (JSONObject) usersList.get(i);
                    if (String.valueOf(snakeScores.get(j)).equals((String) o.get("scoreSnake"))) {
                        messages[j] = String.valueOf(j+1)+ ". " + o.get("login") + " " + "score: " + String.valueOf(snakeScores.get(i));
                        System.out.println(messages[j]);
                    }
                }
            }
        }
        if(snakeScores.size() <5){
            for (int j = 0; j < snakeScores.size(); j++) {
                for (int i = 0; i < usersList.size(); i++) {
                    JSONObject o = (JSONObject) usersList.get(i);
                    if (String.valueOf(snakeScores.get(j)).equals((String) o.get("scoreSnake"))) {
                        messages[j] = String.valueOf(j+1)+ ". " + o.get("login") + " " + "score: " + String.valueOf(snakeScores.get(i));
                        System.out.println(messages[j]);
                    }
                }
            }
        }
        t1.setText(messages[0]);
        t2.setText(messages[1]);
        t3.setText(messages[2]);
        t4.setText(messages[3]);
        t5.setText(messages[4]);
    }

    public void mmGameLeaders(JTextField t1, JTextField t2, JTextField t3, JTextField t4, JTextField t5){
        usersList = reader.readScores();
        System.out.println(usersList.toJSONString());
        String[] messages = {"", "", "", "",""};
        ArrayList<Integer> mmScores = new ArrayList<Integer>();


        for (int i = 0; i < usersList.size(); i++) {
            JSONObject o = (JSONObject) usersList.get(i);
            mmScores.add(Integer.parseInt((String)o.get("scoreMM")));
        }
        Collections.sort(mmScores);
        Collections.reverse(mmScores);


        if(mmScores.size()>5) {
            for (int j = 0; j < 5; j++) {
                for (int i = 0; i < usersList.size(); i++) {
                    JSONObject o = (JSONObject) usersList.get(i);
                    if (String.valueOf(mmScores.get(j)).equals((String) o.get("scoreMM"))) {
                        messages[j] = String.valueOf(j+1)+ ". " + o.get("login") + " " + "score: " + String.valueOf(mmScores.get(i));
                        System.out.println(messages[j]);
                    }
                }
            }
        }
        if(mmScores.size() <5){
            for (int j = 0; j < mmScores.size(); j++) {
                for (int i = 0; i < usersList.size(); i++) {
                    JSONObject o = (JSONObject) usersList.get(i);
                    if (String.valueOf(mmScores.get(j)).equals((String) o.get("scoreMM"))) {
                        messages[j] = String.valueOf(j+1)+ ". " + o.get("login") + " " + "score: " + String.valueOf(mmScores.get(i));
                    }
                }
            }
        }
        t1.setText(messages[0]);
        t2.setText(messages[1]);
        t3.setText(messages[2]);
        t4.setText(messages[3]);
        t5.setText(messages[4]);
    }
}

