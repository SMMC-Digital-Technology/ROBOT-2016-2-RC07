import lejos.nxt.*;

 /* @author	Mr Burt
 *@ edited by Matthew Baker, Thomas Bellato, Alexis Lanuza
 * @version	0.2
 */

public class mazerun {

	/**
	 * declare variables here
	 */
	private LightSensor light;
 	private UltrasonicSensor ultra;

	private int dist = 0;
	private final int THRESHOLD = 10
	/**
	 * Constructs the robot and sets up the sensors and initial values of variables
	 */
	public mazerun () {
		// setup sensors
		light = new LightSensor(SensorPort.S1)
		ultra = new UltrasonicSensor(SensorPort.S2)


		// setup values


		run();

	}

	/**
	 * This is where the robot searches for the person
	 */
	 //lilev = light level
	 //anom = Bright object anomaly e.g person
	 //dist = distance
	private void run() {
		//Order of priority light intensity then distance
	  int lilev = light.getLightValue();
		int anom = light.getLightValue() + 5;
	  int dist = ultra.getDistance();
		int thresh = THRESHOLD
		//check light intensity
    if (lilev < anom) {
			while (thresh < dist) {
				boolean distcheck = true;
				Motor.A.Forward();
				Motor.C.Backward();
		}
		distcheck = false;
		Motor.A.



			}



		}
		//check distance
		//action




	}

	/**
	 * The main function executes the robot.
	 * @param args Not used.
	 */
	public static void main (String[] args) {
		new mazerun();
	}
}
