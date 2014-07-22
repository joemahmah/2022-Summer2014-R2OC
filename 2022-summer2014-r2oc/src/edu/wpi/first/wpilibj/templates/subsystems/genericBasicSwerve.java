/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import java.util.Vector;

/**
 *
 * @author Michael
 */
public class genericBasicSwerve extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    Jaguar DriveMotors[];
    Jaguar TurnMotors[];
    Encoder TurnEncders[];
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void move(){
    
    }
    
    public void rotate(){
        
    }
    
    public void moveDriveMotor(int x, double speed){
        DriveMotors[x].set(speed);
    }
    
    public void moveTurnMotor(int x, double speed){
        TurnMotors[x].set(speed);
    }
}
