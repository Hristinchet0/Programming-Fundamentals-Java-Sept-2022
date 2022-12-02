package p03CarSalesman;

public class Engine {
    //An Engine has a model, power, displacement, and efficiency
    private String engineModel;
    private int power;
    private String displacement;
    private String efficiency;

    public Engine(String engineModel, int power, String displacement, String efficiency) {
        this.engineModel = engineModel;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getEngineModel() {
        return this.engineModel;
    }

    public int getPower() {
        return this.power;
    }

    public String getDisplacement() {
        return this.displacement;
    }

    public String getEfficiency() {
        return this.efficiency;
    }
}
