import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeaderBoardGUI {
    private JPanel leaderboardPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton snakeButton;
    private JButton MMGameButton;
    private JButton closeButton;
    private JTextField textField5;
    private JTextField textField6;
    private LeaderBoardHelper leaders = new LeaderBoardHelper();

    public JPanel getLeaderboardPanel() {
        return leaderboardPanel;
    }

    public LeaderBoardGUI(JFrame f, Userclass user) {

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setContentPane(new GamesGUI(f,user).getGamesGUI());
                f.revalidate();
                f.repaint();
            }
        });
        MMGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("MMGame Scores");
                leaders.mmGameLeaders(textField2,textField3,textField4,textField5,textField6);

            }
        });

        snakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("Snake Scores");
                leaders.snakeLeaders(textField2,textField3,textField4,textField5,textField6);
            }
        });
    }
}
