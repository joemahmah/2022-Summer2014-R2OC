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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.SwerveRobocentricCommand;
import edu.wpi.first.wpilibj.templates.util.Vector;

/**
 *
 * @author Michael
 */
public class SwerveRobocentricSubsystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    Jaguar driveMotors[];
    Jaguar turnMotors[];
    Encoder turnEncoders[];
    
    Vector finalVects[];
    Vector rotVect[];
    Vector moveVect;
    
    public SwerveRobocentricSubsystem(Encoder turnEncoders[], Jaguar turnMotors[], Jaguar driveMotors[]){
        this.turnMotors = turnMotors;
        this.driveMotors = driveMotors;
        this.turnEncoders = turnEncoders;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new SwerveRobocentricCommand());
    }
    
    public void stop(){
        move(0,0,0);
    }
    
    public void move(){
        finalVects = Vector.add(moveVect, rotVect, RobotMap.movePercentage, RobotMap.turnPercentage);
        for(int i=0; i<4; i++){
            turnTo(i,finalVects[i].getAngle());
            driveMotors[i].set(finalVects[i].getMagnitude());
        }
    }
    
    public void move(double x, double y, double pow){
        calcMoveVect(x, y);
        calcRotateVect(pow);
        finalVects = Vector.add(moveVect, rotVect, RobotMap.movePercentage, RobotMap.turnPercentage);
        for(int i=0; i<4; i++){
            turnTo(i,finalVects[i].getAngle());
            driveMotors[i].set(finalVects[i].getMagnitude());
        }
    }
    
    public void calcMoveVect(double x, double y){
        moveVect = new Vector(x, y);
    }
    
    public void calcRotateVect(double pow){
        if(pow < 0){
            rotVect[0] = new Vector(1, 1);
            rotVect[1] = new Vector(1, -1);
            rotVect[2] = new Vector(-1, -1);
            rotVect[3] = new Vector(-1, 1);
        } else if(pow > 0){
            rotVect[0] = new Vector(-1, -1);
            rotVect[1] = new Vector(-1, 1);
            rotVect[2] = new Vector(1, 1);
            rotVect[3] = new Vector(1, -1);
        } else{
            for(int i=0; i<4; i++){
                rotVect[i] = new Vector(0, 0);
            }
        }
    }
    
    public void moveDriveMotor(int x, double speed){
        driveMotors[x].set(speed);
    }
    
    public void moveTurnMotor(int x, double speed){
        turnMotors[x].set(speed);
    }
    public void turnTo(int index, double angle){
        while(turnEncoders[index].get() != (int)(Math.toDegrees(angle)*250/360.0)){    
            if(turnEncoders[index].get() < (int)(Math.toDegrees(angle)*250/360.0)){
                turnMotors[index].set(RobotMap.wheelTurnSpeed);
            } else if(turnEncoders[index].get() > (int)(Math.toDegrees(angle)*250/360.0)){
                turnMotors[index].set(RobotMap.wheelTurnSpeed);
            }
        }
        turnMotors[index].set(0);
    }
}