package com.gklyphon;

import com.gklyphon.generator.PasswordGenerator;

/**
 * Main class to demonstrate the usage of the PasswordGenerator.
 * Generates and prints a password to the console.
 *
 * @author JFCiscoHuerta
 * @version 1.0
 * @since 17-Oct-2024
 */
public class Main {
    public static void main(String[] args) {
        try {
            PasswordGenerator passwordGenerator = new PasswordGenerator();
            String password = passwordGenerator.generate();
            System.out.println("Generated Password: " + password);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error ocurred: " + e.getMessage());
        }
    }
}