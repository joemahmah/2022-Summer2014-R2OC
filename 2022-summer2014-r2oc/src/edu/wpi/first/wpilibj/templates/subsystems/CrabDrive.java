/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.CrabCommand;

/**
 *
 * @author Arturo
 */
public class CrabDrive extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
Jaguar[] turnMotors;
Jaguar[] driveMotors;
Encoder[] turnEncoders;
/*
Creates the crabDrive
@param talPorts the list of ports for all the talons
@param encoder the list of ports for encoders
*/
    public CrabDrive(Encoder turnEncoders[], Jaguar turnMotors[], Jaguar driveMotors[])
    {
        this.turnMotors = turnMotors;
        this.driveMotors = driveMotors;
        this.turnEncoders = turnEncoders;
        //TODO setup up ports to the correct talons/encoder
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new CrabCommand());
    }
    /*
    *Sets the speed of a specific wheel
    *@param speed the speed you want it to go
    *@param index the index of the talon for the wheel
    */
    	public void setSpeed(double speed,int index)
        {
        turnMotors[index].set(limitSpeed(speed));
        }
        /*
        *Stops all the wheels 
        */
        public void stop()
        {
            for(int x = 0; x<turnMotors.length;x++)
            {
            turnMotors[x].set(0);
            }
        }
        /*
        *Rotates the swerve wheel to a specific angle
        *@param angle the angle at which you want it to turn
        *@param talIndex the index for the specific talon that you want to turn
        *@param encodeIndex the index for the encoder for the specific wheel you want to read
        */
        public void rotate(double angle, int talIndex, int encodeIndex)
        {
            if(getDegre(turnEncoders[encodeIndex].get())< angle) turnMotors[talIndex].set(limitSpeed(3)); //not how to move it at an angle
            else if(getDegre(turnEncoders[encodeIndex].get())> angle) turnMotors[talIndex].set(limitSpeed(-3)); //fix this stuff
            else{turnMotors[talIndex].set(0); }
        }
        /*
        *Limits the speed input
        *@param speed the speed that you wish the wheel to move
        */
        public double limitSpeed(double speed)
        {
            double max = 1; double min = -1; // change these speeds
            double limit;
            if(speed>max) limit = max;
            else if(speed<min) limit = min;
            else{limit = speed; }
            return limit;
        }
        /*
        *gives the degrees based on the the encoder's count at the moment
        *@param count the count
        */
        public double getDegre(double count)
        {
            return (count/250)*360;
        }
}
