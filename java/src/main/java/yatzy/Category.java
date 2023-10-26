package yatzy;
import java.util.function.Function;


public enum Category {
    Chance(Score::chance),
    Yatzy(Score::yatzy),
    Ones(Score::ones),
    Twos(Score::twos),
    Threes(Score::threes),
    Fours(Score::fours),
    Fives(Score::fives),
    Sixes(Score::sixes),
    Pair(Score::pair),
    TwoPairs(Score::twoPairs),
    ThreeOfAKind(Score::threeOfAKind),
    FourOfAKind(Score::fourOfAKind),
    SmallStraight(Score::smallStraight),
    LargeStraight(Score::largeStraight),
    FullHouse(Score::fullHouse);

    private final Function<int[], Integer> scoreCalculator;

    Category(Function<int[], Integer> scoreCalculator) {
        this.scoreCalculator = scoreCalculator;
    }

    public String getName() {
        return this.name();
    }

    public Function<int[], Integer> getScore() {
        return scoreCalculator;
    }
}

