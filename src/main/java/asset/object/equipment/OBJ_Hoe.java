package main.java.asset.object.equipment;

import main.java.GamePanel;
import main.java.util.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Hoe extends Weapon{
    public OBJ_Hoe(GamePanel gamePanel) {
        super(gamePanel);

        setName("Farmer's Hoe");
        setDescription("[" + getName() + "]\nLet's change the world");
        setAttackValue(2);
        getAttackArea().width = 30;
        getAttackArea().height = 30;
        setPrice(75);

        try {
            BufferedImage image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/objects/hoe.png")));
            setImage1(UtilityTool.scaleImage(image, gamePanel.getTileSize(), gamePanel.getTileSize()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
