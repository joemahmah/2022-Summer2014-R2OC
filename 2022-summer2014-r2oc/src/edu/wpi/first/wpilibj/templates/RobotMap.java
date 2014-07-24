package edu.wpi.first.wpilibj.templates;

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
     public static final int[] soles = {1,2}; //TODO change this
     public static final int talFR = 1;// change
     public static final int[] talons = {3}; // change this
     public static final int shooterSolenoid1 = 1;
     public static final int shooterSolenoid2 = 2;
     public static final int shooterVictor = 1;
     public static final int shooterEncoder1 = 3;
     public static final int shooterEncoder2 = 4;
     
     public static final int CRAB_DRIVE = 1, SWERVE_DRIVE_ROBO = 2, SWERVE_DRIVE_FIELD = 3;
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    
    public static final double wheelTurnSpeed = .1;
    public static final double movePercentage = .7;
    public static final double turnPercentage = .3;
    
    public static final Jaguar turnMotors[] = {};
    public static final Jaguar driveMotors[] = {};
    public static final Encoder turnEncoders[] = {};
}
