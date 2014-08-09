/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Michael
 */
public class CompCmd extends CommandBase {
    
    public CompCmd() {
        // Use requires() here to declare subsystem dependencies
        requires(comp);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        comp.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        comp.beSmart();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        comp.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        comp.stop();
    }
}
