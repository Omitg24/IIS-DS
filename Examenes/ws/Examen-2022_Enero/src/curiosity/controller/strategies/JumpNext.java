package curiosity.controller.strategies;

import curiosity.controller.ObstacleStrategy;
import curiosity.controller.RoverController;

public class JumpNext implements ObstacleStrategy {

	@Override
	public boolean execute(RoverController roverController) {
		roverController.incrementIp();
		return true;
	}

}
