// @File ProblemSet.java
// @Author Abdullah Alhassan
// @Date 17 Feb 2018
// Description:
//  This is a class that will represent a given problem by representing the
//  parameters of a problem in an ArrayList

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Solution {
  private ArrayList<Ride> rides;
  private ArrayList<Vehicle> vehicle;
  private ArrayList<ArrayList<Integer>> city;
  private ArrayList<Ride> finishedRides;
  private ArrayList<ArrayList<Ride>> solutionRides;

  private int R; // numberofrowsofthegrid (1≤R≤10000)
  private int C; // number of columns of the grid (1 ≤ C ≤ 10000)
  private int F; // number of vehicles in the fleet (1 ≤ F ≤ 1000)
  private int N; // number of rides in the fleet (1 ≤ F ≤ 1000)
  private int B; // per-ride bonus for starting the ride on time (1 ≤ B ≤ 10000)
  private int T; // number of steps in the simulation (1 ≤ T ≤ 10^9)

  public void updateCitySteps(int steps) {
    // this.citySteps += steps;
    this.T -= steps;
  }
  public int getCitySteps() {
    return this.T;
  }

  public Solution( ArrayList<Integer> parameters, ArrayList<ArrayList<Integer>> rides) {
    initRides(rides);
    initVehicles();
    this.R = parameters.get(0);
    this.C = parameters.get(1);
    this.F = parameters.get(2);
    this.N = parameters.get(3);
    this.B = parameters.get(4);
    this.T = parameters.get(5);
  }

  public  ArrayList<ArrayList<Ride>> start() {
    while(!this.rides.isEmpty() && this.T > 0){
      ArrayList<ArrayList<Integer>> distances = new ArrayList<ArrayList<Integer>>();
      for(int i = 0; i < this.rides.size(); i++){
        for(int j = 0; j < this.vehicle.size(); j++) {
          ArrayList<Integer> dist = stepsFromVehicleToRide(this.vehicle.get(j), this.rides.get(i));
          if (dist.get(0) > 100) {
            continue;
          }
          dist.add(j); // car id
          dist.add(i); // ride id
          distances.add(dist);
        }
      }

      // sort distances
      Collections.sort(distances, new Comparator<ArrayList<Integer>>() {
        @Override
        public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
            return o1.get(0).compareTo(o2.get(0));
        }
      });
      // we have sorted distances
      HashMap<Integer,Boolean> carIdx = new HashMap<Integer,Boolean>();
      for(int i  = 0; i < this.F; i++){
        carIdx.put(i,false);
      }

      for(int i = 0; i < distances.size(); i++) {
        ArrayList<Integer> dist = distances.get(i);
        if (carIdx.get(dist.get(1))) {
          continue;
        }
        int vIdx = dist.get(1);
        int rIdx = dist.get(2);
        Ride r = this.rides.get(dist.get(2));
        solutionRides.get(vIdx).add(r);
        Vehicle v = this.vehicle.get(dist.get(1));
        v.updateLocation(r);
        updateCitySteps(dist.get(0));
        carIdx.put(i,true);

        //do updates
        v.updateLocation(r);//GO
        updateCitySteps(dist.get(0));
        v.startRide(r);
        v.endRide(r);
        this.rides.remove(rIdx);
      }
    }
    return this.solutionRides;
  }

  private void initVehicles() {
    for(int i = 0; i < F; i++){
      Vehicle newVehicle = new Vehicle();
      ArrayList<Ride> r = new ArrayList<Ride>();
      solutionRides.add(r);
      vehicle.add(newVehicle);
    }
  }

  //see "Ride" constructor for correct sequence
  private void initRides(ArrayList<ArrayList<Integer>> r) {
    // 1. get hold of rides
    for(int i = 0; i < N; i++){
      // 1.1 read as integers and add to Ride object
      Ride newRide = new Ride(r.get(i).get(0), r.get(i).get(1), r.get(i).get(2),r.get(i).get(3), r.get(i).get(4), r.get(i).get(5));
      rides.add(newRide);
    }
  }

  private ArrayList<Integer> stepsFromVehicleToRide(Vehicle v, Ride r) {
    ArrayList<Integer> vPos = v.getPosition();
    ArrayList<Integer> rPos = r.getPickupPos();
    ArrayList<Integer> dist = new ArrayList<Integer>();
    dist.add(Math.abs(vPos.get(0) - rPos.get(0)) + (Math.abs(vPos.get(1) - rPos.get(1))));

    return dist;
  }

  public ArrayList<Ride> getRides() {
    return rides;
  }

}
