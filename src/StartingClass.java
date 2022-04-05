import javax.swing.*;

public class StartingClass extends Thread {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setContentPane(new LogGUI(f).getLogGUI());
        f.setTitle("minigamesAPPP");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
    }
}
