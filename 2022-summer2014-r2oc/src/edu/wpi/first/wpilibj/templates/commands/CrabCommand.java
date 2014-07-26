/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.controllers.Xbox;
import edu.wpi.first.wpilibj.templates.util.Vector;

/**
 *
 * @author Arturo
 */
public class CrabCommand extends CommandBase {
    
    public CrabCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(driveCrab);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(oi.getDrive() == RobotMap.CRAB_DRIVE){
            
            double magnitude = oi.getXbox().GetLeftMagnitude();
            double angle = oi.getXbox().GetLeftAngle(false);
            
            driveCrab.rotate(angle, 0, 0);
            driveCrab.rotate(angle, 1, 1);
            driveCrab.rotate(angle, 2, 2);
            driveCrab.rotate(angle, 3, 3);
            
            driveCrab.setSpeed(magnitude, 0);
            driveCrab.setSpeed(magnitude, 1);
            driveCrab.setSpeed(magnitude, 2);
            driveCrab.setSpeed(magnitude, 3);
//        double x = oi.getXbox().GetLeftX();
//        double y = oi.getXbox().GetLeftY();
//        if(x== 0||y ==0)
//        {
//            Vector vec = new Vector(x,y);
//            double angle = vec.getAngle();
//            double speed = vec.getMagnitude();
//            driveCrab.rotate(angle, 1, 3); //temporary code to rotatet the wheels
//            driveCrab.setSpeed(speed, 1); //temporary code to move the wheels at that speed
//        }
        if((oi.getXbox().GetBValue())==true)
        {
            driveCrab.stop();
        }
        
            SmartDashboard.putString("Back Right Encoder", "" + RobotMap.turnEncoders[0].get());
            SmartDashboard.putString("Back Left Encoder", "" + RobotMap.turnEncoders[1].get());
            SmartDashboard.putString("Front Right Encoder", "" + RobotMap.turnEncoders[3].get());
            SmartDashboard.putString("Front Left Encoder", "" + RobotMap.turnEncoders[2].get());
            
            
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        driveCrab.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        driveCrab.stop();
        SmartDashboard.putString("Shitter3", "Crab got fucked yo.");
    }
}
