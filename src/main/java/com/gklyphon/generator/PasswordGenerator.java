package com.gklyphon.generator;

import java.security.SecureRandom;

/**
 * Class for generating and validating passwords.
 * This generator ensures that every password contains at least one uppercase letter,
 * one lowercase letter, one digit, and one special character. Additionally,
 * passwords are shuffled for randomness.
 *
 * @author JFCiscoHuerta
 * @version 1.0
 * @since 17-Oct-2024
 */
public class PasswordGenerator implements IGenerator {

    private static final int MIN_LENGTH = 32;
    private final SecureRandom secureRandom;
    private StringBuilder stringBuilder;
    private int length;

    /**
     * Default constructor that sets the password length to the minimum length (32).
     */
    public PasswordGenerator() {
        this(MIN_LENGTH);
    }

    /**
     * Constructor that allows specifying the desired password length.
     *
     * @param length The length of the generated password.
     * @throws IllegalArgumentException if the length is less than 32.
     */
    public PasswordGenerator(int length) {
        if (length < MIN_LENGTH) {
            throw new IllegalArgumentException("The minimum allowed password length is 32. Please specify a length of 32 or greater.");
        }
        this.secureRandom =new SecureRandom();
        this.length = length;
    }

    /**
     * Generates a password containing at least one uppercase letter, one lowercase letter,
     * one digit, and one special character. The rest of the characters are randomly generated.
     *
     * @return A shuffled, randomly generated password.
     */
    @Override
    public String generate() {
        stringBuilder = new StringBuilder(length);

        initializePasswordBasics();

        for(int i =4; i<length; i++) {
            stringBuilder.append(Utils.getRandomSpecialCharacter());
        }

        return shuffle(stringBuilder.toString());
    }

    /**
     * Validates a password by checking if it meets the minimum length and contains
     * at least one uppercase letter, one lowercase letter, one digit, and one special character.
     *
     * @param password The password to validate.
     * @return true if the password is valid, false otherwise.
     */
    @Override
    public boolean validate(String password) {
        return password.length() >= MIN_LENGTH &&
                password.chars().anyMatch(Character::isUpperCase) &&
                password.chars().anyMatch(Character::isLowerCase) &&
                password.chars().anyMatch(Character::isDigit) &&
                password.chars().anyMatch(ch -> "!@#$%^&*()-_=+".indexOf(ch) >= 0);
    }

    /**
     * Initializes the password with one of each required character type:
     * uppercase letter, lowercase letter, digit, and special character.
     *
     */
    private void initializePasswordBasics() {
        stringBuilder.append(Utils.getRandomUppercase());
        stringBuilder.append(Utils.getRandomLowercase());
        stringBuilder.append(Utils.getRandomNumber());
        stringBuilder.append(Utils.getRandomSpecialCharacter());
    }

    /**
     * Shuffles the characters in the provided string to ensure randomness.
     *
     * @param text The text to shuffle.
     * @return A new string with the characters shuffled.
     */
    private String shuffle(String text) {
        char[] textArray = text.toCharArray();

        for(int i=0; i< textArray.length; i++) {
            int j = secureRandom.nextInt(textArray.length);
            char auxiliary = textArray[i];
            textArray[i] = textArray[j];
            textArray[j] = auxiliary;
        }

        return new String(textArray);
    }
}