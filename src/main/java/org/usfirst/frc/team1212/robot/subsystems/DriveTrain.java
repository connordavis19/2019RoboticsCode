// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc.team1212.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team1212.robot.Robot;
import org.usfirst.frc.team1212.robot.RobotMap;
import org.usfirst.frc.team1212.robot.commands.MecanumDriveCom;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;


public class DriveTrain extends Subsystem {
	
	
    

	//sets the default command at beginning of teleop to be mecanum drive
    @Override
    public void initDefaultCommand() {

        setDefaultCommand(new MecanumDriveCom());

      
    }

    @Override
    public void periodic() {

    }
    
    //public methods for controlling the drive train
    
    public void gyroInit() {
    	RobotMap.driveGyro.reset();
    	RobotMap.driveGyro.calibrate();
    }
    
    public double getGyro() {
    	return RobotMap.driveGyro.getAngle();
    }
    
    
    public void MecanumDrive(Joystick driveStick) {
    	RobotMap.mecanumDrive.driveCartesian(Robot.oi.getYValue(), Robot.oi.getXValue(), Robot.oi.getTwistValue());
    	RobotMap.shiftSol.set(DoubleSolenoid.Value.kForward);
    	
    
    }
    
    public void ArcadeDrive(Joystick driveStick) {
    	RobotMap.arcadeDrive.arcadeDrive(Robot.oi.getXValue(), Robot.oi.getTwistValue());
    	RobotMap.shiftSol.set(DoubleSolenoid.Value.kReverse);
    	
    }
    
    //This method is used for controlling the robot drive train during autonomous.
    //X, y, and twist parameters are entered when used as an auto command
    //instead of joystick input.
    
    public void AutoMecDrive(double yValue, double xValue, double twistValue) {
    	
    	RobotMap.mecanumDrive.driveCartesian(yValue, xValue, twistValue);
    	RobotMap.shiftSol.set(DoubleSolenoid.Value.kForward);
    	
    }
    
  

   

}


