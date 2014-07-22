/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.controllers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 *
 * @author Student
 */
public class Attack3 extends Joystick {
   
    /**
* Construct an instance of a Logitech Attack3 joystick (The kind in the
* KoP).
*Initialize Button6 and Button 7 for controlling the pickup relays
* @param port The port on the driver station that the joystick is plugged
* into.
* @return
*/
    
   
    
    
    
    
    public Attack3(int port) {

        super(port);

    } //End public Attack3(int port)

    /**
* Return the value of the Twist axis for this joystick This value is always
* 0 since there is no twist axis.
*
* @param
* @return 0 since there is no twist axis
*/
    public float GetTwist() {

        return (0);	//Return 0 since there is no twist axis

    }//End float GetTwist()

    /**
* Return the value of the Z axis for this joystick This value is always 0
* since there is no Z axis.
*
* @param
* @return 0 since there is no Z axis
*/
   public float GetZ() {

        return (0);	//Return 0 since there is no Z axis

    }//End float GetZ()

    /**
* Get the X value of the joystick. The right side of the axis is positive.
*
* @param
* @return The current X value of the joystick between -1 and 1
*/
    public float GetX() {

        return (float) (this.getX());

    }//End float GetX()

    /**
* Get the Y value of the joystick. The forward part of the axis is
* negative.
*
* @param
* @return The current Y value of the joystick between -1 and 1
*/
    public float GetY() {

        return (float) (this.getY());

    }//End float GetY()

    /**
* Get the Throttle value of the joystick. The top part of the axis is
* negative.
*
* @param
* @return The current Throttle value of the joystick between -1 and 1
*/
    public float GetThrottle() {

        return (float) (this.getThrottle());

    } //End float GetThrottle()

    /**
* Get a JoystickButton for the Command Subsystem OI Class
*
* @param button The button as an integer
* @return JoystickButton
*/
    
    
    /**
* Get the current state of the button7.
*
* @param
* @return The current state of the button
*/
    
    
    public JoystickButton GetButton(int button) {

        return (new JoystickButton(this, button));

    } //End float GetButton(int Button)
  
}
