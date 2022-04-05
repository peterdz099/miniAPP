import javax.swing.*;

public class SnakeGUI extends JFrame {
    private JPanel snakeGUI;
    private JButton closeButton;
    private JPanel gamehere;
    private SnakeGame jpanel;

    public SnakeGUI(Userclass user) {
        jpanel = new SnakeGame(user,this);
        add(jpanel);
        jpanel.startGame();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Snake");
        setResizable(false);
        this.pack();
        this.setVisible(true);
    }

}
