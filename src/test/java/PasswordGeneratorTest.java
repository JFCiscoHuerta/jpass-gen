
import com.gklyphon.generator.PasswordGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the PasswordGenerator class.
 * This test suite ensures that the password generator behaves as expected,
 * covering functionality such as password generation, validation, and error handling.
 *
 * @author JFCiscoHuerta
 * @version 1.0
 * @since 17-Oct-2024
 */
class PasswordGeneratorTest {

    /**
     * Instance of PasswordGenerator to be used in the tests.
     * Initialized before each test to ensure a clean state.
     */
    PasswordGenerator passwordGenerator;

    /**
     * Sets up a new PasswordGenerator instance before each test case.
     */
    @BeforeEach
    void setUp() {
        passwordGenerator = new PasswordGenerator();
    }

    /**
     * Verifies that the generator produces a password with the default length of 32 characters.
     */
    @Test
    void shouldGeneratePasswordWithDefaultLength() {
        String password = passwordGenerator.generate();
        assertEquals(32, password.length(), "Password should have 32 characters by default.");
    }

    /**
     * Ensures that an IllegalArgumentException is thrown when trying to create
     * a PasswordGenerator with an invalid length (e.g., 0).
     */
    @Test
    void shouldThrowExceptionForInvalidLength() {
        assertThrows(IllegalArgumentException.class,
                () -> new PasswordGenerator(0), "Expected exception for invalid password length.");
    }

    /**
     * Confirms that each generated password is unique by comparing two
     * consecutively generated passwords.
     */
    @Test
    void shouldGenerateUniquePasswords() {
        String password1 = passwordGenerator.generate();
        String password2 = passwordGenerator.generate();
        assertNotEquals(password1, password2, "Passwords should not be identical.");
    }

    /**
     * Validates that a generated password meets the expected validation rules.
     * This test ensures that the password generator produces valid passwords by default.
     */
    @Test
    void shouldValidatePassword() {
        String password = passwordGenerator.generate();
        assertTrue(passwordGenerator.validate(password), "Generated password should be valid.");
    }

    /**
     * Checks that the generated password contains at least one uppercase letter.
     * This ensures that the password meets complexity requirements.
     */
    @Test
    void shouldContainAtLeastOneUpperCaseLetter() {
        String password = passwordGenerator.generate();
        assertTrue(password.matches(".*[A-Z].*"), "Password must contain at least one uppercase letter.");
    }

    /**
     * Tests that the password generator correctly produces passwords of varying lengths
     * and ensures that those passwords are valid.
     *
     * @param length The desired length of the password.
     */
    @ParameterizedTest
    @ValueSource(ints = {32,64,128,256})
    void shouldGenerateAndValidateWithMultipleLengths(int length) {
        passwordGenerator = new PasswordGenerator(length);
        String password = passwordGenerator.generate();
        assertAll(
                () -> assertEquals(length, password.length(),
                        "Password length should match the specified value."),
                () -> assertTrue(passwordGenerator.validate(password),
                        "Generated password should be valid.")
        );
    }
}