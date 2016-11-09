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
	private Tacho1 tac1;
	private Tacho2 tac2;
//dist = distance
//lilev = light level
//anom = bright object anomaly
//tac 1 = A Motor
//tac 2 = C Motor
  private int dist = ultra.getDistance();
	private int lilev = light.getLightValue();
	private int anom = light.getLightValue() + 5;
	private int Tacho1 = tac1.getTachoCount();
	private int Tacho1 = tac2.getTachocount();

	private final int THRESHOLD = 10;
	/**
	 * Constructs the robot and sets up the sensors and initial values of variables
	 */
	public labyrinth() {
		// setup sensors
		light = new LightSensor(SensorPort.S1)
		ultra = new UltrasonicSensor(SensorPort.S2)
		tac1 = new Tacho1(MotorPort.A)
		tac2 = new Tacho2(MotorPort.C)
		// setup values
		run();
	}

	//define light = defli
	private void defli() {
			if (lilev > anom) {
			anom = lilev;
		}
	}
	
	// turn, break loop when light is found.
	/
	private void turnSearch(); {
		tac1.resetTachoCount();
		tac2.resetTachoCount();
		if (Tacho1 > 0) && (Tacho2 < 0) {
			//anticlockwise turn
		} else if (Tacho 1 < 0) && (Tacho2 > 0)
		{
			//clockwise turn
		}
		//find way to break loop when light detected

	}



	//find space to search
	private void search(lilev, dist, anom) {
		boolean locate = true;
		while (search) {
			//prioritse light then distance

		}


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
					Motor.A.stop();
					Motor.C.stop();
					delay.msDelay(3000);
					search();
					ultra.getDistance();
					light.getLightValue();
					//function here
				} else
				{
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
				// function here
				ultra.getDistance();
				light.getLightValue();
			}  else
			{ //move toward light
				Motor.A.Forward();
				Motor.C.Forward();
				ultra.getDistance();
				light.getLightValue();
			}
		if (Button.ENTER.isDown()) {
			loop = false;
			button.waitForAnyPress();
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
