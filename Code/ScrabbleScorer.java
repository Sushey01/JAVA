package Week5;
import java.util.*;
public class ScrabbleScorer {
	private final Map<Character, Integer> tileScores;
	public ScrabbleScorer () {
		char [] tiles = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		int[] scores = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
		tileScores = new HashMap<>();
		for (int i = 0; i < tiles.length; i++) {
			tileScores.put(tiles[i], scores[i]);
		}
	}
	
	
	public int scoreForTile(char tile) {
		tile = Character.toUpperCase(tile);
		if (!Character.isLetter(tile)) {
			return 0;
		}
		return tileScores.get(tile);
	}
	public int scoreForWord(String word) {
		char[] tile = word.toCharArray();
		int totalScore = 0;
		for (char tile1 : tile) {
			totalScore = totalScore + scoreForTile(tile1);
		}
		return totalScore;
	}
	public String highestScoringWord(List<String> words) {
		if (!words.isEmpty()) {
		List <Integer> scoreOfWords = new ArrayList<>();  //list of all the scores
		for (String word : words) {
			int scoreOfWord = scoreForWord(word);
			scoreOfWords.add(scoreOfWord);
		}
		int max = Collections.max(scoreOfWords);  //checks the highest score
		int index = scoreOfWords.indexOf(max);   //find the index of the highest score
		return words.get(index);    // use that index to find correspond string
		} else {
			return null;
		}
	}
	public static void main(String[] args) {
		ScrabbleScorer sc1 = new ScrabbleScorer();
		System.out.println(sc1.scoreForTile('y'));
		System.out.println(sc1.scoreForWord("hello"));
	    List<String> words = new ArrayList<>();
	    System.out.println(sc1.highestScoringWord(words));  //checks for empty list
        words.add("My");
        words.add("Name");
        words.add("Is");
        words.add("Blah");
		System.out.println(sc1.highestScoringWord(words)); //check for non empty list
	}
}