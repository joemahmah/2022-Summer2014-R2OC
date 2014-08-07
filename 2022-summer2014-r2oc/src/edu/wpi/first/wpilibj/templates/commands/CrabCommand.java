/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.controllers.Xbox;

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
        if(oi.getDrive() == RobotMap.CRAB_DRIVE){
         lx = xbawks.GetLeftX();
         ly = xbawks.GetLeftY();
         rx = xbawks.GetRightX();
         ry = xbawks.GetRightY();
         
         lmag = xbawks.GetLeftMagnitude();
         rmag = xbawks.GetRightMagnitude();
            if(lx< 0&&ly <0)
            {
              driveCrab.setSpeed(-lmag);
//            Vector vec = new Vector(x,y);
//            double angle = vec.getAngle();
//            driveCrab.rotate(angle,0, 0, angle);
//            driveCrab.rotate(angle,1, 1, angle);
//            driveCrab.rotate(angle,2, 2, angle);
//            driveCrab.rotate(angle,3, 3, angle);
//            driveCrab.setSpeed(magnitude); //temporary code to move the wheels at that speed
            }
            else 
            {
                driveCrab.setSpeed(lmag);
            }
            if(rx < 0 && ry <0)
            {
                driveCrab.turn(-rmag);
            }
            else
            {
                driveCrab.turn(rmag);
            }
            if(xbawks.GetBValue()==true)
            {
                driveCrab.stop();
            }
             if(xbawks.GetAValue()==true)
            {
                driveCrab.turn(1);
            }
            
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