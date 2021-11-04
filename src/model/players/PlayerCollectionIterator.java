package model.players;

import java.util.ArrayList;
import java.util.Iterator;

public class PlayerCollectionIterator implements Iterator<GamePlayer>{

	private ArrayList<GamePlayer> playersList;
	private int index;
	
	public PlayerCollectionIterator(ArrayList<GamePlayer> pList) {
		playersList=pList;
		index=0;
	}
	
	@Override
	public boolean hasNext() {
		return index<playersList.size();
	}

	@Override
	public GamePlayer next() {
		return playersList.get(index++);		
	}	
}
