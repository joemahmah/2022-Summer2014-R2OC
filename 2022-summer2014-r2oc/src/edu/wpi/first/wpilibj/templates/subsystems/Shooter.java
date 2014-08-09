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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.ShootGoal;
/**
 *
 * @author Vimig
 * @author Michael Hrcek
 */


public class Shooter extends Subsystem {

//    DoubleSolenoid releaseSolenoid;
    Solenoid sole1, sole2;
    Talon springPullTalon;
    
    // Initialize your subsystem here
    public Shooter(int solenoidPort1, int solenoidPort2 ,int pullBackPort) {
        
//        releaseSolenoid = new DoubleSolenoid(solenoidPort1,solenoidPort2);
        sole1 = new Solenoid(solenoidPort1);
        sole2 = new Solenoid(solenoidPort2);
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
//        releaseSolenoid.set(DoubleSolenoid.Value.kReverse);
        sole1.set(false);
        sole2.set(true);
//        SmartDashboard.putString("solLock ", releaseSolenoid.get()+"");
    }
    
    public void releaseShooter()
    {
//        releaseSolenoid.set(DoubleSolenoid.Value.kForward);
        sole1.set(true);
        sole2.set(false);
//        SmartDashboard.putString("solRel ", releaseSolenoid.get()+"");
    }
    
    public void stop(){
        springPullTalon.set(0);
    }
}

