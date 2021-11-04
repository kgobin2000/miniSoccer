package model;

import model.players.GamePlayer;
import model.players.Goalkeeper;
import model.players.Striker;

public class PlayerFactory {
	public GamePlayer getPlayer(String player) {
		if(player.equals("goalkeeper"))
			return new Goalkeeper("Goalkeeper");
		else
			return new Striker("Striker");
	}
}
