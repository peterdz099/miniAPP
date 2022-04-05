import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterGUI extends JFrame {

    private JPanel registerGUI;
    private JTextField textField1;
    private JTextField textField2;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton registerButton;
    private JLabel txt;
    private JButton cancelButton;
    private JPanel form;
    private LoginRegister registertool = new LoginRegister();

    public JPanel getRegisterGUI() {
        return registerGUI;
    }

    public JPanel getForm(){
        return form;
    }

    public RegisterGUI(){

    }

    public RegisterGUI(JFrame f) {
        registerButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String newLogin = textField1.getText();
                String email = textField2.getText();
                String newPassword = String.valueOf(passwordField1.getPassword());
                String confirmedPassword = String.valueOf(passwordField2.getPassword());

                if(registertool.isUserCreated(newLogin,email,newPassword,confirmedPassword)){

                    f.setContentPane(new LogGUI(f).getLogGUI());
                    f.revalidate();
                    f.repaint();

                }else{
                    textField1.setText("");
                    textField2.setText("");
                    passwordField1.setText("");
                    passwordField2.setText("");
                    txt.setText(registertool.getMessage());
                    txt.setVisible(true);
                }
            }
        });
        cancelButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                    f.setContentPane(new LogGUI(f).getLogGUI());
                    f.revalidate();
                    f.repaint();
            }
        });
    }
}