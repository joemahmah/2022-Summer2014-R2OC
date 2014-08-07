/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.controllers.Attack3;
import edu.wpi.first.wpilibj.templates.controllers.Xbox;

/**
*
* @author Arturo
*/
public class BallCollector extends CommandBase {
    private final Attack3 attack = oi.getAttack();
    private final Xbox xbawks = oi.getXbox();
    public BallCollector() {
        // Use requires() here to declare subsystem dependencies
        requires(pickUp);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//                while(attack.GetX()== 0) {pickUp.moveSolenoid();}//TODO eventually change this to some button
//                while(attack.GetY()== 0) {pickUp.moveSolenoid();}//TODO eventually change this to some button
                if(attack.GetButton(1).get()==true){pickUp.moveTalon(1);}//TODO change this shit
                else if(attack.GetButton(3).get()==true){pickUp.moveTalon(-1);}
                else if(attack.GetButton(3).get()==false&&attack.GetButton(1).get()== false){pickUp.stop();}
                if(attack.GetButton(5).get() == true){pickUp.moveSolenoid();}
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
