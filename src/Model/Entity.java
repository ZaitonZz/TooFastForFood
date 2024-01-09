package Model;

import java.awt.image.BufferedImage;

public abstract class Entity {
    enum SpriteDirection{
        UP, DOWN, LEFT, RIGHT
    }
    private BufferedImage spriteSheet;
    SpriteDirection spriteDirection;


    public Entity() {
    }

    public Entity(BufferedImage spriteSheet) {
        this.spriteSheet = spriteSheet;
    }

    public abstract void idleAnimation();
    public abstract void walkingAnimation();
}
