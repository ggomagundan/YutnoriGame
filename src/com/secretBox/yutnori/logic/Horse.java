package com.secretBox.yutnori.logic;


import java.util.Map;
import java.util.Set;

public class Horse {
	private Node currentNode=null;
	private Player owner;
	
	public int getID()
	{
		Set<Integer> hIDs = owner.horses.keySet(); 
		for(Integer hID :hIDs)
		{
			Horse compareH = owner.horses.get(hID);
			if(compareH.equals(this))
				return hID;
		}
		return -1;
	}
	public Player getOwner()
	{
		return owner;
	}
	public Horse(Player ownPlayer)
	{
		owner = ownPlayer;

	}
	public boolean canCatch(Horse otherHorse,YutSet.PROPERTY property)
	{
		Set<Integer> nodeIDs = otherHorse.getMovableNodes(property).keySet();
		boolean catched=false;
		if(currentNode.nodeID != Board.END_ID)
		{
			for(Integer nodeID :nodeIDs)
			{
				if(nodeID==currentNode.nodeID)
					catched =true;
			}
		}
		return catched;
	}
	
	public Map<Integer,YutSet.PROPERTY> getMovableNodes(YutSet.PROPERTY property)
	{
		return currentNode.getMovableNodes(property);
	}

	public void move(Node moveNode)
	{
		moveNode.horses.add(this);
		if(currentNode !=null)
			currentNode.horses.remove(this);
		currentNode = moveNode;
		
	}
	public void moveAllHorses(Node moveNode)
	{
		
		currentNode.moveAllHorses(moveNode);
	}
	public Node getPosition() {
		return currentNode;
	}
	public boolean isFinished(){
		return (currentNode.property == Node.PROPERTY.END);
	}
	public boolean isStarted(){
		return (currentNode.property == Node.PROPERTY.START);
	}
	public boolean havePeer()
	{
		if(currentNode.horses.size() >= 2)
			return true;
		else
			return false;
		
	}
	
}
