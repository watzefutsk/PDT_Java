package ru.stqa.pdt.sandbox;

public class myFirstProgram {
	public static void main(String[] args) {
		hello("Dima");

		Square s = new Square(5);

		System.out.println("Площадь квадрата со стороной " + s.l + " равна " + area(s));

		Rectangle r = new Rectangle(7,8);
		
		System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " равна " + area(r));
	}

	public static void hello(String somestr) {
		System.out.println("Hello, " + somestr + "!");
	}

	public static double area (Square s) {
		return s.l * s.l;
	}

	public static double area (Rectangle r) {
		return r.a * r.b;
	}
}