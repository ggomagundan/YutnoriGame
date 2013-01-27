package com.secretBox.yutnori.logic;


import java.util.HashMap;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;




public class Game {
	
	public static final int HORSECOUNT=4;
	private Board board = new Board();
	private YutSet yuts = new YutSet();
	
	private Map<Integer,Player> players= new HashMap<Integer,Player>();
	private int currentPlayerIndex=0;
	
	public Game()
	{
		
		
	}
	private void makePlayers(int userCount,int cpuCount)
	{
		int playerID=0;
		players= new HashMap<Integer,Player>();
		for(int i=0;i<userCount;i++)
			players.put(playerID++,new UserPlayer(HORSECOUNT));
		for(int i=0;i<cpuCount;i++)
			players.put(playerID++,new ComputerPlayer(HORSECOUNT));
	}
	//?úÌåê??Í≤åÏûÑ Ï¥àÍ∏∞??
	public void start()
	{
		board = new Board();
		//?úÏûë???åÎ†à?¥Ïñ¥ ?ãÌåÖ
		makePlayers(1,1);
		//?åÎ†à?¥Ïñ¥ ?úÏÑú ?ïÌïòÍ∏?
		currentPlayerIndex = 0;
		Set<Integer> pIDs =players.keySet();
		Node n = board.getNodeByID(Board.START_ID);
		for(Integer pID:pIDs)
		{
			Player  p = players.get(pID);
			p.initHorses(n);
		}
		
	}
	//?∑ÎçòÏß?äî ??ûÑ
	public YutSet.PROPERTY throwYuts()
	{
		YutSet.PROPERTY yutsProperty = yuts.throwYuts();
		return yutsProperty;
	}
	public Map<Integer,Map<Integer,YutSet.PROPERTY>> getMovableInfo(List<YutSet.PROPERTY> p) //Map<horseID,Set<nodeID>>
	{
		
		Set<YutSet.PROPERTY> pSet = new HashSet<YutSet.PROPERTY>();
		pSet.addAll(p);
		return getCurrentPlayer().getMovableHorses(pSet);
	}
	public void move(int horseID,int nodeID)
	{
		Node targetNode=board.getNodeByID(nodeID);
		Player currentPlayer = getCurrentPlayer();
		
		if(!targetNode.horses.isEmpty() && targetNode.nodeID != Board.END_ID &&
			(targetNode.getHorsesOwner() != getCurrentPlayer()))
		{
			Node startNode=board.getNodeByID(Board.START_ID);
			targetNode.moveAllHorses(startNode);
		}
		
		
		if(currentPlayer.isStarted(horseID))
			currentPlayer.moveHorse(horseID, board.getStartTempNode());
		currentPlayer.moveAllHorses(horseID,targetNode);
	}
	
	public void changeTurn()
	{
		currentPlayerIndex =(currentPlayerIndex + 1) % players.size();
	}
	protected Player getCurrentPlayer()
	{
		return players.get(currentPlayerIndex);
	}
	
	public boolean isWinner()
	{
		
		
		
		Map<Integer,Integer> horses= getCurrentPlayer().getHorsesPosition();
		Set<Integer> horseIDs = horses.keySet();
		int count =0;
		for(Integer h: horseIDs)
		{
			if(horses.get(h)==board.END_ID)
				count++;
		}
		
		
		if(horseIDs.size() == count)
		{
			return true;
		}
		
		return false;
		// return Win Player ID
	}
	//?úÌåê??Í≤åÏûÑ ?ùÎÇò??Î∂?∂Ñ
	public void end()
	{
		
	}
	
	// Map <HorseId, NodeId>
	public Map<Integer,Map<Integer, Integer>> getAllHorsesPosition() {
	
		Map<Integer,Map<Integer,Integer>> retPlayerIDs_horseIDs_nodeIDs = 
			new HashMap<Integer,Map<Integer,Integer>>();
		Set<Integer> playerIDs = players.keySet();
		
		for(Integer playerID:playerIDs)
		{
			Map<Integer,Integer> horseIDs_nodeIDs = players.get(playerID).getHorsesPosition();
			retPlayerIDs_horseIDs_nodeIDs.put(playerID, horseIDs_nodeIDs);
		}
		return retPlayerIDs_horseIDs_nodeIDs;
	}
	public boolean isStarted(int horseID)
	{
		return getCurrentPlayer().isStarted(horseID);
	}
	public boolean isFinished(int horseID)
	{
		return getCurrentPlayer().isFinished(horseID);
	}
	public int getHorseIDbyNodeID(int nodeID)
	{
		return board.getHorseIDbyNodeID(nodeID);
	}
	
	public boolean haveOtherTeamHorse(int nodeID)
	{
		Player nodePlayer  = board.getHorsesOwner(nodeID);
		
		if (nodeID== board.END_ID || nodePlayer == null || nodePlayer == getCurrentPlayer())
			return false;
		return true;
	}
	public int getHorsePosition(int horseID)
	{
		return getCurrentPlayer().getHorsePosition(horseID);
	}
	public boolean havePeerByHorseID(int horseID)
	{
		return getCurrentPlayer().havePeerByHorseID(horseID);
	}
	public int checkScore(int horseID,int nodeID,Map<Integer,Integer> myPlayer,Map<Integer,Integer> otherPlayer)
	{
		
		return board.checkScore(horseID, nodeID,getHorsePosition(horseID), myPlayer, otherPlayer);
	}
	
	
}
