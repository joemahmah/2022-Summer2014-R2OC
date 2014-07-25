/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.controllers.Xbox;
import edu.wpi.first.wpilibj.templates.util.MathUtils;

/**
 *
 * @author Michael Hrcek
 */
public class SwerveRobocentricCommand extends CommandBase {
    
    public SwerveRobocentricCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveSwerveRobocentric);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(oi.getDrive() == RobotMap.SWERVE_DRIVE_ROBO){
        double leftX = MathUtils.limit(oi.getXbox().GetLeftX(), .1, 1, 0, 1);
        double rightX = MathUtils.limit(oi.getXbox().GetRightX(), .1, 1, 0, 1);
        double leftY = MathUtils.limit(oi.getXbox().GetLeftY(), .1, 1, 0, 1);
        double rightY = MathUtils.limit(oi.getXbox().GetRightY(), .1, 1, 0, 1);
        
        double speedModifier = .75;
        
        if(oi.getXbox().GetLeftBumperValue()){ //turtle
            if(oi.getXbox().GetStartButton().get()){ //super turtle
                speedModifier = .25;
                SmartDashboard.putString("Speed", "Super Turtle");
            } else{
                speedModifier = .5;
                SmartDashboard.putString("Speed", "Turtle");
            }
        } else if(oi.getXbox().GetRightBumperValue()){ //turbo
            speedModifier = 1;
            SmartDashboard.putString("Speed", "Turbo");
        } else{
            SmartDashboard.putString("Speed", "Normal");
        }
        
        SmartDashboard.putString("LeftX", "" + leftX);
        SmartDashboard.putString("LeftY", "" + leftY);
        SmartDashboard.putString("RightX", "" + rightX);
        SmartDashboard.putString("RightY", "" + rightY);
        
        driveSwerveRobocentric.move(leftX * speedModifier, leftY * speedModifier, rightX * speedModifier);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        driveSwerveRobocentric.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        driveSwerveRobocentric.stop();
    }
}
