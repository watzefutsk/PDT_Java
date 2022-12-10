package ru.stqa.pdt.sandbox;

public class MyFirstProgram {
	public static void main(String[] args) {

		Point p1 = new Point(2, 4);
		Point p2 = new Point(7, 1);

		System.out.println("Расстояние между точками А и В равно " + p1.distance(p2));
	}
}