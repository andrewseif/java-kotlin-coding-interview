import enums.Condition;
import enums.Signs;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        GameState gameState = new GameState();
        int rounds = 100;
        Random rand = new Random();

        for (int i = 0; i < rounds; i++) {
            int number = rand.nextInt(Signs.values().length);
            Condition game = gamePlay(Signs.getSign(number));
            gameState.gameCounter(game);
        }

        System.out.println("Player A wins " + (rounds - (gameState.getWin() + gameState.getDraws())) + " of 100 games");
        System.out.println("Player B wins " + gameState.getWin() + " of 100 games");
        System.out.println("Draws: " + gameState.getDraws() + " of 100 games");
    }

    public static Condition gamePlay(Signs player2) {
        return switch (player2) {
            case Signs.ROCK -> Condition.DRAW;
            case Signs.PAPER -> Condition.WIN;
            case Signs.SCISSORS -> Condition.LOSE;
        };
    }
}
