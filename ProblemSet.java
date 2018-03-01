// @File ProblemSet.java
// @Author Abdullah Alhassan
// @Date 17 Feb 2018
// Description:
//  This is a class that will represent a given problem by representing the
//  parameters of a problem in an ArrayList

import java.util.ArrayList;

public class ProblemSet {
  private ArrayList<Integer> parameters = new ArrayList<Integer>();
  private ArrayList<ArrayList<Integer>> rides = new ArrayList<ArrayList<Integer>>();

  public ProblemSet( ArrayList<Integer> parameters, ArrayList<ArrayList<Integer>> rides) {
    this.parameters = parameters;
    this.rides = rides;
  }

  public ArrayList<ArrayList<Integer>> getRides() {
    return rides;
  }

  public  ArrayList<Integer> getParam() {
    return parameters;
  }
}
