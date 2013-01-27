package com.secretBox.yutnori.constants;

import java.util.ArrayList;


import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;


public class YutnoriPointConstants {
	
	private final static float HEIGHT_GAP = (YutnoriBasicConstants.DISPLAY_HEIGHT-YutnoriBasicConstants.GAME_HEIGHT*YutnoriBasicConstants.scale)/2;
	private final static float x_gap  = (YutnoriBasicConstants.DISPLAY_WIDTH-YutnoriBasicConstants.GAME_WIDTH)/2;
	private final static float y_gap  = (YutnoriBasicConstants.DISPLAY_HEIGHT-YutnoriBasicConstants.GAME_HEIGHT)/2;
	
	public final static float hCharacterPositionX = 
			(float) (YutnoriBasicConstants.DISPLAY_WIDTH  * 0.120f);
	
	public final static float hCharacterPositionY = 
			(float) (YutnoriBasicConstants.DISPLAY_HEIGHT - (YutnoriBasicConstants.DISPLAY_HEIGHT * 0.700f));
	
	/*
	private final static float simCharacterPositionX = 
			(float) (YutnoriBasicConstants.DISPLAY_HEIGHT - (YutnoriBasicConstants.DISPLAY_HEIGHT * 0.850f));
	
	private final static float simCharacterPositionY = 
			(float) (YutnoriBasicConstants.DISPLAY_HEIGHT - (YutnoriBasicConstants.DISPLAY_HEIGHT * 0.850f));
			*/
	
	public static CGPoint DRAGON_HEAD_POSITION = CGPoint.make((float)(YutnoriBasicConstants.DISPLAY_WIDTH*0.43918), 
			(float)(YutnoriBasicConstants.DISPLAY_HEIGHT*0.4270));
	
	
	public static CGPoint UP_CLOUD_POSITION = CGPoint.make( -CCSprite.sprite(YutnoriBasicConstants.UP_CLOUD_IMG).getTexture().getWidth()*1.5f, 
			(float) (YutnoriBasicConstants.DISPLAY_HEIGHT*0.52));
    public static CGPoint DOWN_CLOUD_POSITION = CGPoint.make( -CCSprite.sprite(YutnoriBasicConstants.DOWN_CLOUD_IMG).getTexture().getWidth(), 
    		(float) (YutnoriBasicConstants.DISPLAY_HEIGHT*0.175));
	
	public static CGPoint DOWN_CLOUD_ACTION_POINT = CGPoint.make(YutnoriBasicConstants.DISPLAY_WIDTH 
			+ CCSprite.sprite(YutnoriBasicConstants.DOWN_CLOUD_IMG).getTexture().getWidth()*2, 0);
	
	public static CGPoint UP_CLOUD_ACTION_POINT_FIRST = CGPoint.make(YutnoriBasicConstants.DISPLAY_WIDTH*2.5f,0);
	public static CGPoint UP_CLOUD_ACTION_POINT_SECOND = CGPoint.make(-CCSprite.sprite(YutnoriBasicConstants.UP_CLOUD_IMG).getTexture().getWidth()*1.5f,
			UP_CLOUD_POSITION.y);
	
	
	
   
    
	  
	
	
	
	
	
	private final static float characterPositionY = 
			(float) (YutnoriBasicConstants.GAME_HEIGHT - (YutnoriBasicConstants.GAME_HEIGHT * 0.874f));
	private final static float endCharacterPositionY = 
			(float) (YutnoriBasicConstants.GAME_HEIGHT - (YutnoriBasicConstants.GAME_HEIGHT * 0.973f));
	
	public final static CGPoint CENTER_POINT = CGPoint.make(YutnoriBasicConstants.DISPLAY_WIDTH / 2, YutnoriBasicConstants.DISPLAY_HEIGHT / 2);
	
	public final static CGPoint EYE_ANIMATION_POSITION = CGPoint.make((float)(YutnoriBasicConstants.DISPLAY_WIDTH*0.3465), 
			(float)(YutnoriBasicConstants.DISPLAY_HEIGHT*0.4210));
	
	public final static CGPoint GAME_START_POSITION = CGPoint.make((float)(YutnoriBasicConstants.DISPLAY_WIDTH*0.770), 
			(float)((YutnoriBasicConstants.DISPLAY_HEIGHT-YutnoriBasicConstants.DISPLAY_HEIGHT*0.7736)));
	
