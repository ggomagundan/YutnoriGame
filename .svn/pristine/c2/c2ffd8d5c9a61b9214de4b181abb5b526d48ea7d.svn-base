package com.secretBox.yutnori;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.cocos2d.actions.instant.CCCallFuncN;
import org.cocos2d.actions.interval.CCDelayTime;
import org.cocos2d.actions.interval.CCJumpTo;
import org.cocos2d.actions.interval.CCMoveTo;
import org.cocos2d.actions.interval.CCSequence;
import org.cocos2d.layers.CCColorLayer;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.menus.CCMenu;
import org.cocos2d.menus.CCMenuItemImage;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCLabel;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGRect;
import org.cocos2d.types.ccColor3B;
import org.cocos2d.types.ccColor4B;

import android.util.Log;
import android.view.MotionEvent;

import com.secretBox.yutnori.constants.YutnoriBasicConstants;
import com.secretBox.yutnori.constants.YutnoriLogicConstants;
import com.secretBox.yutnori.constants.YutnoriLogicConstants.GameStep;
import com.secretBox.yutnori.constants.YutnoriPointConstants;
import com.secretBox.yutnori.logic.YutSet;

public class GameLayer extends CCLayer {

	private int selectedHorseID = 0;
	private Map<Integer,Integer>	nodeID_horseID=null;
	private Map<Integer,Map<Integer,YutSet.PROPERTY>>  horseID_nodeIDs_property=null;

	public boolean isAgainPlay  = false;
	
	public YutThrowLayer yutLayer =  new YutThrowLayer(this);
	public HorseLayer horseLayer =  new HorseLayer();
	public CharacterLayer charLayer =new CharacterLayer();
	public SelectLayer selectLayer = new SelectLayer();
	
	private CGPoint centerPoint = null;
	private CGPoint outOfScreenPoint = null;
	
	private CCSprite[] player_yutDisplay = new CCSprite[6];
	private CCSprite[] cpu_yutDisplay = new CCSprite[6];
	private CCSprite info_moveselect;
	private CCSprite info_horseselect;
	private CCColorLayer startBG;
	
	
	CCSprite background;
	CCMenuItemImage backButton;
	
	
	
	private CCColorLayer loser;
	CCSprite winning;


