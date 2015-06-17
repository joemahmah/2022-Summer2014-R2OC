/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Talon;
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

    private Talon[] leftMotors, rightMotors;

    public TankDrivePWM(GenericDrivebasePWM parent) {
        super(parent);

        leftMotors = getParent().getAllMovementMotorControllersLeftAsTalons();
        rightMotors = getParent().getAllMovementMotorControllersRightAsTalons();
    }

    public void stop() {
        getParent().stop();
    }

    public void move(double leftSpeed, double rightSpeed) {
        for (int i = 0; i < leftMotors.length; i++) {
            leftMotors[i].set(leftSpeed);
        }

        for (int i = 0; i < rightMotors.length; i++) {
            rightMotors[i].set(rightSpeed);
        }
    }
}
