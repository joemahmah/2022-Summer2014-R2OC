/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.BallCollector;

/**
*
* @author Arturo
*/
public class PickUpSystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
//private DoubleSolenoid sole;
    protected Solenoid sole1, sole2;
private boolean isDown = false;
Talon t1;
//Relay lols;
     /*
* Constructs the Pickupsystem
* @param solenoidport the port for the solenoid
* @param rollerPort the port for the Talon for the roller
*/
    public PickUpSystem(int[] solenoidPort, int rollerPort)
    {
//    sole = new DoubleSolenoid(solenoidPort[0],solenoidPort[1]);
        sole1 = new Solenoid(solenoidPort[0]);
        sole2 = new Solenoid(solenoidPort[1]);
    t1 = new Talon(rollerPort);
//    lols = new Relay(5);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new BallCollector());
    }
    
//    public void testCode(){
//        lols.set(Relay.Value.kForward);
//    }
    
    /*
* Turns the solenoid on and off
*/
    public void moveSolenoid()
    {
        if(isDown == false)
        {
//        sole.set(DoubleSolenoid.Value.kForward);
        isDown = true;
        }
        else
        {
//        sole.set(DoubleSolenoid.Value.kReverse);
        isDown = false;
        }
    }
    
    public void moveOut(){
//        sole.set();
        sole1.set(true);
        sole2.set(false);
    }
    
    public void moveIn(){
//        sole.set(DoubleSolenoid.Value.kReverse);
        sole1.set(false);
        sole2.set(true);
    }
    
    public boolean isPickupDown()
    {
        return isDown;
    }
    
    public void moveTalon(double speed)
    {
    t1.set(speed);
    }
    public void stop()
    {
        t1.set(0.1);
    }
}
