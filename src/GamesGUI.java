import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GamesGUI extends JFrame {
    private JPanel gamesGUI;
    private JButton logOutButton;
    private JButton leaderboardButton;
    private JButton muscleMemoryGameButton;
    private JButton snakeButton;
    private JButton ticTacToeButton;
    private JButton commingSoonButton;
    private JLabel helloLBL;
    private boolean canILogout = true;

    public JPanel getGamesGUI() {
        return gamesGUI;
    }

    public GamesGUI(JFrame f, Userclass user){
        helloLBL.setText(" Hello " + user.getLogin() + "!");

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(canILogout){
                    f.setContentPane(new LogGUI(f).getLogGUI());
                    f.revalidate();
                    f.repaint();
                }
            }
        });
        leaderboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    f.setContentPane(new LeaderBoardGUI(f,user).getLeaderboardPanel());
                    f.revalidate();
                    f.repaint();
            }
        });

        snakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canILogout = false;
                JFrame snakeGame = new SnakeGUI(user);
                snakeGame.pack();
                snakeGame.setVisible(true);
                snakeGame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        canILogout = true;
                    }
                });
            }
        });
        muscleMemoryGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canILogout = false;
                JFrame mmGame = new MemoryFrame(user);
                mmGame.pack();
                mmGame.setVisible(true);
                mmGame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        canILogout = true;
                    }
                });
            }
        });
        ticTacToeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame tttGame = new TicTacToeFrame();
                tttGame.pack();
                tttGame.setVisible(true);
                tttGame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        canILogout = true;
                    }
                });

            }
        });
    }
}


