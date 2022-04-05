import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class MuscleMemoryGame extends JPanel implements ActionListener {

    private int screenWidth = 1020;
    private int screenHeight = 600;
    private int squareSize = 30;
    private int squares = (screenWidth * screenHeight)/(squareSize * squareSize);
    private int delay = 600;
    private int pressedX;
    private int pressedY;
    private int score = 0;
    private int pointX;
    private int pointY;
    private boolean running = false;
    private Timer timer;
    private Random random;
    private Userclass userMMGame;
    private int pointCounter;

    public void setRunning(boolean running) {
        this.running = running;
    }

    MuscleMemoryGame(Userclass user, JFrame f){
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                running = false;
            }
        });
        userMMGame = user;
        random = new Random();
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setBackground(Color.DARK_GRAY);
        setFocusable(true);
        addMouseListener(new MyMouseListener());
    }

    public void startGame() {
        newPoint();
        running = true;
        timer = new Timer(delay,this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g) {
        if(running) {
			for(int i=0;i<screenWidth/squareSize;i++) {
				g.drawLine(i*squareSize,0, i*squareSize, screenHeight);
				g.drawLine(0, i*squareSize, screenWidth, i*squareSize);
			}

            g.setColor(Color.orange);
            g.fillOval(pointX, pointY, squareSize, squareSize);

            g.setColor(Color.white);
            g.setFont( new Font("Arial",Font.BOLD, 15));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: "+score, 1000 -metrics.stringWidth("Score: " + score), g.getFont().getSize());
        }
        else {
            gameOver(g);
        }

    }

    public void pointChecker(){
        if(pointX <= pressedX && pressedX <= pointX + 30){
            if(pointY <= pressedY & pressedY <= pointY + 30){
                score += 1;
                newPoint();
                repaint();
            }
        }
    }

    public void gameEndListener(){
        if(pointCounter > 100){
            running = false;
        }
        if(!running){
            if (score > userMMGame.getScoreSnake()) {
                userMMGame.setScoreMMGame(score);
                userMMGame.writeScores();
            }
        }
    }

    public void newPoint(){
        pointX = random.nextInt((int)(screenWidth / squareSize))* squareSize;
        pointY = random.nextInt((int)(screenHeight / squareSize))* squareSize;
        pointCounter += 1;
    }

    public void gameOver(Graphics g) {
        g.setColor(Color.white);
        g.setFont( new Font("Arial",Font.BOLD, 40));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (screenWidth - metrics2.stringWidth("Game Over"))/2, screenHeight /2);

        g.setColor(Color.white);
        g.setFont( new Font("Arial",Font.BOLD, 15));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Your Score: "+ score, (screenWidth - metrics1.stringWidth("Your Score: "+score))/2, screenHeight/2+30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running){
            pointChecker();
            newPoint();
            gameEndListener();
        }
        repaint();
    }


    public class MyMouseListener extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e){
            pressedX = e.getX();
            pressedY = e.getY();
        }
    }
}
