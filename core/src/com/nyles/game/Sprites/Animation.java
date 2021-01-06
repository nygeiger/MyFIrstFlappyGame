package com.nyles.game.Sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

public class Animation {

    private ArrayList<TextureRegion> frames;

    private float maxFrameTime;
    private float currentFrameTime;
    private int frameCount;
    private int frame;

    // TODO Determine if constructor could be able to read in a Texture
    public Animation(TextureRegion region, int frameCount, float cycleTime){

        frames = new ArrayList<TextureRegion>();
        int frameWidth = region.getRegionWidth() / frameCount;

        /**
         *  given an image file it creates frames
         *  to by dividing the image file equally
         */
        for (int i = 0; i < frameCount; i++){
            frames.add(new TextureRegion(region, i * frameWidth, 0, frameWidth, region.getRegionHeight()));
        }

        this.frameCount = frameCount;
        maxFrameTime = cycleTime / frameCount;
        frame = 0;
    }

    public void update (float dt){
        currentFrameTime += dt;

        if (currentFrameTime > maxFrameTime){
            frame++;
            currentFrameTime = 0;
        }

        if (frame >= frameCount){
            frame = 0;
        }
    }

    public TextureRegion getFrame(){
        return frames.get(frame);
    }
}
