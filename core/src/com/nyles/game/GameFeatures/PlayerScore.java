package com.nyles.game.GameFeatures;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;


public class PlayerScore {

    private static final int MOVEMENT = 100;

    private int count;


    private Vector3 position;
    private BitmapFont playerScore;


    public PlayerScore(int positionX, int positionY){

        this.count = 0;
        position = new Vector3(positionX, positionY, 0);

        playerScore = new BitmapFont();
        playerScore.getData().setScale(1);
        playerScore.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    public void draw(SpriteBatch sb){
        playerScore.draw(sb, toDisplay(), position.x, position.y);
    }

    public void update (float dt){
        position.add(MOVEMENT * dt, 0, 0);
    }

    private String toDisplay(){
        return ""+count;
    }

    public void increasePlayerScore(){
        this.count++;
    }

    public int getPlayerScore(){
        return count;
    }

    public void dispose(){
        playerScore.dispose();
    }
}
