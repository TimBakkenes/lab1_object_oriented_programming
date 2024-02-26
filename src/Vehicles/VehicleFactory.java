package src.Vehicles;

public class VehicleFactory {
    public static Volvo240 createVolvo240(){
        return new Volvo240();
    }

    public static Volvo240 createVolvo240(double x, double y){
        return new Volvo240();
    }

    public static Saab95 createSaab95(){
        return new Saab95();
    }

    public static Saab95 createSaab95(double x, double y){
        return new Saab95();
    }

    public static Scania createScania(){
        return new Scania();
    }

    public static Scania createScania(double x, double y){
        return new Scania();
    }

    public static VehicleTransport createVehicleTransport(int cap){
        return new VehicleTransport(cap);
    }
    public static VehicleTransport createVehicleTransport(int cap, double x, double y){
        return new VehicleTransport(cap);
    }


}
