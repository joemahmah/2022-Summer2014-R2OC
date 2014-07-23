/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.controllers.Xbox;
import edu.wpi.first.wpilibj.templates.util.Vector;

/**
 *
 * @author Arturo
 */
public class CrabCommand extends CommandBase {
    Xbox controls = oi.getXbox();
    public CrabCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(crabs);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        crabs.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double x = controls.GetLeftX();
        double y = controls.GetLeftY();
        if(x== 0||y ==0)
        {
        Vector vec = new Vector(x,y);
        double angle = vec.getAngle();
        double speed = vec.getMagnitude();
        crabs.rotate(angle, 1, 3); //temporary code to rotatet the wheels
        crabs.setSpeed(speed, 1); //temporary code to move the wheels at that speed
        }
        else if(controls.GetBValue()==true)
        {
            crabs.stop();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        crabs.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
