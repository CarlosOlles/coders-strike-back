package firstIteration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse the standard input according to the problem statement.
 **/
class Player {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		int xAnterior = 0;
		int yAnterior = 0;
		int frames = 0;
		Map<Integer, List<Integer>> checkPoints = new HashMap<Integer, List<Integer>>();
		List<Integer> checkPointCoords = new ArrayList<>();
		String boost = "";
		// game loop
		while (true) {
			int x = in.nextInt(); // x position of the pod
			int y = in.nextInt(); // x position of the pod
			int nextCheckpointX = in.nextInt(); // x position of the next checkpoint
			int nextCheckpointY = in.nextInt(); // y position of the next checkpoint
			int nextCheckpointDist = in.nextInt(); // distande to the next checkpoint
			int nextCheckpointAngle = in.nextInt(); // angle between your pod orientation and the direction of the next checkpoint
			int opponentX = in.nextInt();
			int opponentY = in.nextInt();
			if (frames == 0) {
				System.err.println("First time");

				checkPointCoords.add(0, nextCheckpointX);
				checkPointCoords.add(1, nextCheckpointY);
				checkPoints.put(checkPoints.size(), new ArrayList<>(checkPointCoords));
			}

			System.err.println("Distance to next: " + nextCheckpointDist);

			int thrust = 100;
			int deltaX = xAnterior - x;
			int deltaY = yAnterior - y;

			System.err.println("xAnterior: " + xAnterior);
			System.err.println("yAnterior: " + yAnterior);
			System.err.println("x: " + x);
			System.err.println("y: " + y);

			checkPointCoords.clear();
			// Start añadir checkpoints al mapa
			checkPointCoords.add(0, nextCheckpointX);
			checkPointCoords.add(1, nextCheckpointY);
			System.err.println("x del siguiente punto: " + checkPointCoords.get(0));
			System.err.println("y del siguiente punto: " + checkPointCoords.get(1));
			// System.err.println("checkPoints.size(): " + checkPoints.size());

			if (!checkPoints.containsValue(checkPointCoords)) {
				checkPoints.put(checkPoints.size(), checkPointCoords);
			}
			// checkPoints.forEach((k, v) -> System.err.println("Id: " + k + " Coords: " + v));
			// End añadir checkpoints al mapa

			int sumaDeltas = (deltaX * deltaX) + (deltaY * deltaY);
			Double absSpeed = Math.sqrt(sumaDeltas);
			Integer absSpeedInt = absSpeed.intValue();
			System.err.println("absSpeedInt: " + absSpeedInt);
			if (nextCheckpointDist > 4000 && nextCheckpointAngle < 20 && nextCheckpointAngle > -20 && boost != "DONE") {
				// Si estoy lejos del siguiente checkpoint, y estoy más o menos apuntando a él
				boost = "BOOST";
				System.err.println("BOOOOOOOOOOOOOOOOOST");
			} else if (nextCheckpointAngle > 80 || nextCheckpointAngle < -80) {
				// Si estoy dándole la espalda al siguiente punto, no acelerar
				thrust = 0;
			} else if (nextCheckpointDist < 1500 && absSpeedInt > 400) {
				// Si estoy muy cerca del siguiente punto, y voy rápido
				System.err.println("Bajo el thrust");
				thrust = 20;
			}

			// Write an action using System.out.println()
			// To debug: System.err.println("Debug messages...");

			// You have to output the target position
			// followed by the power (0 <= thrust <= 100)
			// i.e.: "x y thrust"
			System.err.println("thrust:" + thrust);
			if (boost == "BOOST") {
				System.out.println(nextCheckpointX + " " + nextCheckpointY + " " + boost);
				boost = "DONE";
			} else {
				System.out.println(nextCheckpointX + " " + nextCheckpointY + " " + thrust);
			}
			frames = frames + 1;
			xAnterior = x;
			yAnterior = y;
		}
	}
}