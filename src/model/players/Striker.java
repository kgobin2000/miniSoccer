package model.players;

import java.awt.Color;
import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

import model.SoccerBall;

public class Striker extends GamePlayer {
	public Striker() {
		super("",new Point(490,450),Color.BLUE);
	}
	public Striker(String name) {
		super(name,new Point(490,450),Color.BLUE);
	}
	public void moveLeft() {		
		if(isPlayerHasBall()) {
			boolean ballGrabbed=grabsBall();
			if(ballGrabbed) {
				SoccerBall ball=SoccerBall.getSoccerBall();
				ball.setPosition(new Point(ball.getPosition().x-5,ball.getPosition().y));
			}
		}
		position.x-=5;
	}
	public void moveRight() {
		if(isPlayerHasBall()) {
			boolean ballGrabbed=grabsBall();
			if(ballGrabbed) {
				SoccerBall ball=SoccerBall.getSoccerBall();
				ball.setPosition(new Point(ball.getPosition().x+5,ball.getPosition().y));
			}
		}
		position.x+=5;		
	}
	public void moveDown() {
		if(isPlayerHasBall()) {
			boolean ballGrabbed=grabsBall();
			if(ballGrabbed) {
				SoccerBall ball=SoccerBall.getSoccerBall();
				ball.setPosition(new Point(ball.getPosition().x,ball.getPosition().y+5));
			}
		}
		position.y+=5;		
	}
	public void moveUp() {
		if((position.y-5)<=200) 
			return;
		if(isPlayerHasBall()) {
			boolean ballGrabbed=grabsBall();
			if(ballGrabbed) {
				SoccerBall ball=SoccerBall.getSoccerBall();
				ball.setPosition(new Point(ball.getPosition().x,ball.getPosition().y-5));
			}
		}
		position.y-=5;		
	}
	public void setPlayerStatistics(int stats) {
		super.statistics.updateGoalsScored(stats);
		//System.out.println("Goaled balls: " + getPlayerStatistics());
	}
	public int getPlayerStatistics() {
		return super.statistics.getGoalsScored();
	}
	public void setInitialPosition() {
		super.position.x=490;
		super.position.y=450;		
	}
	public boolean isPlayerHasBall() {		
		SoccerBall ball=SoccerBall.getSoccerBall();
		return !ball.onGoalkeeperSide();
	}
	public boolean grabsBall()
	{
		SoccerBall ball=SoccerBall.getSoccerBall();
		if(Math.pow(position.x-ball.getPosition().x,2) + Math.pow(position.y-ball.getPosition().y,2)< Math.pow(55,2)) {
			ball.setPosition(new Point(position.x-15,position.y+50));			
			return true;
		}
		return false;
	}
	public void shootBall() {
		SoccerBall ball=SoccerBall.getSoccerBall();
		Point currentPosition=ball.getPosition();
		Timer timer = new Timer();
		TimerTask repaintTask = new TimerTask() {
			int i=currentPosition.y;
			@Override
			public void run() {
				if(i>=50) {
					ball.setPosition(new Point(position.x,i));
					i-=5;
				}
			}
		};
		timer.schedule(repaintTask, 0, 10);
		/*for(;i>=50;i-=5) {
			ball.
			try
			{
				Thread.sleep(100);
			}
			catch(InterruptedException ex) {}
		}*/
		//ball.moveBallY(distance);
	}
	public String toString() {
		return super.name + " scored " + super.statistics.getGoalsScored() + " goals";
	}
}
