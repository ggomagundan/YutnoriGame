package com.secretBox.yutnori;



import org.cocos2d.actions.base.CCRepeatForever;
import org.cocos2d.actions.interval.CCAnimate;
import org.cocos2d.actions.interval.CCDelayTime;
import org.cocos2d.actions.interval.CCIntervalAction;
import org.cocos2d.actions.interval.CCMoveBy;
import org.cocos2d.actions.interval.CCMoveTo;
import org.cocos2d.actions.interval.CCSequence;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.menus.CCMenu;
import org.cocos2d.menus.CCMenuItemImage;
import org.cocos2d.menus.CCMenuItemToggle;
import org.cocos2d.nodes.CCAnimation;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.sound.SoundEngine;
import org.cocos2d.types.CGSize;



import com.secretBox.yutnori.constants.YutnoriBasicConstants;
import com.secretBox.yutnori.constants.YutnoriPointConstants;

public final class MenuLayer extends CCLayer {

	protected CCScene gScene;
	protected CCScene sScene;
	
	
	private static YutnoriActivity app;

	
	
	private CCLayer creditLayer = CCLayer.node();
	private boolean isCreditVisible = false;
	
	private CCSprite eye_animation;
	private CCSprite background; 
	private CCSprite creditSprite;

//	private CCSprite maxEffectSprite;
//	private CCSprite middleEffectSprite;
//	private CCSprite minEffectSprite;
//	private CCSprite offBackSound;
//	private CCSprite onBackSound;
	private CCSprite dragon_head;
	private CCSprite upCloudSprite;
	private CCSprite downCloudSprite;
	
	private static CCAnimate animate;
	CCIntervalAction upCloudAction; 
    CCIntervalAction downCloudAction;
	
	private CCMenuItemImage exit;
	private CCMenuItemImage gameStartButton;

	private CCMenuItemToggle sound;
	private CCMenuItemToggle backSound;
	private CCMenuItemImage credit;
	
	
			
