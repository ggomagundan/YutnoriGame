package com.secretBox.yutnori.logic;

import java.util.HashMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Player {
	public Map<Integer,Horse> horses = new HashMap<Integer,Horse>();
	
	public Player(int horseCount)
	{
		int horseID=0;
		for(int i=0;i<horseCount;i++)
		{
			horses.put(horseID,new Horse(this));
			horseID++;
		}
	}
	// return value is Map<horseID,Set<nodeID>>
	public Map<Integer,Map<Integer,YutSet.PROPERTY>> getMovableHorses(Set<YutSet.PROPERTY> p) 
	{
		Map<Integer,Map<Integer,YutSet.PROPERTY>> retMap = new HashMap<Integer,Map<Integer,YutSet.PROPERTY>>();
		
		Set<Integer> keys = horses.keySet();
		int i;
		for(Integer horseID :keys)
		{
			
			Horse h = horses.get(horseID);
			if(h.isFinished())
				continue;
			
			Map<Integer,YutSet.PROPERTY> nodeIDSet = new HashMap<Integer,YutSet.PROPERTY>();
			for(YutSet.PROPERTY eachProperty :p)
			{
				Map<Integer,YutSet.PROPERTY> tmpNodeIDSet  = h.getMovableNodes(eachProperty); 
				nodeIDSet.putAll(tmpNodeIDSet);
			}
			
			if(nodeIDSet.size()!=0)
				retMap.put(horseID,nodeIDSet);
		}
		
		for(i=horses.size()-1; i>= 0 ; i--)
		{
			Horse h = horses.get(i);
			if(h.isStarted())
				continue;
			else
				break;
		}
		for(i = i+2 ; i<horses.size() ; i++)
			retMap.remove(i);
		
		
		return retMap;
	}
	public void moveAllHorses(int horseID,Node node)
	{
		Horse h = horses.get(horseID);
		h.moveAllHorses(node);
	}
	public void moveHorse(int horseID,Node node)
	{
		Horse h = horses.get(horseID);
		h.move(node);	
	}
	public void initHorses(Node startNode)
	{
		
		Set<Integer> horseIDs = horses.keySet();
		
		for(Integer  hID : horseIDs)
		{
			Horse h = horses.get(hID);
			h.move(startNode);
		}
	}
	public boolean isStarted(int horseID)
	{
		Horse h = horses.get(horseID);
		return h.isStarted();
	}
	public boolean isFinished(int horseID)
	{
		Horse h = horses.get(horseID);
		return h.isFinished();
	}
	public int getHorsePosition(int horseID)
	{
		Horse h = horses.get(horseID);
		return h.getPosition().nodeID;
	}
	// Map <HorseId, NodeId>
	public Map<Integer, Integer> getHorsesPosition() {
		
		Map<Integer, Integer> horsePosition = new HashMap<Integer, Integer>();
		
		Set<Integer> horseIDs = horses.keySet();
				
		for(Integer  hID : horseIDs){
			horsePosition.put(hID,getHorsePosition(hID));
		}
		return horsePosition;
	}
	public Set<Horse> canCatchHorse(Player otherPlayer,YutSet.PROPERTY p)
	{
		Set<Horse> retHorses = new HashSet<Horse>();
		Set<Integer> otherHorseIDs = otherPlayer.horses.keySet();
		Set<Integer> myHorseIDs = horses.keySet();
		
		for(Integer myHorseID:myHorseIDs)
		{
			Horse myHorse = horses.get(myHorseID);
			for(Integer otherHorseID:otherHorseIDs)
			{
				Horse otherHorse = otherPlayer.horses.get(otherHorseID);
				if(myHorse.canCatch(otherHorse, p))
				{
					 retHorses.add(myHorse);
				}
			}
			
		}
		return retHorses;
		
		
	}
	public boolean havePeerByHorseID(int horseID)
	{
		Horse h =  horses.get(horseID);
		return h.havePeer();
	}
	
}