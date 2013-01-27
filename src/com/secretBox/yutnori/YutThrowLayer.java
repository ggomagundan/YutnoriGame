package com.secretBox.yutnori;


import org.cocos2d.actions.base.CCRepeatForever;

import org.cocos2d.actions.instant.CCCallFuncN;
import org.cocos2d.actions.interval.CCAnimate;
import org.cocos2d.actions.interval.CCDelayTime;
import org.cocos2d.actions.interval.CCRepeat;
import org.cocos2d.actions.interval.CCSequence;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.menus.CCMenu;
import org.cocos2d.menus.CCMenuItemImage;
import org.cocos2d.nodes.CCAnimation;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.nodes.CCSpriteFrame;
import org.cocos2d.types.CGSize;



import com.secretBox.yutnori.constants.YutnoriBasicConstants;
import com.secretBox.yutnori.constants.YutnoriLogicConstants;
import com.secretBox.yutnori.constants.YutnoriLogicConstants.GameStep;
import com.secretBox.yutnori.logic.YutSet;


public class YutThrowLayer extends CCLayer{

	GameLayer gameLayer =null;
	
	
	CCSprite background;
	CCSprite[] yuts = new CCSprite[7];;
	CCSprite[] yutChars = new CCSprite[7];
	CCSprite yuts_animation; 
	
	
	boolean isAgain= false;
	CCSpriteFrame[] frames = new CCSpriteFrame[7];

	CCRepeatForever repeatForeverAni;
	CCSequence sequenceAni;
	CCMenu menu ;
	public YutThrowLayer(GameLayer in_gameLayer)
	{
		gameLayer = in_gameLayer;
		
		background = CCSprite.sprite(YutnoriBasicConstants.YUT_THROW_LAYER);
		addChild(background);
		
		yuts_animation = CCSprite.sprite(YutnoriLogicConstants.YUT_FILE_NAMES[1]);
		
		addChild(yuts_animation);
		yuts_animation.setPosition(0, 70);
		
		
		

			
		CGSize backgroundSize = background.getContentSize();
		
		float yutCharPointWidth = backgroundSize.width/ 2;
		float yutCharPointHeight = backgroundSize.height /2;
		yutCharPointWidth  = (yutCharPointWidth /3 )*2;
		yutCharPointHeight = (yutCharPointHeight/3 )*2;
		
		for(int i=0;i<yuts.length;i++)
		{

			yuts[i] = CCSprite.sprite(YutnoriLogicConstants.YUT_FILE_NAMES[i]);
			yutChars[i] = CCSprite.sprite(YutnoriLogicConstants.YUT_CHAR_FILE_NAMES[i]);
			yuts[i].setPosition(0, 70);
			yutChars[i].setPosition(yutCharPointWidth,yutCharPointHeight);
			 
			addChild(yuts[i]);
			addChild(yutChars[i]);
		}
		initYuts();
		
		CCAnimation animation =  CCAnimation.animation("yutAnimation",0.2f);
		
		animation.addFrame(YutnoriLogicConstants.YUT_FILE_NAMES[6]);
		animation.addFrame(YutnoriLogicConstants.YUT_FILE_NAMES[1]);
		animation.addFrame(YutnoriLogicConstants.YUT_FILE_NAMES[3]);
		animation.addFrame(YutnoriLogicConstants.YUT_FILE_NAMES[5]);
		animation.addFrame(YutnoriLogicConstants.YUT_FILE_NAMES[4]);
		animation.addFrame(YutnoriLogicConstants.YUT_FILE_NAMES[2]);
		
		CCAnimate frameAni = CCAnimate.action(animation);
		repeatForeverAni =  CCRepeatForever.action(frameAni);
		
		CCRepeat repeatAni = CCRepeat.action(frameAni, 2);
		CCCallFuncN callbackAni = CCCallFuncN.action(this,"callbackYutFinished");
		sequenceAni  = CCSequence.actions(repeatAni,callbackAni);
		
		
		CCMenuItemImage  yutButton = CCMenuItemImage.item(YutnoriLogicConstants.YUT_BUTTON_FILE_NAMES[0], YutnoriLogicConstants.YUT_BUTTON_FILE_NAMES[1],
				this, "callbackYutButton");

		yutButton.setPosition(0 ,-120);		
		menu = CCMenu.menu(yutButton);
		menu.setPosition(0, 0);
		addChild(menu);
		
		
		
	}
	private void initYuts()
	{
		for(int i=0;i<yuts.length;i++)
		{
			yuts[i].setVisible(false);
		}
		for(int i=0;i<yutChars.length;i++)
		{
			yutChars[i].setVisible(false);
		}
		yuts_animation.setVisible(true);
	}
	
