package com.secretBox.yutnori.test;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.menus.CCMenu;
import org.cocos2d.menus.CCMenuItemImage;
import org.cocos2d.nodes.CCLabel;
import org.cocos2d.nodes.CCNode;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;

import com.secretBox.yutnori.MenuLayer;
import com.secretBox.yutnori.constants.YutnoriBasicConstants;

public class PointTestLayer extends CCLayer {
	private CCLabel labelX;
	private CCLabel labelY;
	private CCSprite check;
	private CCNode node;
	private float xValue, yValue;
	
	public PointTestLayer(CCNode testMoveingNode, CCLayer CurrentLayer, boolean isBaseUp) {
		
		node = testMoveingNode;
		xValue =(float)(testMoveingNode.getPosition().x/YutnoriBasicConstants.DISPLAY_WIDTH);
		TestLayerConstants.xPercent = xValue;
		if(isBaseUp == true){
			yValue = (float)(((-1*testMoveingNode.getPosition().y)+YutnoriBasicConstants.DISPLAY_HEIGHT)/YutnoriBasicConstants.DISPLAY_HEIGHT);
			TestLayerConstants.yPercent = yValue;
		}else{
			yValue = (float)(testMoveingNode.getPosition().y/YutnoriBasicConstants.DISPLAY_HEIGHT);
			TestLayerConstants.yPercent = yValue;
		}
		
		TestLayerConstants.isBaseUp = isBaseUp;
		
		
		labelX = CCLabel.makeLabel(Float.toString(xValue), TestLayerConstants.fontFace, TestLayerConstants.labelSize);
		labelX.setPosition(TestLayerConstants.xLabelPositionX, TestLayerConstants.xLabelPositionY);
		labelY = CCLabel.makeLabel(Float.toString(yValue), TestLayerConstants.fontFace, TestLayerConstants.labelSize);
		labelY.setPosition(TestLayerConstants.yLabelPositionX, TestLayerConstants.yLabelPositionY);
		addChild(labelX);
		addChild(labelY);
		check = CCSprite.sprite(TestLayerConstants.CHECK_POINT_IMG);
		check.setPosition(CGPoint.make(
				(float) (YutnoriBasicConstants.DISPLAY_WIDTH * xValue),
				(float) (YutnoriBasicConstants.DISPLAY_HEIGHT * yValue)));
		addChild(check);
		
		
		CCMenuItemImage upButton = CCMenuItemImage.item(TestLayerConstants.UP_IMG, TestLayerConstants.UP_IMG,
				this, "upCallback");
		
		upButton.setPosition((int)(TestLayerConstants.centerPointX), (int)(TestLayerConstants.centerPointY+TestLayerConstants.directionTerm));
		
		CCMenuItemImage downButton = CCMenuItemImage.item(TestLayerConstants.DOWN_IMG, TestLayerConstants.DOWN_IMG,
				this, "downCallback");
		
	
		downButton.setPosition(TestLayerConstants.centerPointX, TestLayerConstants.centerPointY-TestLayerConstants.directionTerm);
		
		CCMenuItemImage leftButton = CCMenuItemImage.item(TestLayerConstants.LEFT_IMG, TestLayerConstants.LEFT_IMG,
				this, "leftCallback");
		
		
		leftButton.setPosition(TestLayerConstants.centerPointX-TestLayerConstants.directionTerm, TestLayerConstants.centerPointY);
		
		CCMenuItemImage rightButton = CCMenuItemImage.item(TestLayerConstants.RIGHT_IMG, TestLayerConstants.RIGHT_IMG,
				this, "rightCallback");
		
		
		rightButton.setPosition(TestLayerConstants.centerPointX+TestLayerConstants.directionTerm, TestLayerConstants.centerPointY);
		
		CCMenu menu = CCMenu.menu(upButton,downButton,leftButton,rightButton);
		menu.setPosition(0, 0);
		addChild(menu);
		
		this.setIsTouchEnabled(true);
		CurrentLayer.addChild(this);
	}

	
	private void setNodePostion(boolean isBaseUp) {
		if(isBaseUp== true){
			node.setPosition(CGPoint.make(
					(float) (YutnoriBasicConstants.DISPLAY_WIDTH * xValue),
					(float) (YutnoriBasicConstants.DISPLAY_HEIGHT -YutnoriBasicConstants.DISPLAY_HEIGHT * yValue)));
			check.setPosition(CGPoint.make(
					(float) (YutnoriBasicConstants.DISPLAY_WIDTH * xValue),
					(float) (YutnoriBasicConstants.DISPLAY_HEIGHT - YutnoriBasicConstants.DISPLAY_HEIGHT * yValue)));
		}else{
			node.setPosition(CGPoint.make(
				(float) (YutnoriBasicConstants.DISPLAY_WIDTH * xValue),
				(float) (YutnoriBasicConstants.DISPLAY_HEIGHT * yValue)));
			check.setPosition(CGPoint.make(
				(float) (YutnoriBasicConstants.DISPLAY_WIDTH * xValue),
				(float) ( YutnoriBasicConstants.DISPLAY_HEIGHT * yValue)));
			
		}
		
	}
	
	public void upCallback(Object sender) {

		if(TestLayerConstants.isBaseUp == true){
			yValue -= TestLayerConstants.increaseValue;
		} else{
			yValue += TestLayerConstants.increaseValue;
		}
		labelY.setString(Float.toString(yValue));
		setNodePostion(TestLayerConstants.isBaseUp);
		
	}

	

	public void downCallback(Object sender) {
		
		if(TestLayerConstants.isBaseUp == true){
			yValue += TestLayerConstants.increaseValue;
		} else{
			yValue -= TestLayerConstants.increaseValue;
		}
		labelY.setString(Float.toString(yValue));
		setNodePostion(TestLayerConstants.isBaseUp);

	}

	public void leftCallback(Object sender) {

		xValue -= TestLayerConstants.increaseValue;
		labelX.setString(Float.toString(xValue));
		setNodePostion(TestLayerConstants.isBaseUp);
		
	}

	public void rightCallback(Object sender) {

		xValue += TestLayerConstants.increaseValue;
		labelX.setString(Float.toString(xValue));
		setNodePostion(TestLayerConstants.isBaseUp);
		
	}
}
