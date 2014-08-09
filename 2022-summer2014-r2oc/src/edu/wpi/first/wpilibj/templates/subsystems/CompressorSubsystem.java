/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.CompressorCommand;

/**
 *
 * @author Michael
 */
public class CompressorSubsystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private Compressor comp;
    
    public CompressorSubsystem(Compressor c){
        comp = c;
    }
    
    public void start(){
        comp.start();
    }
    
    public void stop(){
        comp.stop();
    }
    
    public void kill(){
        comp.free();
    }
    
    /*public void toggle(){
        if(comp.getPressureSwitchValue()){
            comp.stop();
        }else{
            comp.start();
        }
    }*/
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new CompressorCommand());
    }
}
