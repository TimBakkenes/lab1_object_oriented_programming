package WithComposition;

public class TestVarious {
    public static void main(String [] args){
        Saab95 saab = new Saab95();
        saab.startEngine();
        saab.gas(0.7);
        saab.brake(0.4);

        Scania scania = new Scania();
        scania.startEngine();

    }
}
