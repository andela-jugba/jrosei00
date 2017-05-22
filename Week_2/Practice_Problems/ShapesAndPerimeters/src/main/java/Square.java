/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class Square extends Shape {

    double length;

    public Square(String color, double length) {
        super(color);
        this.length = length;
    }

    @Override
    public double area() {
        return 2 * length;
    }

    public double perimeter() {
        return 4 * length;
    }
}