	public final static CGPoint GAME_STORY_POSITION = CGPoint.make(YutnoriBasicConstants.DISPLAY_WIDTH / 5 *2, YutnoriBasicConstants.DISPLAY_HEIGHT / 5*3);
	
	public final static CGPoint GAME_EFFECT_POSITION = CGPoint.make(YutnoriBasicConstants.DISPLAY_WIDTH / 3 * 2, 
			(float) (YutnoriBasicConstants.DISPLAY_HEIGHT*0.07));
	public final static CGPoint GAME_BACKSOUND_POSITION = CGPoint.make(YutnoriBasicConstants.DISPLAY_WIDTH / 3 * 2 + YutnoriBasicConstants.DISPLAY_WIDTH / 8, 
			(float) (YutnoriBasicConstants.DISPLAY_HEIGHT*0.07));
	public final static CGPoint GAME_CREDIT_POSITION = CGPoint.make(YutnoriBasicConstants.DISPLAY_WIDTH / 3 * 2 + YutnoriBasicConstants.DISPLAY_WIDTH / 4, 
			(float) (YutnoriBasicConstants.DISPLAY_HEIGHT*0.07));
	
	public final static CGPoint CREDIT_EXIT_POSITION = CGPoint.make(YutnoriBasicConstants.DISPLAY_WIDTH / 2, 
			CENTER_POINT.y - CCSprite.sprite(YutnoriBasicConstants.CREDIT_BACKGROUND_IMG).getTexture().getHeight() / 2 
			+ CCSprite.sprite(YutnoriBasicConstants.CREDIT_EXIT_IMG).getTexture().getHeight());
	
	public final static CGPoint STORY_BACK_POSITION = 	CGPoint.make(CCSprite.sprite(YutnoriBasicConstants.BACK_KEY_IMG).getTexture().getWidth()/2, 
			YutnoriBasicConstants.DISPLAY_HEIGHT - (CCSprite.sprite(YutnoriBasicConstants.BACK_KEY_IMG).getTexture().getHeight()/2) - HEIGHT_GAP);
	public final static CGPoint STORY_PRE_POSITION = 	CGPoint.make(YutnoriBasicConstants.DISPLAY_WIDTH / 10 * 1, (float)(YutnoriBasicConstants.DISPLAY_HEIGHT * 0.052));
	public final static CGPoint STORY_NEXT_POSITION = 	CGPoint.make(YutnoriBasicConstants.DISPLAY_WIDTH / 10 * 9, (float)(YutnoriBasicConstants.DISPLAY_HEIGHT * 0.052));
	
	public final static CGPoint GAME_EXIT_YES_POSITION = CGPoint.make(YutnoriBasicConstants.DISPLAY_WIDTH/2 - CENTER_POINT.x/3,
			CENTER_POINT.y - CCSprite.sprite(YutnoriBasicConstants.GAME_EXIT_BACKGROUND_IMG).getTexture().getHeight()/2
			+ CCSprite.sprite(YutnoriBasicConstants.GAME_EXIT_YES_IMG).getTexture().getHeight()/2);
	
	public final static CGPoint GAME_EXIT_NO_POSITION = CGPoint.make(YutnoriBasicConstants.DISPLAY_WIDTH/2 + CENTER_POINT.x/3,
			CENTER_POINT.y - CCSprite.sprite(YutnoriBasicConstants.GAME_EXIT_BACKGROUND_IMG).getTexture().getHeight()/2
			+ CCSprite.sprite(YutnoriBasicConstants.GAME_EXIT_NO_IMG).getTexture().getHeight()/2);
			
	
	public final static CGPoint GAME_PLAY_BACK_POSITION = CGPoint.make(CCSprite.sprite(YutnoriBasicConstants.BACK_KEY_IMG).getTexture().getWidth()/2 + (YutnoriBasicConstants.DISPLAY_WIDTH-YutnoriBasicConstants.GAME_WIDTH)/2, 
			(YutnoriBasicConstants.GAME_HEIGHT - (CCSprite.sprite(YutnoriBasicConstants.BACK_KEY_IMG).getTexture().getHeight())/2 )+(YutnoriBasicConstants.DISPLAY_HEIGHT-YutnoriBasicConstants.GAME_HEIGHT)/2);
	
