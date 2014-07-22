/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.util;

/**
 *
 * @author Michael
 */
public class Vector {
    
    private double magnitude;
    private double angle;
    private double x;
    private double y;
    
    public Vector(double x, double y){
        this.x = x;
        this.y = y;
        calculate(x,y);
    }
    
    public void calculate(double x, double y){
        magnitude = Math.abs(Math.sqrt(x*x + y*y));
        angle = com.sun.squawk.util.MathUtils.atan(y/x);
    }
    
    public double getMagnitude(){
        return magnitude;
    }
    
    public double getAngle(){
        return angle;
    }
    
    
}
