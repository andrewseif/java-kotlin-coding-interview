import enums.Condition;

public class GameState {

    private int win;
    private int draws;

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public void gameCounter(Condition output) {
        if (output == Condition.WIN) {
            win++;
            setWin(win);
        }
        if (output == Condition.DRAW) {
            draws++;
            setDraws(draws);
        }
    }
}
