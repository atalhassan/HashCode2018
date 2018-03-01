// @File Main.java
// @Author Abdullah Alhassan
// @Date 17 Feb 2018
// Description:
//  This is the where everything start, steps:
//    1. Read a problem from a file
//    2. Representing the problem with a class
//    3. Solve the ProblemSet
//    4. Write the solution in file

// io libraries
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;

// util libraries
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    String filename = args[0];
    ProblemSet ps = readFile(filename);
    Solution s = new Solution(ps.getParam(), ps.getRides());

    System.out.println(ps.getParam()) ;
    ArrayList<ArrayList<Integer>> rides = ps.getRides();
    for (ArrayList<Integer> row : rides){
        System.out.println(row);
    }
    // System.out.println("There should be at least " + () + " slices");

    // Start finding slices
    // writeFile("example.out");
  }

  public static void writeFile(String filename, ArrayLists<ArrayLists<Ride>> rides) {

    try {
           //Whatever the file path is.
           File outFile = new File(filename);
           FileWriter fl = new FileWriter(outFile);
           BufferedWriter bf = new BufferedWriter(fl);
           PrintWriter output = new PrintWriter(bf);
           for(int row = 0; row < rides.size(); row++){
             output.println(row + ' ' + rides.get(row));
           }
           output.close();
       } catch (IOException e) {
           System.err.println("Problem writing to the file statsTest.txt");
       }
  }

  // Read the problem from a file then represent it with a class
  public static ProblemSet readFile(String filename) {
    // Initiate inputs
    File inFile = new File(filename);
    ArrayList<Integer> parameters = new ArrayList<Integer>();
    ArrayList<ArrayList<Integer>> rides = new ArrayList<ArrayList<Integer>>();

    int numT = 0;
    int numM = 0;

    try {
      Scanner sc = new Scanner(inFile);
      // Read the Integer part (R, C, L, H)
      for(int i = 0; i < 6; i++) {
        parameters.add(sc.nextInt());
      }
      sc.nextLine();
      // Read the int part (pizza)
      while(sc.hasNextLine()) {


        ArrayList<Integer> rowList = new ArrayList<Integer>();
        for(int i = 0; i < 6; i++) {
          rowList.add(sc.nextInt());
        }
        // sc.nextLine();
        sc.nextLine();
        rides.add(rowList);
      }

      sc.close();
    } catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
    return new ProblemSet(parameters, rides);
  }
}
