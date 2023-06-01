package main.java.asset;

import main.java.GamePanel;
import main.java.asset.entity.monster.MON_GreenSlime;
import main.java.asset.entity.npc.NPC_OldMan;
import main.java.asset.object.usable.inventory.OBJ_Potion_Red;
import main.java.asset.object.usable.inventory.OBJ_Seeds;
import main.java.asset.object.usable.pickuponly.OBJ_Coin_Bronze;
import main.java.asset.object.usable.pickuponly.OBJ_Heart;
import main.java.asset.tile.interactive.IT_DryTree;

public class AssetManager {

    private final GamePanel gamePanel;
    private final int tileSize;
    private int map = 0;

    public AssetManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.tileSize = gamePanel.getTileSize();
    }

    public void setObjects() {

        // MAP 0
        map = 0;

        if(gamePanel.getDifficulty() == 0)
        {
            gamePanel.getObjects()[map][0] = new OBJ_Coin_Bronze(gamePanel);
            gamePanel.getObjects()[map][0].setWorldX(tileSize * 25);
            gamePanel.getObjects()[map][0].setWorldY(tileSize * 23);
            gamePanel.getObjects()[map][0].setIndex(0);

            gamePanel.getObjects()[map][1] = new OBJ_Seeds(gamePanel);
            gamePanel.getObjects()[map][1].setWorldX(tileSize * 21);
            gamePanel.getObjects()[map][1].setWorldY(tileSize * 19);
            gamePanel.getObjects()[map][1].setIndex(1);

            gamePanel.getObjects()[map][2] = new OBJ_Potion_Red(gamePanel);
            gamePanel.getObjects()[map][2].setWorldX(tileSize * 37);
            gamePanel.getObjects()[map][2].setWorldY(tileSize * 10);
            gamePanel.getObjects()[map][2].setIndex(2);
        }
        else if(gamePanel.getDifficulty() == 1){
            gamePanel.getObjects()[map][0] = new OBJ_Coin_Bronze(gamePanel);
            gamePanel.getObjects()[map][0].setWorldX(tileSize * 39);
            gamePanel.getObjects()[map][0].setWorldY(tileSize * 15);
            gamePanel.getObjects()[map][0].setIndex(0);

            gamePanel.getObjects()[map][1] = new OBJ_Seeds(gamePanel);
            gamePanel.getObjects()[map][1].setWorldX(tileSize * 27);
            gamePanel.getObjects()[map][1].setWorldY(tileSize * 30);
            gamePanel.getObjects()[map][1].setIndex(1);

            gamePanel.getObjects()[map][2] = new OBJ_Potion_Red(gamePanel);
            gamePanel.getObjects()[map][2].setWorldX(tileSize * 15);
            gamePanel.getObjects()[map][2].setWorldY(tileSize * 26);
            gamePanel.getObjects()[map][2].setIndex(2);

            gamePanel.getObjects()[map][3] = new OBJ_Seeds(gamePanel);
            gamePanel.getObjects()[map][3].setWorldX(tileSize * 15);
            gamePanel.getObjects()[map][3].setWorldY(tileSize * 9);
            gamePanel.getObjects()[map][3].setIndex(3);
        }
        else if(gamePanel.getDifficulty() == 2){
            gamePanel.getObjects()[map][0] = new OBJ_Coin_Bronze(gamePanel);
            gamePanel.getObjects()[map][0].setWorldX(tileSize * 39);
            gamePanel.getObjects()[map][0].setWorldY(tileSize * 15);
            gamePanel.getObjects()[map][0].setIndex(0);

            gamePanel.getObjects()[map][4] = new OBJ_Coin_Bronze(gamePanel);
            gamePanel.getObjects()[map][4].setWorldX(tileSize * 7);
            gamePanel.getObjects()[map][4].setWorldY(tileSize * 11);
            gamePanel.getObjects()[map][4].setIndex(4);

            gamePanel.getObjects()[map][1] = new OBJ_Seeds(gamePanel);
            gamePanel.getObjects()[map][1].setWorldX(tileSize * 27);
            gamePanel.getObjects()[map][1].setWorldY(tileSize * 30);
            gamePanel.getObjects()[map][1].setIndex(1);

            gamePanel.getObjects()[map][2] = new OBJ_Potion_Red(gamePanel);
            gamePanel.getObjects()[map][2].setWorldX(tileSize * 38);
            gamePanel.getObjects()[map][2].setWorldY(tileSize * 16);
            gamePanel.getObjects()[map][2].setIndex(2);

            gamePanel.getObjects()[map][3] = new OBJ_Seeds(gamePanel);
            gamePanel.getObjects()[map][3].setWorldX(tileSize * 30);
            gamePanel.getObjects()[map][3].setWorldY(tileSize * 30);
            gamePanel.getObjects()[map][3].setIndex(3);
        }
        /*
        gamePanel.getObjects()[map][2] = new OBJ_Coin_Bronze(gamePanel);
        gamePanel.getObjects()[map][2].setWorldX(tileSize * 26);
        gamePanel.getObjects()[map][2].setWorldY(tileSize * 21);
        gamePanel.getObjects()[map][2].setIndex(2);

        gamePanel.getObjects()[map][5] = new OBJ_Potion_Red(gamePanel);
        gamePanel.getObjects()[map][5].setWorldX(tileSize * 22);
        gamePanel.getObjects()[map][5].setWorldY(tileSize * 27);
        gamePanel.getObjects()[map][5].setIndex(5);

        gamePanel.getObjects()[map][6] = new OBJ_Heart(gamePanel);
        gamePanel.getObjects()[map][6].setWorldX(tileSize * 22);
        gamePanel.getObjects()[map][6].setWorldY(tileSize * 29);
        gamePanel.getObjects()[map][6].setIndex(6);*/
    }

    public void setNPCs() {

        // MAP 0
        map = 0;
        /*gamePanel.getNpcs()[map][0] = new NPC_OldMan(gamePanel);
        gamePanel.getNpcs()[map][0].setWorldX(tileSize * 21);
        gamePanel.getNpcs()[map][0].setWorldY(tileSize * 21);
        gamePanel.getNpcs()[map][0].setIndex(0);*/
    }

    public void setMonsters() {

        // MAP 0
        map = 0;
        createMonster(map,23,17,0);

        if (gamePanel.getDifficulty() > 0)
        {
            createMonster(map, 17,18,1);
            createMonster(map, 29,30,2);
        }

        if (gamePanel.getDifficulty() > 1)
        {
            createMonster(map,28,20,3);
            createMonster(map,9,11,4);
            createMonster(map,37,17,5);
            createMonster(map,32,27,6);
        }

    }

    public void setInteractiveTiles() {

        // MAP 0
        map = 0;
        gamePanel.getInteractiveTiles()[map][0] = new IT_DryTree(gamePanel);
        gamePanel.getInteractiveTiles()[map][0].setWorldX(tileSize * 27);
        gamePanel.getInteractiveTiles()[map][0].setWorldY(tileSize * 12);
        gamePanel.getInteractiveTiles()[map][0].setIndex(0);

    }

    public void createMonster(int map, int x, int y, int id)
    {
        gamePanel.getMonsters()[map][id] = new MON_GreenSlime(gamePanel);
        gamePanel.getMonsters()[map][id].setWorldX(tileSize * x);
        gamePanel.getMonsters()[map][id].setWorldY(tileSize * y);
        gamePanel.getMonsters()[map][id].setIndex(id);
    }
}
