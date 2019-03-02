package org.usfirst.frc.team1212.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoRightLeft extends CommandGroup {
	public AutoRightLeft() {

		addSequential(new AutoElevatorUp(1));
		addParallel(new AutoHerdersIn(2));
		addSequential(new AutoForwardUntilEye(2));
		addSequential(new ExtendHerdersCom());
	}
}
