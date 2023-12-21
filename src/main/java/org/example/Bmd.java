package org.example;

/**
 * Class Bmd with Car's and Plane's fields
 */
public class Bmd {
    @AutoInjectable
    public Car car;
    @AutoInjectable
    public Plane plane;

    /**
     * Method for call Car's and Plane's methods
     */
    public void land(){
        this.car.drive();
        this.plane.fly();
    }
}
