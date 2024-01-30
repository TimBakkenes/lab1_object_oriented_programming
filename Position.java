public class Position {
    private double x;
    private double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double get_x() {
        return x;
    }

    public double get_y(){
        return y;
    }

    public void set_position(double x_c, double y_c){
        this.x = x_c;
        this.y = y_c;
    }

    public double distance_to_other_position(Position p){
        return Math.sqrt(Math.pow((x-p.x), 2) + Math.pow(y-p.y, 2));
    }
}
