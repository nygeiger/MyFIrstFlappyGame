package com.nyles.game.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import org.w3c.dom.css.Rect;

public class PlayerModel {

    // TODO make player model assume a different sprite texture when clicked

    private static final int JUMP = 72;
    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 100;

    private Vector3 position;
    private Vector3 velocity;

    private Rectangle bounds; //TODO make hit-box more accurate
    private Texture normalSpidey;
    private Texture jumpingSpidey;
    private Animation playerAnimation;


    public PlayerModel(int x, int y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0,0,0);

        normalSpidey = new Texture("8BitMilesMoralesNormal.png");
        jumpingSpidey = new Texture("8BitSpiderManUp.png");

        /**
         * contains images side by side represent the frames in the player animation
         */
        Texture texture = new Texture("8BitMilesMoralesIdleAnimation.png");
        playerAnimation = new Animation(new TextureRegion(texture), 3, 0.35f);

        //bounds = new Rectangle( position.x, position.y, 30, 30);
        /**
         * width must be divided by number of frames represented by texture
         */
        bounds = new Rectangle( x, y, 30, 30);
    }

    /**
     * If the player isn't ascending they are falling. This describes the behavior.
     * The change in velocity only occurs in the 'y' position.
     * it is scaled with time and then added to the position of the playerModel.
     * Then the velocity is unscaled after the position is changed.
     * @param dt seconds between current and previous frame.
     */
    public void update (float dt){
        playerAnimation.update(dt);

        velocity.add(0, GRAVITY, 0);
        velocity.scl(dt);
        position.add(MOVEMENT * dt, velocity.y, 0);
        velocity.scl(1/dt);

        if (position.y < 0){
            position.y = 0;
            velocity.y=0;
        }

        bounds.setPosition(position.x, position.y);
    }

    public void jump(){
        velocity.y = JUMP;
        position.add(0,velocity.y, 0);

    }

    public void dispose(){
        normalSpidey.dispose();
        jumpingSpidey.dispose();
    }

    public Rectangle getBounds(){
        return bounds;
    }

    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getNormalTexture() {
        //return normalSpidey;
        return playerAnimation.getFrame();
    }
}
