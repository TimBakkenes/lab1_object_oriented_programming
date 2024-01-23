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
}
