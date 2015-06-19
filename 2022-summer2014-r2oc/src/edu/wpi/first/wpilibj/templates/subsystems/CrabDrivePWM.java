/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.CrabCommand;
import edu.wpi.first.wpilibj.templates.util.MotorControllerDefinition;

/**
 *
 * @author Arturo
 */
public class CrabDrivePWM extends GenericDrivebasePWM {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    /*
     Creates the crabDrive
     @param talPorts the list of ports for all the talons
     @param encoder the list of ports for encoders
     */

    public CrabDrivePWM(GenericDrivebasePWM parent) {
        super(parent);
        SmartDashboard.putString("Begin Crab Drive", "");
    }

    public void initDefaultCommand() {

    }

    /**
     * Sets the speed of a specific wheel
     *
     * @param speed the speed you want it to go
     * @param index the index of the talon for the wheel
     */
    public void setSpeed(double speed) {
        getParent().getMovementMotorControllerByName("FRONT-LEFT").getMotorController().set(speed);
        getParent().getMovementMotorControllerByName("FRONT-RIGHT").getMotorController().set(speed);
        getParent().getMovementMotorControllerByName("BACK-LEFT").getMotorController().set(speed);
        getParent().getMovementMotorControllerByName("BACK-RIGHT").getMotorController().set(speed);
    }

    /**
     * Stops all the wheels
     */
    public void stop() {
        getParent().stop();
    }

    /**
     * Rotates the swerve wheel to a specific angle
     *
     * @param angle the angle at which you want it to turn
     * @param talIndex the index for the specific talon that you want to turn
     * @param encodeIndex the index for the encoder for the specific wheel you
     * want to read
     */
    public void rotate(double target, int talIndex, int encodeIndex, double speed) {
        SmartDashboard.putString("Encoder " + encodeIndex + " calc", "" + getDegree(turnEncoders[encodeIndex].get()));
        int direction;
        double current = getDegree(turnEncoders[encodeIndex].get());

        //double speedMult = limitSpeed(Math.abs(current - target)/5);
        double speedMult = 1;

        if (current < (target - 3)) {
            direction = 1;
        } else {
            direction = -1;
        }
        turnMotors[talIndex].set(limitSpeed(direction * speed * speedMult));
        SmartDashboard.putString("First", limitSpeed(direction * speed * speedMult) + "");

        if (Math.abs(current - target) < 3) {
//            if(current < target - 3){
//                turnMotors[talIndex].set(limitSpeed(-speed * speedMult));
//                SmartDashboard.putString("First", limitSpeed(speed * speedMult) + "");
//            }
//            else if(current > target + 3){
//                turnMotors[talIndex].set(limitSpeed(speed * speedMult));
//                SmartDashboard.putString("Seconds", limitSpeed(-speed * speedMult) + "");
//            }
//            else{
//                turnMotors[talIndex].set(0); 
//                SmartDashboard.putString("We got fuck in the ass by a donkey...", limitSpeed(speed * speedMult) + "");
//            }
            turnMotors[talIndex].set(0);
        }
    }

    /**
     * Limits the speed input
     *
     * @param speed the speed that you wish the wheel to move
     */
    public double limitSpeed(double speed) {
        double max = 1;
        double min = -1;
        double limit;
        if (speed > max) {
            limit = max;
        } else if (speed < min) {
            limit = min;
        } else {
            limit = speed;
        }
        return limit;
    }

    /**
     * gives the degrees based on the the encoder's count at the moment
     *
     * @param count the count
     */
    public double getDegree(double count) {
        return Math.abs((count / 2160.0 * 360.0) % 360);
    }

    /**
     * Testing code to see if the wheels rotate
     */
    public void turn(double speed) {
        getParent().getTurnMotorControllerByName("FRONT-LEFT").getMotorController().set(speed);
        getParent().getTurnMotorControllerByName("FRONT-RIGHT").getMotorController().set(speed);
        getParent().getTurnMotorControllerByName("BACK-LEFT").getMotorController().set(speed);
        getParent().getTurnMotorControllerByName("BACK-RIGHT").getMotorController().set(speed);
    }

}
