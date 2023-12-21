package org.example;

/**
 * Lab work number 5
 * <p>
 * Project for demonstrate reflection
 * @author Ivan Dorofeev
 * @version 1.0
 */
public class App 
{
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Bmd bmd = (new Injector()).inject(new Bmd());
        bmd.land();
    }
}
