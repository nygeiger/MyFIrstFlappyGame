package com.nyles.game.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nyles.game.FirstFlappyGame;

import java.util.Stack;

/**
 * Created By Nyles Geiegr 12/25/2020
 */
public class GameStateManager {

    private Stack<State> states;

    public GameStateManager(){
        states = new Stack<State>();
    }

    public void push(State state){
        states.push(state);
    }

    /**
     * remove current state
     */
    public void pop(){
        states.pop();
    }

    /**
     * remove current state and initiate given state
     * @param state
     * the state to be initialiozed
     */
    public void set(State state){
        states.pop();
        states.push(state);
    }

    public void update(float dt){
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }
}
