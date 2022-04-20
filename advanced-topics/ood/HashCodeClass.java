package OOD;

public class HashCodeClass {

    public static void main(String[] args) {

        Car car = new Car("bmw", "320");
        car.hashCode();

    }

}

class Car {

    String brand;
    String model;

    Car(String brand, String model){
        this.brand = brand;
        this.model = model;
    }
}