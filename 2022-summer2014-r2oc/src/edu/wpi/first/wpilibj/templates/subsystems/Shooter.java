/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.ShootGoal;
/**
 *
 * @author Vimig
 * @author Michael Hrcek
 */


public class Shooter extends Subsystem {

    DoubleSolenoid releaseSolenoid;
    Talon springPullTalon;
    
    // Initialize your subsystem here
    public Shooter(int solenoidPort1, int solenoidPort2 ,int pullBackPort) {
        
        releaseSolenoid = new DoubleSolenoid(solenoidPort1,solenoidPort2);
        springPullTalon = new Talon(pullBackPort);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new ShootGoal());
    }
    
    public void pull(){
        springPullTalon.set(.75);
    }
    
    public void lockShooter(){
        releaseSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void releaseShooter()
    {
        releaseSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    
    public void stop(){
        springPullTalon.set(0);
    }
}

