package main.java.asset.object.equipment;

import main.java.GamePanel;
import main.java.util.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Axe extends Weapon {

    public OBJ_Axe(GamePanel gamePanel) {
        super(gamePanel);

        setName("Woodcutter's Axe");
        setDescription("[" + getName() + "]\nMight cut some trees\none day");
        setAttackValue(2);
        getAttackArea().width = 30;
        getAttackArea().height = 30;
        setPrice(75);

        try {
            BufferedImage image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/images/objects/axe.png")));
            setImage1(UtilityTool.scaleImage(image, gamePanel.getTileSize(), gamePanel.getTileSize()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
