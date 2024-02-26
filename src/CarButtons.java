package src;

import javax.swing.*;

public class CarButtons {

    View view;
    Model model;
    JPanel addVehiclePanel = new JPanel();
    JLabel addVehicleLabel = new JLabel("Add Vehicle");

    public CarButtons(View view, Model model) {
        this.view = view;
        this.model = model;
        initComponents();
    }

    private void initComponents() {}

}
