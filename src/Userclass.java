import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Userclass extends Thread {
    private String login;
    private int scoreP = 0;
    private int scoreMMGame = 0;
    private int scoreSnake = 0;
    private Reader reader = new Reader();
    private Writer writer = new Writer();

    public String getLogin() {
        return login;
    }

    public int getScoreP() {
        return scoreP;
    }

    public int getScoreMMGame() {
        return scoreMMGame;
    }

    public int getScoreSnake() {
        return scoreSnake;
    }

    public void setScoreP(int scoreP) {
        this.scoreP = scoreP;
    }

    public void setScoreMMGame(int scoreMMGame) {
        this.scoreMMGame = scoreMMGame;
    }

    public void setScoreSnake(int scoreSnake) {
        this.scoreSnake = scoreSnake;
    }

    public void writeScores(){
        writer.writeScores(login,scoreP, scoreMMGame,scoreSnake);
    }

    public void setScores(String login){
        JSONArray usersList = reader.readScores();
        for (int i = 0; i < usersList.size(); i++) {
            JSONObject o = (JSONObject) usersList.get(i);
            if (o.get("login").equals(login)) {
                this.scoreMMGame = Integer.parseInt((String)o.get("scoreMM"));
                this.scoreP = Integer.parseInt((String)o.get("scoreP"));
                this.scoreSnake = Integer.parseInt((String)o.get("scoreSnake"));
            }
        }
    }

    public void printScores(){
        System.out.println(this.scoreP);
        System.out.println(this.scoreMMGame);
        System.out.println(this.scoreSnake);
    }

    public Userclass(String login) {
        this.login = login;
        setScores(login);
    }
}


