/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.SolenoidBase;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.util.MotorControllerDefinition;
import edu.wpi.first.wpilibj.templates.util.SolenoidDefinition;

/**
 *
 * @author mhrcek
 */
public class GenericDrivebasePWM extends Subsystem {

    private MotorControllerDefinition[] allMovementMotorControllers;
    private MotorControllerDefinition[] allMovementMotorControllersFront;
    private MotorControllerDefinition[] allMovementMotorControllersLeft;
    private MotorControllerDefinition[] allMovementMotorControllersBack;
    private MotorControllerDefinition[] allMovementMotorControllersRight;
    private MotorControllerDefinition[] allTurnMotorControllers;
    private SolenoidDefinition[] allSolenoids;
    private GenericDrivebasePWM parent;

    public GenericDrivebasePWM(GenericDrivebasePWM parent){
        this.parent = parent;
    }

    protected GenericDrivebasePWM getParent() {
        return parent;
    }
    
    public GenericDrivebasePWM(MotorControllerDefinition[] movementControllers, MotorControllerDefinition[] turnControllers, SolenoidDefinition[] solenoids) {

        this.allMovementMotorControllers = movementControllers;
        this.allTurnMotorControllers = turnControllers;
        this.allSolenoids = solenoids;

        int front = 0, left = 0, back = 0, right = 0;

        for (int i = 0; i < movementControllers.length; i++) {
            if (movementControllers[i].isFront()) {
                front++;
            }
            if (movementControllers[i].isLeft()) {
                left++;
            }
            if (movementControllers[i].isBack()) {
                back++;
            }
            if (movementControllers[i].isRight()) {
                right++;
            }
        }

        allMovementMotorControllersFront = new MotorControllerDefinition[front];
        allMovementMotorControllersLeft = new MotorControllerDefinition[left];
        allMovementMotorControllersBack = new MotorControllerDefinition[back];
        allMovementMotorControllersRight = new MotorControllerDefinition[right];

        front = 0;
        left = 0;
        back = 0;
        right = 0;

        for (int i = 0; i < movementControllers.length; i++) {
            if (movementControllers[i].isFront()) {
                allMovementMotorControllersFront[front] = movementControllers[i];
                front++;
            }
            if (movementControllers[i].isLeft()) {
                allMovementMotorControllersLeft[left] = movementControllers[i];
                left++;
            }
            if (movementControllers[i].isBack()) {
                allMovementMotorControllersBack[back] = movementControllers[i];
                back++;
            }
            if (movementControllers[i].isRight()) {
                allMovementMotorControllersRight[right] = movementControllers[i];
                right++;
            }
        }

    }

    protected MotorControllerDefinition[] getAllMovementMotorControllers() {
        return allMovementMotorControllers;
    }

    protected MotorControllerDefinition[] getAllMovementMotorControllersFront() {
        return allMovementMotorControllersFront;
    }

    protected MotorControllerDefinition[] getAllMovementMotorControllersLeft() {
        return allMovementMotorControllersLeft;
    }

    protected MotorControllerDefinition[] getAllMovementMotorControllersBack() {
        return allMovementMotorControllersBack;
    }

    protected MotorControllerDefinition[] getAllMovementMotorControllersRight() {
        return allMovementMotorControllersRight;
    }

    protected Talon[] getAllMovementMotorControllersAsTalons() {
        Talon[] motorControllersAsTalons = new Talon[allMovementMotorControllers.length];

        for (int i = 0; i < allMovementMotorControllers.length; i++) {
            motorControllersAsTalons[i] = allMovementMotorControllers[i].getMotorController();
        }

        return motorControllersAsTalons;
    }

    protected Talon[] getAllMovementMotorControllersFrontAsTalons() {
        Talon[] motorControllersAsTalons = new Talon[allMovementMotorControllersFront.length];

        for (int i = 0; i < allMovementMotorControllersFront.length; i++) {
            motorControllersAsTalons[i] = allMovementMotorControllersFront[i].getMotorController();
        }

        return motorControllersAsTalons;
    }

    protected Talon[] getAllMovementMotorControllersLeftAsTalons() {
        Talon[] motorControllersAsTalons = new Talon[allMovementMotorControllersLeft.length];

        for (int i = 0; i < allMovementMotorControllersLeft.length; i++) {
            motorControllersAsTalons[i] = allMovementMotorControllersLeft[i].getMotorController();
        }

        return motorControllersAsTalons;
    }

    protected Talon[] getAllMovementMotorControllersBackAsTalons() {
        Talon[] motorControllersAsTalons = new Talon[allMovementMotorControllersBack.length];

        for (int i = 0; i < allMovementMotorControllersBack.length; i++) {
            motorControllersAsTalons[i] = allMovementMotorControllersBack[i].getMotorController();
        }

        return motorControllersAsTalons;
    }

    protected Talon[] getAllMovementMotorControllersRightAsTalons() {
        Talon[] motorControllersAsTalons = new Talon[allMovementMotorControllersRight.length];

        for (int i = 0; i < allMovementMotorControllersRight.length; i++) {
            motorControllersAsTalons[i] = allMovementMotorControllersRight[i].getMotorController();
        }

        return motorControllersAsTalons;
    }

    protected MotorControllerDefinition[] getAllTurnMotorControllers() {
        return allTurnMotorControllers;
    }

    protected SolenoidDefinition[] getAllSolenoids() {
        return allSolenoids;
    }

    protected MotorControllerDefinition getMovementMotorControllerByName(String name) {
        for (int i = 0; i < allMovementMotorControllers.length; i++) {
            if (allMovementMotorControllers[i].getName().equals(name)) {
                return allMovementMotorControllers[i];
            }
        }
        return null;
    }

    protected MotorControllerDefinition getTurnMotorControllerByName(String name) {
        for (int i = 0; i < allTurnMotorControllers.length; i++) {
            if (allTurnMotorControllers[i].getName().equals(name)) {
                return allTurnMotorControllers[i];
            }
        }
        return null;
    }

    protected SolenoidDefinition getSolenoidByName(String name) {
        for (int i = 0; i < allSolenoids.length; i++) {
            if (allSolenoids[i].getName().equals(name)) {
                return allSolenoids[i];
            }
        }
        return null;
    }

    public void stop() {

        for (int i = 0; i < allMovementMotorControllers.length; i++) {
            allMovementMotorControllers[i].getMotorController().set(0);
        }

        for (int i = 0; i < allTurnMotorControllers.length; i++) {
            allTurnMotorControllers[i].getMotorController().set(0);
        }

    }

    protected void initDefaultCommand() {

    }

}
