package View.GameMap;

import View.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class GameMapManager {
    private final GamePanel gamePanel;
    private GameMap gameMap;

    public GameMapManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        gameMap = new GameMap();

        getMapImage();
    }

    public final void getMapImage() {
        try {
            gameMap.setMapImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/map/app_map.png"))));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(gameMap.getMapImage(), 0, 0, gamePanel.getSCREEN_WIDTH(), gamePanel.getSCREEN_WIDTH(), null);
    }
}