	public final static CGPoint GAME_HORSE_SELECT_CANCEL_POSITION = CGPoint.make(YutnoriBasicConstants.DISPLAY_WIDTH/2 ,YutnoriBasicConstants.DISPLAY_HEIGHT/3);
			
	private final static float HORSE_DISTANCE = 0.087f; 
	
	// First Horse Start Point
	public final static ArrayList<CGPoint>  F_HORSE_POINT_LIST = new ArrayList<CGPoint>();
	static {
		F_HORSE_POINT_LIST.add(CGPoint.make((float) ((float)YutnoriBasicConstants.GAME_WIDTH * (0.14 +HORSE_DISTANCE * 0.0f)+x_gap), characterPositionY+y_gap));
		F_HORSE_POINT_LIST.add(CGPoint.make((float) ((float)YutnoriBasicConstants.GAME_WIDTH * (0.14 +HORSE_DISTANCE * 1.0f)+x_gap), characterPositionY+y_gap));
		F_HORSE_POINT_LIST.add(CGPoint.make((float) ((float)YutnoriBasicConstants.GAME_WIDTH * (0.14 +HORSE_DISTANCE * 2.0f)+x_gap), characterPositionY+y_gap));
		F_HORSE_POINT_LIST.add(CGPoint.make((float) ((float)YutnoriBasicConstants.GAME_WIDTH * (0.14 +HORSE_DISTANCE * 3.0f)+x_gap), characterPositionY+y_gap));

	}
	
	// Second Horse Start Point
	public final static ArrayList<CGPoint>  S_HORSE_POINT_LIST = new ArrayList<CGPoint>();
	static {
		S_HORSE_POINT_LIST.add(CGPoint.make((float) (YutnoriBasicConstants.GAME_WIDTH * (0.64 + HORSE_DISTANCE * 0.0f)+x_gap), characterPositionY+y_gap));
		S_HORSE_POINT_LIST.add(CGPoint.make((float) (YutnoriBasicConstants.GAME_WIDTH * (0.64 + HORSE_DISTANCE * 1.0f)+x_gap), characterPositionY+y_gap));
		S_HORSE_POINT_LIST.add(CGPoint.make((float) (YutnoriBasicConstants.GAME_WIDTH * (0.64 + HORSE_DISTANCE * 2.0f)+x_gap), characterPositionY+y_gap));
		S_HORSE_POINT_LIST.add(CGPoint.make((float) (YutnoriBasicConstants.GAME_WIDTH * (0.64 + HORSE_DISTANCE * 3.0f)+x_gap), characterPositionY+y_gap));
	}
	
	
	// First Horse End Point
	public final static ArrayList<CGPoint>  F_HORSE_END_POINT_LIST = new ArrayList<CGPoint>();
	static{
		F_HORSE_END_POINT_LIST.add(CGPoint.make((float) ((float)YutnoriBasicConstants.GAME_WIDTH * (0.14 + HORSE_DISTANCE * 0.0f)+x_gap), endCharacterPositionY+y_gap));
		F_HORSE_END_POINT_LIST.add(CGPoint.make((float) ((float)YutnoriBasicConstants.GAME_WIDTH * (0.14 + HORSE_DISTANCE * 1.0f)+x_gap), endCharacterPositionY+y_gap));
		F_HORSE_END_POINT_LIST.add(CGPoint.make((float) ((float)YutnoriBasicConstants.GAME_WIDTH * (0.14 + HORSE_DISTANCE * 2.0f)+x_gap), endCharacterPositionY+y_gap));
		F_HORSE_END_POINT_LIST.add(CGPoint.make((float) ((float)YutnoriBasicConstants.GAME_WIDTH * (0.14 + HORSE_DISTANCE * 3.0f)+x_gap), endCharacterPositionY+y_gap));
	}
	
