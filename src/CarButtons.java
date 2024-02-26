package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarButtons {

    View view;
    Model model;
    JPanel vehiclePanel = new JPanel();
    // JLabel addVehicleLabel = new JLabel("Add Vehicle");

    JButton addVehicleButton = new JButton("Add Vehicle");
    JButton removeVehicleButton = new JButton("Remove Vehicle");

    public CarButtons(View view, Model model) {
        this.view = view;
        this.model = model;
        initComponents();
    }

    private void initComponents() {
        vehiclePanel.setLayout(new GridLayout(2,1));

        vehiclePanel.add(addVehicleButton, 0);
        vehiclePanel.add(removeVehicleButton, 1);
        vehiclePanel.setPreferredSize(new Dimension((model.dimensions.width/6)+4, 200));

        view.add(vehiclePanel);
        view.setVisible(true);

        addVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarAdder.addRandomCar(model);
            }
        });

        removeVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarAdder.removeRandomCar(model);
            }
        });

    }




}
