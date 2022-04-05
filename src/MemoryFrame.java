import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MemoryFrame extends JFrame {
    private MuscleMemoryGame jpanel;
    public MemoryFrame(Userclass user){
        jpanel = new MuscleMemoryGame(user,this);
        add(jpanel);
        jpanel.startGame();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Muscle Memory Game");
        setResizable(false);
        this.pack();
        this.setVisible(true);
    }
}
