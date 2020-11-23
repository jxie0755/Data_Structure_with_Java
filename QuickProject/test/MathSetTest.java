import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathSetTest {
    @Test
    void test_1() {
        Integer[] universe = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        MathSet<Integer> uut = new MathSet<Integer>(universe);
        assertEquals(0, uut.size());
        assertTrue(uut.isEmpty());

        uut.add(1);
        assertEquals(1, uut.size());
        assertFalse(uut.isEmpty());

        uut.add(3);
        assertEquals(2, uut.size());
        assertFalse(uut.isEmpty());

        uut.add(3);
        assertEquals(2, uut.size());
        assertFalse(uut.isEmpty());

        assertTrue(uut.contains(3));
        assertFalse(uut.contains(9));

        uut.delete(10);
        assertEquals(2, uut.size());
        assertFalse(uut.isEmpty());

        uut.delete(1);
        assertEquals(1, uut.size());
        assertFalse(uut.isEmpty());

        uut.delete(3);
        assertEquals(0, uut.size());
        assertTrue(uut.isEmpty());
    }

    @Test
    void test_2() {
        Character[] universe = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        MathSet<Character> uut = new MathSet<Character>(universe);
        Character[] keys1 = {'a', 'e', 'h'};
        Character[] keys2 = {'b', 'c', 'd', 'f', 'g'};
        for (char key : keys1) {
            uut.add(key);
        }
        assertFalse(uut.isEmpty());
        assertEquals(3, uut.size());
        MathSet<Character> cSet = uut.complement();
        for (char key : keys1) {
            assertFalse(cSet.contains(key));
        }
        for (char key : keys2) {
            assertTrue(cSet.contains(key));
        }
    }

    @Test
    void test_3() {
        Integer[] universe = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        MathSet<Integer> set1 = new MathSet<Integer>(universe);
        MathSet<Integer> set2 = new MathSet<Integer>(universe);

        Integer[] keys1 = {1, 3, 6};
        Integer[] keys2 = {2, 4, 6, 8};
        for (Integer key : keys1) {
            set1.add(key);
        }
        assertEquals(keys1.length, set1.size());

        for (Integer key : keys2) {
            set2.add(key);
        }
        assertEquals(keys2.length, set2.size());

        set1.union(set2);
        assertEquals(6, set1.size());

        for (Integer key : keys1) {
            assertTrue(set1.contains(key));
        }

        for (Integer key : keys2) {
            assertTrue(set1.contains(key));
        }
    }

    @Test
    void test_4() {
        Integer[] universe = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        MathSet<Integer> set1 = new MathSet<Integer>(universe);
        MathSet<Integer> set2 = new MathSet<Integer>(universe);

        Integer[] keys1 = {1, 2, 3, 5, 8};
        Integer[] keys2 = {2, 4, 6, 8};
        for (Integer key : keys1) {
            set1.add(key);
        }
        assertEquals(keys1.length, set1.size());

        for (Integer key : keys2) {
            set2.add(key);
        }
        assertEquals(keys2.length, set2.size());

        set1.intersection(set2);
        assertEquals(2, set1.size());

        for (Integer key : universe) {
            if (key == 2 || key == 8) {
                assertTrue(set1.contains(key));
            } else {
                assertFalse(set1.contains(key));
            }
        }
    }

}
