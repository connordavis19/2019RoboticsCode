/* This code is untested, but updated as of 10/12
* Autonomous is fully implemented, however it is untested
*/

package org.usfirst.frc.team1212.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1212.robot.commands.*;
import org.usfirst.frc.team1212.robot.subsystems.*;

public class Robot extends TimedRobot {

	Command autonomousCommand;
//	SendableChooser<Command> chooser = new SendableChooser<>();
	SendableChooser<Command> autoChooser = new SendableChooser<>();

	public static OI oi;
	public static DriveTrain driveTrain;
	public static ElevatorSub elevatorSub;
	public static HerderSub herderSub;

	@Override
	public void robotInit() {
		RobotMap.init();
		driveTrain = new DriveTrain();
		elevatorSub = new ElevatorSub();
		herderSub = new HerderSub();

		SmartDashboard.putData(driveTrain);

		oi = new OI();
		Robot.driveTrain.gyroInit();

//		chooser.addDefault("Herders Down", new ExtendHerdersCom());
//		chooser.addObject("MecanumDrive", new MecanumDriveCom());
//		chooser.addObject("ArcadeDrive", new ArcadeDriveCom());
//		autoChooser.addObject("AutoForwardUntilEye", new AutoForwardUntilEye());
		autoChooser.addDefault("AALineFollow", new AALineFollow());
		autoChooser.addObject("AAGroup", new AAGroup());
//		chooser.addObject("AutoStrafeLeft", new AutoStrafeLeft());
//		chooser.addObject("AutoStrafeRight", new AutoStrafeRight());
/*		autoChooser.addObject("AutoGyroTurnLeft", new AutoGyroTurnLeft());
		autoChooser.addObject("AutoGyroTurnRight", new AutoGyroTurnRight());
		autoChooser.addDefault("AutonomousLeft", new AutoLeftGroup());
		autoChooser.addObject("AutonomousRight", new AutoRightGroup());
		autoChooser.addObject("AutonomousCenter", new AutoCenterGroup());
		autoChooser.addObject("HerderUp (post-match)", new RetractHerdersCom());
		autoChooser.addObject("HerderDown (post-match)", new ExtendHerdersCom());
		autoChooser.addObject("CafeteriaCommand", new CafeteriaCommand()); */

		
		 RobotMap.cameraSelector.addObject("Front Camera", RobotMap.frontCam); //Adds the "Front Camera" option to the dashboard
	     RobotMap.cameraSelector.addObject("backCamera", RobotMap.backCam); //Does almost the same thing as the previous line, except this option is "backCamera"
		
//		SmartDashboard.putData("Auto mode", chooser);
		SmartDashboard.putData("Auto Selector", autoChooser);
		
		//*************************************************************************************
		//Maybe put the gyro init code here to cut down on initialization time in autonomous???
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		
		//Here is gyro init code. Maybe put this in robot init? ***Untested***

		

		autonomousCommand = autoChooser.getSelected();
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {

		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
}
