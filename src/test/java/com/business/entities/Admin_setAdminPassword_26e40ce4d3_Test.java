/*
Test generated by RoostGPT for test java_spring_17Jan using AI Type Open AI and AI Model gpt-4

1. Scenario: Test when the given adminPassword is null.
   Expected Result: The adminPassword should not be set to null. The system should throw an error or exception.

2. Scenario: Test when the given adminPassword is an empty string.
   Expected Result: The adminPassword should not be set to an empty string. The system should throw an error or exception.

3. Scenario: Test when the given adminPassword is a valid string.
   Expected Result: The adminPassword should be set to the given string.

4. Scenario: Test when the given adminPassword contains special characters.
   Expected Result: If the system allows special characters in the password, then the adminPassword should be set to the given string. If not, the system should throw an error or exception.

5. Scenario: Test when the given adminPassword is a string that exceeds the maximum allowed length.
   Expected Result: The system should throw an error or exception, indicating that the password is too long.

6. Scenario: Test when the given adminPassword is a string that is shorter than the minimum allowed length.
   Expected Result: The system should throw an error or exception, indicating that the password is too short.

7. Scenario: Test when the given adminPassword is a string with spaces.
   Expected Result: If the system allows spaces in the password, then the adminPassword should be set to the given string. If not, the system should throw an error or exception.

8. Scenario: Test when the given adminPassword is a string with leading or trailing spaces.
   Expected Result: The system should either trim the spaces and set the adminPassword, or throw an error or exception, depending on the business rules. 

9. Scenario: Test when the setAdminPassword function is called multiple times with the same password.
   Expected Result: The system should not throw any errors or exceptions, as the password remains the same.

10. Scenario: Test when the setAdminPassword function is called multiple times with different passwords.
    Expected Result: The last set password should be the one that is saved in the system.
*/
package com.business.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Admin_setAdminPassword_26e40ce4d3_Test {
    private Admin admin;

    @BeforeEach
    void setUp() {
        admin = new Admin();
    }

    @Test
    void testSetAdminPassword_NullPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            admin.setAdminPassword(null)
        );
        assertEquals("Password should not be null", exception.getMessage());
    }

    @Test
    void testSetAdminPassword_EmptyPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            admin.setAdminPassword("")
        );
        assertEquals("Password should not be empty", exception.getMessage());
    }

    @Test
    void testSetAdminPassword_ValidPassword() {
        admin.setAdminPassword("Admin@123");
        assertEquals("Admin@123", admin.getAdminPassword());
    }

    @Test
    void testSetAdminPassword_SpecialCharactersPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            admin.setAdminPassword("Admin@#")
        );
        assertEquals("Password should not contain special characters", exception.getMessage());
    }

    @Test
    void testSetAdminPassword_LongPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            admin.setAdminPassword("Admin@1234567890")
        );
        assertEquals("Password is too long", exception.getMessage());
    }

    @Test
    void testSetAdminPassword_ShortPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            admin.setAdminPassword("Ad@1")
        );
        assertEquals("Password is too short", exception.getMessage());
    }

    @Test
    void testSetAdminPassword_PasswordWithSpaces() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            admin.setAdminPassword("Admin @123")
        );
        assertEquals("Password should not contain spaces", exception.getMessage());
    }

    @Test
    void testSetAdminPassword_PasswordWithLeadingTrailingSpaces() {
        admin.setAdminPassword(" Admin@123 ");
        assertEquals("Admin@123", admin.getAdminPassword());
    }

    @Test
    void testSetAdminPassword_SamePasswordMultipleTimes() {
        admin.setAdminPassword("Admin@123");
        admin.setAdminPassword("Admin@123");
        assertEquals("Admin@123", admin.getAdminPassword());
    }

    @Test
    void testSetAdminPassword_DifferentPasswordsMultipleTimes() {
        admin.setAdminPassword("Admin@123");
        admin.setAdminPassword("Admin@456");
        assertEquals("Admin@456", admin.getAdminPassword());
    }
}
