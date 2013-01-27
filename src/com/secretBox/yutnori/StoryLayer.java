package com.secretBox.yutnori;


import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.menus.CCMenu;
import org.cocos2d.menus.CCMenuItemImage;
import org.cocos2d.menus.CCMenuItemLabel;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;


import com.secretBox.yutnori.constants.YutnoriBasicConstants;
import com.secretBox.yutnori.constants.YutnoriPointConstants;

public class StoryLayer extends CCLayer {

	int depth;
	CCMenuItemImage backButton= null;
	CCMenuItemLabel preLabel = null;
	CCMenuItemLabel nextLabel = null;
	CCSprite background;
	int compareStartEnd;
	
	public StoryLayer(int depth) {
		
		super();
		
		if(depth == 0){
			compareStartEnd = 0;
		}else if(depth+1 == YutnoriBasicConstants.STORY_IMG_LIST.length){
			compareStartEnd = 2;
		}else{
			compareStartEnd = 1;
		}
		
		this.depth = depth; 
		
		


		background = CCSprite.sprite(YutnoriBasicConstants.STORY_IMG_LIST[depth]);
		background.setPosition(YutnoriPointConstants.CENTER_POINT);
		addChild(background);
		
		
		CCMenu menu = CCMenu.menu();
		
		backButton = CCMenuItemImage.item(YutnoriBasicConstants.BACK_KEY_IMG, YutnoriBasicConstants.BACK_KEY_IMG, this, "backCallback");
		menu.addChild(backButton);
		backButton.setPosition(YutnoriPointConstants.STORY_BACK_POSITION);
		switch(compareStartEnd){
			case 0:
				nextLabel = CCMenuItemLabel.item("next", this,
						"nextCallback");
				
				menu.addChild(nextLabel);
				
				nextLabel.setPosition(YutnoriPointConstants.STORY_NEXT_POSITION);
				break;
			case 1:
				preLabel = CCMenuItemLabel.item("pre", this,
						 "preCallback");
				nextLabel = CCMenuItemLabel.item("next", this,
						"nextCallback");
				menu.addChild(preLabel);
				menu.addChild(nextLabel);
				preLabel.setPosition(YutnoriPointConstants.STORY_PRE_POSITION);
				nextLabel.setPosition(YutnoriPointConstants.STORY_NEXT_POSITION);
				break;
			case 2:
				preLabel = CCMenuItemLabel.item("pre", this,
						 "preCallback");
				menu.addChild(preLabel);
				preLabel.setPosition(YutnoriPointConstants.STORY_PRE_POSITION);
				break;
		}
		

		menu.setPosition(0, 0);



		addChild(menu);
		

		
	}
	
	
	
	
	

	public void backCallback(Object Sender) {
		YutnoriBasicConstants.isBackKey = false;
		
		GameManager.getGame().playEffect("back");
		
		GameManager.getGame().showOrHideLayer();
		for(int i =0 ;i < depth+1;i++)
			CCDirector.sharedDirector().popScene();
	}
	
	public void preCallback(Object Sender) {
		YutnoriBasicConstants.isBackKey = false;
		
		GameManager.getGame().playEffect("click");
		
		GameManager.getGame().showOrHideLayer();
		CCDirector.sharedDirector().popScene();

	}

	public void nextCallback(Object Sender) {
		CCScene s = CCScene.node();
		
		GameManager.getGame().playEffect("click");
	
		YutnoriBasicConstants.isBackKey = false;
		GameManager.getGame().showOrHideLayer();
		StoryLayer cLayer = new StoryLayer(depth+1);
		s.addChild(cLayer);
		cLayer.applyScale(YutnoriBasicConstants.scale);
		CCDirector.sharedDirector().pushScene(
				CCDirector.sharedDirector().getRunningScene());
		CCDirector.sharedDirector().replaceScene(s);

	}






	public void applyScale(float scale) {
		
		
		background.setScale(scale);
		backButton.setScale(scale);
		
		
		
		switch(compareStartEnd){
		case 0:
			nextLabel.setScale(scale);
			break;
		case 1:
			preLabel.setScale(scale);
			nextLabel.setScale(scale);
			break;
		case 2:
			preLabel.setScale(scale);
			break;
		}
	}

}
