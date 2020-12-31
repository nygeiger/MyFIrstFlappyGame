package com.nyles.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nyles.game.FirstFlappyGame;
import com.nyles.game.Sprites.PlayerModel;

/**
 * Describes the programs behavior while the game is in action
 */
public class PlayState extends State{

    private PlayerModel spideyModel;
    private Texture background;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        spideyModel = new PlayerModel(50, 100);
        background = new Texture("backgoundCitywithStars.png");
        cam.setToOrtho(false, FirstFlappyGame.WIDTH/2, FirstFlappyGame.HEIGHT/2);
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            spideyModel.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        spideyModel.update(dt);

    }

    /**
     * generates sprites used while in the playState.
     * @param sb container for everything that will be rendered onto the screen
     */
    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, cam.position.x-(cam.viewportWidth/2), 0, FirstFlappyGame.WIDTH/2, FirstFlappyGame.HEIGHT/2);
        sb.draw(spideyModel.getNormalTexture(), spideyModel.getPosition().x, spideyModel.getPosition().y, 65, 65);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
