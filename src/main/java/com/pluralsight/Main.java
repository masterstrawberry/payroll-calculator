package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        try {
            FileReader fileReader = new FileReader("../DataFiles/employees.csv");
            // create a FileReader object connected to the File
            // create a BufferedReader to manage input stream
            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;
            // read until there is no more data
            bufReader.readLine();
            while((input = bufReader.readLine()) != null) {
                String []arr = input.split("\\|");
                Employee employee = new Employee(Integer.parseInt(arr[0]), arr[1], Double.parseDouble(arr[2]), Double.parseDouble(arr[3]));

                System.out.println("\n");
                System.out.println("employeeId: " + employee.getEmployeeId());
                System.out.println("name: " + employee.getName());
                System.out.println("gross pay: " + employee.getGrossPay());

            }
            // close the stream and release the resources
            bufReader.close();
        } catch(IOException e) {
            // display stack trace if there was an error
            e.printStackTrace();
        }
    }
}