package p05VehicleCatalogue;

public class Vehicle {
    //характеристики
    private String type;
    private String model;
    private String color;
    private int hp;

    //конструктор

    public Vehicle(String type, String model, String color, int hp) {
        this.type = type;
        this.model = model;
        this.color = color;
        this.hp = hp;
    }

    public String getModel() {
        return this.model;
    }

    public String getType() {
        return this.type;
    }

    public int getHp() {
        return this.hp;
    }

    @Override
    public String toString() {
        //Type: {typeOfVehicle}
        //Model: {modelOfVehicle}
        //Color: {colorOfVehicle}
        //Horsepower: {horsepowerOfVehicle}
        String formattedType = "";
        if (this.type.equals("car")) {
            formattedType = "Car";
        } else if (this.type.equals("truck")) {
            formattedType = "Truck";
        }
        return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d",
                formattedType, this.model, this.color, this.hp);
    }
}
