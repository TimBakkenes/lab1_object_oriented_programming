package src;

import src.Vehicles.Vehicle;
import src.Vehicles.VehicleFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class CarAdder {


    static List<String> types = initList();

    static void addRandomCar(Model model){
        int cap = model.cars.size();
        if (cap < 100) {
            Vehicle car = getRandomCar(model.dimensions.width - 100, model.dimensions.height - 240);
            model.cars.add(car);
            model.components.add(car);
        }
    }

    static void removeRandomCar(Model model){
        Random rand = new Random();
        int cap = model.cars.size();
        if (cap > 0) {
            int randInt = rand.nextInt(cap);
            Vehicle car = model.cars.remove(randInt);
            model.components.remove(car);
        }

    }

    static private Vehicle getRandomCar(int boundX, int boundY) {

        Random rand = new Random();
        int cap = types.size();
        int randInt = rand.nextInt(cap);

        int randX = rand.nextInt(boundX);
        int randY = rand.nextInt(boundY);

        String arg = types.get(randInt);

        if (Objects.equals(arg, "Volvo240")) {
            return VehicleFactory.createVolvo240(randX, randY);
        } else if (Objects.equals(arg, "Saab95")) {
            return VehicleFactory.createSaab95(randX, randY);
        } else if (Objects.equals(arg, "Scania")) {
            return VehicleFactory.createScania(randX, randY);
        } else if (Objects.equals(arg, "VehicleTransport")) {
            return VehicleFactory.createVehicleTransport(4, randX, randY);
        } else {
            return null;
        }
    }

    public static List<String> initList() {
        List<String> typeList = new ArrayList<>();
        typeList.add("Volvo240");
        typeList.add("Saab95");
        typeList.add("Scania");
        typeList.add("VehicleTransport");
        System.out.println(typeList);
        return typeList;
    }

}






