import lejos.nxt.*;

 /* @author	Mr Burt
 *@ edited by Matthew Baker, Thomas Bellato, Alexis Lanuza
 * @version	0.2
 */

public class labyrinth {

	/**
	 * declare variables here
	 */
	private LightSensor light;
 	private UltrasonicSensor ultra;
//dist = distance
//lilev = light level
//anom = bright object anomaly
  private int dist = ultra.getDistance();
	private int lilev = light.getLightValue();
	private int anom = light.getLightValue();

	private final int THRESHOLD = 10;
	/**
	 * Constructs the robot and sets up the sensors and initial values of variables
	 */
	public labyrinth() {
		// setup sensors
		light = new LightSensor(SensorPort.S1)
		ultra = new UltrasonicSensor(SensorPort.S2)


		// setup values


		run();

	}

	//define light = defli
	private void defli() {
			if (lilev > anom) {
			anom = lilev;
		}
	}


	//light seeking function
	private void lightseek() {


	}


//code for robot movement
	private void run() {
		//Order of priority distance then light intensity
		//check distance then light.
		//action
	boolean loop = true;
		while (loop) {
			while (lilev < anom ) {
				if (dist < THRESHOLD)
				{ //stop, find area to search
					//code here
				} else {
					//forward
					Motor.A.forward();
					Motor.C.forward();
					ultra.getDistance();
					light.getLightValue();
				}
			}
			//once lilev is greater than anom
			if (dist < THRESHOLD) {
				Motor.A.stop();
				Motor.C.stop();
				delay.msDelay(2000);
				lightseek();
				ultra.getDistance();
				light.getLightValue();
			}  else
			{ //move toward light
				Motor.A.Forward();
				Motor.C.Forward();
				ultra.getDistance();
				light.getLightValue();
			}
		}
		if (Button.ENTER.isDown()) {
			loop = false;

		}

	}

	/**
	 * The main function executes the robot.
	 * @param args Not used.
	 */
	public static void main (String[] args) {
		new labyrinth();
	}
}