	public GameLayer() {

		super();
		
		background = CCSprite.sprite(YutnoriBasicConstants.GAME_BACKGROUND_IMG);
		//화면 중점
		background.setPosition(CGPoint.make(YutnoriBasicConstants.DISPLAY_WIDTH / 2, YutnoriBasicConstants.DISPLAY_HEIGHT / 2));
		
		addChild(background);
		setScale(YutnoriBasicConstants.scale);
		
		
		backButton = CCMenuItemImage.item(YutnoriBasicConstants.BACK_KEY_IMG, YutnoriBasicConstants.BACK_KEY_IMG, this, "backCallback");
		backButton.setPosition(YutnoriPointConstants.GAME_PLAY_BACK_POSITION);
		

		CCMenu menu = CCMenu.menu();
		menu.addChild(backButton);
		
		menu.setPosition(0, 0);

		// 540 * 960 Sensation
		Log.d("PBS", "width " + YutnoriBasicConstants.DISPLAY_WIDTH + " " + "height " + " " + YutnoriBasicConstants.DISPLAY_HEIGHT);

		addChild(menu);
		info_moveselect = CCSprite.sprite("game_img/play_horse_select_tell.png");
		info_horseselect = CCSprite.sprite("game_img/play_horse_select_move.png");
		addChild(info_moveselect);
		addChild(info_horseselect);
		
		addChild(charLayer);
		addChild(selectLayer);
		addChild(horseLayer);

		
		float moveWidth = (YutnoriBasicConstants.DISPLAY_WIDTH - YutnoriBasicConstants.GAME_WIDTH )/2;
		float moveHeight = (YutnoriBasicConstants.DISPLAY_HEIGHT - YutnoriBasicConstants.GAME_HEIGHT)/2;
		info_moveselect.setPosition(297 + moveWidth,683+moveHeight);
		info_horseselect.setPosition(297+ moveWidth,683+moveHeight);
		
		addChild(yutLayer);
		
		
		
		centerPoint =CGPoint.make(YutnoriPointConstants.CENTER_POINT.x,YutnoriPointConstants.CENTER_POINT.y);
		centerPoint.y=centerPoint.y+100;
		outOfScreenPoint = CGPoint.make(-centerPoint.x, centerPoint.y);
		

		yutLayer.setPosition(outOfScreenPoint.x,outOfScreenPoint.y);
		

		
		
		
		
		for(int i=0;i<YutnoriLogicConstants.GAME_YUT_CHAR_FILE_NAMES.length;i++)
		{
			player_yutDisplay[i] = CCSprite.sprite(YutnoriLogicConstants.GAME_YUT_CHAR_FILE_NAMES[i]);
			cpu_yutDisplay[i] = CCSprite.sprite(YutnoriLogicConstants.GAME_YUT_CHAR_FILE_NAMES[i]);
		}
		
		
		// Available Touch Event
		this.setIsTouchEnabled(true);
		
	
	
		
		winning = CCSprite.sprite("game_img/winning_background.png");
	//	winning = CCSprite.sprite("test/cancel_button.png");
		addChild(winning);
		winning.setPosition(YutnoriPointConstants.CENTER_POINT.x, YutnoriPointConstants.CENTER_POINT.y);
		winning.setVisible(false);
		
		CCSprite loserString = CCSprite.sprite("game_img/loser_string.png");
		loser = CCColorLayer.node(ccColor4B.ccc4(35, 24, 21, 255));
		addChild(loser);
		loser.addChild(loserString);
		loserString.setPosition(YutnoriPointConstants.CENTER_POINT.x, YutnoriPointConstants.CENTER_POINT.y - 120);
		
		startBG = CCColorLayer.node(ccColor4B.ccc4(0, 0, 0, 200));
		addChild(startBG);
		CCLabel charCountLabel  = CCLabel.makeLabel("게임을 시작합니다.","고딕",40);
		charCountLabel.setColor(new ccColor3B(255, 255, 255));
		charCountLabel.setPosition(YutnoriBasicConstants.DISPLAY_WIDTH/2,YutnoriBasicConstants.DISPLAY_HEIGHT/2);
		startBG.addChild(charCountLabel);
		startBG.setVisible(false);
		
		
		

	}

