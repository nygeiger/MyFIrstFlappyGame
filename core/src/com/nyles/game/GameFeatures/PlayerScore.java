package com.nyles.game.GameFeatures;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Holds the count of the player. Determines how much to increase player score by.
 * Displays score as text.
 */
public class PlayerScore {

    private static final int MOVEMENT = 100;

    private int count;

    private Vector3 position;
    private BitmapFont playerScore;

    /**
     *
     * @param positionX determines begining position of player score along x axis
     * @param positionY determines begiing  position of player score along y axis
     */
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

    /**
     * Updates playerScore to move along playing area
     * @param dt difference in time between frames rendered
     */
    public void update (float dt){
        position.add(MOVEMENT * dt, 0, 0);
    }

    private String toDisplay() { return ""+count; }

    public void increasePlayerScore(){
        this.count++;
    }

    public void dispose(){
        playerScore.dispose();
    }
}
