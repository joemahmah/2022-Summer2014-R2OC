/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.CompCmd;

/**
 *
 * @author Michael
 */
public class UbreComp extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    protected Relay outr5;
    protected DigitalInput inio9;
    
    public UbreComp(){
        outr5 = new Relay(5);
        inio9 = new DigitalInput(9);
    }
    
    public void start(){
        outr5.set(Relay.Value.kForward);
    }
    
    public void stop(){
        outr5.set(Relay.Value.kOff);
    }
    
    public void beSmart(){
        if(inio9.get()){
            start();
        } else{
            stop();
        }
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new CompCmd());
    }
}
