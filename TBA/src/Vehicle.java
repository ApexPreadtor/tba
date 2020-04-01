import java.util.UUID;
import javax.swing.*;
/*
 *   This Class is responsible of creating the relevant Components of the Vehicle.
 *   Each Vehicle has following Components: RandomId, Type and Color.
 */
public class Vehicle extends JComponent {
    private final UUID id;
    private String type;

    public void setType(String type) {
        this.type = type;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private String color;
    private Directions direction;


    public Vehicle(String type, String color) {
        this.id = UUID.randomUUID();
        this.type = type;
        this.color = color;
        this.direction = Directions.Middle;

    }

    public String getType() {
        return type;
    }


    public String getColor() {
        return color;
    }


    public UUID getId() {
        return id;
    }

    public Directions getDirection() {
        return direction;
    }

    public void setDirection(Directions direction) {
        this.direction = direction;
    }

}
