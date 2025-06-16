package dsa.practice.hash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HashMapTests {

    private HashMap map;

    @BeforeEach
    void setUp() {
        map = new HashMap();
    }

    @Test
    void testPutAndGet() {
        map.put("A", "Apple");
        map.put("B", "Banana");
        map.put("C", "Cherry");

        assertEquals("Apple", map.get("A"));
        assertEquals("Banana", map.get("B"));
        assertEquals("Cherry", map.get("C"));
    }

    @Test
    void testOverwriteValue() {
        map.put("A", "Apple");
        map.put("A", "Apricot"); // overwrite

        assertEquals("Apricot", map.get("A"));
    }

    @Test
    void testGetNonExistentKey() {
        map.put("A", "Apple");

        assertNull(map.get("Z")); // not present
    }

    @Test
    void testRemoveKey() {
        map.put("A", "Apple");
        map.put("B", "Banana");

        map.remove("A");

        assertNull(map.get("A"));       // removed
        assertEquals("Banana", map.get("B")); // still present
    }

    @Test
    void testRemoveNonExistentKey() {
        map.put("A", "Apple");

        map.remove("Z"); // should not throw
        assertEquals("Apple", map.get("A")); // unaffected
    }

    @Test
    void testPutNullKeyAndValue() {
        map.put(null, "NullKey");
        map.put("NullValue", null);

        assertEquals("NullKey", map.get(null));
        assertNull(map.get("NullValue"));
    }

    @Test
    void testChainingWithCollisions() {
        // All these keys will have the same hash, forcing them into the same bucket
        BadKey key1 = new BadKey("Key1", 1);
        BadKey key2 = new BadKey("Key2", 1);
        BadKey key3 = new BadKey("Key3", 1);

        map.put(key1.toString(), "Value1");
        map.put(key2.toString(), "Value2");
        map.put(key3.toString(), "Value3");

        // Check that all keys are retrievable
        assertEquals("Value1", map.get(key1.toString()));
        assertEquals("Value2", map.get(key2.toString()));
        assertEquals("Value3", map.get(key3.toString()));
    }

    @Test
    void testRemoveHeadWithCollisions() {
        BadKey key1 = new BadKey("Key1", 1); // Will be head
        BadKey key2 = new BadKey("Key2", 1);
        BadKey key3 = new BadKey("Key3", 1);

        map.put(key1.toString(), "Value1");
        map.put(key2.toString(), "Value2");
        map.put(key3.toString(), "Value3");

        map.remove(key1.toString()); // remove head

        assertNull(map.get(key1.toString()));
        assertEquals("Value2", map.get(key2.toString()));
        assertEquals("Value3", map.get(key3.toString()));
    }

    @Test
    void testRemoveMiddleWithCollisions() {
        BadKey key1 = new BadKey("Key1", 1);
        BadKey key2 = new BadKey("Key2", 1); // Will be middle
        BadKey key3 = new BadKey("Key3", 1);

        map.put(key1.toString(), "Value1");
        map.put(key2.toString(), "Value2");
        map.put(key3.toString(), "Value3");

        map.remove(key2.toString()); // remove middle

        assertEquals("Value1", map.get(key1.toString()));
        assertNull(map.get(key2.toString()));
        assertEquals("Value3", map.get(key3.toString()));
    }

    @Test
    void testRemoveTailWithCollisions() {
        BadKey key1 = new BadKey("Key1", 1);
        BadKey key2 = new BadKey("Key2", 1);
        BadKey key3 = new BadKey("Key3", 1); // Will be tail

        map.put(key1.toString(), "Value1");
        map.put(key2.toString(), "Value2");
        map.put(key3.toString(), "Value3");

        map.remove(key3.toString()); // remove tail

        assertEquals("Value1", map.get(key1.toString()));
        assertEquals("Value2", map.get(key2.toString()));
        assertNull(map.get(key3.toString()));
    }

    static class BadKey {
        private final String key;
        private final int forcedHash;

        public BadKey(String key, int forcedHash) {
            this.key = key;
            this.forcedHash = forcedHash;
        }

        @Override
        public int hashCode() {
            return forcedHash; // Force the same hash for all instances
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof BadKey)) {
                return false;
            }
            BadKey other = (BadKey) o;
            return key.equals(other.key);
        }

        @Override
        public String toString() {
            return key;
        }
    }
}
