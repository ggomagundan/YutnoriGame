package com.secretBox.yutnori;
import java.util.ArrayList;

import org.cocos2d.actions.base.CCRepeatForever;
import org.cocos2d.actions.interval.CCAnimate;
import org.cocos2d.actions.interval.CCDelayTime;
import org.cocos2d.actions.interval.CCSequence;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCAnimation;
import org.cocos2d.nodes.CCSprite;

import com.secretBox.yutnori.constants.YutnoriBasicConstants;


public class CharacterLayer extends CCLayer{
	private static final float HUCK_CHAR_X =  53.0f;
	private static final float HUCK_CHAR_Y =  242.0f;
	private static final float SIM_CHAR_X =  300.4f;
	private static final float SIM_CHAR_Y =  245.0f;
	
	
	public final static String[] MAIN_H_CHAR_FILE_NAMES = 
		{"game_img/play_hyukgerse_face.png",
		"game_img/play_hyukgerse_face_open.png"		
		};
	public final static String[] MAIN_SIM_CHAR_FILE_NAMES = 
		{
		"game_img/play_simchungie_face.png",
		"game_img/play_simchungie_face_mid_hair.png",
		"game_img/play_simchungie_face_long_hair.png",
		
		};

	ArrayList<CCSprite> simCharList  = new ArrayList<CCSprite>();
	CCSprite huckSprite;
	CCSprite simSprite;
	
	public CharacterLayer()
	{
		float moveWidth = (YutnoriBasicConstants.DISPLAY_WIDTH - YutnoriBasicConstants.GAME_WIDTH )/2;
		float moveHeight = (YutnoriBasicConstants.DISPLAY_HEIGHT - YutnoriBasicConstants.GAME_HEIGHT)/2;
		huckSprite =  CCSprite.sprite(MAIN_H_CHAR_FILE_NAMES[0]);
		huckSprite.setPosition(HUCK_CHAR_X + moveWidth , HUCK_CHAR_Y+moveHeight);
		addChild(huckSprite);
		
		simSprite = CCSprite.sprite(MAIN_SIM_CHAR_FILE_NAMES[0]);
		simSprite.setPosition(SIM_CHAR_X+moveWidth , SIM_CHAR_Y+moveHeight);
		addChild(simSprite);
		
		
	
		
	}
	public void addAniHChar()
	{
		CCAnimation animation =  CCAnimation.animation("hCharAnimation",0.3f);
		
		animation.addFrame(MAIN_H_CHAR_FILE_NAMES[0]);
		animation.addFrame(MAIN_H_CHAR_FILE_NAMES[1]);
		
		CCAnimate frameAni = CCAnimate.action(animation);
		CCDelayTime delay=CCDelayTime.action(0.4f);
		CCSequence seq = CCSequence.actions(frameAni, delay);
		CCRepeatForever repeatAni =  CCRepeatForever.action(seq);
	//	CCRepeat repeatAni = CCRepeat.action(frameAni, 3);
		
		huckSprite.runAction(repeatAni);
		
		
	}
	public void addAniSIMChar()
	{
		CCAnimation animation =  CCAnimation.animation("hCharAnimation",0.3f);
		
		animation.addFrame(MAIN_SIM_CHAR_FILE_NAMES[0]);
		animation.addFrame(MAIN_SIM_CHAR_FILE_NAMES[1]);
		animation.addFrame(MAIN_SIM_CHAR_FILE_NAMES[2]);
		
		CCAnimate frameAni = CCAnimate.action(animation);
		CCRepeatForever repeatAni =  CCRepeatForever.action(frameAni);
	//	CCRepeat repeatAni = CCRepeat.action(frameAni, 3);
	
		simSprite.runAction(repeatAni);
		
		
	}
	

}