	// Second Horse End Point
	public final static ArrayList<CGPoint>  S_HORSE_END_POINT_LIST = new ArrayList<CGPoint>();
	static{
		S_HORSE_END_POINT_LIST.add(CGPoint.make((float) (YutnoriBasicConstants.GAME_WIDTH * (0.64 + HORSE_DISTANCE * 0.0f)+x_gap), endCharacterPositionY+y_gap));
		S_HORSE_END_POINT_LIST.add(CGPoint.make((float) (YutnoriBasicConstants.GAME_WIDTH * (0.64 + HORSE_DISTANCE * 1.0f)+x_gap), endCharacterPositionY+y_gap));
		S_HORSE_END_POINT_LIST.add(CGPoint.make((float) (YutnoriBasicConstants.GAME_WIDTH * (0.64 + HORSE_DISTANCE * 2.0f)+x_gap), endCharacterPositionY+y_gap));
		S_HORSE_END_POINT_LIST.add(CGPoint.make((float) (YutnoriBasicConstants.GAME_WIDTH * (0.64 + HORSE_DISTANCE * 3.0f)+x_gap), endCharacterPositionY+y_gap));
	}
	
	
	
	private final static float MOVE_POINT_1_X = (float) (YutnoriBasicConstants.GAME_WIDTH * 0.634)+x_gap;
	private final static float MOVE_POINT_2_X = (float) (YutnoriBasicConstants.GAME_WIDTH * 0.754)+x_gap;
	private final static float MOVE_POINT_3_X = (float) (YutnoriBasicConstants.GAME_WIDTH * 0.846)+x_gap;
	private final static float MOVE_POINT_4_X = (float) (YutnoriBasicConstants.GAME_WIDTH * 0.908)+x_gap;
	private final static float MOVE_POINT_5_X = (float) (YutnoriBasicConstants.GAME_WIDTH * 0.922)+x_gap;
	private final static float MOVE_POINT_6_X = MOVE_POINT_4_X;
	private final static float MOVE_POINT_7_X = MOVE_POINT_3_X;
	private final static float MOVE_POINT_8_X = MOVE_POINT_2_X;
	private final static float MOVE_POINT_9_X = MOVE_POINT_1_X;
	private final static float MOVE_POINT_10_X =(float) (YutnoriBasicConstants.GAME_WIDTH * 0.500)+x_gap;
	private final static float MOVE_POINT_11_X =(float) (YutnoriBasicConstants.GAME_WIDTH * 0.367)+x_gap;
	private final static float MOVE_POINT_12_X =(float) (YutnoriBasicConstants.GAME_WIDTH * 0.248)+x_gap;
	private final static float MOVE_POINT_13_X =(float) (YutnoriBasicConstants.GAME_WIDTH * 0.154)+x_gap;
	private final static float MOVE_POINT_14_X =(float) (YutnoriBasicConstants.GAME_WIDTH * 0.092)+x_gap;
	private final static float MOVE_POINT_15_X =(float) (YutnoriBasicConstants.GAME_WIDTH * 0.076)+x_gap;
	private final static float MOVE_POINT_16_X =MOVE_POINT_14_X;
	private final static float MOVE_POINT_17_X =MOVE_POINT_13_X;
	private final static float MOVE_POINT_18_X =MOVE_POINT_12_X;
	private final static float MOVE_POINT_19_X =MOVE_POINT_11_X;
	private final static float MOVE_POINT_20_X =MOVE_POINT_10_X;
	private final static float MOVE_POINT_21_X =(float) (YutnoriBasicConstants.GAME_WIDTH * 0.780)+x_gap;
	private final static float MOVE_POINT_22_X =(float) (YutnoriBasicConstants.GAME_WIDTH * 0.668)+x_gap;
	private final static float MOVE_POINT_23_X =MOVE_POINT_10_X;
	private final static float MOVE_POINT_24_X =(float) (YutnoriBasicConstants.GAME_WIDTH * 0.334)+x_gap;
	private final static float MOVE_POINT_25_X =(float) (YutnoriBasicConstants.GAME_WIDTH * 0.224)+x_gap;
	private final static float MOVE_POINT_26_X =MOVE_POINT_10_X;
	private final static float MOVE_POINT_27_X =MOVE_POINT_10_X;
	private final static float MOVE_POINT_28_X =MOVE_POINT_10_X;
	private final static float MOVE_POINT_29_X =MOVE_POINT_10_X;

	
	
