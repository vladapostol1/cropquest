package code.utils;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public class SpriteRenderer {
    private Map<String, BufferedImage[]> sprites;
    private String currentAnimation;
    private int currentFrame;
    private int animationSpeed;
    private boolean looping;
    private int animationCounter = 0;

    public SpriteRenderer() {
        sprites = new HashMap<>();
        currentAnimation = "";
        currentFrame = 0;
        animationSpeed = 10;
        looping = true;
    }

    public void addSprite(String name, String folderPath, int numFrames) throws IOException {
        BufferedImage[] frames = new BufferedImage[numFrames];
        for (int i = 0; i < numFrames; i++) {
            String filePath = String.format("%s/%d.png", folderPath, i);
            frames[i] = ImageIO.read(new File(filePath));
        }
        sprites.put(name, frames);
    }

    public void setCurrentAnimation(String name) {
        if (sprites.containsKey(name) && currentAnimation != name) {
            currentAnimation = name;
            currentFrame = 0;
        }
    }

    public void setAnimationSpeed(int speed) {
        animationSpeed = speed;
    }

    public void setLooping(boolean loop) {
        looping = loop;
    }

    public void update() {
        if(++animationCounter >= animationSpeed)
        {
            currentFrame = (currentFrame + 1) % sprites.get(currentAnimation).length;
            animationCounter = 0;
        }
    }

    public void render(Graphics2D g2d, int x, int y) {
        BufferedImage[] frames = sprites.get(currentAnimation);
        BufferedImage currentSprite = frames[currentFrame];
        g2d.drawImage(currentSprite, x, y, null);
    }

    public int getSpriteWidth() {
        BufferedImage[] frames = sprites.get(currentAnimation);
        BufferedImage currentSprite = frames[currentFrame];
        return currentSprite.getWidth();
    }

    public int getSpriteHeight() {
        BufferedImage[] frames = sprites.get(currentAnimation);
        BufferedImage currentSprite = frames[currentFrame];
        return currentSprite.getHeight();
    }
}
