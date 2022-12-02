package p03CarSalesman;

public class Car {

    //. A Car has a model, engine, weight, and color.
    private String carModel;
    private String engine;
    private String weight;
    private String colour;

    public Car(String carModel, String engine, String weight, String colour) {
        this.carModel = carModel;
        this.engine = engine;
        this.weight = weight;
        this.colour = colour;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getEngine() {
        return engine;
    }

    public String getWeight() {
        return weight;
    }

    public String getColour() {
        return colour;
    }

//    @Override
//    public String toString() {
//
//        return String.format("%s:%n" + //{CarModel}:
//                        " %s:%n" +      //  {EngineModel}:
//                        "  Power: %d%n" +   //    Power: {EnginePower}
//                        "  Displacement: %d%n" +  //    Displacement: {EngineDisplacement}
//                        "  Efficiency: %s%n" +    //    Efficiency: {EngineEfficiency}
//                        " Weight: %d%n" +    //  Weight: {CarWeight}
//                        " Color: %s"   //  Color: {CarColor}"
//                , this.carModel, );
//    }
}
