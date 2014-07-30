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
        if(Math.abs(num) < low){
            return defaultLow;
        } else if(Math.abs(num) > high && num > 0){
            return defaultHigh;
        } else if(Math.abs(num) > high && num < 0){
            return (defaultHigh * -1);
        } else{
            return num;
        }
    }
    
}
