package model;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
class UnitTest {

	@Test
	void testBallColor() {
		SoccerBall ball=SoccerBall.getSoccerBall();
		assertEquals(ball.getColor(),java.awt.Color.WHITE);
	}
	@Test
	void testBallPosition() {
		SoccerBall ball=SoccerBall.getSoccerBall();
		assertEquals(ball.getPosition().x,480);
		assertEquals(ball.getPosition().y,500);
	}
	@Test
	void testBallInGate() {
		SoccerBall ball=SoccerBall.getSoccerBall();
		assertFalse(ball.inGate());
	}
	@Test
	void testBallInGoalKeeperSide() {
		SoccerBall ball=SoccerBall.getSoccerBall();
		assertFalse(ball.onGoalkeeperSide());
	}
	@Test
	void testMoveBall() {
		SoccerBall ball=SoccerBall.getSoccerBall();
		java.awt.Point initPosition=ball.getPosition();
		ball.moveBallY(100);
		java.awt.Point movePosition=ball.getPosition();
		assertEquals(initPosition.x,movePosition.x);
	}
	@Test
	void testPlayerStatistics() {
		PlayerStatistics pstats=new PlayerStatistics();
		assertEquals(pstats.getCaughtBalls(),0);
		assertEquals(pstats.getGoalsScored(),0);
		pstats.updateCaughtBalls(1);
		assertEquals(pstats.getCaughtBalls(),1);
		pstats.updateCaughtBalls(2);
		assertEquals(pstats.getCaughtBalls(),2);
		pstats.updateGoalsScored(1);
		assertEquals(pstats.getGoalsScored(),1);
		pstats.updateGoalsScored(2);
		assertEquals(pstats.getGoalsScored(),2);		
	}
	@Test
	void testPlayerFactory() {
		PlayerFactory factory=new PlayerFactory();
		model.players.GamePlayer player=factory.getPlayer("goalkeeper");
		assertTrue(player instanceof model.players.Goalkeeper);		
		player=factory.getPlayer("Striker");
		assertTrue(player instanceof model.players.Striker);		
	}
}
