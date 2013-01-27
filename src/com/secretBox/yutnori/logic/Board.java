package com.secretBox.yutnori.logic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Board {
	public static final Map<Integer,Integer> MOVE_RULE_TURNNING_FROMID_TOID= 
		new HashMap<Integer,Integer>();
	public static final Map<Integer,Integer> MOVE_RULE_NORMAL_FROMID_TOID= 
		new HashMap<Integer,Integer>();
	public static final int MOVE_RULE_CENTER=23;
	public static final Map<Integer,Integer> MOVE_RULE_TRACE_BEFOREID_TOID=
		new HashMap<Integer,Integer>();
	
	public static final int START_ID = 0;
	public static final int END_ID = 30;
	public static final int FIRST_TURN_POINT_ID = 5;
	public static final int SECOND_TURN_POINT_ID = 10;
	public static final int THIRD_TURN_POINT_ID = 23;
	
	
	
	private Map<Integer,Node> nodeMap = new HashMap<Integer,Node>();
	private Node startNode =null ;
	private Node endNode= null;
	private Node startTempNode = null;
	private int nodeID=0;
	
	public Board()
	{
		nodeID=0;
		makeNodes();
		makeMoveRule();
	}
	private void makeMoveRule()
	{
		MOVE_RULE_TURNNING_FROMID_TOID.put(5, 21);
		MOVE_RULE_TURNNING_FROMID_TOID.put(10, 26);
		MOVE_RULE_TURNNING_FROMID_TOID.put(23, 28);
		
		MOVE_RULE_NORMAL_FROMID_TOID.put(5, 6);
		MOVE_RULE_NORMAL_FROMID_TOID.put(10, 11);
		
		MOVE_RULE_TRACE_BEFOREID_TOID.put(27,28);
		MOVE_RULE_TRACE_BEFOREID_TOID.put(22,24);
		
		 
	}
	private Node createNode()
	{
		Node retNode = new Node(nodeID,this);
		nodeMap.put(nodeID,retNode);
		nodeID++;
		return retNode;
	}
	private void makeNodes()
	{
		Node[] mainNodeArray = new Node[20];
		Node[] sideNodeArray1 = new Node[7];
		Node[] sideNodeArray2 = new Node[7];
		startNode  = createNode();
		for(int i=0;i<20;i++)
			mainNodeArray[i] = createNode();
		sideNodeArray1[0]=mainNodeArray[4];
		for(int i=1;i<6;i++)
			sideNodeArray1[i]=createNode();
		sideNodeArray1[6]=mainNodeArray[14];
		sideNodeArray2[0]=mainNodeArray[9];
		sideNodeArray2[1]=createNode();
		sideNodeArray2[2]=createNode();
		sideNodeArray2[3]=sideNodeArray1[3];
		sideNodeArray2[4]=createNode();
		sideNodeArray2[5]=createNode();
		sideNodeArray2[6]=mainNodeArray[19];
		
		makeLinks(mainNodeArray);
		makeLinks(sideNodeArray1);
		makeLinks(sideNodeArray2);
		mainNodeArray[0].addBackNode(mainNodeArray[19]);
		
		endNode = createNode();
		startTempNode = createNode();
		startTempNode.addFrontNode(mainNodeArray[0]);
		startNode.addFrontNode(mainNodeArray[0]);
		mainNodeArray[19].addFrontNode(endNode);
		startNode.property = Node.PROPERTY.START;
		endNode.property = Node.PROPERTY.END;
	}
	
	private void makeLinks(Node[] lineNode)
	{
		for(int i=0;i<lineNode.length;i++)
		{
			if(i==0)
			{
				lineNode[i].makeLink(lineNode[i+1],null);
			}else if(i==lineNode.length-1)
			{
				lineNode[i].makeLink(null,lineNode[i-1]);
			}else
			{
				lineNode[i].makeLink(lineNode[i+1],lineNode[i-1]);
			}
		}
	
	}
	public Node getStartNode()
	{
		return startNode;
	}
	public Node getEndNode()
	{
		return endNode;
	}
	public Node getStartTempNode()
	{
		return startTempNode;
	}
	public Node getNodeByID(int nodeID)
	{
		return nodeMap.get(nodeID);
	}
	public int getNodeIDByNode(Node node)
	{
		return node.nodeID;
	}
	public Set<Integer> getNodeIDsByNodes(Set<Node> nodes)
	{	
		Set<Integer> IDs = new HashSet<Integer>();
		for(Node n:nodes)
		{
			IDs.add(new Integer(getNodeIDByNode(n)));
		}
		return IDs;
	}
	public int getHorseIDbyNodeID(int nodeID)
	{
		Node targetNode = nodeMap.get(nodeID);
		return targetNode.getHorseID();
	}
	public Player getHorsesOwner(int nodeID)
	{
		Node targetNode = nodeMap.get(nodeID);
		return targetNode.getHorsesOwner();	
	}
	public int[] getTargetNodeIDs(int nodeID)
	{
		int[] tNodeID = {-1,-1};
		if(nodeID == 20 )
		{
			tNodeID[0]= 28;
			tNodeID[1]= 18;
		}else if(nodeID == 15)
		{
			tNodeID[0]= 24;
			tNodeID[1]= 13;
		}else if(nodeID == 23)
		{
			tNodeID[0]=21;
			tNodeID[1]=26;
		}
		else if(nodeID == 22)
		{
			tNodeID[0]=5;
		}else if(nodeID == 24)
		{
			tNodeID[0]=22;
		}else if(nodeID ==27)
		{
			tNodeID[0]=10;
		}else if(nodeID==28)
		{
			tNodeID[0]=27;
		}else if(nodeID==29)
		{
			tNodeID[0]=23;
		}
		else if(nodeID >=2 && nodeID <= 19 && nodeID != 12 && nodeID != 7)
		{
			tNodeID[0] = nodeID-2;
		}
		return tNodeID;
	}
	public int checkScore(int horseID,int nodeID,int currentNodeID,Map<Integer,Integer> myPlayer,Map<Integer,Integer> otherPlayer)
	{
		int score=0;
		
		
		Set<Integer> myHorseIDs = myPlayer.keySet();
		for(int myHorseID:myHorseIDs)
		{
			if(myHorseID != horseID)
			{
				int myNodeID = myPlayer.get(myHorseID);
				if(nodeID  == myNodeID)
					score++;
			}
			
		}
		Set<Integer> otherHorseIDs = otherPlayer.keySet();
		for(int otherHorseID:otherHorseIDs)
		{
			 int otherNodeID = otherPlayer.get(otherHorseID);
			 if(nodeID == otherNodeID)
				 score+=2;//score++;
			 
		}
		

		if(nodeID == this.FIRST_TURN_POINT_ID)
		{
			score+=2;
		}
		if(nodeID == this.SECOND_TURN_POINT_ID)
		{
			score+=1;
		}
			
		if(nodeID== this.THIRD_TURN_POINT_ID  && currentNodeID != 10 &&currentNodeID != 26 && currentNodeID != 27)
		{
			score+=1;
		}
		
		int[] tNodeID = getTargetNodeIDs(nodeID);
		
		for(int value :tNodeID)
		{
			if(value !=-1)
			{
				for(int otherHorseID:otherHorseIDs)
				{
					
					int otherNodeID = otherPlayer.get(otherHorseID);
					
					if(value == otherNodeID)
					{
						score-=1;//2;
						break;						 
					}
					 
				}
			}
		}
		int[] tnodeID2 = getTargetNodeIDs(currentNodeID);
		
		for(int value :tnodeID2)
		{
			if(value !=-1)
			{
				for(int otherHorseID:otherHorseIDs)
				{
					
					int otherNodeID = otherPlayer.get(otherHorseID);
					
					if(value == otherNodeID)
					{
						score++;
						break;						 
					}
					 
				}
			}
		}
		
		
		return score;
	}
	
}
