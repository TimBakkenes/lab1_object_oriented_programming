package src.Vehicles;

import src.AutoShop;


public class TestVarious {
    public static void main(String [] args){
        AutoShop<Saab95> verkstad = new AutoShop<Saab95>(4);

        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();

        verkstad.dropOff(saab);


        System.out.println(verkstad.cars);

        Saab95 test = verkstad.pickUp(saab);

    }
}
