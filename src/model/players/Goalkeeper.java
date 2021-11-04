package model.players;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import model.SoccerBall;

public class Goalkeeper extends GamePlayer{
	private boolean ballGrabbed;
	private int movementStep;
	public Goalkeeper() {
		super("",new Point(280,100),Color.YELLOW);
		ballGrabbed=false;
	}
	public Goalkeeper(String name) {
		super(name,new Point(280,100),Color.YELLOW);
		ballGrabbed=false;
	}
	public void moveLeft() {
		position.x-=movementStep;
	}
	public void moveRight() {
		position.x+=movementStep;
	}
	public void moveDown() {
	}
	public void moveUp() {
	}
	public void setPlayerStatistics(int stats) {
		super.statistics.updateCaughtBalls(stats);
		//System.out.println("Caught balls: " + getPlayerStatistics());
	}
	public int getPlayerStatistics() {
		return super.statistics.getCaughtBalls();
	}
	public void setInitialPosition() {
		super.position.x=280;
		super.position.y=100;	
		ballGrabbed=false;
	}
	public void grabsBall() {
		SoccerBall ball=SoccerBall.getSoccerBall();
//		System.out.println("ball position: " + ball.getPosition().x + ", keeper position: " + super.position.x);
		if(ball.onGoalkeeperSide()) {
			if(!ball.inGate()) {
				ballGrabbed=true;
				ball.setPosition(new Point(position.x-50,position.y+50));
			}
			else {
				ballGrabbed=false;
			}
		}
			//	ballGrabbed=true;
			//else {
			//}
		//}
		//else {
		//	ballGrabbed=false;
		//}
		//System.out.println("Ballgrabbed : " + ballGrabbed);
	}
	public void shootBall() {
		SoccerBall ball=SoccerBall.getSoccerBall();
		if(ballGrabbed) {
			Point currentPosition=ball.getPosition();
			Timer timer = new Timer();
			TimerTask repaintTask = new TimerTask() {
				int i=currentPosition.y;
				@Override
				public void run() {
					if(i<=500) {
						ball.setPosition(new Point(position.x,i));
						i+=5;
					}
				}
			};
			timer.schedule(repaintTask, 0, 10);
			
			//ball.setPosition(new Point(position.x,500));			
		}
	}
	public boolean isPlayerHasBall() {
		//grabsBall();
		return ballGrabbed;
	}
	public void moveRandomly() {
		Random random=new Random();
		double playerCurrentPosition=(double)getPlayerPosition().x+15;
		double chanceOfMovingLeft=(playerCurrentPosition-300)/100-(random.nextGaussian());
		movementStep=(int)Math.abs(30 * chanceOfMovingLeft);
		if(chanceOfMovingLeft > 0) {
			moveLeft();
		}
		else {
			moveRight();
		}
	}
	public String toString() {
		return super.name + " caught " + super.statistics.getCaughtBalls() + " balls";
	};
	
}