	public YutSet.PROPERTY throwYut()
	{
	
		initYuts();
	
		YutSet.PROPERTY yutProperty =GameManager.getGame().throwYuts();
		
		yuts_animation.setVisible(false);
	
		if(yutProperty ==YutSet.PROPERTY.NAK)
		{
			yuts[0].setVisible(true);
			yutChars[0].setVisible(true);
		}
		else if(yutProperty ==YutSet.PROPERTY.BACKDO)
		{
			yuts[1].setVisible(true);
			yutChars[1].setVisible(true);
		
		}else if(yutProperty ==YutSet.PROPERTY.DO)
		{
			yuts[2].setVisible(true);
			yutChars[2].setVisible(true);
		
		}else if(yutProperty ==YutSet.PROPERTY.GE)
		{
			yuts[3].setVisible(true);
			yutChars[3].setVisible(true);
		
		}else if(yutProperty ==YutSet.PROPERTY.GUL)
		{
			yuts[4].setVisible(true);
			yutChars[4].setVisible(true);
		}
		else if(yutProperty ==YutSet.PROPERTY.YUT)
		{
			yuts[5].setVisible(true);
			yutChars[5].setVisible(true);
		}
		else if(yutProperty ==YutSet.PROPERTY.MO)
		{
			yuts[6].setVisible(true);
			yutChars[6].setVisible(true);
		}
		return yutProperty;
		
	}
	

	public void callbackYutShow(Object Sender)
	{
		
		
		if(GameManager.getGame().isHumanTurn == true)
		{
			menu.setVisible(true);
			startAnimation(true);
			GameManager.getGame().changeStep();
		}else//적의 턴인경우
		{
			menu.setVisible(false);
			startAnimation(false);
			
		}
		
	}
	
	public void startAnimation(boolean isRepeatForever)
	{
		initYuts();
		if(isRepeatForever == true)
		{
			yuts_animation.runAction(repeatForeverAni);
		}else
		{
			yuts_animation.runAction(sequenceAni);
		}
		
		
	}
	public void callbackYutFinished(Object Sender)
	{
		YutSet.PROPERTY yutProperty =  throwYut();
		
		
		if(yutProperty == YutSet.PROPERTY.YUT || yutProperty== YutSet.PROPERTY.MO)
		{
			isAgain=true;	
		}
		if(GameManager.getGame().isHumanTurn)
		{
			if(yutProperty!= YutSet.PROPERTY.NAK )
				GameManager.getGame().playerSaveMoveYutList.add(yutProperty);
		}else
		{
			if(yutProperty!= YutSet.PROPERTY.NAK)
				GameManager.getGame().cpuSaveMoveYutList.add(yutProperty);
		}
		
		
		CCDelayTime delayAni = CCDelayTime.action(1.0f);
		CCCallFuncN callbackAni = CCCallFuncN.action(this,"callbackWait");
		yuts_animation.runAction(CCSequence.actions(delayAni,callbackAni));
	}
	
	public void callbackWait(Object Sender)
	{
		
		if(isAgain)
		{
			if(GameManager.getGame().isHumanTurn)
				GameManager.getGame().changeStep(GameStep.YUT_ANING_ON_TURN);
			callbackYutShow(null);
			isAgain=false;
		}else
		{
			if(GameManager.getGame().isHumanTurn == true)
			{
				GameManager.getGame().changeStep();
			}
			gameLayer.hideYutThrowLayer();
		}
	}
	
	public void stopYutAnimation()
	{
		yuts_animation.stopAllActions();
	}

	public void callbackYutButton(Object Sender)
	{
		if(GameManager.getGame().getStep() == GameStep.YUT_INTERACTION_TURN) //윷던지기
		{
			GameManager.getGame().playEffect("click");
			GameManager.getGame().changeStep();
			stopYutAnimation();
			callbackYutFinished(null);
			 
		}
		
	}

}
