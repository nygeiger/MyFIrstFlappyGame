package com.nyles.game.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class ObstacleBuilding {

    public static final int OBSTACLE_WIDTH = 52;

    private static final int FLUCTUATION = 130;
    private static final int OBSTACLE_GAP = 140;
    private static final int LOWEST_OPENING = 120;

    private Texture topBuilding, bottomBuilding; //TODO refactor into a static reference to minimize obstacle textures created
    private Vector2 posTopBuilding, posBottomBuilding;
    private Rectangle boundsTop, boundsBottom; //TODO make hit-boxes more accurate
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

        posTopBuilding = new Vector2(x, rand.nextInt(FLUCTUATION) + OBSTACLE_GAP + LOWEST_OPENING);
        posBottomBuilding = new Vector2(x, posTopBuilding.y - OBSTACLE_GAP - bottomBuilding.getHeight());

        boundsTop = new Rectangle(posTopBuilding.x, posTopBuilding.y /*+ 30*/, topBuilding.getWidth()-topBuilding.getWidth()/2, topBuilding.getHeight());
        boundsBottom = new Rectangle(posBottomBuilding.x, posBottomBuilding.y /*- 30*/, bottomBuilding.getWidth()-bottomBuilding.getWidth()/2, bottomBuilding.getHeight());
    }

    public Rectangle getBoundsTop() { // for hitbox testing
        return boundsTop;
    }

    public Rectangle getBoundsBottom() { // for hitbox testing
        return boundsBottom;
    }

    /**
     * Each pair of buildings will reset their position once
     * the player model passes them
     * @param x
     */
    public void reposition(float x){
        posTopBuilding.set(x, rand.nextInt(FLUCTUATION) + OBSTACLE_GAP + LOWEST_OPENING);
        posBottomBuilding.set(x, posTopBuilding.y - OBSTACLE_GAP - bottomBuilding.getHeight());
        boundsTop.setPosition(posTopBuilding.x, posTopBuilding.y);
        boundsBottom.setPosition(posBottomBuilding.x, posBottomBuilding.y);
    }

    public boolean collides(Rectangle player){
        return player.overlaps(boundsTop) || player.overlaps(boundsBottom);
    }

    public void dispose (){
        topBuilding.dispose();
        bottomBuilding.dispose();
    }

    public Texture getTopBuilding() {
        return topBuilding;
    }

    public Texture getBottomBuilding() {
        return bottomBuilding;
    }

    public Vector2 getPostopBuilding() {
        return posTopBuilding;
    }

    public Vector2 getPosBottomBuilding() {
        return posBottomBuilding;
    }
}
