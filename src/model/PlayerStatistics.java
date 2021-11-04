package model;

public class PlayerStatistics {
	private int noOfCaughtBalls;
	private int noOfGoalsScored;
	public PlayerStatistics(){
		noOfCaughtBalls=0;
		noOfGoalsScored=0;		
	}
	public void updateCaughtBalls(int caught) {
		noOfCaughtBalls=caught;
	}
	public void updateGoalsScored(int goals) {
		noOfGoalsScored=goals;
	}
	public int getCaughtBalls() {
		return noOfCaughtBalls;
	}
	public int getGoalsScored() {
		return noOfGoalsScored;
	}	
}
