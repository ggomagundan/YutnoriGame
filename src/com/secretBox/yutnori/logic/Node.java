package com.secretBox.yutnori.logic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Node {
	
	enum PROPERTY
	{
		START,END,NORMAL	
	};
	public Board board;
	public PROPERTY property= PROPERTY.NORMAL;
	private Set<Node> frontNodeSet =new HashSet<Node>();
	private Set<Node> backNodeSet = new HashSet<Node>();
	public Set<Horse> horses=new HashSet<Horse>();
	int nodeID;
	public Node(int nID,Board b)
	{
		board =b;
		nodeID = nID;
	}
	public void addFrontNode(Node frontNode)
	{
		if(frontNode !=null)
			frontNodeSet.add(frontNode);
	}
	public void addBackNode(Node backNode)
	{
		if(backNode != null)
			backNodeSet.add(backNode);
	}
	
	public void makeLink(Node frontNode,Node backNode)
	{
		addFrontNode(frontNode);
		addBackNode(backNode);
	}
	public int getFrontNodeCount()
	{
		return frontNodeSet.size();
	}
	public int getBackNodeCount()
	{
		return backNodeSet.size();
	}
	
	public Player getHorsesOwner()
	{
		Player p=null;
		for(Horse h : horses)
		{
			p = h.getOwner();
			break;
		}
		return p;
	}
	public Map<Integer,YutSet.PROPERTY> getMovableNodes(YutSet.PROPERTY property)
	{
		int moveCount = YutSet.getMoveCount(property);
		Map<Integer,YutSet.PROPERTY> movableNodes=new HashMap<Integer,YutSet.PROPERTY>();
		if(moveCount <0)
		{
			for(Node backNode:backNodeSet)
				movableNodes.put(backNode.nodeID,property);
		}else
		{
			List<Node> traceNodes= new LinkedList<Node>();
			Node currentNode =this;
			Node nextNode =null;
			for(int i=0;i<moveCount;i++)
			{
				nextNode = currentNode.nextNode(traceNodes);
				if(nextNode != null)
					currentNode = nextNode;
			}
			movableNodes.put(currentNode.nodeID,property);
		}
		return movableNodes;
	}
	public Node nextNode(List<Node> traceNodes)
	{
		Node nextNode=null;
		int nextNodeID=0;
		if(frontNodeSet.size()==2)
		{
			if(traceNodes.isEmpty())
			{
				
				nextNodeID = Board.MOVE_RULE_TURNNING_FROMID_TOID.get(nodeID);
	
			}else
			{
				if(Board.MOVE_RULE_CENTER == nodeID)
				{
					for(Node tN:traceNodes)
					{
						Integer iNextNodeID=Board.MOVE_RULE_TRACE_BEFOREID_TOID.get(tN.nodeID);
						if(iNextNodeID!=null)
						{
							nextNodeID=iNextNodeID;
							break;
						}
					}
					
				}else
				{
				
					nextNodeID = Board.MOVE_RULE_NORMAL_FROMID_TOID.get(nodeID);
				}
			}
			for(Node next:frontNodeSet)
			{
				if(next.nodeID ==nextNodeID)
				{
					nextNode = next;
					break;
				}
			}
		}else
		{
			for(Node next:frontNodeSet)
			{
				nextNode=next;
				break;
			}
		}
		traceNodes.add(this);
		return nextNode;
	}
	public void moveAllHorses(Node node)
	{
		List<Horse> listHorses = new ArrayList<Horse>(horses);
		horses.clear();
		for(int i=0;i<listHorses.size();i++)
		{
			 Horse h = listHorses.get(i);
			 h.move(node);	 
		}
		
	}
	public int getHorseID()
	{
		if(horses.isEmpty()==false)
		{
			int minHorseID= Integer.MAX_VALUE;
			for(Horse h:horses)
			{	
				int hID = h.getID();
				if(minHorseID > hID)
					minHorseID = hID;
			}
			return minHorseID;
			
		}	
		return -1;
	}
	
	
	

}

