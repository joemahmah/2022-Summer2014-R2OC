/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.controllers.Attack3;

/**
 *
 * @author Vimig;
 * @author Michael Hrcek
 */


public class ShootGoal extends CommandBase {

    
    private final Attack3 attack = oi.getAttack();
    private static final int farPullDistance = 24;
    private static final int shortPullDistance = 12;    
    
    JoystickButton fireButton;
    JoystickButton trussShotButton;
    
    public ShootGoal() {
        // Use requires() here to declare subsystem dependencies
        requires(pickUp);
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        if(attack.GetButton(2).get()){
            shooter.releaseShooter();
            shooter.pull();
        } else{
            shooter.stop();
            shooter.lockShooter();
        }
        
        if(attack.getTrigger() == true && pickUp.isPickupDown()){
            shooter.releaseShooter();
        }
        
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        shooter.stop();
        shooter.lockShooter();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        
    }
}
