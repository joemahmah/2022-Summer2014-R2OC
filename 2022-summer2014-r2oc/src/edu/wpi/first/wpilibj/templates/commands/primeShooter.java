/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Vimig
 */
public class primeShooter extends CommandBase {
    
    Timer timer;
    
    public primeShooter() {
        // Use requires() here to declare subsystem dependencies
        
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timer = new Timer();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(pickUp.isPickupDown() == false)
        {
            pickUp.moveSolenoid();
            timer.delay(2);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
