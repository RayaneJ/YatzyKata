package testyazy;
import org.junit.jupiter.api.Test;

import yatzy.Score;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyScoreTest {

    @Test
    public void testOnesCategory() {
        int[] diceRoll = {1, 2, 1, 4, 1};
        int score = Score.ones(diceRoll);
        assertEquals(3, score);
    }

    @Test
    public void testTwosCategory() {
        int[] diceRoll = {2, 2, 1, 4, 1};
        int score = Score.twos(diceRoll);
        assertEquals(4, score);
    }

    @Test
    public void testThreesCategory() {
        int[] diceRoll = {3, 3, 3, 4, 1};
        int score = Score.threes(diceRoll);
        assertEquals(9, score);
    }

    @Test
    public void testFoursCategory() {
        int[] diceRoll = {4, 4, 2, 4, 1};
        int score = Score.fours(diceRoll);
        assertEquals(12, score);
    }

    @Test
    public void testFivesCategory() {
        int[] diceRoll = {5, 5, 5, 1, 2};
        int score = Score.fives(diceRoll);
        assertEquals(15, score);
    }

    @Test
    public void testSixesCategory() {
        int[] diceRoll = {6, 2, 6, 4, 6};
        int score = Score.sixes(diceRoll);
        assertEquals(18, score);
    }

    @Test
    public void testPairCategory() {
        int[] diceRoll = {3, 3, 2, 4, 4};
        int score = Score.pair(diceRoll);
        assertEquals(8, score);
    }

    @Test
    public void testTwoPairsCategory() {
        int[] diceRoll = {1, 1, 2, 2, 4};
        int score = Score.twoPairs(diceRoll);
        assertEquals(6, score);
    }

    @Test
    public void testThreeOfAKindCategory() {
        int[] diceRoll = {3, 3, 3, 4, 2};
        int score = Score.threeOfAKind(diceRoll);
        assertEquals(9, score);
    }

    @Test
    public void testFourOfAKindCategory() {
        int[] diceRoll = {5, 5, 5, 5, 2};
        int score = Score.fourOfAKind(diceRoll);
        assertEquals(20, score);
    }

    @Test
    public void testSmallStraightCategory() {
        int[] diceRoll = {1, 2, 3, 4, 5};
        int score = Score.smallStraight(diceRoll);
        assertEquals(15, score);
    }

    @Test
    public void testLargeStraightCategory() {
        int[] diceRoll = {2, 3, 4, 5, 6};
        int score = Score.largeStraight(diceRoll);
        assertEquals(20, score);
    }

    @Test
    public void testFullHouseCategory() {
        int[] diceRoll = {4, 4, 4, 2, 2};
        int score = Score.fullHouse(diceRoll);
        assertEquals(16, score);
    }

    @Test
    public void testYatzyCategory() {
        int[] diceRoll = {6, 6, 6, 6, 6};
        int score = Score.yatzy(diceRoll);
        assertEquals(50, score);
    }
}
