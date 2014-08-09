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
        SmartDashboard.putString("Begin Crab Drive", "");
        
        this.turnMotors = turnMotors; // FL (2), FR(3), BL (1), BR (0)
        this.driveMotors = driveMotors; // FL (2), FR (3), BL (1), BR (0)
        this.turnEncoders = turnEncoders; // FL (2), FR (3), BL (1), BR (0)
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
     public void setSpeed(double speed)
        {
        driveMotors[0].set(limitSpeed(speed));
        driveMotors[1].set(limitSpeed(speed));
        driveMotors[2].set(limitSpeed(speed));
        driveMotors[3].set(limitSpeed(speed));
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
        public void rotate(double target, int talIndex, int encodeIndex, double speed)
        {
            SmartDashboard.putString("Encoder " + encodeIndex + " calc", "" + getDegree(turnEncoders[encodeIndex].get()));
            int direction;
            double speedMult;
            double current = getDegree(turnEncoders[encodeIndex].get());
            speedMult = limitSpeed(Math.abs(current - target)/5);
            if(Math.abs(current - target) < 6){
              
            speedMult = 0;  
            }
            SmartDashboard.putString("Speed Multiplier", speedMult + "");
            
            double midpoint = (target + 180) % 360;
            if(current < midpoint)
            {
                direction = -1;
            }
            else
            {
                direction = 1;
            }
            if(Math.abs(current-target) > 6){
                
            turnMotors[talIndex].set(limitSpeed(direction*speed*speedMult));
            
            SmartDashboard.putString("First", limitSpeed(direction*speed*speedMult) + "");
            
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
            }else{
            turnMotors[talIndex].set(0);
            }
        }
        /*
*Limits the speed input
*@param speed the speed that you wish the wheel to move
*/
        public double limitSpeed(double speed)
        {
            double max = 1; double min = -1; 
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
        public double getDegree(double count)
        {
            return Math.abs((count/2160.0*360.0)%360);
        }
        
        /*
        Testing code to see if the wheels rotate
        */
        public void turn(double speed)
        {
            turnMotors[0].set(speed);
            turnMotors[1].set(speed);
            turnMotors[2].set(speed);
            turnMotors[3].set(speed);
        }
        
}