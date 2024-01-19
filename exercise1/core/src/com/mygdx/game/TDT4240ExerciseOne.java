package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

public class TDT4240ExerciseOne extends ApplicationAdapter {
	SpriteBatch batch;
	Texture chopperImage;
	Rectangle chopper;
	Vector2 chopperVelocity;
	Vector2 windowSize;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		windowSize = new Vector2(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		chopperImage = new Texture("heli1.png");
		chopper = new Rectangle();
		chopper.x = 100;
		chopper.y = 100;
		chopper.width=chopperImage.getWidth();
		chopper.height=chopperImage.getHeight();
		chopperVelocity = new Vector2(8, 5);

	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		batch.draw(
				chopperImage,
				chopper.x,
				chopper.y,
				chopperImage.getWidth(),
				chopperImage.getHeight(),
				0, 0, chopperImage.getWidth(), chopperImage.getHeight(), (chopperVelocity.x > 0), false
				);
		batch.end();

		chopper.x += chopperVelocity.x;
		chopper.y += chopperVelocity.y;

		if (chopper.x <= 0) {
			chopperVelocity.x = -1*chopperVelocity.x;
		}
		if (chopper.x >= (windowSize.x - chopper.width)) {
			chopperVelocity.x = -1*chopperVelocity.x;
		}
		if (chopper.y <= 0) {
			chopperVelocity.y = -1*chopperVelocity.y;
		}
		if (chopper.y >= (windowSize.y - chopper.height)) {
			chopperVelocity.y = -1*chopperVelocity.y;
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		chopperImage.dispose();
	}
}
