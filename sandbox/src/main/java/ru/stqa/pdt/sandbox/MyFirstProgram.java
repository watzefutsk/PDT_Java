package ru.stqa.pdt.sandbox;

public class MyFirstProgram {
	public static void main(String[] args) {

		Point p1 = new Point(-0.01,-1);
		Point p2 = new Point(-100, -5);

		System.out.println("Расстояние между точками А и В равно " + p1.distance(p2));
	}
}