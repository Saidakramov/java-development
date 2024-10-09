package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class EmployeeApplication {
    public static void main(String[] args) throws IOException {
        reader();

    }


    public  static void reader() throws IOException {
        BufferedReader bufReader = new BufferedReader(new FileReader("employees.csv"));
        try
        {
            String input;
            //Employee[] employees = new Employee[8];
            // read until there is no more data
            bufReader.readLine();
            while((input = bufReader.readLine()) != null) {
               //System.out.println(input);

                //Split the input using |
                String[] divided = input.split("\\|");

                //assign the divided array into variables
//                int employeeId = Integer.parseInt(divided[0]);
//                String name = divided[1];
//                double hoursWorked = Double.parseDouble(divided[2]);
//                double payRate = Double.parseDouble(divided[3]);

                //create a new Employee emp
                Employee employee = new Employee(Integer.parseInt(divided[0]), divided[1], Double.parseDouble(divided[2]), Double.parseDouble(divided[3]));
                System.out.printf("ID: %d, Name: %s, Gross Pay: $%.2f\n",
                        employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
            }
            // close the stream and release the resources
            bufReader.close();
        }
        catch(IOException e) {
            // display stack trace if there was an error
            e.printStackTrace();
        }
        bufReader.close();
    }
}