	private CCSprite hitTestWithCCSprite(MotionEvent e,float x,float y,CCSprite[] sprites)
	{
		CGPoint point = CCDirector.sharedDirector().convertToGL(CGPoint.make(x, y));

		for (CCSprite sprite : sprites) {
			CGRect rect = sprite.getBoundingBox();
			rect.origin.x -= YutnoriBasicConstants.DISPLAY_WIDTH/2;
			rect.origin.y -= YutnoriBasicConstants.DISPLAY_HEIGHT/2;
			
			rect.origin.x *=YutnoriBasicConstants.scale;
			rect.origin.y *=YutnoriBasicConstants.scale;
			rect.origin.x += YutnoriBasicConstants.DISPLAY_WIDTH/2;
			rect.origin.y += YutnoriBasicConstants.DISPLAY_HEIGHT/2;
			rect.size.width *= YutnoriBasicConstants.scale;
			rect.size.height *=YutnoriBasicConstants.scale;
			Log.d("point","point"+point.x+point.y);
			if (rect.contains(point.x, point.y))
				return sprite;
		
		}
		return null;
	}
	private CCSprite hitTestWithCCSprite(MotionEvent e,float x,float y,ArrayList<CCSprite> spriteList)
	{
		CCSprite[] sprites= new CCSprite[spriteList.size()];
		spriteList.toArray(sprites);
		return hitTestWithCCSprite(e,x,y,sprites);
	}
	
	
	private void checkAndMergeHorse()
	{
		for(int playerIndex = 0;playerIndex<2;playerIndex++)
		{
			Map<Integer,Map<Integer,Integer>> playerID_horseID_nodeID = GameManager.getGame().getAllHorsesPosition();
			Map<Integer,Integer> horseID_nodeID = playerID_horseID_nodeID.get(playerIndex);
			int[] horsePosition= {horseID_nodeID.get(0),horseID_nodeID.get(1),horseID_nodeID.get(2),horseID_nodeID.get(3)};
			int[] peerIDs = {-1,-1,-1,-1};
			for(int j=2 ; j!=-1 ; j--)
				for(int i=3 ; i!=j ; i--)
					if(horsePosition[j]==horsePosition[i])
						peerIDs[j]=i;
			boolean[] peerCheck ={false,false,false,false};
			for(int i=0;i<4;i++)
			{	
				if(peerCheck[i]==false)
				{
					peerCheck[i]=true;
					int nextID = peerIDs[i];
					int peerCount = 1;
					while(true)
					{
						if(nextID!=-1)
						{
							if(playerIndex==0)
								horseLayer.playerHorseList.get(nextID).setVisible(false);
							else
								horseLayer.cpuHorseList.get(nextID).setVisible(false);
							
							//nextID 숨기기
							peerCount++;
							peerCheck[nextID]=true;
							nextID = peerIDs[nextID];
						}else
							break;
					}
					if(peerCount > 1)
					{
						if(playerIndex==0)
							horseLayer.playerHorseLabelList.get(i).setString(""+peerCount);
						else
							horseLayer.cpuHorseLabelList.get(i).setString(""+peerCount);	
					}	
				}
			}
		}
	}
	
	
	@Override
	public boolean ccTouchesEnded(MotionEvent e)
	{
		
		if(GameManager.getGame().getStep() == GameStep.GAME_END)
		{
			backCallback(null);
		}
		else if(GameManager.getGame().getStep() == GameStep.CHAR_SELECT_TURN)
		{
			
			
			startBG.setVisible(false);
			charLayer.addAniHChar();
			GameManager.getGame().changeStep(YutnoriLogicConstants.GameStep.YUT_ANING_ON_TURN);
			GameManager.getGame().playEffect("jing");
			showYutThrowLayer();
			
			
		}
		else if(GameManager.getGame().getStep() == GameStep.YUT_INTERACTION_TURN) //윷던지기
		{
	//		GameManager.getGame().changeStep();
	//		yutLayer.stopYutAnimation();
	//		yutLayer.throwYut();
	//		yutLayer.callbackYutFinished(null);
			 
		}else if(GameManager.getGame().getStep() == GameStep.MAL_INTERACTION_TURN) // 말선택턴 //취소하기
		{
			ArrayList<CCSprite> selectHorsePosButtonList = new ArrayList<CCSprite>(); 
			Set<Integer> horseIDs = horseID_nodeIDs_property.keySet();
		
			for(Integer horseID : horseIDs)
			{
				int nodeID = GameManager.getGame().getHorsePosition(horseID);
				selectHorsePosButtonList.add(selectLayer.horsePosButtons[nodeID]);	
			}
			
			CCSprite hittedHorsePosButton;
			
			if(e==null)
				hittedHorsePosButton = selectLayer.horsePosButtons[0];
			else
				hittedHorsePosButton = hitTestWithCCSprite(e,e.getX(),e.getY(),selectHorsePosButtonList);
			
			if(hittedHorsePosButton !=null)
			{
				selectLayer.hideHorsePosButtons();
				int nodeID = selectLayer.findIndexFromHorsePosButtons(hittedHorsePosButton);
				
				int horseID = nodeID_horseID.get(nodeID);
				Set<Integer> nodeIDs = horseID_nodeIDs_property.get(horseID).keySet();
				for(Integer movableNodeID:nodeIDs)
				{
					selectLayer. showPosButton(movableNodeID);
				}
				selectLayer.addHorseButton.setVisible(false);
				selectLayer.cancelButton.setVisible(true);
				selectedHorseID = horseID;
				GameManager.getGame().changeStep();
				info_moveselect.setVisible(false);
				info_horseselect.setVisible(true);
				
			}

					
			
			
		}else if(GameManager.getGame().getStep() == GameStep.MOVE_INTERACTION_TURN) // 말 이동 가능한곳
		{
			ArrayList<CCSprite> selectHorsePosButtonList = new ArrayList<CCSprite>(); 
			Set<Integer> nodeIDs = horseID_nodeIDs_property.get(selectedHorseID).keySet();
			for(Integer nodeID:nodeIDs)
			{
				selectHorsePosButtonList.add(selectLayer.horsePosButtons[nodeID]);
				
			}
			CCSprite hittedHorsePosButton = hitTestWithCCSprite(e,e.getX(),e.getY(),selectHorsePosButtonList);
			
			if(hittedHorsePosButton !=null)
			{
				selectLayer.hideHorsePosButtons();
				int nodeID = selectLayer.findIndexFromHorsePosButtons(hittedHorsePosButton);
				
				if(nodeID !=30 && GameManager.getGame().haveOtherTeamHorse(nodeID))
				{
					GameManager.getGame().playEffect("turn");
					isAgainPlay =true;
				}
				
				moveCharater(selectedHorseID,nodeID);
				YutSet.PROPERTY property = horseID_nodeIDs_property.get(selectedHorseID).get(nodeID);
				GameManager.getGame().playerSaveMoveYutList.remove(property);
				GameManager.getGame().move(selectedHorseID,nodeID);
				
				GameManager.getGame().changeStep();
				selectLayer.cancelButton.setVisible(false);
				info_moveselect.setVisible(false);
				info_horseselect.setVisible(false);
				
			}
		}
		
		
	
		
		return true;
	}	
	
