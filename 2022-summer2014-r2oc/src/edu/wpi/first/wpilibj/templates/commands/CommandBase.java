package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.subsystems.CompressorSubsystem;
import edu.wpi.first.wpilibj.templates.subsystems.CrabDrive;
import edu.wpi.first.wpilibj.templates.subsystems.PickUpSystem;
import edu.wpi.first.wpilibj.templates.subsystems.Shooter;
import edu.wpi.first.wpilibj.templates.subsystems.TankSubsystem;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    
    // Create a single static instance of all of your subsystems
     public static PickUpSystem pickUp = new PickUpSystem(RobotMap.soles,RobotMap.talons[0]);
     public static CrabDrive driveCrab = new CrabDrive(RobotMap.turnEncoders,RobotMap.turnMotors, RobotMap.driveMotors);
     public static TankSubsystem tank = new TankSubsystem(RobotMap.driveMotors);
     public static Shooter shooter = new Shooter(RobotMap.shooterSolenoid1, RobotMap.shooterSolenoid2, RobotMap.shooterVictor);
     public static CompressorSubsystem compress = new CompressorSubsystem(RobotMap.COMPRESSOR);
     
    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(pickUp);
        SmartDashboard.putData(driveCrab);
        SmartDashboard.putData(shooter);
        
        for(int i=0; i<RobotMap.turnEncoders.length; i++){
            RobotMap.turnEncoders[i].start();
        }
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