	private final static float MOVE_POINT_1_Y = (float) (YutnoriBasicConstants.GAME_HEIGHT * 0.541)+y_gap;
	private final static float MOVE_POINT_2_Y = (float) (YutnoriBasicConstants.GAME_HEIGHT * 0.506)+y_gap;
	private final static float MOVE_POINT_3_Y = (float) (YutnoriBasicConstants.GAME_HEIGHT * 0.449)+y_gap;
	private final static float MOVE_POINT_4_Y = (float) (YutnoriBasicConstants.GAME_HEIGHT * 0.381)+y_gap;
	private final static float MOVE_POINT_5_Y = (float) (YutnoriBasicConstants.GAME_HEIGHT * 0.304)+y_gap;
	private final static float MOVE_POINT_6_Y = (float) (YutnoriBasicConstants.GAME_HEIGHT * 0.223)+y_gap;
	private final static float MOVE_POINT_7_Y = (float) (YutnoriBasicConstants.GAME_HEIGHT * 0.154)+y_gap;
	private final static float MOVE_POINT_8_Y = (float) (YutnoriBasicConstants.GAME_HEIGHT * 0.096)+y_gap;	
	private final static float MOVE_POINT_9_Y = (float) (YutnoriBasicConstants.GAME_HEIGHT * 0.057)+y_gap;
	private final static float MOVE_POINT_10_Y =(float) (YutnoriBasicConstants.GAME_HEIGHT * 0.053)+y_gap;
	private final static float MOVE_POINT_11_Y =MOVE_POINT_9_Y;
	private final static float MOVE_POINT_12_Y =MOVE_POINT_8_Y;
	private final static float MOVE_POINT_13_Y =MOVE_POINT_7_Y;
	private final static float MOVE_POINT_14_Y =MOVE_POINT_6_Y;
	private final static float MOVE_POINT_15_Y =MOVE_POINT_5_Y;
	private final static float MOVE_POINT_16_Y =MOVE_POINT_4_Y;
	private final static float MOVE_POINT_17_Y =MOVE_POINT_3_Y;
	private final static float MOVE_POINT_18_Y =MOVE_POINT_2_Y;
	private final static float MOVE_POINT_19_Y =MOVE_POINT_1_Y;
	private final static float MOVE_POINT_20_Y =(float) (YutnoriBasicConstants.GAME_HEIGHT * 0.550)+y_gap;
	private final static float MOVE_POINT_21_Y =MOVE_POINT_5_Y ;//(float) (YutnoriBasicConstants.DISPLAY_HEIGHT * 0.303);
	private final static float MOVE_POINT_22_Y =MOVE_POINT_21_Y;
	private final static float MOVE_POINT_23_Y =MOVE_POINT_21_Y;
	private final static float MOVE_POINT_24_Y =MOVE_POINT_21_Y;
	private final static float MOVE_POINT_25_Y =MOVE_POINT_21_Y;
	private final static float MOVE_POINT_26_Y =(float) (YutnoriBasicConstants.GAME_HEIGHT * 0.140)+y_gap;
	private final static float MOVE_POINT_27_Y =(float) (YutnoriBasicConstants.GAME_HEIGHT * 0.208)+y_gap;
	private final static float MOVE_POINT_28_Y =(float) (YutnoriBasicConstants.GAME_HEIGHT * 0.398)+y_gap;
	private final static float MOVE_POINT_29_Y =(float) (YutnoriBasicConstants.GAME_HEIGHT * 0.463)+y_gap;		
			
