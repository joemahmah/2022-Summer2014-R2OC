/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.ShootGoal;
/**
 *
 * @author Vimig
 * @author Michael Hrcek
 */


public class Shooter extends Subsystem {

    Solenoid releaseSolenoid1, releaseSolenoid2;
    Talon springPullTalon;
    
    // Initialize your subsystem here
    public Shooter(int solenoidPort1, int solenoidPort2 ,int pullBackPort) {
        
        releaseSolenoid1 = new Solenoid(solenoidPort1);
        releaseSolenoid2 = new Solenoid(solenoidPort2);
        springPullTalon = new Talon(pullBackPort);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new ShootGoal());
    }
    
    public void pull(){
        springPullTalon.set(-0.35);
    }
    
    public void lockShooter(){
        releaseSolenoid1.set(true);
        releaseSolenoid2.set(true);
    }
    
    public void releaseShooter()
    {
        releaseSolenoid1.set(false);
        releaseSolenoid2.set(false);
    }
    
    public void stop(){
        springPullTalon.set(0);
    }
}

