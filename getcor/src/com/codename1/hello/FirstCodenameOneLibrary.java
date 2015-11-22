/*
 * Copyright comment here
 */
package com.codename1.hello;

import com.codename1.system.NativeLookup;

/**
 * This is a demo class to help you get started building a library
 *
 * @author Your name here
 */
public class FirstCodenameOneLibrary {
    /**
     * Method javadoc information
     */
    public double[] get() {
        System.out.println("Hello");
        
        NewInterface interface1 = (NewInterface)NativeLookup.create(NewInterface.class);
        
        if(interface1!=null){
            double[] a = interface1.getCoordinates();
            if(a==null) return new double[]{1,1};
            else return a;
        }
        else return new double[]{0,0};
    }
}
