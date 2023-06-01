package main.java.asset.object.usable.inventory;

import main.java.GamePanel;
import main.java.asset.object.Object;
import main.java.util.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Seeds extends Object {

    private final GamePanel gamePanel;

    public OBJ_Seeds(GamePanel gamePanel) {
        super(gamePanel);
        this.gamePanel = gamePanel;

        setName("Seeds");
        setValue(5);
        setDescription("[" + getName() + "]\nYou can plant them ");
        setPrice(25);

        try {
            BufferedImage image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/objects/seeds.png")));
            setImage1(UtilityTool.scaleImage(image, gamePanel.getTileSize(), gamePanel.getTileSize()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void use() {
        gamePanel.setGameState(gamePanel.getDialogueState());
        gamePanel.getUi().setCurrentDialogue("You couldn't plant... " + getName() + "!\n");

        gamePanel.getPlayer().setCurrentLife(gamePanel.getPlayer().getCurrentLife() + getValue());

        gamePanel.playSoundEffect(2);
    }
}
