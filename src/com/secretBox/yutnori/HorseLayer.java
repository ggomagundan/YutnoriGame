package com.secretBox.yutnori;

import java.util.ArrayList;
import java.util.Map;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCLabel;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.ccColor3B;

import com.secretBox.yutnori.constants.YutnoriBasicConstants;
import com.secretBox.yutnori.constants.YutnoriPointConstants;

public class HorseLayer extends CCLayer{
	
	public ArrayList<CCLabel> playerHorseLabelList = new ArrayList<CCLabel>();
	public ArrayList<CCLabel> cpuHorseLabelList = new ArrayList<CCLabel>();
	public ArrayList<CCSprite> playerHorseList = new ArrayList<CCSprite>();
	public ArrayList<CCSprite> cpuHorseList = new ArrayList<CCSprite>();

	
	public void loadSprite()
	{
		for(int i=0;i<4;i++)
		{
			CCLabel charCountLabel  = CCLabel.makeLabel(""+1,"Abduction",14);
			charCountLabel.setColor(new ccColor3B(0, 0, 0));
			
			CCSprite playerHorseSprite = CCSprite.sprite(YutnoriBasicConstants.PLAYER_HORSE_FILE_NAME);
			playerHorseSprite.setAnchorPoint(0.5f, 0.0f);
			addChild(playerHorseSprite);
			
			playerHorseSprite.addChild(charCountLabel);
			playerHorseList.add(playerHorseSprite);
			playerHorseSprite.setScale(YutnoriBasicConstants.scale);
			playerHorseLabelList.add(charCountLabel);
			
		}
		for(int i=0;i<4;i++)
		{
			CCLabel charCountLabel  = CCLabel.makeLabel(""+1,"Abduction",14);
			charCountLabel.setColor(new ccColor3B(0, 0, 0));
			
			CCSprite cpuHorseSprite = CCSprite.sprite(YutnoriBasicConstants.CPU_PLAYER_FILE_NAME);
			addChild(cpuHorseSprite);
			
			cpuHorseSprite.addChild(charCountLabel);
			cpuHorseSprite.setAnchorPoint(0.5f, 0.0f);
			cpuHorseList.add(cpuHorseSprite);
			cpuHorseLabelList.add(charCountLabel);
		}
	}
	public void setInitPosition()
	{
		for (CCSprite temp : playerHorseList) {
			temp.setPosition(YutnoriPointConstants.F_HORSE_POINT_LIST.get(playerHorseList.indexOf(temp)));
		}
		for (CCSprite temp : cpuHorseList) {
			temp.setPosition(YutnoriPointConstants.S_HORSE_POINT_LIST.get(cpuHorseList.indexOf(temp)));
		}
		
	}
	
	public HorseLayer()
	{
		loadSprite();
		setInitPosition();
	}
	public void resetHorsesPosition()
	{
		
		int firstStartHorseIndex=0;
		int secondStartHorseIndex=0;
		int firstEndHorseIndex=0;
		int secondEndHorseIndex=0;
		for(int playerIndex = 0;playerIndex<2;playerIndex++)
		{
			Map<Integer,Map<Integer,Integer>> playerID_horseID_nodeID = GameManager.getGame().getAllHorsesPosition();
			Map<Integer,Integer> horseID_nodeID = playerID_horseID_nodeID.get(playerIndex);
			int[] horsePosition= {horseID_nodeID.get(0),horseID_nodeID.get(1),horseID_nodeID.get(2),horseID_nodeID.get(3)};
			for(int i=0;i<4;i++)
			{
			
				if(horsePosition[i] == 0)
				{
					if(playerIndex==0)
					{
						CCSprite horseSprite = playerHorseList.get(i);
						CCLabel horseLabel = playerHorseLabelList.get(i);
						horseSprite.setVisible(true);
						horseLabel.setString("1");
						horseSprite.setPosition(YutnoriPointConstants.F_HORSE_POINT_LIST.get(firstStartHorseIndex++));
					}
					else
					{
						CCSprite horseSprite = cpuHorseList.get(i);
						CCLabel horseLabel = cpuHorseLabelList.get(i);
						horseSprite.setVisible(true);
						horseLabel.setString("1");
						horseSprite.setPosition(YutnoriPointConstants.S_HORSE_POINT_LIST.get(secondStartHorseIndex++));
					}
				}else if(horsePosition[i]== 30)
				{
					if(playerIndex==0)
					{
						CCSprite horseSprite = playerHorseList.get(i);
						CCLabel horseLabel = playerHorseLabelList.get(i);
						horseSprite.setVisible(true);
						horseLabel.setString("1");
						horseSprite.setPosition(YutnoriPointConstants.F_HORSE_END_POINT_LIST.get(firstEndHorseIndex++));
					}
					else
					{
						CCSprite horseSprite = cpuHorseList.get(i);
						CCLabel horseLabel = cpuHorseLabelList.get(i);
						horseSprite.setVisible(true);
						horseLabel.setString("1");
						horseSprite.setPosition(YutnoriPointConstants.S_HORSE_END_POINT_LIST.get(secondEndHorseIndex++));
					}
					
				}
			}
			
		}
		
	}
	

}
