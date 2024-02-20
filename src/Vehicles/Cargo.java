package src.Vehicles;

public class Cargo<T, R> {

    T contents;
    R capacity;

    public Cargo(T contents, R capacity){
        this.contents = contents;
        this.capacity = capacity;
    }

}
