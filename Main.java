// @File Main.java
// @Author Abdullah Alhassan
// @Date 17 Feb 2018
// Description:
//  This is the where everything start, steps:
//    1. Read a problem from a file
//    2. Representing the problem with a class
//    3. Solve the ProblemSet
//    4. Write the solution in file


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    String filename = args[0];
    ProblemSet ps = readFile(filename);

    System.out.println(ps.getParam()) ;
    ArrayList<ArrayList<Character>> pizza = ps.getPizza();
    for (ArrayList<Character> row : pizza){
        System.out.println(row);
    }
    // System.out.println("There should be at least " + () + " slices");

    // Start finding slices
  }

  // Read the problem from a file then represent it with a class
  public static ProblemSet readFile(String filename) {
    // Initiate inputs
    File inFile = new File(filename);
    ArrayList<Integer> parameters = new ArrayList<Integer>();
    ArrayList<ArrayList<Character>> pizza = new ArrayList<ArrayList<Character>>();

    int numT = 0;
    int numM = 0;

    try {
      Scanner sc = new Scanner(inFile);
      int i = 0;
      // Read the Integer part (R, C, L, H)
      while(sc.hasNextInt()) {
        parameters.add(sc.nextInt());
      }
      sc.nextLine();

      // Read the char part (pizza)
      while(sc.hasNextLine()) {
        String line = sc.nextLine();
        ArrayList<Character> row = new ArrayList<Character>();
        for(i = 0; i < line.length(); i++) {
          if (line.charAt(i) == 'T') {
            numT += 1;
          } else if (line.charAt(i) == 'M') {
            numM += 1;
          }
          row.add(line.charAt(i));
        }
        pizza.add(row);
      }

      sc.close();
    } catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
    parameters.add(numT);
    parameters.add(numM);
    return new ProblemSet(parameters, pizza);
  }
}
