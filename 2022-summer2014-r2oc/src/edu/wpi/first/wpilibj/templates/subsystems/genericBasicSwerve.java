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
import edu.wpi.first.wpilibj.templates.util.Vector;

/**
 *
 * @author Michael
 */
public class genericBasicSwerve extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    Jaguar driveMotors[];
    Jaguar turnMotors[];
    Encoder turnEncoders[];
    
    Vector finalVects[];
    Vector rotVect[];
    Vector moveVect;
    
    public genericBasicSwerve(Encoder turnEncoders[], Jaguar turnMotors[], Jaguar driveMotors[]){
        this.turnMotors = turnMotors;
        this.driveMotors = driveMotors;
        this.turnEncoders = turnEncoders;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void move(){
        finalVects = Vector.add(moveVect, rotVect);
        for(int i=0; i<4; i++){
            turnTo(i,finalVects[i].getAngle());
            driveMotors[i].set(finalVects[i].getMagnitude());
        }
    }
    
    public void calcMoveVect(double x, double y){
        
    }
    
    public void calcRotateVect(double pow){
        
    }
    
    public void moveDriveMotor(int x, double speed){
        driveMotors[x].set(speed);
    }
    
    public void moveTurnMotor(int x, double speed){
        turnMotors[x].set(speed);
    }
}
