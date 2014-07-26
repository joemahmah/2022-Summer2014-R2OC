/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.util.MathUtils;

/**
 *
 * @author Michael Hrcek
 */
public class TankCommand extends CommandBase {
    
    public TankCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(tank);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        
        if(oi.getDrive() == RobotMap.TANK_DRIVE){
            
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
        
            SmartDashboard.putString("LeftX", "NULL");
            SmartDashboard.putString("LeftY", "" + leftY);
            SmartDashboard.putString("RightX", "NULL");
            SmartDashboard.putString("RightY", "" + rightY);
            
            tank.move(leftY * speedModifier, rightY * speedModifier);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        tank.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        tank.stop();
        SmartDashboard.putString("Shitter1", "Tank got fucked yo.");
    }
}
