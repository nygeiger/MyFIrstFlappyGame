package com.nyles.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nyles.game.FirstFlappyGame;

public class MenuState extends State {

    /**
     * Drawings dimensions are counted from bottom left to top right
     */
    private Texture background;
    private Texture playButton;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("backgoundCitywithStars.png");
        playButton = new Texture("8BitPlayButton1.png");

        cam.setToOrtho(false, FirstFlappyGame.WIDTH, FirstFlappyGame.HEIGHT);
    }

    @Override
    public void handleInput() {
        if(Gdx.input.isTouched()){
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    /**
     * renders given images to the screen
     * must open, act, then close
     */
    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, FirstFlappyGame.WIDTH, FirstFlappyGame.HEIGHT);
        sb.draw(playButton, (FirstFlappyGame.WIDTH/2)-(playButton.getWidth()/6)*2, FirstFlappyGame.HEIGHT/2, FirstFlappyGame.HEIGHT/4, FirstFlappyGame.WIDTH/4);

        sb.end();
    }

    /**
     * Removes unnecessary rendering of images once a game state is no longer being used
     */
    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
    }

}
