/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.controllers.Xbox;
import edu.wpi.first.wpilibj.templates.util.Vector;

public class CrabCommand extends CommandBase {
    Xbox xbawks = oi.getXbox();
    double lx,ly, rx,ry, lmag, rmag;
    public CrabCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(driveCrab);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //if(oi.getDrive() == RobotMap.CRAB_DRIVE){
//         double angle = xbawks.GetLeftX() * 180;
//         double mag = xbawks.GetRightY();
         
//         if(angle < 0){
//             angle = 360+angle;
//         }
         
        double ry = dead(xbawks.GetRightY(),1,.1);
        double rx = dead(xbawks.GetRightX(),1,.1);
        double speed = dead(xbawks.GetLeftY(),1,.1);
        
        double angleValue = MathUtils.atan2(ry, rx);
        if(angleValue < 0){
            angleValue = angleValue + (Math.PI*2);
        }
        
        angleValue = angleValue * (180/Math.PI);
        
        double angle = angleValue;
        
        SmartDashboard.putString("Target Angle", angle + "");
        
        double multiply = SmartDashboard.getNumber("Multiplyer", 1);
        
         //driveCrab.rotate(angle, 0, 0, .35 * multiply);
         //driveCrab.rotate(angle, 1, 1, .25 * multiply);
         driveCrab.rotate(angle, 2, 2, .25 * multiply);
         //driveCrab.rotate(angle, 3, 3, .25 * multiply);
         
         driveCrab.setSpeed(speed);
         
         
        //}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    public double dead(double value, double maxAbs, double minAbs){
        double calc;
        
        if(Math.abs(value) > maxAbs && value > 0){
            return maxAbs;
        } else if(Math.abs(value) > maxAbs && value < 0){
            return -maxAbs;
        } else if(Math.abs(value) < minAbs && value < 0){
            return -0;
        } else if(Math.abs(value) < minAbs && value > 0){
            return 0;
        } else{
            return value;
        }
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