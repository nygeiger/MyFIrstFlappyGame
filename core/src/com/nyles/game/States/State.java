package com.nyles.game.States;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class State {

    /**
     * A camera that a method of projection in which an object is depicted or a surface mapped using parallel lines to project its shape onto a plane.
     */
    protected OrthographicCamera cam;

    /**
     * X, Y, Z coordinate plane
     * back	Shorthand for writing Vector3(0, 0, -1).
     * down	Shorthand for writing Vector3(0, -1, 0).
     * forward	Shorthand for writing Vector3(0, 0, 1).
     *
     */
    protected Vector3 mouse;


    protected GameStateManager gsm;

    public State(GameStateManager gsm) {
        this.gsm = gsm;
        cam = new OrthographicCamera();
        mouse = new Vector3();
    }


    public abstract void handleInput();

    /**
     * @param dt difference in time between frames renderd
     */
    public abstract void update(float dt);

    /**
     * @param sb container for everything that will be rendered onto the screen
     */
    public abstract void render(SpriteBatch sb);

    /**
     * Used to prevent Memory leaks
     */
    public abstract void dispose();


}
