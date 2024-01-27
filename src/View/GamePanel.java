package View;

import View.GameMap.GameMapManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    // SCREEN SETTINGS
    private final int TILE_SIZE = 48; // 48x48 tile
    private final int MAX_SCREEN_COL = 18;
    private final int MAX_SCREEN_ROW = 18;
    private final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COL;
    private final int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREEN_ROW;

    // FPS
    private int FPS = 60;

    // SYSTEM
    private final GameMapManager gameMapManager = new GameMapManager(this);

    // APP THREAD
    private Thread appThread;

    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
    }

    public void startAppThread() {
        appThread = new Thread(this);
        appThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1_000_000_000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (appThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += currentTime - lastTime;
            lastTime = currentTime;

            if (delta >= 1) {
                // 1 UPDATE: update information such as character position
                update();

                // 2 DRAW: draw the
                repaint();

                delta--;
                drawCount++;
            }
        }
    }

    public void update() {

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        gameMapManager.draw(g2);

        g.dispose();
    }

    public int getTILE_SIZE() {
        return TILE_SIZE;
    }

    public int getMAX_SCREEN_COL() {
        return MAX_SCREEN_COL;
    }

    public int getMAX_SCREEN_ROW() {
        return MAX_SCREEN_ROW;
    }

    public int getSCREEN_WIDTH() {
        return SCREEN_WIDTH;
    }

    public int getSCREEN_HEIGHT() {
        return SCREEN_HEIGHT;
    }

    public int getFPS() {
        return FPS;
    }

    public void setFPS(int FPS) {
        this.FPS = FPS;
    }

    public Thread getAppThread() {
        return appThread;
    }

    public void setAppThread(Thread appThread) {
        this.appThread = appThread;
    }
}
