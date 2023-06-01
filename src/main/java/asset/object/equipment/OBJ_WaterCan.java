package main.java.asset.object.equipment;

import main.java.GamePanel;
import main.java.asset.object.Object;
import main.java.asset.object.equipment.Weapon;
import main.java.util.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class OBJ_WaterCan extends Weapon {
    public OBJ_WaterCan(GamePanel gamePanel) {
        super(gamePanel);

        setName("Water Can");
        setDescription("[" + getName() + "]\nLet's grow some plants");
        setPrice(75);

        try {
            BufferedImage image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/objects/watercan.png")));
            setImage1(UtilityTool.scaleImage(image, gamePanel.getTileSize(), gamePanel.getTileSize()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
