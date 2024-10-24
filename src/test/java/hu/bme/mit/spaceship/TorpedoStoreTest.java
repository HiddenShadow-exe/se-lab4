package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void fire_Fail() {
        // Arrange
        TorpedoStore store = new TorpedoStore(0);

        // Assert
        assertThrows(IllegalArgumentException.class, () -> store.fire(1));
    }

    @Test
    void fire_Fail_TooMany() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Assert
        assertThrows(IllegalArgumentException.class, () -> store.fire(2));
    }

    @Test
    void isEmpty_True() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        store.fire(1);
        boolean result = store.isEmpty();

        // Assert
        assertEquals(true, result);
    }

    @Test
    void failedFire() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1, 1.0);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(false, result);
    }

    @Test
    void checkCount() {
        // Arrange
        TorpedoStore store = new TorpedoStore(2);

        // Act
        store.fire(1);
        int result = store.getTorpedoCount();

        // Assert
        assertEquals(1, result);
    }
}
