
import java.util.*;

public class Ride {
  public int currentRide;
  public int vehicleId;
  public int distance; // calculated in getDistance()
  public int rideState; // 0: not-started  --  1: undergoing -- 2:finished
  public int xi, yi, xf, yf;
  public int earliestStart, latestFinish;

  ArrayList<Integer> tmp = new ArrayList<Integer>();

  //Setters
  public void setCurrentRide(int x) {
    this.currentRide = x;
  }
  public void setVehicleId(int x) {
    this.vehicleId = x;
  }
  public void setRideState(int x) {
    this.rideState = x;
  }

  //Getters
  public int getCurrentRide() {
    return this.currentRide;
  }
  public int getVehicleId() {
    return this.vehicleId;
  }
  public int getRideState() {
    return this.rideState;
  }
  public int getXi() {
    return this.xi;
  }
  public int getYi() {
    return this.yi;
  }
  public int getXf() {
    return this.xf;
  }
  public int getYf() {
    return this.yf;
  }

  //Constructors
  public Ride() {
    // Atts. to be added (in case we need this)
  }

  public Ride(int xinit, int yinit, int xfinal, int yfinal, int es, int lf) {
    xi=xinit;
    yi=yinit;
    xf=xfinal;
    yf=yfinal;
    earliestStart=es;
    latestFinish=lf;
  }

  public ArrayList<Integer> getPickupPos(){
    ArrayList<Integer> pos = new ArrayList<Integer>();
    pos.add(xi);
    pos.add(yi);
    return pos;
  }
  public ArrayList<Integer> getDropoffPos(){
    ArrayList<Integer> pos = new ArrayList<Integer>();
    pos.add(xf);
    pos.add(yf);
    return pos;
  }
  public int getDistance(){
    int D = Math.abs((xf-xi) + (yf-yi));
    return D;
  }
  public int getMaxTime(){
    int D = (latestFinish - earliestStart);
    return D;
  }

}
