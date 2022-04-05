import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class TicTactoe extends JPanel implements ActionListener {

    private int screenWidth = 600;
    private int screenHeight = 600;
    private int squareSize = 200;
    private int pressedX;
    private int pressedY;
    private int targetX;
    private int targetY;
    private boolean running;
    private Timer timer;
    private int turn = 0;
    private String whoWon = "X";
    private Image imgO;
    private Image imgX;
    private int[][] board = { {0,11,12}, {13,14,15}, {16,17,18} };


    public TicTactoe(JFrame f) {
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                running = false;
            }
        });
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setBackground(Color.DARK_GRAY);
        setFocusable(true);
        addMouseListener(new MyMouseListener());

        try{
            imgO = ImageIO.read(new File("C:/Users/PITERKE/IdeaProjects/po2021/miniAPP/circllle.png"));
            imgX = ImageIO.read(new File("C:/Users/PITERKE/IdeaProjects/po2021/miniAPP/Ximage.png"));
        }catch (IOException e) {
        }
        startGame();
    }
    public void startGame() {
        running = true;
        timer = new Timer(100,this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        if(running){
            for(int i=0;i<screenWidth/squareSize;i++) {
                g.drawLine(i*squareSize,0, i*squareSize, screenHeight);
                g.drawLine(0, i*squareSize, screenWidth, i*squareSize);
            }

            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    int y = i*squareSize + squareSize/2;
                    int x = j*squareSize + squareSize/2;
                    if(board[i][j] == 1){
                        g.drawImage(imgX, x - 63, y - 41, null);
                    }
                    if(board[i][j] == 2){
                        g.drawImage(imgO, x -50 , y -50, null);
                    }
                }
            }
        }
        else {
            gameOver(g);
        }
    }
    public void gameOver(Graphics g){
        g.setColor(Color.white);
        g.setFont( new Font("Arial",Font.BOLD, 40));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString(" "+ whoWon+" Wins! ", (screenWidth - metrics2.stringWidth("Game Over"))/2, screenHeight /2);
    }
    public void printX(int x, int y){
        if(0 < x && x <= 200){
            targetX = 0;
        }
        if(200 < x && x <= 400){
            targetX = 1;
        }
        if(400 < x && x <= 600){
            targetX = 2;
        }
        if(0 < y && y <= 200){
            targetY = 0;
        }
        if(200 < y && y <= 400){
            targetY = 1;
        }
        if(400 < y && y <= 600){
            targetY = 2;
        }
        if(board[targetY][targetX] != 2){
            board[targetY][targetX] = 1;
            turn += 1;
        }
    }
    public void printO(int x, int y){
        if(0 < x && x <= 200){
            targetX = 0;
        }
        if(200 < x && x <= 400){
            targetX = 1;
        }
        if(400 < x && x <= 600){
            targetX = 2;
        }
        if(0 < y && y <= 200){
            targetY = 0;
        }
        if(200 < y && y <= 400){
            targetY = 1;
        }
        if(400 < y && y <= 600){
            targetY = 2;
        }
        if(board[targetY][targetX] != 1){
            board[targetY][targetX] = 2;
            turn += 1;
        }
    }

    public void checkBoard() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                if(board[i][0]==2){
                    whoWon="O";
                }
                running=false;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                if(board[0][i]==2){
                    whoWon="O";
                }
                running=false;
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]){
            if(board[0][0]==2){
                whoWon="O";
                }
            running =false;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]){
            if(board[0][0]==2){
                whoWon="O";
                }
            running =false;
        }
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(running){
            checkBoard();
        }
        repaint();
    }
    public class MyMouseListener extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e){
            pressedX = e.getX();
            pressedY = e.getY();
            if(turn % 2 == 0) {
                printX(pressedX, pressedY);
            }
            if(turn % 2 == 1){
                printO(pressedX, pressedY);
            }
        }
    }
}
