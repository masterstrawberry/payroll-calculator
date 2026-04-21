package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        try {
            Scanner scanner =  new Scanner(System.in);
            System.out.println("enter file to process: ");
            String file = scanner.nextLine();
            System.out.println("enter the file to create: ");
            String file1 = scanner.nextLine();

            FileReader fileReader = new FileReader("../DataFiles/"+file);
            FileWriter writer = new FileWriter(file1);

            // create a FileReader object connected to the File
            // create a BufferedReader to manage input stream
            BufferedReader bufReader = new BufferedReader(fileReader);
            BufferedWriter bufWriter = new BufferedWriter(writer);
            String input;
            // read until there is no more data
            bufReader.readLine();
            while((input = bufReader.readLine()) != null) {
                String []arr = input.split("\\|");
                Employee employee = new Employee(Integer.parseInt(arr[0]), arr[1], Double.parseDouble(arr[2]), Double.parseDouble(arr[3]));

                bufWriter.write("\n");
                bufWriter.write("employeeId: " + employee.getEmployeeId());
                bufWriter.write("name: " + employee.getName());
                bufWriter.write("gross pay: " + employee.getGrossPay());

            }
            // close the stream and release the resources
            bufReader.close();
        } catch(IOException e) {
            // display stack trace if there was an error
            e.printStackTrace();
        }
    }
}