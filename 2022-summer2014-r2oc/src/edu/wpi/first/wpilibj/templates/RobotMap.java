package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
     public static final int[] soles = {3,4}; //TODO change this
     public static final int[] talons = {10}; // change this
     public static final int shooterSolenoid1 = 1;
     public static final int shooterSolenoid2 = 2;
     public static final int shooterVictor = 9;
     
     public static final int CRAB_DRIVE = 1, SWERVE_DRIVE_ROBO = 2, SWERVE_DRIVE_FIELD = 3, TANK_DRIVE = 4, ARCADE_DRIVE = 5;
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    
    public static final double wheelTurnSpeed = .1;
    public static final double movePercentage = .7;
    public static final double turnPercentage = .3;
    
    public static final Jaguar turnMotors[] = {new Jaguar(4),new Jaguar(5),new Jaguar(7),new Jaguar(2)};
    public static final Jaguar driveMotors[] = {new Jaguar(3),new Jaguar(6),new Jaguar(8),new Jaguar(1)};
    public static final Encoder turnEncoders[] = {new Encoder(1, 2,true,CounterBase.EncodingType.k2X),new Encoder(3, 4,true,CounterBase.EncodingType.k2X),new Encoder(7, 8,true,CounterBase.EncodingType.k2X),new Encoder(5, 6,true,CounterBase.EncodingType.k2X)};
    
    
    public static final Compressor COMPRESSOR = new Compressor(9,1);
}
