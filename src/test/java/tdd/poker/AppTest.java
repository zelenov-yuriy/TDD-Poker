package tdd.poker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @BeforeEach
    void setUp() {
        System.out.println("setUp");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }

    @Test
    public void testCardCreation() {
        Card card = new Card(0, "2", "clubs");
        String result = card.toString();
        assertEquals("0) 2 of clubs", result);
    }
}