package mk.finki.ukim;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    @Test
    public void test_EveryStatementMethod() {
        // Test: allItems == null edge case
        RuntimeException e = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, ""));
        assertEquals("allItems list can't be null!", e.getMessage());

        // Test: item name == null edge case
        Item item1 = new Item(null, 0, 0, 0.0);
        e = assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(item1), ""));
        assertEquals("Invalid item!", e.getMessage());

        // Test: All cases covered except edge cases M,O,T includes discount and a correct card number
        Item item2 = new Item("Apple", 11, 400, 0.45);
        double sum = SILab2.checkCart(List.of(item2), "1234567898765432");
        assertEquals(2390.0000000000005, sum);

        // Test: Item without discount and with a wrong card number which covers edge cases M and T
        Item item3 = new Item("Apple", 11, 400, 0.0);
        e=assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(item3), "STQREYUIOPASDFGH"));
        assertEquals("Invalid character in card number!", e.getMessage());

        //Test: Item without a card covers edge case O
        Item item4 = new Item("Apple", 11, 400, 0.0);
        e=assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(item4), ""));
        assertEquals("Invalid card number!", e.getMessage());
    }

    @Test
    public void testing_MultipleConditionMethod() {

        // Test 1: TXX by setting price > 300
        Item item1 = new Item("Apple", 1, 400, 0.0);
        double sum = SILab2.checkCart(List.of(item1), "1234567898765432");
        assertEquals(370, sum);

        // Test 2: FTX by setting discount > 0
        Item item2 = new Item("Apple", 1, 100, 0.45);
        sum = SILab2.checkCart(List.of(item2), "1234567898765432");
        assertEquals(25.000000000000007, sum);

        // 3.  FFT by setting quantity > 10
        Item item3 = new Item("Apple", 11, 100, 0.0);
        sum = SILab2.checkCart(List.of(item3), "1234567898765432");
        assertEquals(1070, sum);

        // 4. FFF through quantity < 10, price < 100 and discount == 0
        Item item4 = new Item("item4", 1, 100, 0.0);
        sum = SILab2.checkCart(List.of(item4), "1234567898765432");
        assertEquals(100, sum);
    }
}