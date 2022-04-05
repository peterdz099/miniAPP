import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class LoginRegister {
    private Reader reader = new Reader();
    private JSONObject user;
    private Writer writer = new Writer();
    private String message = "PUSTA";

    public String getMessage() {
        return message;
    }

    public boolean letUserIn(String login, String password) {
        boolean finder = false;
        boolean passchecker = false;
        boolean gate = false;
        JSONArray usersList = reader.readFile();

        JSONObject userObj = new JSONObject();
        userObj.put("login", login);
        userObj.put("password", password);
        userObj.put("email", login);

        for (int i = 0; i < usersList.size(); i++) {
            JSONObject o = (JSONObject) usersList.get(i);
            if ((o.get("login")).equals(userObj.get("login")) | (o.get("email")).equals(userObj.get("email"))) {
                finder = true;
                if ((o.get("password")).equals(userObj.get("password"))) {
                    passchecker =false;
                    gate = true;
                }
            }
        }
        if (finder == false) {
            this.message = "User not found.";
        }
        if (finder == true & passchecker == false) {
            this.message = "Wrong password!";
        }
    return gate;
    }

    public boolean isUserCreated(String newLogin, String email, String newPassword, String confirmedPassword){
        boolean newCreated = false;
        JSONArray usersList = reader.readFile();

        if(!newLogin.equals("") & !email.equals("") & !newPassword.equals("") & !confirmedPassword.equals("")){

            for (int i = 0; i < usersList.size(); i++) {
                JSONObject o = (JSONObject) usersList.get(i);
                if (o.get("login").equals(newLogin)) {
                    this.message = "User with this login already exist";
                    return newCreated;
                }
                if (o.get("email").equals(email)){
                    this.message = "This email already exist in our database.";
                    return newCreated;
                }
            }

            if (newPassword.equals(confirmedPassword)){

                JSONObject newUser = new JSONObject();
                    newUser.put("login", newLogin);
                    newUser.put("password", newPassword);
                    newUser.put("email", email);

                writer.writeUser(usersList, newUser);
                newCreated = true;

            }else {
               this.message = "Passwords doesn't match";
            }
        }
        return newCreated;
    }
}
