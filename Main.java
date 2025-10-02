// Product interface
interface Transport {
    void deliver();
}

// Concrete Products
class Truck implements Transport {
    public void deliver() {
        System.out.println("Delivering by land in a Truck");
    }
}

class Ship implements Transport {
    public void deliver() {
        System.out.println("Delivering by sea in a Ship");
    }
}

// Creator (Factory Method)
abstract class Logistics {
    // Factory Method
    public abstract Transport createTransport();

    // Business logic
    public void planDelivery() {
        Transport t = createTransport();
        t.deliver();
    }
}

// Concrete Creators
class RoadLogistics extends Logistics {
    public Transport createTransport() {
        return new Truck();
    }
}

class SeaLogistics extends Logistics {
    public Transport createTransport() {
        return new Ship();
    }
}

// --- Abstract Factory part ---

// Abstract Products
interface Button { void paint(); }
interface Checkbox { void paint(); }

// Concrete Products (Windows)
class WinButton implements Button {
    public void paint() { System.out.println("Rendering Windows Button"); }
}
class WinCheckbox implements Checkbox {
    public void paint() { System.out.println("Rendering Windows Checkbox"); }
}

// Concrete Products (Mac)
class MacButton implements Button {
    public void paint() { System.out.println("Rendering Mac Button"); }
}
class MacCheckbox implements Checkbox {
    public void paint() { System.out.println("Rendering Mac Checkbox"); }
}

// Abstract Factory
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Factories
class WinFactory implements GUIFactory {
    public Button createButton() { return new WinButton(); }
    public Checkbox createCheckbox() { return new WinCheckbox(); }
}

class MacFactory implements GUIFactory {
    public Button createButton() { return new MacButton(); }
    public Checkbox createCheckbox() { return new MacCheckbox(); }
}

// --- Client ---
public class Main {
    public static void main(String[] args) {
        // Factory Method demo
        Logistics road = new RoadLogistics();
        road.planDelivery();

        Logistics sea = new SeaLogistics();
        sea.planDelivery();

        // Abstract Factory demo
        GUIFactory factory = new WinFactory(); // можно заменить на new MacFactory()
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.paint();
        checkbox.paint();
    }
}
