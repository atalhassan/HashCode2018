// @File ProblemSet.java
// @Author Abdullah Alhassan
// @Date 17 Feb 2018
// Description:
//  This is a class that will represent a given problem by representing the
//  parameters of a problem in an ArrayList

import java.util.ArrayList;

public class Solution {
  private ArrayList<ArrayList<Integer>> rides;
  private ArrayList<ArrayList<Integer>> city;

  private int R; // numberofrowsofthegrid (1≤R≤10000)
  private int C; // number of columns of the grid (1 ≤ C ≤ 10000)
  private int F; // number of vehicles in the fleet (1 ≤ F ≤ 1000)
  private int N; // number of vehicles in the fleet (1 ≤ F ≤ 1000)
  private int B; // per-ride bonus for starting the ride on time (1 ≤ B ≤ 10000)
  private int T; // number of steps in the simulation (1 ≤ T ≤ 10^9)

  public Solution( ArrayList<Integer> parameters, ArrayList<ArrayList<Integer>> rides) {
    this.rides = rides;
    this.R = parameters.get(0);
    this.C = parameters.get(1);
    this.F = parameters.get(2);
    this.N = parameters.get(3);
    this.B = parameters.get(4);
    this.T = parameters.get(5);
  }

  public ArrayList<ArrayList<Integer>> getRides() {
    return rides;
  }

}
