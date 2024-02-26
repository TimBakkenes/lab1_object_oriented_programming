package src.Vehicles;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class VehicleFactory {

    public static Volvo240 createVolvo240(){
        return new Volvo240();
    }

    public static Volvo240 createVolvo240(double x, double y){
        Volvo240 volvo = new Volvo240();
        volvo.setPosition(x, y);
        return volvo;
    }

    public static Saab95 createSaab95(){
        return new Saab95();
    }

    public static Saab95 createSaab95(double x, double y){
        Saab95 saab = new Saab95();
        saab.setPosition(x, y);
        return saab;
    }

    public static Scania createScania(){
        return new Scania();
    }

    public static Scania createScania(double x, double y){
        Scania scania = new Scania();
        scania.setPosition(x, y);
        return scania;
    }

    public static VehicleTransport createVehicleTransport(int cap){
        return new VehicleTransport(cap);
    }
    public static VehicleTransport createVehicleTransport(int cap, double x, double y){
        VehicleTransport vehicleTransport = new VehicleTransport(cap);
        vehicleTransport.setPosition(x, y);
        return vehicleTransport;
    }


}
