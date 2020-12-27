package com.nyles.game.States;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nyles.game.FirstFlappyGame;
import com.nyles.game.Sprites.PlayerModelNormal;

/**
 * Describes the programs behavior while the game is in action
 */
public class PlayState extends State{

    private PlayerModelNormal normalSpidey;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        normalSpidey = new PlayerModelNormal(50, 100);
        cam.setToOrtho(false, FirstFlappyGame.WIDTH/2, FirstFlappyGame.HEIGHT/2);
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {
        handleInput();
        normalSpidey.update(dt);
    }

    /**
     * generates sprites used while in the playState.
     * @param sb container for everything that will be rendered onto the screen
     */
    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(normalSpidey.getTexture(), normalSpidey.getPosition().x, normalSpidey.getPosition().y, 65, 65);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
