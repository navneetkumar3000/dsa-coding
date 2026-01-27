package interview_problems;

public class SingleCode {
    public static void main(String[] args) {
        Wheel carWheel = new Wheel();
        Car car = new Car(carWheel);
        car.move();
    }
}

class Wheel {
    void rotate(){
        System.out.println("Wheel Rotating");
    }
}

class Car {
    Wheel wheel;
    Car(Wheel wheel){
        this.wheel = wheel;
    }
    void move(){
        wheel.rotate();
        System.out.println("Car Moving");
    }
}
