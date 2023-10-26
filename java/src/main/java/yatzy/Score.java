package yatzy;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Score {

	// scores the sum of all dice

	public static int chance(int[] dice) {
		return Arrays.stream(dice).sum();
	}

	// If all dice have the same number, the player scores 50 points , if not 0

	public static int yatzy(int[] dice) {
		if (Arrays.stream(dice).allMatch(d -> d == dice[0])) {
			return 50;
		}
		return 0;
	}

	// sum of: Ones, Twos, Threes, Fours, Fives or Sixes:

	public static int ones(int[] dice) {
		return calculateNumberScore(dice, 1);
	}

	public static int twos(int[] dice) {
		return calculateNumberScore(dice, 2);
	}

	public static int threes(int[] dice) {
		return calculateNumberScore(dice, 3);
	}

	public static int fours(int[] dice) {
		return calculateNumberScore(dice, 4);
	}

	public static int fives(int[] dice) {
		return calculateNumberScore(dice, 5);
	}

	public static int sixes(int[] dice) {
		return calculateNumberScore(dice, 6);
	}

   // sum of the two highest matching dice
	
	public static int pair(int[] dice) {
		Map<Integer, Long> counts = Arrays.stream(dice).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		return counts.entrySet().stream().filter(entry -> entry.getValue() >= 2).mapToInt(entry -> entry.getKey() * 2)
				.max().orElse(0);
	}
   //If there are two pairs of dice with the same number, we calculate the sum of these dice
	
	public static int twoPairs(int[] dice) {
		Map<Integer, Long> counts = Arrays.stream(dice).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		List<Integer> pairs = counts.entrySet().stream().filter(entry -> entry.getValue() >= 2).map(Map.Entry::getKey)
				.collect(Collectors.toList());
		if (pairs.size() >= 2) {
			return pairs.stream().mapToInt(pair -> pair * 2).sum();
		}
		return 0;
	}

	// If there are three dice with the same number, sum of these dice
	
	public static int threeOfAKind(int[] dice) {
	    for (int number = 1; number <= 6; number++) {
	        int score = calculateNumberScore(dice, number);
	        if (score >= 3 * number) {
	            return score;
	        }
	    }
	    return 0; // No three of a kind found
	}

	public static int fourOfAKind(int[] dice) {
	    for (int number = 1; number <= 6; number++) {
	        int score = calculateNumberScore(dice, number);
	        if (score >= 4 * number) {
	            return score;
	        }
	    }
	    return 0; // No four of a kind found
	}

	// Dice : 1,2,3,4,5, score :15
	
	public static int smallStraight(int[] dice) {
		List<Integer> sortedDice = Arrays.stream(dice).distinct().sorted().boxed().collect(Collectors.toList());
		return sortedDice.equals(List.of(1, 2, 3, 4, 5)) ? 15 : 0;
	}
	
   // Dice : 2,3,4,5,6, score : 20
	
	public static int largeStraight(int[] dice) {
		List<Integer> sortedDice = Arrays.stream(dice).distinct().sorted().boxed().collect(Collectors.toList());
		return sortedDice.equals(List.of(2, 3, 4, 5, 6)) ? 20 : 0;
	}

	public static int fullHouse(int[] dice) {
		Map<Integer, Long> counts = Arrays.stream(dice).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		if (counts.size() == 2 && counts.containsValue(2L) && counts.containsValue(3L)) {
			return Arrays.stream(dice).sum();
		}
		return 0;
	}
	
  //If the dice are two of a kind and three of a kind, the player scores the sum of all the dice
	
	private static int calculateNumberScore(int[] dice, int number) {
		return Arrays.stream(dice).filter(d -> d == number).sum();
	}
}
