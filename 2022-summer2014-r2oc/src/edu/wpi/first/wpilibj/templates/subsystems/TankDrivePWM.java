/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.TankCommand;

/**
 *
 * @author Michael Hrcek
 */
public class TankDrivePWM extends GenericDrivebasePWM {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private Jaguar[] left, right;
    
    public TankDrivePWM(Jaguar motors[]){
        
        SmartDashboard.putString("Begin Tank Drive", "");
        left = new Jaguar[2];
        right = new Jaguar[2];
        
        left[0] = motors[0];
        left[1] = motors[3];
        right[0] = motors[1];
        right[1] = motors[2];
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new TankCommand());
    }
    
    public void stop(){
        for(int i=0; i<2; i++){
            left[i].set(0);
            right[i].set(0);
        }
    }
    
    public void move(double lY, double rY){
        for(int i=0; i<2; i++){
            left[i].set(lY);
            right[i].set(rY);
        }
    }
}
