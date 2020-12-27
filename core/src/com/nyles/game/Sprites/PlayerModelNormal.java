package com.nyles.game.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class PlayerModelNormal {


    private static final int GRAVITY = -15;
    private Vector3 position;
    private Vector3 velocity;
    private Texture normalSpidey;

    public PlayerModelNormal(int x, int y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0,0,0);
        normalSpidey = new Texture("8BitMilesMoralesNormal.png");
    }

    /**
     * If the player isn't ascending they are falling. This describes the behavior.
     * The change in velociyt only occurs in the 'y' position.
     * it is scaled with time and then added to the position of the playerModel.
     * Then the velocity is unscaled after the position is changed.
     * @param dt
     */
    public void update (float dt){
        velocity.add(0, GRAVITY, 0);
        velocity.scl(dt);
        position.add(0, velocity.y, 0);
        velocity.scl(1/dt);
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return normalSpidey;
    }
}
