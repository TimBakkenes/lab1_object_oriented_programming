package WithComposition;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame implements Observer{

    Model model;
    DrawPanel drawPanel;

    public View(Model model){
        this.model = model;
        this.drawPanel = new DrawPanel(model.dimensions.width, model.dimensions.height-240, model.components);
        this.add(drawPanel);
        initComponents();
    }

    private void initComponents() {
        this.setTitle("CarSim 1.0");
        this.setPreferredSize(model.dimensions);
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();
        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void update() {
        drawPanel.repaint();
    }


}
