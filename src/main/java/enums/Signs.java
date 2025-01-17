package enums;

public enum Signs {

    ROCK,
    PAPER,
    SCISSORS;

    public static Signs getSign(int number) {
        return switch (number) {
            case 1 -> PAPER;
            case 2 -> SCISSORS;
            default -> ROCK;
        };
    }
}