	@Override
	public boolean ccTouchesMoved(MotionEvent e) {
		
		return true;
	}

	
	public void backCallback(Object Sender) {
		
		GameManager.getGame().playEffect("back");
		YutnoriBasicConstants.isBackKey = false;
		GameManager.getGame().showOrHideLayer();
		
		CCDirector.sharedDirector().popScene();
	}

	public void moveCharater(int characterIndex, int moveNumber) {

		CGPoint movePoint = CGPoint.make(YutnoriPointConstants.MOVE_POINT_LIST.get(moveNumber).x, 
				YutnoriBasicConstants.DISPLAY_HEIGHT - YutnoriPointConstants.MOVE_POINT_LIST.get(moveNumber).y);
		
		moveCharater(characterIndex, movePoint);
		
		
	}

	private void moveCharater(int characterIndex, CGPoint movePoint) {

		CCSprite character;
		if(GameManager.getGame().isHumanTurn) 
			character = horseLayer.playerHorseList.get(characterIndex);
		else
			character = horseLayer.cpuHorseList.get(characterIndex);
		horseLayer.reorderChild(character, 10);
			
		CCJumpTo jumpToAni = CCJumpTo.action(YutnoriBasicConstants.CHARAC_MOVE_TIME, movePoint, YutnoriBasicConstants.CHARAC_MOVE_HEIGHT, YutnoriBasicConstants.CHARAC_MOVE_JUMP_COUNT);
		CCCallFuncN callbackAni = CCCallFuncN.action(this,"callbackCharMoveFinished");
		character.runAction(CCSequence.actions(jumpToAni,callbackAni));

	}
	public void hideYutThrowLayer()
	{
		CGPoint toPoint=outOfScreenPoint;
		CCMoveTo moveAni = CCMoveTo.action(0.1f,toPoint);
		CCCallFuncN callbackAni = CCCallFuncN.action(this,"callbackYutHide");
		yutLayer.runAction(CCSequence.actions(moveAni,callbackAni));

	}
	public void showYutThrowLayer()
	{
		CGPoint toPoint=centerPoint;
		
		CCMoveTo moveAni = CCMoveTo.action(0.1f,toPoint);
		CCDelayTime delayAni = CCDelayTime.action(0.25f);
		CCCallFuncN callbackAni = CCCallFuncN.action(yutLayer,"callbackYutShow");
		yutLayer.runAction(CCSequence.actions(moveAni,delayAni,callbackAni));
	}
	public void callbackYutHide(Object Sender)
	{
		
		if(GameManager.getGame().isHumanTurn == true){
			if(GameManager.getGame().yutProperty == YutSet.PROPERTY.NAK)
			{
				if(GameManager.getGame().playerSaveMoveYutList.size()==0)
				{
					
					GameManager.getGame().changeStep(GameStep.ENEMY_TURN);
					GameManager.getGame().changeTurn();
					showYutThrowLayer();
					
				}else
				{
					GameManager.getGame().changeStep(GameStep.YUT_ANING_OFF_TURN);
					GameManager.getGame().yutProperty=YutSet.PROPERTY.NONE;
					callbackYutHide(null);
				}
			}else
			{
				info_moveselect.setVisible(true);
				info_horseselect.setVisible(false);
				nodeID_horseID = new HashMap<Integer,Integer>();
				horseID_nodeIDs_property = GameManager.getGame().getMovableInfo(GameManager.getGame().playerSaveMoveYutList);
				Set<Integer> horseIDs = horseID_nodeIDs_property.keySet();
				
				if(horseIDs.size()==0)
				{
					GameManager.getGame().playerSaveMoveYutList = new LinkedList<YutSet.PROPERTY>();
					GameManager.getGame().changeStep(GameStep.ENEMY_TURN);
					GameManager.getGame().changeTurn();
					showYutThrowLayer();
				}
				else
				{
					for(Integer horseID : horseIDs)
					{
						int nodeID = GameManager.getGame().getHorsePosition(horseID);
						//		selectLayer.horsePosButtons[nodeID].setVisible(true);
						if(nodeID==0)
							selectLayer.addHorseButton.setVisible(true);
						else
							selectLayer.showPosButton(nodeID);
						if(nodeID_horseID.get(nodeID)==null)
							nodeID_horseID.put(nodeID, horseID);
					
					
					}
					GameManager.getGame().changeStep();
				}
				
				
			}
			
		}else
		{
			
			
			
			if(GameManager.getGame().yutProperty == YutSet.PROPERTY.NAK && GameManager.getGame().cpuSaveMoveYutList.size()==0)
			{
				
				GameManager.getGame().changeTurn();
				GameManager.getGame().changeStep(GameStep.YUT_ANING_ON_TURN);				
				showYutThrowLayer();
				
			}else
			{
				//AI need
				horseID_nodeIDs_property = GameManager.getGame().getMovableInfo(GameManager.getGame().cpuSaveMoveYutList);
				Set<Integer> horseIDs = horseID_nodeIDs_property.keySet();
				
				if(horseIDs.size()==0)
				{
					GameManager.getGame().cpuSaveMoveYutList = new LinkedList<YutSet.PROPERTY>();
					callbackCharMoveFinished(null);
				}
				else
				{
					Map<Integer,Integer> nodeIDs_horseIDs = new HashMap<Integer,Integer>();
					
					for(int horseID:horseIDs)
					{
						
						int currentNodeID = GameManager.getGame().getHorsePosition(horseID);
						if(nodeIDs_horseIDs.get(currentNodeID)==null)
							nodeIDs_horseIDs.put(currentNodeID, horseID);
						
					}
				
					Map<Integer,Map<Integer,Integer>> allPosition = GameManager.getGame().getAllHorsesPosition(); //player ID  <말 ,노드>
					
					Map<Integer,Integer> userPlayer = allPosition.get(0);
					Map<Integer,Integer> cpuPlayer = allPosition.get(1);
					
					int bestScoreHorseID =0;
					int bestScoreNodeID=0;
					int bestScore = -100;
					
					Set<Integer> currentNodeIDs = nodeIDs_horseIDs.keySet();
					
					
					for(Integer currentNodeID : currentNodeIDs)
					{
						Integer horseID = nodeIDs_horseIDs.get(currentNodeID);
						Set<Integer> nodeIDs = horseID_nodeIDs_property.get(horseID).keySet();
						for(Integer nodeID:nodeIDs)
						{
							int currentScore = GameManager.getGame().checkScore(horseID,nodeID,cpuPlayer,userPlayer);
							Log.d("score","score"+currentScore+"horseID"+horseID+"nodeID"+nodeID);
							if(currentScore > bestScore)
							{
								bestScore = currentScore;
								bestScoreHorseID = horseID;
								bestScoreNodeID = nodeID;
							}
						
						}
					}
					selectedHorseID = bestScoreHorseID;
				
					
					if(GameManager.getGame().haveOtherTeamHorse(bestScoreNodeID))
					{
						GameManager.getGame().playEffect("turn");
						isAgainPlay =true;
					}
					
					
					moveCharater(bestScoreHorseID, bestScoreNodeID);
					YutSet.PROPERTY property = horseID_nodeIDs_property.get(bestScoreHorseID).get(bestScoreNodeID);
					GameManager.getGame().cpuSaveMoveYutList.remove(property);
					GameManager.getGame().move(bestScoreHorseID, bestScoreNodeID);
					
					
					
					return;
				}
				
			}
		}
		
	
			
			
	}
	