	CCAnimation animation;

	
	public MenuLayer(CCScene gS, CCScene sS) {
		
		
		app = YutnoriActivity.getActivity();
		
		gScene = gS;
		
		sScene = sS;

		// Display BackGround Image
		background = CCSprite.sprite(YutnoriBasicConstants.MENU_BACKGROUND_IMG);
		
		background.setPosition(YutnoriPointConstants.CENTER_POINT);
		addChild(background);
		
		//background.setScale(YutnoriBasicConstants.scale);


		upCloudSprite = CCSprite.sprite(YutnoriBasicConstants.UP_CLOUD_IMG);
		downCloudSprite = CCSprite.sprite(YutnoriBasicConstants.DOWN_CLOUD_IMG);
		
		CCIntervalAction downCloudMove = CCMoveBy.action(12, YutnoriPointConstants.DOWN_CLOUD_ACTION_POINT);
        CCIntervalAction downCloudMoveBack = downCloudMove.reverse();
       
    
        CCIntervalAction upCloudMove = CCMoveBy.action(7, YutnoriPointConstants.UP_CLOUD_ACTION_POINT_FIRST);
        CCMoveTo upCloudMoveOri =CCMoveTo.action(0.0001f, YutnoriPointConstants.UP_CLOUD_ACTION_POINT_SECOND);
        
        
        
        CCIntervalAction moveDelay = CCDelayTime.action(0.25f);
        
        upCloudAction =CCSequence.actions(upCloudMove, moveDelay, upCloudMoveOri, moveDelay); 
        downCloudAction =CCSequence.actions(downCloudMove, moveDelay, downCloudMoveBack, moveDelay.copy()); 
       
     
        
        upCloudSprite.setPosition(YutnoriPointConstants.UP_CLOUD_POSITION);
       
        
        downCloudSprite.setPosition(YutnoriPointConstants.DOWN_CLOUD_POSITION);
        
       
        
		  
        addChild(upCloudSprite);
		addChild(downCloudSprite);
		 
				
		animation =  CCAnimation.animation("mainEyeAnimation",0.05f);
	
		for(String fileName:YutnoriBasicConstants.EYE_PICTURE_NAMES)
		{
			animation.addFrame(fileName);	
		}
		
		eye_animation = CCSprite.sprite(YutnoriBasicConstants.EYE_PICTURE_NAMES[0]);
		animate = CCAnimate.action(animation);	
		

		dragon_head = CCSprite.sprite(YutnoriBasicConstants.DRAGON_HEAD_IMG);
		dragon_head.setPosition(YutnoriPointConstants.DRAGON_HEAD_POSITION);
		
		addChild(dragon_head);
		
		addChild(eye_animation);
		
		
		eye_animation.setPosition(YutnoriPointConstants.EYE_ANIMATION_POSITION);
		
		
		
		
		gameStartButton = CCMenuItemImage.item(YutnoriBasicConstants.GAME_START_BUTTON_IMG, YutnoriBasicConstants.GAME_START_BUTTON_PRESSED_IMG, 
				this, "startCallback");

		gameStartButton.setPosition(YutnoriPointConstants.GAME_START_POSITION);		
		
		
		
		
//		storyButton = CCMenuItemImage.item(YutnoriBasicConstants.GAME_STORY_BUTTON_IMG, YutnoriBasicConstants.GAME_STORY_BUTTON_PRESSED_IMG,
//				this, "storyCallback");

//		storyButton.setPosition(YutnoriPointConstants.GAME_STORY_POSITION);
		
		

		
		
	//	CCMenu menu = CCMenu.menu(storyButton,gameStartButton);
		CCMenu menu = CCMenu.menu(gameStartButton);
		menu.setPosition(0, 0);
		
				
		
		
		addChild(menu);

		
		
		
		sound = CCMenuItemToggle.item(this, "soundCallback",
				CCMenuItemImage.item(YutnoriBasicConstants.GAME_MORE_EFFECT_PLAY_IMG, YutnoriBasicConstants.GAME_MORE_EFFECT_PLAY_IMG),
				CCMenuItemImage.item(YutnoriBasicConstants.GAME_LESS_EFFECT_PLAY_IMG, YutnoriBasicConstants.GAME_LESS_EFFECT_PLAY_IMG),
				CCMenuItemImage.item(YutnoriBasicConstants.GAME_EFFECT_NON_PLAY_IMG, YutnoriBasicConstants.GAME_EFFECT_NON_PLAY_IMG));
//		maxEffectSprite  = CCSprite.sprite(YutnoriBasicConstants.GAME_MORE_EFFECT_PLAY_IMG);
//		middleEffectSprite  = CCSprite.sprite(YutnoriBasicConstants.GAME_LESS_EFFECT_PLAY_IMG);
//		minEffectSprite  = CCSprite.sprite(YutnoriBasicConstants.GAME_EFFECT_NON_PLAY_IMG);
	
		
		backSound = CCMenuItemToggle.item(this, "backsoundCallback",
				CCMenuItemImage.item(YutnoriBasicConstants.GAME_BACKSOUND_PLAY_IMG, YutnoriBasicConstants.GAME_BACKSOUND_PLAY_IMG),
				CCMenuItemImage.item(YutnoriBasicConstants.GAME_BACKSOUND_NON_PLAY_IMG, YutnoriBasicConstants.GAME_BACKSOUND_NON_PLAY_IMG));
//		onBackSound = CCSprite.sprite(YutnoriBasicConstants.GAME_BACKSOUND_PLAY_IMG);
//		offBackSound = CCSprite.sprite(YutnoriBasicConstants.GAME_BACKSOUND_NON_PLAY_IMG);
		
		credit = CCMenuItemImage.item(YutnoriBasicConstants.GAME_CREDIT_BUTTON_IMG, YutnoriBasicConstants.GAME_CREDIT_BUTTON_PRESSED_IMG, this, "creditCallback");

		CCMenu optionMenu = CCMenu.menu(sound, backSound, credit);
		
		sound.setPosition(YutnoriPointConstants.GAME_EFFECT_POSITION);
//		maxEffectSprite.setPosition(YutnoriPointConstants.GAME_EFFECT_POSITION);
//		middleEffectSprite.setPosition(YutnoriPointConstants.GAME_EFFECT_POSITION);
//		minEffectSprite.setPosition(YutnoriPointConstants.GAME_EFFECT_POSITION);
		
		backSound.setPosition(YutnoriPointConstants.GAME_BACKSOUND_POSITION);
//		onBackSound.setPosition(YutnoriPointConstants.GAME_BACKSOUND_POSITION);
//		offBackSound.setPosition(YutnoriPointConstants.GAME_BACKSOUND_POSITION);
		
		credit.setPosition(YutnoriPointConstants.GAME_CREDIT_POSITION);
		
		optionMenu.setPosition(0, 0);
		addChild(optionMenu);
//		sound.setOpacity((byte) 0);
//		backSound.setOpacity((byte) 0);
//		addChild(maxEffectSprite);
//		addChild(middleEffectSprite);
//		addChild(minEffectSprite);
//		addChild(onBackSound);
//		addChild(offBackSound);
//		maxEffectSprite.setVisible(false);
//		middleEffectSprite.setVisible(false);
//		minEffectSprite.setVisible(false);
//		onBackSound.setVisible(false);
//		offBackSound.setVisible(false);
		
		makeCredit();
	
		this.setIsTouchEnabled(true);
		CCSprite allicon = CCSprite.sprite("allicon.png");
		addChild(allicon);
		allicon.setPosition(allicon.getTexture().getWidth()/2 +5, allicon.getTexture().getHeight()/2+20);
		
	}

	

	
	
