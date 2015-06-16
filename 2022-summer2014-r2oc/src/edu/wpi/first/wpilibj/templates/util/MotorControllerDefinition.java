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
public class MotorControllerDefinition {
    
    Talon motorController;
    Location[] locations;
    
    public MotorControllerDefinition(Talon motorController, Location[] locations){
        this.motorController = motorController;
        this.locations = locations;
    }

    public Talon getMotorController() {
        return motorController;
    }

    public Location[] getLocations() {
        return locations;
    }
    
    public boolean isFront(){
        for(int i=0; i<locations.length; i++){
            if(locations[i] == Location.FRONT){
                return true;
            }
        }
        return false;
    }
    
    public boolean isLeft(){
        for(int i=0; i<locations.length; i++){
            if(locations[i] == Location.LEFT){
                return true;
            }
        }
        return false;
    }
    
    public boolean isBack(){
        for(int i=0; i<locations.length; i++){
            if(locations[i] == Location.BACK){
                return true;
            }
        }
        return false;
    }
    
    public boolean isRight(){
        for(int i=0; i<locations.length; i++){
            if(locations[i] == Location.RIGHT){
                return true;
            }
        }
        return false;
    }
    
}
