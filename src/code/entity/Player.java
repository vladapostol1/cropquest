package code.entity;

import code.math.Vector2;
import code.main.KeyController;
import code.utils.Direction;
import code.utils.SpriteRenderer;
import java.awt.Graphics2D;
import java.io.IOException;

public class Player extends Entity {
    private SpriteRenderer spriteRenderer;
    private Direction facing;

    public Player(Vector2 worldCord) {
        this.worldCord = worldCord;
        this.movementSpeed = 2;
        this.spriteRenderer = new SpriteRenderer();
        facing = Direction.DOWN;
        try {
            spriteRenderer.addSprite("down", "src/res/graphics/character/down", 4);
            spriteRenderer.addSprite("down_idle", "src/res/graphics/character/down_idle", 2);
            spriteRenderer.addSprite("down_axe", "src/res/graphics/character/down_axe", 2);
            spriteRenderer.addSprite("down_hoe", "src/res/graphics/character/down_hoe", 2);
            spriteRenderer.addSprite("up", "src/res/graphics/character/up", 4);
            spriteRenderer.addSprite("up_idle", "src/res/graphics/character/up_idle", 2);
            spriteRenderer.addSprite("up_axe", "src/res/graphics/character/up_axe", 2);
            spriteRenderer.addSprite("up_hoe", "src/res/graphics/character/up_hoe", 2);
            spriteRenderer.addSprite("left", "src/res/graphics/character/left", 4);
            spriteRenderer.addSprite("left_idle", "src/res/graphics/character/left_idle", 2);
            spriteRenderer.addSprite("left_axe", "src/res/graphics/character/left_axe", 2);
            spriteRenderer.addSprite("left_hoe", "src/res/graphics/character/left_hoe", 2);
            spriteRenderer.addSprite("right", "src/res/graphics/character/right", 4);
            spriteRenderer.addSprite("right_idle", "src/res/graphics/character/right_idle", 2);
            spriteRenderer.addSprite("right_axe", "src/res/graphics/character/right_axe", 2);
            spriteRenderer.addSprite("right_hoe", "src/res/graphics/character/right_hoe", 2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        spriteRenderer.setCurrentAnimation("down_idle");
    }

    public void update(KeyController keyController) {
        int deltaX = 0;
        int deltaY = 0;

        if (keyController.upPressed) {
            deltaY -= movementSpeed;
            facing = Direction.UP;
        }
        if (keyController.downPressed) {
            deltaY += movementSpeed;
            facing = Direction.DOWN;
        }
        if (keyController.leftPressed) {
            deltaX -= movementSpeed;
            facing = Direction.LEFT;
        }
        if (keyController.rightPressed) {
            deltaX += movementSpeed;
            facing = Direction.RIGHT;
        }

        if (deltaX != 0 || deltaY != 0) {
            switch (facing){
                case UP -> {
                    spriteRenderer.setCurrentAnimation("up");
                    break;
                }
                case DOWN -> {
                    spriteRenderer.setCurrentAnimation("down");
                    break;
                }
                case LEFT -> {
                    spriteRenderer.setCurrentAnimation("left");
                    break;
                }
                case RIGHT -> {
                    spriteRenderer.setCurrentAnimation("right");
                    break;
                }
            }
        } else {
            switch (facing){
                case UP -> {
                    spriteRenderer.setCurrentAnimation("up_idle");
                    break;
                }
                case DOWN -> {
                    spriteRenderer.setCurrentAnimation("down_idle");
                    break;
                }
                case LEFT -> {
                    spriteRenderer.setCurrentAnimation("left_idle");
                    break;
                }
                case RIGHT -> {
                    spriteRenderer.setCurrentAnimation("right_idle");
                    break;
                }
            }
        }

        worldCord.x += deltaX;
        worldCord.y += deltaY;

        spriteRenderer.update();
    }

    public void render(Graphics2D g2d, Vector2 screenCord) {
        int x = (int)screenCord.x - spriteRenderer.getSpriteWidth() / 2;
        int y = (int)screenCord.y - spriteRenderer.getSpriteHeight() / 2;
        spriteRenderer.render(g2d, x, y);
    }


}