	// Board Move Point
	public final static ArrayList<CGPoint>  MOVE_POINT_LIST = new ArrayList<CGPoint>();
	static{
			
			MOVE_POINT_LIST.add(CGPoint.make((float) (YutnoriBasicConstants.GAME_WIDTH * 0.500)+x_gap, (float) (YutnoriBasicConstants.DISPLAY_HEIGHT * 0.700)+y_gap)); // 0 startPoint

			MOVE_POINT_LIST.add(CGPoint.make(MOVE_POINT_1_X, 	MOVE_POINT_1_Y)); // 1 
			MOVE_POINT_LIST.add(CGPoint.make(MOVE_POINT_2_X,	MOVE_POINT_2_Y)); // 2 
			MOVE_POINT_LIST.add(CGPoint.make(MOVE_POINT_3_X,	MOVE_POINT_3_Y)); // 3 
			MOVE_POINT_LIST.add(CGPoint.make(MOVE_POINT_4_X, 	MOVE_POINT_4_Y)); // 4 
			MOVE_POINT_LIST.add(CGPoint.make(MOVE_POINT_5_X, 	MOVE_POINT_5_Y)); // 5 
			MOVE_POINT_LIST.add(CGPoint.make(MOVE_POINT_6_X, 	MOVE_POINT_6_Y)); // 6 
			MOVE_POINT_LIST.add(CGPoint.make(MOVE_POINT_7_X, 	MOVE_POINT_7_Y)); // 7
			MOVE_POINT_LIST.add(CGPoint.make(MOVE_POINT_8_X, 	MOVE_POINT_8_Y)); // 8 
			MOVE_POINT_LIST.add(CGPoint.make(MOVE_POINT_9_X, 	MOVE_POINT_9_Y)); // 9  
			MOVE_POINT_LIST.add(CGPoint.make(MOVE_POINT_10_X,	MOVE_POINT_10_Y)); // 10 
			MOVE_POINT_LIST.add(CGPoint.make(MOVE_POINT_11_X, 	MOVE_POINT_11_Y)); // 11 
			MOVE_POINT_LIST.add(CGPoint.make(MOVE_POINT_12_X, 	MOVE_POINT_12_Y)); // 12 
			MOVE_POINT_LIST.add(CGPoint.make(MOVE_POINT_13_X, 	MOVE_POINT_13_Y)); // 13 
			MOVE_POINT_LIST.add(CGPoint.make(MOVE_POINT_14_X, 	MOVE_POINT_14_Y)); // 14
			MOVE_POINT_LIST.add(CGPoint.make(MOVE_POINT_15_X, 	MOVE_POINT_15_Y)); // 15 
			MOVE_POINT_LIST.add(CGPoint.make(MOVE_POINT_16_X, 	MOVE_POINT_16_Y)); // 16 
			MOVE_POINT_LIST.add(CGPoint.make(MOVE_POINT_17_X, 	MOVE_POINT_17_Y)); // 17 
			MOVE_POINT_LIST.add(CGPoint.make(MOVE_POINT_18_X, 	MOVE_POINT_18_Y)); // 18 
			MOVE_POINT_LIST.add(CGPoint.make(MOVE_POINT_19_X, 	MOVE_POINT_19_Y)); // 19 
			MOVE_POINT_LIST.add(CGPoint.make(MOVE_POINT_20_X, 	MOVE_POINT_20_Y)); // 20 
			MOVE_POINT_LIST.add(CGPoint.make(MOVE_POINT_21_X, 	MOVE_POINT_21_Y)); // 21
			MOVE_POINT_LIST.add(CGPoint.make(MOVE_POINT_22_X, 	MOVE_POINT_22_Y)); // 22
			MOVE_POINT_LIST.add(CGPoint.make(MOVE_POINT_23_X, 	MOVE_POINT_23_Y)); // 23
			MOVE_POINT_LIST.add(CGPoint.make(MOVE_POINT_24_X, 	MOVE_POINT_24_Y)); // 24
			MOVE_POINT_LIST.add(CGPoint.make(MOVE_POINT_25_X, 	MOVE_POINT_25_Y)); // 25
			MOVE_POINT_LIST.add(CGPoint.make(MOVE_POINT_26_X, 	MOVE_POINT_26_Y)); // 26
			MOVE_POINT_LIST.add(CGPoint.make(MOVE_POINT_27_X, 	MOVE_POINT_27_Y)); // 27
			MOVE_POINT_LIST.add(CGPoint.make(MOVE_POINT_28_X, 	MOVE_POINT_28_Y)); // 28
			MOVE_POINT_LIST.add(CGPoint.make(MOVE_POINT_29_X, 	MOVE_POINT_29_Y)); // 29
			
			MOVE_POINT_LIST.add(CGPoint.make((float) (YutnoriBasicConstants.DISPLAY_WIDTH * 0.500)+x_gap, (float) (YutnoriBasicConstants.DISPLAY_HEIGHT * 0.700)+y_gap)); // 30
		
			
	}

}
