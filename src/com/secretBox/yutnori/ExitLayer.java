package com.secretBox.yutnori;

import org.cocos2d.layers.CCColorLayer;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.menus.CCMenu;
import org.cocos2d.menus.CCMenuItemImage;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.ccColor4B;

import android.util.Log;

import com.secretBox.yutnori.constants.YutnoriBasicConstants;
import com.secretBox.yutnori.constants.YutnoriPointConstants;

public class ExitLayer extends CCLayer {
	
	public static ExitLayer layer=new ExitLayer();
	public static ExitLayer getLayer() {
		return layer;
	}
	
	private ExitLayer(){
		super();
		
		
		CCColorLayer exitBG = CCColorLayer.node(ccColor4B.ccc4(0, 0, 0, 200));
		addChild(exitBG);
		CCSprite endString = CCSprite.sprite("end_img/end_string.png");
		exitBG.addChild(endString);
		endString.setPosition(YutnoriPointConstants.CENTER_POINT.x, YutnoriPointConstants.CENTER_POINT.y + 200);
		
		
		
		
		
	//	layer.setContentSize(CGSize.make(YutnoriBasicConstants.DISPLAY_WIDTH/2, YutnoriBasicConstants.DISPLAY_HEIGHT/2));
	//	layer.setPosition(0, 0);
	
//		CCSprite exitBackground = CCSprite.sprite(YutnoriBasicConstants.GAME_EXIT_BACKGROUND_IMG);
	
		
//		exitBackground.setPosition(YutnoriPointConstants.CENTER_POINT);
	
		
//		layer.addChild(exitBackground);
	
		
		
		CCMenuItemImage yes = CCMenuItemImage.item("end_img/exit_ask_yes_button.png","end_img/exit_ask_yes_button.png", this, "yesCallback");
		yes.setPosition(YutnoriPointConstants.CENTER_POINT.x-120, YutnoriPointConstants.CENTER_POINT.y - 200);
		
		
		CCMenuItemImage no =  CCMenuItemImage.item("end_img/exit_ask_no_button.png","end_img/exit_ask_no_button.png",this,"noCallback");
		no.setPosition(YutnoriPointConstants.CENTER_POINT.x +120, YutnoriPointConstants.CENTER_POINT.y - 200);
	
		CCMenu menu = CCMenu.menu(yes,no);
		menu.setPosition(0, 0);
		exitBG.addChild(menu);
	
		setIsTouchEnabled(true);	
		
	}
	
	
	
	
	
	public void noCallback(Object Sender) {

		YutnoriBasicConstants.isBackKey = false;
		
		showOrHideLayer();
	}
	
	public void yesCallback(Object Sender) {

		YutnoriBasicConstants.isBackKey = false;
		while(CCDirector.sharedDirector().getRunningScene() != null){
			CCDirector.sharedDirector().getRunningScene().cleanup();
			CCDirector.sharedDirector().popScene();
		}
		CCDirector.sharedDirector().end();
		
		YutnoriActivity app = YutnoriActivity.getActivity();
		app.onDestroy();
		app.finish();
		System.exit(0);		
	}

	

	public void showOrHideLayer() {
		if(YutnoriBasicConstants.isBackKey == true){
			if(CCDirector.sharedDirector().getRunningScene() == null) {
				YutnoriActivity app = YutnoriActivity.getActivity();
				Log.d("PBS", "Director Null"); 
				app.onDestroy();
				app.finish();
			}else if(!(CCDirector.sharedDirector().getRunningScene()
					.getChildren()
					.contains(this))){
				CCDirector.sharedDirector().getRunningScene().addChild(this);
			}
			setVisible(YutnoriBasicConstants.isBackKey);
		}else{
			setVisible(YutnoriBasicConstants.isBackKey);
			
		}
		
		
		
	}


}
