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

    private final ArrayList<DrawAble> components;

    public DrawPanel(int x, int y, ArrayList<DrawAble> components) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.components = components;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (DrawAble component : components) {
            try {
                BufferedImage image = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream(component.getImage())));
                g.drawImage(image, (int) Math.round(component.getPosition().getX()), (int) Math.round(component.getPosition().getY()), null);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
