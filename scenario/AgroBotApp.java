interface SensorReadable {
    void readSensorData();
}

class IrrigationUnit implements SensorReadable {
    protected String unitId;

    IrrigationUnit(String unitId) {
        this.unitId = unitId;
    }

    public void startWatering() {
        System.out.println("Starting generic irrigation...");
    }

    public void readSensorData() {
        System.out.println("Reading generic sensor data...");
    }

    private void calibrate() {
        System.out.println("Calibrating irrigation unit...");
    }

    protected void runCalibration() {
        calibrate();
    }
}

class Sprinkler extends IrrigationUnit {
    Sprinkler(String unitId) {
        super(unitId);
    }

    @Override
    public void startWatering() {
        System.out.println("Sprinkler " + unitId + " is watering the field.");
    }

    @Override
    public void readSensorData() {
        System.out.println("Sprinkler " + unitId + " reading moisture levels...");
    }
}

class DripSystem extends IrrigationUnit {
    DripSystem(String unitId) {
        super(unitId);
    }

    @Override
    public void startWatering() {
        System.out.println("DripSystem " + unitId + " is watering the roots.");
    }

    @Override
    public void readSensorData() {
        System.out.println("DripSystem " + unitId + " reading root humidity...");
    }
}

public class AgroBotApp {
    public static void main(String[] args) {
        IrrigationUnit unit1 = new Sprinkler("SP101");
        IrrigationUnit unit2 = new DripSystem("DR202");

        unit1.readSensorData();
        unit1.startWatering();
        unit1.runCalibration();

        unit2.readSensorData();
        unit2.startWatering();
        unit2.runCalibration();
    }
}
