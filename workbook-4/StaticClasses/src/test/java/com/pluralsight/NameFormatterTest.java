package com.pluralsight;

import org.junit.jupiter.api.Test;

import static com.pluralsight.NameFormatter.format;
import static org.junit.jupiter.api.Assertions.*;

class NameFormatterTest {

    @org.junit.jupiter.api.Test
    void format_test_firstName_lastName() {
        //arrange
        String firstName = "Akbar";
        String lastName = "Saidakramov";
        String expectedFullName = "Akbar Saidakramov";
        //act
        String actualFullName = format(firstName, lastName);
        //assert
        assertEquals(expectedFullName, actualFullName);
    }

    @org.junit.jupiter.api.Test
    void testFormat_emptyPrefix() {
        String prefix = "";
        String firstName = "Akbar";
        String middleName = "Said";
        String lastName = "Saidakramov";
        String suffix = "Phd";
        String expectedFullName = "Akbar Said Saidakramov, Phd";
        //act
        String actualFullName = format(prefix,firstName,middleName,lastName,suffix);
        //assert
        assertEquals(expectedFullName, actualFullName);

    }

    @org.junit.jupiter.api.Test
    void testFormat_emptyPrefix_emptyMiddleName() {
        String prefix = "";
        String firstName = "Akbar";
        String middleName = "";
        String lastName = "Saidakramov";
        String suffix = "Phd";
        String expectedFullName = "Akbar Saidakramov, Phd";
        //act
        String actualFullName = format(prefix,firstName,middleName,lastName,suffix);
        //assert
        assertEquals(expectedFullName, actualFullName);
    }

    @Test
    void testFormat_emptyPrefix_emptyMiddleName_emptySuffix() {
        String prefix = "";
        String firstName = "Akbar";
        String middleName = "";
        String lastName = "Saidakramov";
        String suffix = "";
        String expectedFullName = "Akbar Saidakramov";
        //act
        String actualFullName = format(prefix,firstName,middleName,lastName,suffix);
        //assert
        assertEquals(expectedFullName, actualFullName);
    }

    @Test
    void testFormat_emptyMiddleName_emptySuffix() {
        String prefix = "Mr";
        String firstName = "Akbar";
        String middleName = "";
        String lastName = "Saidakramov";
        String suffix = "";
        String expectedFullName = "Mr. Akbar Saidakramov";
        //act
        String actualFullName = format(prefix,firstName,middleName,lastName,suffix);
        //assert
        assertEquals(expectedFullName, actualFullName);
    }

    @Test
    void testFormat_emptyPrefix_emptySuffix() {
        String prefix = "";
        String firstName = "Akbar";
        String middleName = "Alijon";
        String lastName = "Saidakramov";
        String suffix = "";
        String expectedFullName = "Akbar Alijon Saidakramov";
        //act
        String actualFullName = format(prefix,firstName,middleName,lastName,suffix);
        //assert
        assertEquals(expectedFullName, actualFullName);
    }

    @Test
    void testFormat_emptySuffix() {
        String prefix = "Mr";
        String firstName = "Akbar";
        String middleName = "Alijon";
        String lastName = "Saidakramov";
        String suffix = "";
        String expectedFullName = "Mr. Akbar Alijon Saidakramov";
        //act
        String actualFullName = format(prefix,firstName,middleName,lastName,suffix);
        //assert
        assertEquals(expectedFullName, actualFullName);
    }

    @Test
    void testFormat_fullName() {
        String fullname = " Akbar Saidakramov ";
        String expectedFullName = "Akbar Saidakramov";
        //act
        String actualFullName = format(fullname);
        //assert
        assertEquals(expectedFullName,actualFullName);
    }

}