	private void makeCredit() {

		creditLayer.setContentSize(CGSize.make(YutnoriBasicConstants.DISPLAY_WIDTH / 2, YutnoriBasicConstants.DISPLAY_HEIGHT / 2));
		creditLayer.setPosition(0, 0);

		creditSprite = CCSprite.sprite(YutnoriBasicConstants.CREDIT_BACKGROUND_IMG);
		creditSprite.setPosition(YutnoriPointConstants.CENTER_POINT);

		creditSprite.setOpacity(225);
		creditLayer.addChild(creditSprite);

		
		exit = CCMenuItemImage.item(YutnoriBasicConstants.CREDIT_EXIT_IMG,YutnoriBasicConstants.CREDIT_EXIT_IMG,this,"creditExitCallback");
		exit.setPosition(YutnoriPointConstants.CREDIT_EXIT_POSITION);
		
		
		
		CCMenu menu = CCMenu.menu(exit);
		menu.setPosition(0, 0);
			
		creditLayer.addChild(menu);
		
		exit.setContentSize(exit.getContentSize().width*YutnoriBasicConstants.scale,(exit.getContentSize().width-20)*YutnoriBasicConstants.scale);

		this.addChild(creditLayer);

		creditLayer.setVisible(isCreditVisible);
	}


	public void startCallback(Object sender) {
		if (isCreditVisible == false && YutnoriBasicConstants.isBackKey == false) {
		
			GameManager.getGame().playEffect("click");
			
			GameManager.getGame().showOrHideLayer();
			CCDirector.sharedDirector().pushScene(
					CCDirector.sharedDirector().getRunningScene());
			CCDirector.sharedDirector().replaceScene(gScene);
		}

	}

	public void storyCallback(Object sender) {
		if (isCreditVisible == false && YutnoriBasicConstants.isBackKey == false) {
			
			GameManager.getGame().playEffect("click");
			
//			GameManager.getGame().showOrHideLayer();
//			CCDirector.sharedDirector().pushScene(
//					CCDirector.sharedDirector().getRunningScene());
//			CCDirector.sharedDirector().replaceScene(sScene);
		}

	}

