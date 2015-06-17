/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.util;

/**
 *
 * @author mhrcek
 */
public abstract class BaseDefinition {

    private Location[] locations;
    private String name;

    protected BaseDefinition(Location[] locations, String name) {
        this.locations = locations;
        this.name = name;
    }

    public Location[] getLocations() {
        return locations;
    }

    public boolean isFront() {
        for (int i = 0; i < locations.length; i++) {
            if (locations[i] == Location.FRONT) {
                return true;
            }
        }
        return false;
    }

    public boolean isLeft() {
        for (int i = 0; i < locations.length; i++) {
            if (locations[i] == Location.LEFT) {
                return true;
            }
        }
        return false;
    }

    public boolean isBack() {
        for (int i = 0; i < locations.length; i++) {
            if (locations[i] == Location.BACK) {
                return true;
            }
        }
        return false;
    }

    public boolean isRight() {
        for (int i = 0; i < locations.length; i++) {
            if (locations[i] == Location.RIGHT) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

}
