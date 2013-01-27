package com.secretBox.yutnori;
import org.cocos2d.actions.base.CCRepeatForever;
import org.cocos2d.actions.interval.CCAnimate;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.menus.CCMenu;
import org.cocos2d.menus.CCMenuItemImage;
import org.cocos2d.nodes.CCAnimation;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;

import com.secretBox.yutnori.constants.YutnoriBasicConstants;
import com.secretBox.yutnori.constants.YutnoriLogicConstants.GameStep;
import com.secretBox.yutnori.constants.YutnoriPointConstants;


public class SelectLayer extends CCLayer{
	public final static String[] CANCEL_BUTTON_FILE_NAMES = 
		{
		"game_img/play_horse_go_cancel_button.png",
		"game_img/play_horse_go_cancel_button_press.png"	
		};
	public final static String[] ADD_HORSE_BUTTON_FILE_NAMES = 
		{
		"game_img/play_horse_select_button.png",
		"game_img/play_horse_select_button_press.png"	
		};
	public final static String[] GET_IN_POINT_FILE_NAMES = 
		{
		"game_img/play_horse_get_in_point_big.png",
		"game_img/play_horse_get_in_point_mid.png",
		"game_img/play_horse_get_in_point_small.png"
		};
	
	
	public CCMenuItemImage cancelButton;
	public CCMenuItemImage addHorseButton;
	public CCSprite[] horsePosButtons = new CCSprite[YutnoriPointConstants.MOVE_POINT_LIST.size()];
	public CCRepeatForever[] repeatAni = new CCRepeatForever[YutnoriPointConstants.MOVE_POINT_LIST.size()];
	public SelectLayer()
	{
		
		for(int i=0;i< YutnoriPointConstants.MOVE_POINT_LIST.size();i++)
		{
			horsePosButtons[i] = CCSprite.sprite(GET_IN_POINT_FILE_NAMES[0]);
			addChild(horsePosButtons[i]);
			CGPoint p = YutnoriPointConstants.MOVE_POINT_LIST.get(i);
			horsePosButtons[i].setPosition(p.x,YutnoriBasicConstants.DISPLAY_HEIGHT-p.y);
			horsePosButtons[i].setOpacity(200);
			
			CCAnimation animation =  CCAnimation.animation("selectAnimation"+i,0.3f);
			
			animation.addFrame(GET_IN_POINT_FILE_NAMES[0]);
			animation.addFrame(GET_IN_POINT_FILE_NAMES[1]);
			animation.addFrame(GET_IN_POINT_FILE_NAMES[2]);
			
			CCAnimate frameAni = CCAnimate.action(animation);
			
			repeatAni[i] =  CCRepeatForever.action(frameAni);
				
		}
		cancelButton = CCMenuItemImage.item(CANCEL_BUTTON_FILE_NAMES[0], CANCEL_BUTTON_FILE_NAMES[1],
				this, "callbackCancelButton");

		float moveWidth = (YutnoriBasicConstants.DISPLAY_WIDTH - YutnoriBasicConstants.GAME_WIDTH )/2;
		float moveHeight = (YutnoriBasicConstants.DISPLAY_HEIGHT - YutnoriBasicConstants.GAME_HEIGHT)/2;
		
		
		
		
		cancelButton.setPosition(240 + moveWidth , 280+moveHeight);		
		CCMenu menu = CCMenu.menu(cancelButton);
		menu.setPosition(0,0);
		addChild(menu);
		
		addHorseButton = CCMenuItemImage.item(ADD_HORSE_BUTTON_FILE_NAMES[0], ADD_HORSE_BUTTON_FILE_NAMES[1],
				this, "callbackAddHorseButton");

		addHorseButton.setPosition(240 + moveWidth , 280+moveHeight);		
		CCMenu menu2 = CCMenu.menu(addHorseButton);
		menu2.setPosition(0,0);
		addChild(menu2);

		
	}
	public void showPosButton(int index)
	{
		horsePosButtons[index].setVisible(true);
		horsePosButtons[index].runAction(repeatAni[index]);
	}
	public void hidePosButton(int index)
	{
		
	}
	public void hideHorsePosButtons()
	{
		for(CCSprite horsePosButton:horsePosButtons)
		{
			horsePosButton.stopAllActions();
			horsePosButton.setVisible(false);
		}
	}
	
	public int findIndexFromHorsePosButtons(CCSprite sprite)
	{
		for(int i=0;i<horsePosButtons.length;i++)
		{
			if(horsePosButtons[i] == sprite)
				return i;
		}
		return -1;
	}


	public void callbackCancelButton(Object sender)
	{
		cancelButton.setVisible(false);
		hideHorsePosButtons();
		GameManager.getGame().changeStep(GameStep.YUT_ANING_OFF_TURN);
		GameManager.getGame().gLayer.callbackYutHide(null);
		
		
		
	
	}
	public void callbackAddHorseButton(Object sender)
	{	
		
		GameManager.getGame().gLayer.ccTouchesEnded(null);
	}
}
