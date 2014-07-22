/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.controllers.Attack3;

/**
*
* @author Arturo
*/
public class BallCollector extends CommandBase {
    private final Attack3 attack = oi.getAttack();
    public BallCollector() {
        // Use requires() here to declare subsystem dependencies
        requires(pickUp);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
         while(attack.GetX()== 0) {pickUp.moveSolenoid();}//TODO eventually change this to some button
                while(attack.GetY()== 0) {pickUp.moveSolenoid();}//TODO eventually change this to some button
                while(attack.GetZ() == 0){pickUp.moveTalon(0.5);}//TODO change this shit
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
