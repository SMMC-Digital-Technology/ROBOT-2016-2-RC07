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
	private int lastTurn = 0;
	private int turnav = //turn average 0;
	//0 = neutral 1 = left 2 = right

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
////////////////////////////////////////////////////////////////////////////////
//robot functions

	//define light = defli
	private void defli() {
			if (lilev > anom) {
			anom = lilev;
		}
	}

	// turn, break loop when light is found.
	//turnDet = Turn determine
	private void turnDet() {
		boolean deter = true;
		while (deter) {
		while (lilev < anom) {
		if (lastTurn = 2) {
			//anticlockwise turn
			while (dist < THRESHOLD) {
				Motor.A.resetTachoCount();
				Motor.C.resetTachoCount();
				Motor.A.rotateTo(-900);
				Motor.C.rotateTo(900)
				light.getLightValue();
				ultra.getDistance();
				Tacho1 = Motor.A.getTachoCount();
				Tacho2 = Motor.C.getTachoCount();
				defli();
			}
		} else if (lastTurn = 1){
			while (dist < THRESHOLD) {
			//clockwise turn
			Motor.A.resetTachoCount()
			Motor.C.resetTachoCount();
			Motor.A.rotateTo(900);
			Motor.C.rotateTo(-900);
			light.getLightValue();
			ultra.getDistance();
			Tacho1 = Motor.A.getTachoCount();
			Tacho2 = Motor.C.getTachoCount();
		}
	}
	deter = false;
}
}
///////////////////////////////////////////////////////////////////////////////
//robot movement code past this point

//code for robot movement
	private void run() {
		//Order of priority distance then light intensity
		//check distance then light.
		//action
	boolean loop = true;
		while (loop) {
			while (lilev < anom ) {
				if (dist < THRESHOLD) & (tleft.isPressed() = true) & (tright.isPressed() = false)
				{ //stop, turn right
					Motor.A.stop();
					Motor.C.stop();
					delay.msDelay(3000);
					Motor.A.resetTachoCount();
					Motor.C.resetTachoCount();
					while (dist < THRESHOLD + 2) {
						Motor.A.forward();
						Motor.C.backward();
						lastTurn = 2;
						}
					ultra.getDistance();
					light.getLightValue();
					Tacho1 = Motor.A.getTachocount();
					Tacho2 = Motor.C.getTachocount();
					defli();
				} else if (dist < THRESHOLD) & (tright.isPressed() = true ) & (tleft.isPressed() = false) {
					//stop turn left
					Motor.A.stop();
						Motor.C.stop();
						delay.msDelay(3000);
						Motor.A.resetTachoCount();
						Motor.C.resetTachoCount();
						while (dist < THRESHOLD + 2) {
							Motor.A.backward();
								Motor.C.forward();
								lastTurn = 1;
							}
							ultra.getDistance();
							light.getLightValue();
							Tacho1 = Motor.A.getTachoCount();
							Tacho2 = Motor.C.getTachoCount();
							defli();
						} else if (distance < THRESHOLD) {
							//stop and find passage
							Motor.A.stop();
							Motor.C.stop()
							delay.msDelay(3000)
							Motor.A.resetTachoCount();
							Motor.C.resetTachoCount();
							while (distance < THRESHOLD + 2) {
								Motor.A.forward();
								Motor.C.backward();
								lastTurn = 2;
							}
							ultra.getDistance();
							light.getLightValue();
							Tacho1 = Motor.A.getTachoCount();
							Tacho2 = Motor.C.getTachoCount();
							defli();
						} else if (distance < THRESHOLD) & (tleft.isPressed()) & (tright.isPressed()) {
							//stop and reverse the same distance travelled
							Motor.A.stop();
							Motor.C.stop();
							delay.msDelay(3000);
							Motor.A.resetTachoCount();
							Motor.C.resetTachoCount();
							delay.msDelay(1000)
							Motor.A.rotateTo(Tacho1);
							Motor.C.rotateTo(Tacho2);
							Motor.A.stop();
							Motor.C.stop();
							turndet();
							Tacho1 = Motor.A.getTachoCount();
							Tacho2 = Motor.C.getTachoCount();
							defli();
						} else {
							//go forward until object
							Motor.A.resetTachoCount();
							Motor.C.resetTachoCount()
							Motor.A.forward();
							Motor.C.forward();
							Tacho1 = Motor.A.getTachoCount();
							Tacho2 = Motor.C>getTachoCount();
							defli();
						}
						//conditions (go through all possible combinations)
						//find way to store taachometer reading as variable
						}
			//once lilev is greater than anom
			if (dist < THRESHOLD) {
				Motor.A.stop();
				Motor.C.stop();
				delay.msDelay(2000);
			  Sound.beepSequenceUp();
				ultra.getDistance();
				light.getLightValue();
			}  else
			{ //move toward light
				Motor.A.Forward();
				Motor.C.Forward();
				ultra.getDistance();
				light.getLightValue();
				defli();
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
