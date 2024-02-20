package WithComposition.Vehicles;

public class Position {
    private double x;
    private double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY(){
        return y;
    }

    public void setPosition(double x_c, double y_c){
        this.x = x_c;
        this.y = y_c;
    }

    public double distanceToOtherPosition(Position p){
        return Math.sqrt(Math.pow((x-p.x), 2) + Math.pow(y-p.y, 2));
    }
}