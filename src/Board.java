import com.sun.deploy.uitoolkit.impl.text.TextAppletAdapter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.*;

public class Board extends JPanel implements ActionListener{

    private final int B_WIDTH = 300;
    private final int B_HEIGHT = 300;
    private final int DOT_SIZE = 10;
    private final int ALL_DOTS = 900;
    private final int RAND_POS = 29;
    private final int DELAY = 140;

    private final int x[] - new int[ALL_DOTS];
    private final int y[] - new int[ALL_DOTS];

    private int dots;
    private int apple_x;
    private int apple_y;

    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;

    private Timer timer;
    private Image ball;
    private Image apple;
    private Image head;

    public Board() {
        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
        initGame();
    }

    private void loadImages() {
        ImageIcon iid = new ImageIcon(getClass().getResource("/res/dot.png"));
        ball = iid.getImage();

        ImageIcon iia = new ImageIcon(getClass().getResource("/res/apple.png"));
        apple = iia.getImage();

        ImageIcon iih = new ImageIcon(getClass().getResource("/res/head.png"));
        head = iih.getImage();
    }

    private void initGame() {
        dots = 3;

        for (int i = 0; i < dots; i++) {
            x[i] = 50 * i - 10;
            y[i] = 50;
        }

        locateApple();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
        if(inGame) {
            g.drawImage(apple, apple_x, apple_y, this);

            for(int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(head, x[z], y[z],this);
                }
                else {
                    g.drawImage(ball, x[z], y[z],this);
                }
            }

            Toolkit.getDefaultToolkit().sync();
        }
        else {
            gameOver(g);
        }
    }

    private void gameOver(Graphics g) {
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg))/ 2, B_HEIGHT / 2);
    }

    private void checkApple() {
        if((x[0] == apple_x) && y[0] == apple_y) {
            dots++;
            locateApple();
        }
    }

    public void move() {
        for (int z = dots; z > 0; z--) {
            x[z] = x[z-1];
            y[z] = y[z-1];
        }

        if ( )
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
