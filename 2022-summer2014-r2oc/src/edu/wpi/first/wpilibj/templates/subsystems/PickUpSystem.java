/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Arturo
 */
public class PickUpSystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
private final DoubleSolenoid sole;
private boolean isDown = false;
Talon t1; 
    	/*
    * Constructs the Pickupsystem
    * @param solenoidport the port for the solenoid
    * @param rollerPort the port for the Talon for the roller
    */
    public PickUpSystem(int[] solenoidPort, int rollerPort)
    {
    sole = new DoubleSolenoid(solenoidPort[1],solenoidPort[2]);
    t1 = new Talon(rollerPort);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    /*
    * Turns the solenoid on and off
    */
    public void moveSolenoid()
    {
        if(isDown == false)
        {
        sole.set(DoubleSolenoid.Value.kForward);
        isDown = true;
        }
        else
        {
        sole.set(DoubleSolenoid.Value.kReverse);
        isDown = false;
        }

    }
    public void moveTalon(double speed)
    {
    t1.set(speed);
    }
}
