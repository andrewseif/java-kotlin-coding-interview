import enums.Signs;
import enums.Condition;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTests {


    // Test for the gamePlay method
    @Test
    public void testGamePlay() {
        // Test ROCK
        assertEquals(Condition.DRAW, Main.gamePlay(Signs.ROCK), "Expected DRAW when player2 plays ROCK");

        // Test PAPER
        assertEquals(Condition.WIN, Main.gamePlay(Signs.PAPER), "Expected WIN when player2 plays PAPER");

        // Test SCISSORS
        assertEquals(Condition.LOSE, Main.gamePlay(Signs.SCISSORS), "Expected LOSE when player2 plays SCISSORS");
    }

    // Test for Signs enum
    @Test
    public void testGetSign() {
        assertEquals(Signs.PAPER, Signs.getSign(1), "Expected PAPER for input 1");
        assertEquals(Signs.SCISSORS, Signs.getSign(2), "Expected SCISSORS for input 2");

        // Test invalid input (default case)
        assertEquals(Signs.ROCK, Signs.getSign(0), "Expected ROCK for out-of-range input 3");
        assertEquals(Signs.ROCK, Signs.getSign(3), "Expected ROCK for out-of-range input 3");
    }

    // Test for GameState class
    @Test
    public void testGameStateInitialValues() {
        GameState gameState = new GameState();
        assertEquals(0, gameState.getWin(), "Initial win count should be 0");
        assertEquals(0, gameState.getDraws(), "Initial draws count should be 0");
    }

    @Test
    public void testGameStateWinCounter() {
        GameState gameState = new GameState();

        // Simulate a WIN result
        gameState.gameCounter(Condition.WIN);

        assertEquals(1, gameState.getWin(), "Win count should increment to 1 after a WIN");
        assertEquals(0, gameState.getDraws(), "Draws count should remain 0 after a WIN");
    }

    @Test
    public void testGameStateDrawCounter() {
        GameState gameState = new GameState();

        // Simulate a DRAW result
        gameState.gameCounter(Condition.DRAW);

        assertEquals(0, gameState.getWin(), "Win count should remain 0 after a DRAW");
        assertEquals(1, gameState.getDraws(), "Draws count should increment to 1 after a DRAW");
    }

    @Test
    public void testGameStateInvalidInput() {
        GameState gameState = new GameState();

        // Simulate invalid input (no action for LOSE)
        gameState.gameCounter(Condition.LOSE);

        assertEquals(0, gameState.getWin(), "Win count should remain 0 for LOSE input");
        assertEquals(0, gameState.getDraws(), "Draws count should remain 0 for LOSE input");
    }

    @Test
    public void testGameStateMultipleResults() {
        GameState gameState = new GameState();

        // Simulate multiple results
        gameState.gameCounter(Condition.WIN);
        gameState.gameCounter(Condition.DRAW);
        gameState.gameCounter(Condition.WIN);

        assertEquals(2, gameState.getWin(), "Win count should be 2 after two WINs");
        assertEquals(1, gameState.getDraws(), "Draws count should be 1 after one DRAW");
    }
}
