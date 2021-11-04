package model.players;

import java.awt.Color;
import java.awt.Point;

import model.PlayerStatistics;
import model.SoccerBall;

public abstract class GamePlayer {
	protected String name;
	protected Point position;
	protected Color color;
	protected PlayerStatistics statistics;	
	public GamePlayer() {
		name="";
		position=new Point(0,0);
		color=Color.RED;
		statistics=new PlayerStatistics();
	}
	public GamePlayer(String name,Point location,Color color) {
		this.name=name;
		this.position=location;
		this.color=color;
		statistics=new PlayerStatistics();
	}
	public String getPlayerName() {
		return name;
	}
	public Point getPlayerPosition() {
		return position;
	}
	public Color getPlayerColor() {
		return color;
	}
	public abstract void moveLeft();
	public abstract void moveRight();
	public abstract void moveDown();
	public abstract void moveUp();
	public abstract void setPlayerStatistics(int stats);
	public abstract int getPlayerStatistics();
	public abstract void setInitialPosition();
	public abstract boolean isPlayerHasBall();
	public abstract void shootBall();
}