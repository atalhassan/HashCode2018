
import java.util.ArrayList;

public class Vehicle {
  private int currentRide = 0; // 0: available , 1: unavailable
  private int xPos = 0;//current positions
  private int yPos = 0;
  private int vSteps = 0;


  ArrayList<Ride> rides = new ArrayList<Ride>();

  public void incrementVSteps() {
    this.vSteps++;
  }
  public int getVSteps() {
    return this.vSteps;
  }
  public int getX() {
    return this.xPos;
  }
  public int getY() {
    return this.yPos;
  }

  public Vehicle() {

  }

  public ArrayList<Integer> getPosition() {
    ArrayList<Integer> pos = new ArrayList<Integer>();
    pos.add(xPos);
    pos.add(yPos);
    return pos;
  }

  public void updateLocation(Ride r){
    if (currentRide == 1){
      this.xPos = r.xi;
      this.yPos = r.yi;
    }
    else if (currentRide == 0){
      this.xPos = r.xf;
      this.yPos = r.yf;
    }

  }

  public void startRide(Ride r){
    if((r.rideState==0) && (this.getX()==r.getXi()) && (this.getY()==r.getYi())) {
      this.currentRide = 1;
      updateLocation(r);
      r.rideState=1;
      rides.add(r);
    }
  }
  public void endRide(Ride r){
    this.currentRide = 0;
    updateLocation(r);
    r.rideState=2;
  }
}
