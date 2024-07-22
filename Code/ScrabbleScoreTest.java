package Week5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ScrabbleScoreTest {
	ScrabbleScorer sc1 = new ScrabbleScorer();
	@Test
	public void scoreForTileTest() {
		assertEquals(1, sc1.scoreForTile('a'));
	}
	
	@Test
	public void scoreForWordTest() {
		assertEquals(8, sc1.scoreForWord("hello"));
	}
	
	@Test
	public void highestScoringWordTest() {
		List<String> words = new ArrayList<>();
        words.add("My");
        words.add("Name");
        words.add("Is");
        words.add("Blah");
		assertEquals("Blah", sc1.highestScoringWord(words));
	}
}
