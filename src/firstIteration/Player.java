package firstIteration;

import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Player {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		int xAnterior = 0;
		int yAnterior = 0;
		int frames = 0;
		// game loop
		while (true) {
			int x = in.nextInt();
			int y = in.nextInt();
			int nextCheckpointX = in.nextInt(); // x position of the next check
												// point
			int nextCheckpointY = in.nextInt(); // y position of the next check
												// point
			int nextCheckpointDist = in.nextInt(); // distance to the next
													// checkpoint
			int nextCheckpointAngle = in.nextInt(); // angle between your pod
													// orientation and the
													// direction of the next
													// checkpoint
			int opponentX = in.nextInt();
			int opponentY = in.nextInt();
			if (frames == 0) {
				xAnterior = x;
				yAnterior = y;
			}

			System.err.println("Distance to next: " + nextCheckpointDist);

			int thrust = 100;
			int deltaX = xAnterior - x;
			int deltaY = yAnterior - y;

			// calcular velocidad absoluta
			int sumaDeltas = (deltaX * deltaX) + (deltaY * deltaY);
			double absSpeed = Math.sqrt(sumaDeltas);
			System.err.println("absSpeed: " + absSpeed);

			if (nextCheckpointAngle > 90 || nextCheckpointAngle < -90) {
				thrust = 0;
			} else if (nextCheckpointDist < 2000) {
				System.err.println("Bajo el thrust");
				thrust = 20;
			}
			// Si mi velocidad absoluta es mucha, bajar el thrust

			// Write an action using System.out.println()
			// To debug: System.err.println("Debug messages...");

			// You have to output the target position
			// followed by the power (0 <= thrust <= 100)
			// i.e.: "x y thrust"
			System.out.println(nextCheckpointX + " " + nextCheckpointY + " " + thrust);
			frames = frames++;
			xAnterior = x;
			yAnterior = y;
		}
	}
}