
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.controllers.Attack3;
import edu.wpi.first.wpilibj.templates.controllers.Xbox;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
     private final Xbox xbawks;
    private final Attack3 attack;
    
    private int drive;
    
    public OI()
    {
        xbawks = new Xbox(3); //change posrts
        attack = new Attack3(1); // change port
        drive = RobotMap.CRAB_DRIVE;
        
        //SmartDashboard.putString("Current Drive: ", "Swerve");
        //SmartDashboard.putString("This drive:", getDrive() + "");
        
                
            }
    public Xbox getXbox()
    {
        return xbawks;
    }
    public Attack3 getAttack()
    {
        return attack;
    }
    
    public int getDrive(){
        return drive;
    }
    
    public void changeDrive(){
        if(drive == RobotMap.ARCADE_DRIVE){
            drive = RobotMap.CRAB_DRIVE;
        } else{
            drive++;
        }
        
        String temp;
        
        if(drive == RobotMap.CRAB_DRIVE){
            temp = "Crab";
        } else if(drive == RobotMap.SWERVE_DRIVE_ROBO){
            temp = "Robocentric Swerve";
        } else if(drive == RobotMap.SWERVE_DRIVE_FIELD){
            temp = "Fieldcentric Swerve";
        } else if(drive == RobotMap.TANK_DRIVE){
            temp = "Tank";
        } else if(drive == RobotMap.ARCADE_DRIVE){
            temp = "Arcade";
        } else{
            temp = "ERROR!";
        }
        
        SmartDashboard.putString("Current Drive: ", temp);
    }
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

