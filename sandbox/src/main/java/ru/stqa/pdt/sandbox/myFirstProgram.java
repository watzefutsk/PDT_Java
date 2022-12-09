package ru.stqa.pdt.sandbox;

public class myFirstProgram {
	public static void main(String[] args) {
		hello("Dima");
		double v = 5;
		System.out.println("Площадь квадрата со стороной " + v + " равна " + area(v));

		double a = 7;
		double b = 8;
		System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " равна " + area(a, b));
	}

	public static void hello(String somestr) {
		System.out.println("Hello, " + somestr + "!");
	}

	public static double area (double l) {
		return l * l;
	}

	public static double area (double a, double b) {
		return a * b;
	}
}