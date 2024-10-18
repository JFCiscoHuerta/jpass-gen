import com.gklyphon.generator.Utils;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Utils class.
 * This test suite validates the behavior of various utility methods
 * that generate random characters, such as uppercase, lowercase, numbers,
 * and special characters.
 *
 * @author JFCiscoHuerta
 * @version 1.0
 * @since 17-Oct-2024
 */
class UtilsTest {

    /**
     * Verifies that the getRandomUppercase method returns a single uppercase letter.
     * The test is repeated 15 times to ensure randomness and reliability.
     */
    @RepeatedTest(15)
    void shouldReturnRandomUppercase() {
        char uppercase = Utils.getRandomUppercase();
        assertEquals(1, String.valueOf(uppercase).length(),
                "The character should have length 1.");

        assertTrue(uppercase >= 65 && uppercase <= 90,
                "Character is not a valid uppercase letter.");
    }

    /**
     * Verifies that the getRandomLowercase method returns a single lowercase letter.
     * The test is repeated 15 times to ensure randomness and reliability.
     */
    @RepeatedTest(15)
    void shouldReturnRandomLowercase() {
        char lowercase = Utils.getRandomLowercase();
        assertEquals(1, String.valueOf(lowercase).length(),
                "The character should have length 1.");

        assertTrue(lowercase >= 97 && lowercase <= 122,
                "Character is not a valid lowercase letter.");
    }

    /**
     * Validates that the getRandomNumber method returns a single numeric character.
     * The test is repeated 15 times to ensure randomness and reliability.
     */
    @RepeatedTest(15)
    void shouldReturnRandomNumber() {
        char number = Utils.getRandomNumber();
        assertEquals(1, String.valueOf(number).length(),
                "The character should have length 1.");
        assertTrue(number >= 48 && number <= 57,
                "Character is not a valid numeric digit.");
    }

    /**
     * Ensures that the getRandomSpecialCharacter method returns a valid special character.
     * The test is repeated 15 times to validate randomness and proper character selection.
     */
    @RepeatedTest(15)
    void shouldReturnRandomSpecialCharacter() {
        char special = Utils.getRandomSpecialCharacter();
        assertEquals(1, String.valueOf(special).length(),
                "The character should have length 1.");

        String validSpecialCharacters = "!@#$%^&*()-_=+";
        assertTrue(validSpecialCharacters.indexOf(special) != -1,
                "Character is not a valid special character.");
    }

    /**
     * Tests that the getRandomCharacter method returns a valid character,
     * which could be an uppercase letter, lowercase letter, number, or special character.
     */
    @Test
    void shouldReturnRandomCharacter() {
        char character = Utils.getRandomCharacter();
        assertEquals(1, String.valueOf(character).length(),
                "The character should have length 1.");

        boolean isValid = (character >= 'A' && character <= 'Z') ||
                (character >= 'a' && character <= 'z') ||
                (character >= '0' && character <= '9') ||
                "!@#$%^&*()-_=+[]{}|;:'\",.<>?/".indexOf(character) != -1;
        assertTrue(isValid,
                "Character is not a valid uppercase, lowercase, number, or special character.");
    }
}