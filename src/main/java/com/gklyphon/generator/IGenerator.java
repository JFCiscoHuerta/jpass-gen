package com.gklyphon.generator;


/**
 * Interface for generating and validating strings, such as passwords.
 * Classes implementing this interface should provide their own logic
 * for generating and validating content.
 *
 * @author JFCiscoHuerta
 * @version 1.0
 * @since 17-Oct-2024
 */
public interface IGenerator {

    /**
     * Generates a new string based on the implementation logic (e.g., a password).
     *
     * @return A newly generated string.
     */
    String generate();

    /**
     * Validates the provided string according to specific rules defined
     * by the implementing class.
     *
     * @param T The string to be validated.
     * @return true if the input is valid, false otherwise.
     */
    boolean validate(String T);
}