/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.util;

import edu.wpi.first.wpilibj.Talon;

/**
 *
 * @author mhrcek
 */
public class MotorControllerDefinition extends BaseDefinition{
    
    private Talon motorController;
    
    public MotorControllerDefinition(Talon motorController, Location[] locations, String name){
        super(locations, name);
        this.motorController = motorController;
    }

    public Talon getMotorController() {
        return motorController;
    }

    
    
}
