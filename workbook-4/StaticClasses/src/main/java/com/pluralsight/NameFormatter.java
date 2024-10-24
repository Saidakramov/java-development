package com.pluralsight;

public class NameFormatter {

    private NameFormatter(){

    }

    public static String format(String firstName, String lastName){
        return firstName + " " + lastName;
    }

    public static String format(String prefix,
                                String firstName,
                                String middleName,
                                String lastName,
                                String suffix) {
        StringBuilder formattedName = new StringBuilder();

        // Add prefix if it exists
        if (!prefix.isEmpty()) {
            formattedName.append(prefix).append(". ");
        }

        // Add first name (always exists)
        formattedName.append(firstName);

        // Add middle name if it exists
        if (!middleName.isEmpty()) {
            formattedName.append(" ").append(middleName);
        }

        // Add last name (always exists)
        formattedName.append(" ").append(lastName);

        // Add suffix if it exists
        if (!suffix.isEmpty()) {
            formattedName.append(", ").append(suffix);
        }

        return formattedName.toString().trim(); // Trim in case of extra spaces
    }

    public static String format(String fullName){
        return fullName.trim();
    }
}
