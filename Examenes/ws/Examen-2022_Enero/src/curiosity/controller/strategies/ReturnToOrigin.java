package curiosity.controller.strategies;

import curiosity.controller.ObstacleStrategy;
import curiosity.controller.RoverController;

public class ReturnToOrigin implements ObstacleStrategy {

	@Override
	public boolean execute(RoverController roverController) {
		roverController.getMemory().goBack();
		return false;
	}

}
