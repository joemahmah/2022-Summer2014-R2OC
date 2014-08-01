/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.util.Vector;

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
        double x = oi.getXbox().GetLeftX();
        double y = oi.getXbox().GetLeftY();
        double magnitude = oi.getXbox().getMagnitude();
            if(x== 0||y ==0)
            {
            Vector vec = new Vector(x,y);
            double angle = vec.getAngle();
            driveCrab.rotate(angle,0, 0, angle);
            driveCrab.rotate(angle,1, 1, angle);
            driveCrab.rotate(angle,2, 2, angle);
            driveCrab.rotate(angle,3, 3, angle);
            driveCrab.setSpeed(magnitude); //temporary code to move the wheels at that speed
            }
            else if(oi.getXbox().GetBValue()==true)
            {
                driveCrab.stop();
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