package model.players;

import java.util.ArrayList;
import java.util.Iterator;

public class PlayerCollection implements Iterable<GamePlayer>{

	private ArrayList<GamePlayer> playersList;
	
	public PlayerCollection() {
		playersList=new ArrayList<>();
	}
	
	public void add(GamePlayer player) {
		playersList.add(player);
	}
	
	public void remove(GamePlayer player) {
		playersList.remove(player);
	}
	
	public GamePlayer get(String player) {
		for(int i=0;i<playersList.size();i++) {
			if(player.equalsIgnoreCase("striker") && playersList.get(i) instanceof Striker) {
				return playersList.get(i);
			}
			else if(player.equalsIgnoreCase("goalkeeper") && playersList.get(i) instanceof Goalkeeper) {
				return playersList.get(i);
			}
		}
		return null;
	}
	
	@Override
	public Iterator<GamePlayer> iterator() {
		// TODO Auto-generated method stub
		return new PlayerCollectionIterator(playersList);
	}
	
	public void sort() {
		for(int i=0;i<playersList.size();i++) {
			GamePlayer a=playersList.get(i);
			for(int j=i+1;j<playersList.size();j++) {
				GamePlayer b=playersList.get(j);
				if(a.getPlayerStatistics()<b.getPlayerStatistics()) {
					GamePlayer temp;
					temp=playersList.get(i);
					playersList.set(i, playersList.get(j));
					playersList.set(j, temp);
				}
			}
		}
	}
	
}
