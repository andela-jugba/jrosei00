/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class Circle extends Shape {

    double radius;
    double PI = 3.14;

    public Circle(String color, double radius, double PI) {
        super(color);
        this.PI = PI;
        this.radius = radius;
    }

    public double area() {
        return PI * (Math.pow(radius, 2));
    }

    public double perimeter() {
        return 2 * PI * radius;
    }

}
