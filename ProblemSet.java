// @File ProblemSet.java
// @Author Abdullah Alhassan
// @Date 17 Feb 2018
// Description:
//  This is a class that will represent a given problem by representing the
//  parameters of a problem in an ArrayList

import java.util.ArrayList;

public class ProblemSet {
  private ArrayList<Integer> parameters = new ArrayList<Integer>();
  private ArrayList<ArrayList<Character>> pizza = new ArrayList<ArrayList<Character>>();

  public ProblemSet( ArrayList<Integer> parameters, ArrayList<ArrayList<Character>> pizza) {
    this.parameters = parameters;
    this.pizza = pizza;
  }

  public ArrayList<ArrayList<Character>> getPizza() {
    return pizza;
  }

  public  ArrayList<Integer> getParam() {
    return parameters;
  }
}
