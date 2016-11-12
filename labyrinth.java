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
	private TouchSensor tleft;
	private TouchSensor tright;
//dist = distance
//lilev = light level
//anom = bright object anomaly
//tac 1 = A Motor left
//tac 2 = C Motor left
//Tosen = touch sensor 1 = left 2 = right
  private int dist = ultra.getDistance();
	private int lilev = light.getLightValue();
	private int anom = light.getLightValue() + 5;
	private int Tacho1 = Motor.A.getTachoCount();
	private int Tacho1 = Motor.C.getTachocount();

	private final int THRESHOLD = 10;
	/**
	 * Constructs the robot and sets up the sensors and initial values of variables
	 */
	public labyrinth() {
		// setup sensors
		light = new LightSensor(SensorPort.S1);
		ultra = new UltrasonicSensor(SensorPort.S2);
		tleft = new TouchSensor(Sensorport.S3);
		tright = new TouchSensor(Sensorport.S4);
		Motor.A.resetTachoCount();
		Motor.C.resetTachoCount();
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
	//turnDet = Turn determine
	private void turnDet(); {
		while (lilev < anom) {
		if (Tacho1 < Tacho2) {
			//anticlockwise turn
		}
			while (dist < THRESHOLD) {
				Motor.A.Backward();
				Motor.C.Forward()
				Light.getLightValue();
				Ultra.getDistance();
				Tacho1.getTachocount();
				Tacho2.getTachocount();

			}
		} else if (Tacho2 < 0) && (Tacho2 > 0)
		{
			while (dist < THRESHOLD)
			//clockwise turn
			Motor.A.Forward();
			Motor.C.Backward();
		}
	}
		//find way to break loop when light detected

	}


//code for robot movement
	private void run() {
		//Order of priority distance then light intensity
		//check distance then light.
		//action
	boolean loop = true;
		while (loop) {
			while (lilev < anom ) {
				if (dist < THRESHOLD) & (tleft.isPressed())
				{ //stop, turn right
					Motor.A.stop();
					Motor.C.stop();
					delay.msDelay(3000);
					Motor.A.resetTachoCount();
					Motor.C.resetTachoCount();
					while (dist < THRESHOLD + 2) {
						Motor.A.forward();
						Motor.C.backward();
					}
					ultra.getDistance();
					light.getLightValue();
					Motor.A.getTachocount();
					Motor.C.getTachocount();
				} else if (dist < THRESHOLD) & (tright.isPressed()) {
					//stop turn left
				Motor.A.stop();
				Motor.C.stop();
				delay.msDelay(3000);
				Motor.A.resetTachoCount();
				Motor.C.resetTachoCount();
				while (dist < THRESHOLD);
				Motor.A.backward();
				Motor.C.forward();
			}
			ultra.getDistance();
			light.getLightValue();
			Motor.A.getTachoCount();
			Motor.C.getTachoCount();
		} //conditions (go through all possible combinations)
		//find way to store taachometer reading as variable
		

			{

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
