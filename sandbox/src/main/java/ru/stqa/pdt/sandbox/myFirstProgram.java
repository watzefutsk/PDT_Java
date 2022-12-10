package ru.stqa.pdt.sandbox;

public class myFirstProgram {
	public static void main(String[] args) {

		Point p1 = new Point(2, 4);
		Point p2 = new Point(4,6);

		System.out.println("Расстояние между точками: " + distance(p1, p2));

	}

	public static double distance(Point p1, Point p2) {
		return Math.sqrt((p1.p2 - p1.p1) * (p1.p2 - p1.p1) + (p2.p2 - p2.p1) * (p2.p2 - p2.p1));
	}

}