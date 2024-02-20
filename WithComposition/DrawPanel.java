package WithComposition;

import WithComposition.Vehicles.Vehicle;
import WithComposition.Vehicles.Volvo240;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;


public class DrawPanel extends JPanel {

    private final ArrayList<Vehicle> cars;

    private final ArrayList<AutoShop<Volvo240>> autoShops;

    public DrawPanel(int x, int y, ArrayList<Vehicle> cars, ArrayList<AutoShop<Volvo240>> autoShops) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.cars = cars;
        this.autoShops = autoShops;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (AutoShop<Volvo240> autoShop : autoShops) {
            try {
                BufferedImage image = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream(autoShop.getImage())));
                g.drawImage(image, (int) Math.round(autoShop.pos.getX()), (int) Math.round(autoShop.pos.getY()), null);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        for (Vehicle car : cars){
            try {
                BufferedImage carImage = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream(car.getImage())));
                g.drawImage(carImage, (int) Math.round(car.getPosition().getX()), (int) Math.round(car.getPosition().getY()), null);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
