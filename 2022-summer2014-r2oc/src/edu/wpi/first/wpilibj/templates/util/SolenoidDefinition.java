/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.util;

import edu.wpi.first.wpilibj.SolenoidBase;

/**
 *
 * @author mhrcek
 */
public class SolenoidDefinition extends BaseDefinition{

    private SolenoidBase solenoid;
    
    public SolenoidDefinition(SolenoidBase solenoid, Location[] locations, String name) {
        super(locations, name);
        this.solenoid = solenoid;
    }

    public SolenoidBase getSolenoid() {
        return solenoid;
    }
    
    
    
}
