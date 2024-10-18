package com.gklyphon.generator;

import java.security.SecureRandom;

/**
 * Utility class for generating random characters.
 * This class provides static methods to generate uppercase letters,
 * lowercase letters, numbers, special characters, and any random character
 * from a predefined set.
 *
 * @author JFCiscoHuerta
 * @version 1.0
 * @since 17-Oct-2024
 */
public class Utils {

    private static final SecureRandom secureRandom = new SecureRandom();
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBER = "0123456789";
    private static final String SPECIAL_CHARACTER = "!@#$%^&*()-_=+";
    private static final String ALL_CHARACTERS = UPPERCASE + LOWERCASE + NUMBER + SPECIAL_CHARACTER;

    /**
     * Generates a random uppercase letter.
     *
     * @return A random uppercase letter from 'A' to 'Z'.
     */
    public static char getRandomUppercase() {
        return UPPERCASE.charAt(secureRandom.nextInt(UPPERCASE.length()));
    }

    /**
     * Generates a random lowercase letter.
     *
     * @return A random lowercase letter from 'a' to 'z'.
     */
    public static char getRandomLowercase() {
        return LOWERCASE.charAt(secureRandom.nextInt(LOWERCASE.length()));
    }

    /**
     * Generates a random numeric character.
     *
     * @return A random numeric character from '0' to '9'.
     */
    public static char getRandomNumber() {
        return NUMBER.charAt(secureRandom.nextInt(NUMBER.length()));
    }

    /**
     * Generates a random special character.
     *
     * @return A random special character from the predefined set.
     */
    public static char getRandomSpecialCharacter() {
        return SPECIAL_CHARACTER.charAt(secureRandom.nextInt(SPECIAL_CHARACTER.length()));
    }

    /**
     * Generates a random character, which could be an uppercase letter,
     * lowercase letter, numeric character, or special character.
     *
     * @return A random character from the complete set of characters.
     */
    public static char getRandomCharacter() {
        return ALL_CHARACTERS.charAt(secureRandom.nextInt(ALL_CHARACTERS.length()));
    }
}