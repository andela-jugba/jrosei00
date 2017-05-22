/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class Rectangle extends Shape {

    double width;
    double height;

    public Rectangle(String color, double width, double height) {
        super(color);
        this.height = height;
        this.width = width;
    }
    @Override
    public double area() {
        return width*height;
    }
    public double perimeter() {
        return (2*width)+(2*height);
    }
    
}
