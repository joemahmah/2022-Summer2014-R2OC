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
public class MathUtils {
    
    public static double limit(double num, double low, double high, double defaultLow, double defaultHigh){
        if(num < low){
            return defaultLow;
        } else if(num > high){
            return defaultHigh;
        } else{
            return num;
        }
    }
    
}
