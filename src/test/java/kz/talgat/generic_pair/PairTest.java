package kz.talgat.generic_pair;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairTest {

    @Test
    void testPair() {
        Pair <String, Integer> pair = new Pair<>("String object", 1);
        assertEquals("String object", pair.getFirst());
        assertEquals(1, pair.getSecond());
        pair.setFirst("updated string object");
        assertEquals("updated string object", pair.getFirst());
        pair.setSecond(10);
        assertEquals(10, pair.getSecond());
        assertEquals("Pair [first=updated string object, second=10]", pair.toString());
    }
}