	public void callbackCharMoveFinished(Object Sender)
	{
		
		if(GameManager.getGame().havePeerByHorseID(selectedHorseID))
		{
			checkAndMergeHorse();		
		}
		
		horseLayer.resetHorsesPosition();
		
		if(GameManager.getGame().isWinner())
		{
			if(GameManager.getGame().isHumanTurn)
			{
				GameManager.getGame().playEffect("win");
				winning.setVisible(true);
			}
			else
			{
				GameManager.getGame().playEffect("lose1");
				loser.setVisible(true);
			}
			GameManager.getGame().changeStep(GameStep.GAME_END);
			return;
			
			
		}
		
		if(isAgainPlay)
		{
		
			isAgainPlay = false;
			if(GameManager.getGame().isHumanTurn)
			{
				GameManager.getGame().changeStep(GameStep.YUT_ANING_ON_TURN);
				
			}else
			{
				GameManager.getGame().changeStep(GameStep.ENEMY_TURN);
				
			}
			showYutThrowLayer();
			
		}
		else if( (GameManager.getGame().isHumanTurn ? (GameManager.getGame().playerSaveMoveYutList.size()!=0 ): ( GameManager.getGame().cpuSaveMoveYutList.size()!=0) ) )
		{
			if(GameManager.getGame().isHumanTurn )
			{
				GameManager.getGame().changeStep(GameStep.YUT_ANING_OFF_TURN);
			}
			callbackYutHide(null);
		}else
		{
			
			if(GameManager.getGame().isHumanTurn)
				GameManager.getGame().changeStep(GameStep.ENEMY_TURN);
			else
				GameManager.getGame().changeStep(GameStep.YUT_ANING_ON_TURN);
			GameManager.getGame().changeTurn();
			showYutThrowLayer();
			
		}
		
		
		
	
		
		
		
		
		
	}


	public void applyScale(float scale) {
		
		
		
	}
	
	
	@Override
	public void onEnter(){
		super.onEnter();
		GameManager.getGame().gameInit();
		isAgainPlay =false;
		horseLayer.setInitPosition();
		selectLayer.hideHorsePosButtons();
		yutLayer.setPosition(outOfScreenPoint.x,outOfScreenPoint.y);
		selectLayer.hideHorsePosButtons();
		selectLayer.addHorseButton.setVisible(false);
		selectLayer.cancelButton.setVisible(false);
		info_moveselect.setVisible(false);
		info_horseselect.setVisible(false);
		loser.setVisible(false);
		winning.setVisible(false);
		horseLayer.resetHorsesPosition();
		yutLayer.isAgain =false;
		startBG.setVisible(true);
	}
	
	
}


