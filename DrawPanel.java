import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

import static java.lang.Math.round;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize


    HashMap<Vehicle, BufferedImage> vImage = new HashMap<>();

    CarController carC;

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,300);

    // TODO: Make this general for all cars
    void moveit(Vehicle car, int x, int y){
        car.setPosition(x, y);
    }

    // Initializes the panel and reads the images
    public DrawPanel(CarController carC, int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.carC = carC;
        ArrayList<Vehicle> cars = carC.cars;

        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.


            for (Vehicle car : cars) {
                vImage.put(car, ImageIO.read(DrawPanel.class.getResourceAsStream(String.format("pics/%s.jpg", car.getModelName()))));
            }


            //volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));

            //scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));

            //saab95Image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
        /*
        g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null);
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);

        // TODO: Change to list somehow, professional comment
        g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null);
        g.drawImage(saab95Image, saabPoint.x, saabPoint.y, null);
        */

        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
        for (Vehicle car : carC.cars){
            g.drawImage(vImage.get(car), (int) Math.round(car.getPosition().getX()), (int) Math.round(car.getPosition().getY()), null);
        }

    }
}
