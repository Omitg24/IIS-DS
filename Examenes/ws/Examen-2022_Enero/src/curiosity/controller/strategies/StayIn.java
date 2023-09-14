package curiosity.controller.strategies;

import curiosity.controller.ObstacleStrategy;
import curiosity.controller.RoverController;

public class StayIn implements ObstacleStrategy {

	@Override
	public boolean execute(RoverController roverController) {
		return false;
	}

}
