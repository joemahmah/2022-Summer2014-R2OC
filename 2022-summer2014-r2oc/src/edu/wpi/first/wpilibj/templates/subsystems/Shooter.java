/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.Talon;
/**
 *
 * @author Vimig
 */


public class Shooter extends PIDSubsystem {

    private static final double Kp = 5.0;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
    
    
    DoubleSolenoid releaseSolenoid;
    Talon springPullTalon;
    Encoder springPullEncoder;
    // Initialize your subsystem here
    public Shooter(int solenoidPort1, int solenoidPort2 ,int pullBackPort, int encoderPortA, int encoderPortB) {
        super("Shooter", Kp, Ki, Kd);
        
        releaseSolenoid = new DoubleSolenoid(solenoidPort1,solenoidPort2);
        springPullTalon = new Talon(pullBackPort);
        springPullEncoder = new Encoder(encoderPortA, encoderPortB, true, EncodingType.k2X);
        springPullEncoder.setDistancePerPulse(25.0/750.0);
        springPullEncoder.start();
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
         enable(); //- Enables the PID controller.
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return springPullEncoder.getDistance();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
         if (output > 1) {
            output = 1;
        } else if (output < -1) {
            output = -1;
        }
        /**
         * sets output for the Jaguar movement
         */
        springPullTalon.set(output);
    }
    //set point is in inches of extension of the spring
    public void setShootPoint(int distanceExtended)
    {
        setSetpoint(distanceExtended);
    }
    public void releaseShooter()
    {
        releaseSolenoid.set(DoubleSolenoid.Value.kForward);
        springPullEncoder.reset();
    }
}

