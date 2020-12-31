package com.nyles.game.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class ObstacleBuilding {

    public static final int OBSTACLE_WIDTH = 52;

    private static final int FLUCTUATION = 130;
    private static final int OBSTACLE_GAP = 100;
    private static final int LOWEST_OPENING = 120;

    private Texture topBuilding, bottomBuilding;
    private Vector2 postopBuilding, posBottomBuilding;
    private Rectangle boundsTop, boundsBottom;
    private Random rand;

    /**
     *
     * @param x coordinate on x axis where obstacle starts
     */
    public ObstacleBuilding(float x){
        topBuilding = new Texture("turquoiseSkyscraperUpsideDown.png");
        bottomBuilding = new Texture("turquoiseSkyscraper.png");
        rand = new Random();
        int obstaclePosition = rand.nextInt();

        postopBuilding = new Vector2(x, rand.nextInt(FLUCTUATION) + OBSTACLE_GAP + LOWEST_OPENING);
        posBottomBuilding = new Vector2(x, postopBuilding.y - OBSTACLE_GAP - bottomBuilding.getHeight());
    }

    /**
     * Each pair of buildings will reset their position once
     * the player model passes them
     * @param x
     */
    public void reposition(float x){
        postopBuilding.set(x, rand.nextInt(FLUCTUATION) + OBSTACLE_GAP + LOWEST_OPENING);
        posBottomBuilding.set(x, postopBuilding.y - OBSTACLE_GAP - bottomBuilding.getHeight());
    }

    public Texture getTopBuilding() {
        return topBuilding;
    }

    public Texture getBottomBuilding() {
        return bottomBuilding;
    }

    public Vector2 getPostopBuilding() {
        return postopBuilding;
    }

    public Vector2 getPosBottomBuilding() {
        return posBottomBuilding;
    }
}
