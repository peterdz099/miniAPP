import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogGUI extends JFrame{

    private JPasswordField passwordField1;
    private JButton loginButton;
    private JButton newUserButton;
    private JPanel logGUI;
    private JTextField textField1;
    private JLabel lbl;
    private LoginRegister logger = new LoginRegister();

    public JPanel getLogGUI() {
        return logGUI;
    }

    public LogGUI(JFrame f) {
        newUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setContentPane(new RegisterGUI(f).getRegisterGUI());
                f.revalidate();
                f.repaint();
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String log = textField1.getText();
                String pass = String.valueOf(passwordField1.getPassword());
                if(!log.equals("") & !pass.equals("")) {
                    if (logger.letUserIn(log, pass)) {
                        Userclass user = new Userclass(log);
                        f.setContentPane(new GamesGUI(f, user).getGamesGUI());
                        f.revalidate();
                        f.repaint();
                    } else {
                        lbl.setText(logger.getMessage());
                        lbl.setVisible(true);
                        textField1.setText("");
                        passwordField1.setText("");
                    }
                }
            }
        });
    }
}



