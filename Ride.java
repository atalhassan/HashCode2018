
import java.util.ArrayList;

public class Ride {
  private int currentRide;
  private int vehicleId;

  private int xi, yi, xf, yf;

  private int earliestStart, latestFinish;

  public Ride(int xinit, int yinit, int xfinal, int yfinal) {
    xi=xinit;
    yi=yinit;
    xf=xfinal;
    yf=yfinal;
  }

}
