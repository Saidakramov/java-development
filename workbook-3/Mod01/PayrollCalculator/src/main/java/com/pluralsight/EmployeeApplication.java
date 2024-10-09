package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EmployeeApplication {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
    fileToProcess();
    scanner.close();

    }

    public  static void reader() throws IOException {
        try {

            String fileToCreate = input("\nEnter the name of the payroll file to create: Ex: title.csv");
            // create a BufferedWriter
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter(fileToCreate));
            // write to the file

            bufWriter.write("id|name|gross pay\n");

            // read csv file again, to get the employees
            BufferedReader br = new BufferedReader(new FileReader("employees.csv"));

            List<Employee> employees = new ArrayList<>();

            // turn csv file into employees arr
            String line;
            //skip first line with column names
            br.readLine();
            int index = 0;
            while ((line = br.readLine()) != null) {
                String[] employeeData = line.split("\\|");
                employees.add(new Employee(Integer.parseInt(employeeData[0]), employeeData[1], Double.parseDouble(employeeData[2]), Double.parseDouble(employeeData[3])));
                index++;


            }
            for (Employee e: employees){
                bufWriter.write(e.toCsvLine());
            }
            br.close();
            bufWriter.close();

            // display info for each employee
            //System.out.printf("ID: %d, Name: %s, Gross Pay: $%.2f\n",



        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String input(String message){
        System.out.println(message);
        return scanner.nextLine();
    }

    public static void fileToProcess() throws IOException {
        String fileToProcess = input("Enter the name of the file employee file to process: ");
        while (true) {

            if (fileToProcess.equalsIgnoreCase("employees.csv")) {
                reader();
                break;
            } else {
                System.out.println("Please enter the correct file name to process. Ex:employees.csv ");
                fileToProcess = scanner.nextLine();
            }
        }
    }

}
