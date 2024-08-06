package com.learn.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

    private static final String LOWERCASE_PATTERN = ".*[a-z].*";
    private static final String UPPERCASE_PATTERN = ".*[A-Z].*";
    private static final String DIGIT_PATTERN = ".*\\d.*";
    private static final String SPECIAL_CHARACTER_PATTERN = ".*[@$!%*?&].*";
    private static final int MIN_LENGTH = 8;

    private static final Pattern lowercasePattern = Pattern.compile(LOWERCASE_PATTERN);
    private static final Pattern uppercasePattern = Pattern.compile(UPPERCASE_PATTERN);
    private static final Pattern digitPattern = Pattern.compile(DIGIT_PATTERN);
    private static final Pattern specialCharacterPattern = Pattern.compile(SPECIAL_CHARACTER_PATTERN);

    // Method to validate the password
    public static String validate(String password) {
        String errorMessages = "";

        if (StringUtils.isBlank(password)) {
            errorMessages = "Password cannot be blank.";
            return errorMessages;
        }

        if (password.length() < MIN_LENGTH) {
            errorMessages += "Password must be at least " + MIN_LENGTH + " " +
                    "characters long.\n";
        }

        Matcher lowercaseMatcher = lowercasePattern.matcher(password);
        if (!lowercaseMatcher.matches()) {
            errorMessages += "Password must contain at least one lowercase " +
                    "letter.\n";
        }

        Matcher uppercaseMatcher = uppercasePattern.matcher(password);
        if (!uppercaseMatcher.matches()) {
            errorMessages += "Password must contain at least one uppercase " +
                    "letter.\n";
        }

        Matcher digitMatcher = digitPattern.matcher(password);
        if (!digitMatcher.matches()) {
            errorMessages += "Password must contain at least one digit.\n";
        }

        Matcher specialCharacterMatcher = specialCharacterPattern.matcher(password);
        if (!specialCharacterMatcher.matches()) {
            errorMessages += "Password must contain at least one special " +
                    "character (@$!%*?&).\n";
        }

        return errorMessages;
    }

    public static void main(String[] args) {
        // Test cases
        String[] testPasswords = {
                "Password123!",    // Valid
                "password123",     // No uppercase letter
                "PASSWORD123",     // No lowercase letter
                "Password!",       // No digit
                "Pass1234",        // No special character
                "Short1!",         // Less than 8 characters
                "ValidPassword123!"// Valid
        };

        for (String password : testPasswords) {
            String errors = validate(password);
            System.out.println("Password: " + password);
            if (errors.isEmpty()) {
                System.out.println("is valid.");
            } else {
                System.out.println("is invalid for the following reasons:");
                System.out.println(errors);
            }
            System.out.println();
        }
    }
}
