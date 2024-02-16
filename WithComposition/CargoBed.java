package WithComposition;

public class CargoBed {

    private double platformAngle;
    private final double maxAngle;
    private final double minAngle;

    public CargoBed(double startAngle, double minAngle, double maxAngle){
        this.platformAngle = startAngle;
        this.minAngle = minAngle;
        this.maxAngle = maxAngle;
    }

    public double getPlatformAngle(){
        return this.platformAngle;
    }

    public double getMinAngle(){
        return this.minAngle;
    }

    public double getMaxAngle(){
        return this.maxAngle;
    }

    public void setPlatformAngle(double angle){
        this.platformAngle = angle;
    }
}
