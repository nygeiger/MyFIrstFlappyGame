package com.nyles.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.nyles.game.FirstFlappyGame;
import com.nyles.game.Sprites.PlayerModel;
import com.nyles.game.Sprites.ObstacleBuilding;

import java.util.ArrayList;

/**
 * Describes the programs behavior while the game is in action
 */
public class PlayState extends State{

    private static final int SPACING = 125;
    private static final int OBSTACLE_COUNT = 4;

    private PlayerModel spideyModel;
    private ObstacleBuilding buildings;

    private Texture background;
    private Texture ground;

    private Vector2 groundPos1;
    private Vector2 groundPos2;

    private ArrayList<ObstacleBuilding> buildingsArray;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        spideyModel = new PlayerModel(50, 150);
        buildings = new ObstacleBuilding(100);

        background = new Texture("backgoundCitywithStars.png");
        ground = new Texture ("8BitFireFloor.png");


        groundPos1 = new Vector2(cam.position.x - cam.viewportWidth/2, 0);
        groundPos2 = new Vector2((cam.position.x - cam.viewportWidth/2) + ground.getWidth(), 0);

        cam.setToOrtho(false, FirstFlappyGame.WIDTH/2, FirstFlappyGame.HEIGHT/2);
        buildingsArray = new ArrayList<ObstacleBuilding>();

        for (int i = 1; i <= OBSTACLE_COUNT; i++){
            buildingsArray.add(new ObstacleBuilding(i *(SPACING + ObstacleBuilding.OBSTACLE_WIDTH)));
        }

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
        updateGround();
        spideyModel.update(dt);
        cam.position.x = spideyModel.getPosition().x + 80;

        /**
         * checks if building pair's rightmost x-coordinate is less than the
         * leftmost x-coordinate of the camera. If true position is reset to
         */
        for(ObstacleBuilding building: buildingsArray){
            if (cam.position.x - (cam.viewportWidth/2) > (building.getPostopBuilding().x+ building.getTopBuilding().getWidth())){
                building.reposition(building.getPostopBuilding().x + (ObstacleBuilding.OBSTACLE_WIDTH + SPACING) * OBSTACLE_COUNT);
            }

            /**
             * checks for collision between playerModel and buildings
             */
            //TODO Implementation is not optimal for scaling
            if (building.collides(spideyModel.getBounds())){
                gsm.set(new MenuState(gsm));
            }

            if (spideyModel.getPosition().y <= ground.getHeight()){
                gsm.set(new MenuState(gsm));
            }
        }


        cam.update(); // must be called whenever the position of the camera is changed
    }

    private void updateGround(){

        if (cam.position.x - (cam.viewportWidth/2) > (groundPos1.x + ground.getWidth())){
            groundPos1.add(ground.getWidth()*2, 0);
        }

        if (cam.position.x - (cam.viewportWidth/2) > (groundPos2.x + ground.getWidth())){
            groundPos2.add(ground.getWidth()*2, 0);
        }

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
        sb.draw(spideyModel.getNormalTexture(), spideyModel.getPosition().x, spideyModel.getPosition().y, 35, 35);

        for (ObstacleBuilding building: buildingsArray){
            sb.draw(building.getTopBuilding(), building.getPostopBuilding().x, building.getPostopBuilding().y, 80, building.getTopBuilding().getHeight());
            sb.draw(building.getBottomBuilding(), building.getPosBottomBuilding().x, building.getPosBottomBuilding().y, 75, building.getBottomBuilding().getHeight());
        }

        sb.draw(ground, groundPos1.x, groundPos1.y);
        sb.draw(ground, groundPos2.x, groundPos2.y);

        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        buildings.dispose();

        for (ObstacleBuilding building: buildingsArray){
            building.dispose();
        }

        spideyModel.dispose();
    }
}