	public void soundCallback(Object sender) {
		if (isCreditVisible == false && YutnoriBasicConstants.isBackKey == false) {
			
			if(YutnoriBasicConstants.currentVolume == YutnoriBasicConstants.EFFECT_VOLUME.MAX){
//				middleEffectSprite.setVisible(true);
//				maxEffectSprite.setVisible(true);
				
				SoundEngine.sharedEngine().playEffect(app, R.raw.effect_middle);
				GameManager.getGame().setEffectSound(1);
				
			}else if(YutnoriBasicConstants.currentVolume == YutnoriBasicConstants.EFFECT_VOLUME.MIDDLE){
//				minEffectSprite.setVisible(true);
//				middleEffectSprite.setVisible(false);
				GameManager.getGame().setEffectSound(0);
			}else {
//				maxEffectSprite.setVisible(true);
//				minEffectSprite.setVisible(false);
				SoundEngine.sharedEngine().playEffect(app, R.raw.effect_max);
				GameManager.getGame().setEffectSound(2);
				
			}
			
			
		}

	}

	public void backsoundCallback(Object sender) {
		if (isCreditVisible == false && YutnoriBasicConstants.isBackKey == false) {
			
			if (YutnoriBasicConstants.isBackSound == true) {
//				onBackSound.setVisible(false);
//				offBackSound.setVisible(true);
				SoundEngine.sharedEngine().pauseSound();
				GameManager.getGame().setBackSound();
			} else {
//				offBackSound.setVisible(false);
//				onBackSound.setVisible(true);
				SoundEngine.sharedEngine().resumeSound();
				GameManager.getGame().setBackSound();
			}
		}

	}

	public void creditCallback(Object sender) {

		if (isCreditVisible == false && YutnoriBasicConstants.isBackKey == false) {
			
			GameManager.getGame().playEffect("click");
			creditLayer.setVisible(true);
			isCreditVisible = true;
		}
	}

	public void creditExitCallback(Object sender) {
		
		if (isCreditVisible == true && YutnoriBasicConstants.isBackKey == false) {
				
				isCreditVisible = false;
				creditLayer.setVisible(false);
			
		}
	}

	
	
	@Override
	public void onEnter() {
		super.onEnter();
		YutnoriBasicConstants.isBackKey = false;

		GameManager.getGame().showOrHideLayer();
		
		CCDelayTime delayAction = CCDelayTime.action(1.4f);
		CCRepeatForever animates =  CCRepeatForever.action(CCSequence.actions(animate, delayAction));
		
		
		
		eye_animation.runAction(animates);
		
		//setSoundSprite();
	
		upCloudSprite.runAction(CCRepeatForever.action(upCloudAction));
        downCloudSprite.runAction(CCRepeatForever.action(downCloudAction));
	
		GameManager.getGame().preLoadMusics();
		
		if(YutnoriBasicConstants.isBackSound == false){
			SoundEngine.sharedEngine().pauseSound();
		}else{
			SoundEngine.sharedEngine().playSound(app, R.raw.blue_sky, true);
		}
	}

//	private void setSoundSprite() {
//		
//		if(YutnoriBasicConstants.currentVolume == YutnoriBasicConstants.EFFECT_VOLUME.MAX){
//			maxEffectSprite.setVisible(true);
//		}else if(YutnoriBasicConstants.currentVolume == YutnoriBasicConstants.EFFECT_VOLUME.MIDDLE){
//			middleEffectSprite.setVisible(true);
//		}else{
//			minEffectSprite.setVisible(true);
//		}
//		
//		if(YutnoriBasicConstants.isBackSound == true){
//			onBackSound.setVisible(true);
//		}else{
//			offBackSound.setVisible(true);
//		}
//		
//		
//	}

	public void applyScale(float scale) {
		
		background.setScale(scale);
	//	storyButton.setScale(scale);
		gameStartButton.setScale(scale);
		sound.setScale(scale);
		backSound.setScale(scale);
		eye_animation.setScale(scale);
		creditLayer.setScale(scale);
		dragon_head.setScale(scale);
		
		
	}

	
	
}



