import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
/*
 * This Class defines the Main Class, where the main List of the Vehicles as the main Warehouse will be defined.
 * Multiple Functions has been implemented. InsertVehicle so the User can add a new Vehicle to the main Warehouse,
 * DeleteVehicleById so the User can delete a specific Vehicle from the Warehouse and SelectVehicleById so the User can know some Information about a Vehicle.
 * */
public class TheMainWarehouse extends JComponent {

    protected static List<Vehicle> vehiclesList = new ArrayList<Vehicle>();

    public TheMainWarehouse() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        JLabel mainLabel = new JLabel("The Main Warehouse");
        JButton addButton = new JButton("Add Vehicle");
        JButton deleteButton = new JButton("Delete Vehicle");
        JButton updateButton = new JButton("Update Vehicle");
        JButton moveButton = new JButton("Move Vehicle");
        JButton overviewButton = new JButton("Overview");

        panel.add(mainLabel);
        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(updateButton);
        panel.add(moveButton);
        panel.add(overviewButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addWindow();
                //insertVehicle(new Vehicle());
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteWindow();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateWindow();
            }
        });

        moveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveWindow();
            }
        });

        overviewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                overviewWindow();
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("TBA");
        frame.pack();
        frame.setVisible(true);

    }


   public void overviewWindow() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        frame.add(panel, BorderLayout.CENTER);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Overview");
        frame.pack();
        frame.setVisible(true);

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        model.addColumn("Type");
        model.addColumn("Color");
        model.addColumn("Direction");
        // j = new JTable(data, columnNames);
        //j.setBounds(30, 40, 200, 300);
        for (Vehicle v : vehiclesList) {
            model.addRow(new Object[]{v.getType(), v.getColor(), v.getDirection()});
        }      //addElement("(" + v.getType() + " , " + v.getColor() + " , " + v.getDirection() + ")" + "\n");

        //originalJList.setModel(newListModel);
        //j = new JTable(data, columnNames);
        //j.setBounds(30, 40, 200, 300);

        // adding it to JScrollPane
        //JScrollPane sp = new JScrollPane(j);
        //panel.add(sp);
        /*JList list = new JList();
        list.setModel(newListModel);
        list.setVisible(true);*/
        panel.add(table);
        panel.invalidate();
    }

    public void addWindow() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        frame.add(panel, BorderLayout.CENTER);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Add Vehicle");
        frame.pack();
        frame.setVisible(true);
        JLabel label = new JLabel("Type");
        label.setBounds(10, 20, 80, 25);
        panel.add(label);

        JTextField typeText = new JTextField();
        typeText.setBounds(100, 20, 165, 25);
        panel.add(typeText);
        JLabel label1 = new JLabel("Color");
        label1.setBounds(10, 20, 80, 25);
        panel.add(label1);
        JTextField colorText = new JTextField();
        colorText.setBounds(100, 20, 165, 25);
        panel.add(colorText);
        JButton addButton1 = new JButton("Add");
        panel.add(addButton1);
        addButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertVehicle(new Vehicle(typeText.getText(), colorText.getText()));
            }
        });


    }

    public void deleteWindow() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        frame.add(panel, BorderLayout.CENTER);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Delete Vehicle");
        frame.pack();
        frame.setVisible(true);
        JLabel label = new JLabel("Type");
        label.setBounds(10, 20, 80, 25);
        panel.add(label);

        JTextField typeText = new JTextField();
        typeText.setBounds(100, 20, 165, 25);
        panel.add(typeText);
        JLabel label1 = new JLabel("Color");
        label1.setBounds(10, 20, 80, 25);
        panel.add(label1);
        JTextField colorText = new JTextField();
        colorText.setBounds(100, 20, 165, 25);
        panel.add(colorText);
        JButton deleteButton1 = new JButton("Delete");
        panel.add(deleteButton1);
        deleteButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteVehicleByTypeAndColor(typeText.getText(), colorText.getText());
            }
        });
    }

    public void updateWindow() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        frame.add(panel, BorderLayout.CENTER);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Update Vehicle");
        frame.pack();
        frame.setVisible(true);
        JLabel label = new JLabel("Old Type");
        label.setBounds(10, 20, 80, 25);
        panel.add(label);

        JTextField oldTypeText = new JTextField();
        oldTypeText.setBounds(100, 20, 165, 25);
        panel.add(oldTypeText);
        JLabel label1 = new JLabel("Old Color");
        label1.setBounds(10, 20, 80, 25);
        panel.add(label1);
        JTextField oldColorText = new JTextField();
        oldColorText.setBounds(100, 20, 165, 25);
        panel.add(oldColorText);

        JLabel label2 = new JLabel("New Type");
        label2.setBounds(10, 20, 80, 25);
        panel.add(label2);
        JTextField newTypeText = new JTextField();
        newTypeText.setBounds(100, 20, 165, 25);
        panel.add(newTypeText);


        JLabel label3 = new JLabel("New Color");
        label3.setBounds(10, 20, 80, 25);
        panel.add(label3);
        JTextField newColorText = new JTextField();
        newColorText.setBounds(100, 20, 165, 25);
        panel.add(newColorText);

        JButton updateButton1 = new JButton("Update");
        panel.add(updateButton1);
        updateButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateVehicle(oldTypeText.getText(), oldColorText.getText(), newTypeText.getText(), newColorText.getText());
            }
        });
    }


    public void moveWindow() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        frame.add(panel, BorderLayout.CENTER);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Move Vehicle");
        frame.pack();
        frame.setVisible(true);
        JLabel label = new JLabel("Type");
        label.setBounds(10, 20, 80, 25);
        panel.add(label);

        JTextField typeText = new JTextField();
        typeText.setBounds(100, 20, 165, 25);
        panel.add(typeText);
        JLabel label1 = new JLabel("Color");
        label1.setBounds(10, 20, 80, 25);
        panel.add(label1);
        JTextField colorText = new JTextField();
        colorText.setBounds(100, 20, 165, 25);
        panel.add(colorText);

        JLabel label2 = new JLabel("Direction");
        label2.setBounds(10, 20, 80, 25);
        panel.add(label2);
        JTextField directionText = new JTextField();
        directionText.setBounds(100, 20, 165, 25);
        panel.add(directionText);

        JButton moveButton1 = new JButton("Move");
        panel.add(moveButton1);


        moveButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Optional<Vehicle> v = selectVehicleByTypeAndColor(typeText.getText(), colorText.getText());
                if (directionText.getText().equals("East")) {
                    v.get().setDirection(Directions.East);
                } else if (directionText.getText().equals("West")) {
                    v.get().setDirection(Directions.West);
                } else if (directionText.getText().equals("North")) {
                    v.get().setDirection(Directions.North);
                } else if (directionText.getText().equals("South")) {
                    v.get().setDirection(Directions.South);
                }
            }
        });
    }

    public void insertVehicle(Vehicle vehicle) {
        vehiclesList.add(new Vehicle(vehicle.getType(), vehicle.getColor()));
    }

    public Optional<Vehicle> selectVehicleByTypeAndColor(String type, String color) {
        return vehiclesList.stream().filter(vehicle -> vehicle.getType().equals(type) && vehicle.getColor().equals(color)).findAny();
    }

    public int deleteVehicleByTypeAndColor(String type, String color) {
        Optional<Vehicle> vehicle = selectVehicleByTypeAndColor(type, color);
        if (vehicle.isEmpty()) {
            return 0;
        } else {
            vehiclesList.remove(vehicle.get());
            return 1;
        }
    }

    public void updateVehicle(String oldType, String oldColor, String newType, String newColor) {
        Optional<Vehicle> v = selectVehicleByTypeAndColor(oldType, oldColor);
        v.get().setType(newType);
        v.get().setColor(newColor);
    }

    public static void main(String[] args) {
        new TheMainWarehouse();
    }
}
       /* TheMainWarehouse theMain = new TheMainWarehouse();
        Scanner in = new Scanner(System.in);
        String function = in.next();
        if (function.equals("add")) {
            String type = in.next();
            String color = in.next();
            Vehicle vehicle = new Vehicle(type, color);
            theMain.insertVehicle(vehicle);
            System.out.println("You have just added the new Vehicle " + type + " to the Warehouse");
        } else if (function.equals("delete")) {
            String type1 = in.next();
            String color1 = in.next();
            theMain.deleteVehicleByTypeAndColor(type1, color1);
            System.out.println("You have just deleted the Vehicle " + type1 + " from the Warehouse");
        } else if (function.equals("update")) {
            String oldType = in.next();
            String oldColor = in.next();
            String newType = in.next();
            String newColor = in.next();
            theMain.updateVehicle(oldType, oldColor, newType, newColor);
            System.out.println("You have just updated the Vehicle " + oldType + " with the Color " + oldColor + " to " + newType + " with the Color " + newColor);
        } else if (function.equals("move")) {
            String type2 = in.next();
            String color2 = in.next();
            String direction = in.next();
            Optional<Vehicle> v = theMain.selectVehicleByTypeAndColor(type2, color2);
            if (direction.equals("East")) {
                v.get().setDirection(Directions.East);
                System.out.println("the Vehicle " + type2 + " is moving " + v.get().getDirection());
            } else if (direction.equals("West")) {
                v.get().setDirection(Directions.West);
                System.out.println("the Vehicle " + type2 + " is moving " + v.get().getDirection());
            } else if (direction.equals("North")) {
                v.get().setDirection(Directions.North);
                System.out.println("the Vehicle " + type2 + " is moving " + v.get().getDirection());
            } else if (direction.equals("South")) {
                v.get().setDirection(Directions.South);
                System.out.println("the Vehicle " + type2 + " is moving " + v.get().getDirection());
            }
        } else if (function.equals("overview")) {
            for (Vehicle v : vehiclesList) {
                System.out.print("(" + v.getType() + " , " + v.getColor() + " , " + v.getDirection() + ")" + "\n");
            }

        } else if (!function.equals("add") && !function.equals("delete") && !function.equals("move") && !function.equals("overview") && !function.equals("update") && !function.equals("stop")) {
            System.out.println("You have entered incorrect Command. Please try again");
            main(args);
        }
        System.out.println("You can enter another Command");
        main(args); */






