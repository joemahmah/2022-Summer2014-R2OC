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
        angle = com.sun.squawk.util.MathUtils.atan2(y,x);
    }
    
    public double getMagnitude(){
        return magnitude;
    }
    
    public double getAngle(){
        return angle;
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public static Vector add(Vector a, Vector b){
        return new Vector(a.getX() + b.getX(), a.getY() + b.getY());
    }
    
    public static Vector add(Vector a, Vector b, double aPer, double bPer){
        return new Vector(a.getX() * aPer + b.getX() * bPer, a.getY() * aPer + b.getY() * bPer);
    }
    
    public static Vector[] add(Vector a, Vector b[]){
        Vector vects[] = new Vector[b.length];
        for(int i=0; i<b.length; i++){
            vects[i] = add(a,b[i]);
        }
        return vects;
    }
    
    public static Vector[] add(Vector a, Vector b[], double aPer, double bPer){
        Vector vects[] = new Vector[b.length];
        for(int i=0; i<b.length; i++){
            vects[i] = add(a, b[i], aPer, bPer);
        }
        return vects;
    }
    
}
