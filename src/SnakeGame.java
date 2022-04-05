import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SnakeGame extends JPanel implements ActionListener {
    private int screenWidth = 400;
    private int screenHeight = 400;
    private int squareSize = 10;
    private int squares = (screenWidth * screenHeight)/(squareSize * squareSize);
    private int delay = 160;
    private int x[] = new int[squares];
    private int y[] = new int[squares];
    private int bodyParts = 5;
    private int applesEaten;
    private int buffX;
    private int buffY;
    private char direction = 'R';
    private boolean running = false;
    private Timer timer;
    private Random random;
    private Userclass userSnake;


    SnakeGame(Userclass user, JFrame f){
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                running = false;
            }
        });
        userSnake = user;
        random = new Random();
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setBackground(Color.DARK_GRAY);
        setFocusable(true);
        addKeyListener(new MyKeyAdapter());
    }
    public void startGame() {
        newApple();
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

            g.setColor(Color.white);
            g.fillRect(buffX, buffY, squareSize, squareSize);

            for(int i = 0; i< bodyParts;i++) {
                g.setColor(Color.orange);
                g.fillRect(x[i], y[i], squareSize, squareSize);
            }
            g.setColor(Color.white);
            g.setFont( new Font("Arial",Font.BOLD, 15));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: "+applesEaten, 390 -metrics.stringWidth("Score: " + applesEaten), g.getFont().getSize());
        }
        else {
            gameOver(g);
        }

    }
    public void newApple(){
        buffX = random.nextInt((int)(screenWidth / squareSize))* squareSize;
        buffY = random.nextInt((int)(screenHeight / squareSize))* squareSize;
    }

    public void move(){
        for(int i = bodyParts;i>0;i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        switch(direction) {
            case 'U':
                y[0] = y[0] - squareSize;
                break;
            case 'D':
                y[0] = y[0] + squareSize;
                break;
            case 'L':
                x[0] = x[0] - squareSize;
                break;
            case 'R':
                x[0] = x[0] + squareSize;
                break;
        }
    }
    public void checkApple() {
        if((x[0] == buffX) && (y[0] == buffY)) {
            bodyParts++;
            applesEaten++;
            newApple();
        }
    }
    public void checkCollisions() {
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
            }
        }
        if (x[0] < 0) {
            running = false;
        }

        if (x[0] > screenWidth) {
            running = false;
        }

        if (y[0] < 0) {
            running = false;
        }

        if (y[0] > screenHeight) {
            running = false;
        }

        if (!running) {
            timer.stop();
            if (applesEaten > userSnake.getScoreSnake()) {
                userSnake.setScoreSnake(applesEaten);
                userSnake.writeScores();
            }
        }
    }
    public void gameOver(Graphics g) {
        g.setColor(Color.white);
        g.setFont( new Font("Arial",Font.BOLD, 40));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (screenWidth - metrics2.stringWidth("Game Over"))/2, screenHeight /2);

        g.setColor(Color.white);
        g.setFont( new Font("Arial",Font.BOLD, 15));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Your Score: "+ applesEaten, (screenWidth - metrics1.stringWidth("Your Score: "+applesEaten))/2, screenHeight/2+30);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if(direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction != 'U') {
                        direction = 'D';
                    }
                    break;
            }
        }
    }
}

