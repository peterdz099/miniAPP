import javax.swing.*;

public class TicTacToeFrame extends JFrame{
    public TicTacToeFrame() {
        add(new TicTactoe(this));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Tic Tac Toe");
        setResizable(false);
        this.pack();
        this.setVisible(true);
    }

}
