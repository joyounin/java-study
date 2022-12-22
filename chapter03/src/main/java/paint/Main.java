package paint;

public class Main {

	public static void main(String[] args) {
		Point point1 = new Point(10, 10);
		// point1.setX(10);
		// point1.setY(10);

		// drawPoint(point1);
		draw(point1);
		point1.show(false);

		// point1.disapear(); 하나의 방법으로 다양하게 쓰는 방법 : 오버로딩
		// ColorPoint colorPoint2 = (ColorPoint)point2; //명시적으로 (ColorPoint)를 넣어 자식<>부모를
		// 바꿔줌

		Point point2 = new ColorPoint(20, 20, "red");

		// drawPoint(point2);
//		draw(point2);
		Rect rect = new Rect();
//		drawRect(rect);
		drawShape(rect);

		Triangle triangle = new Triangle();
//		drawTriangel(triangle);
		// drawShape(triangle);
		draw(triangle);

		Circle circle = new Circle();
		// drawShape(circle);
		draw(circle);
		draw(new GraphicText("Hello World"));

		// instanceof 연산자 Test
		System.out.println(circle instanceof Object);
		System.out.println(circle instanceof Shape);
		System.out.println(circle instanceof Circle);

		// 오류 : 연산자 우측항이 클래스인 경우,
		// 레퍼런스 하고 있는 class 타입의 hierachy 상위 하위와 상위만
		// instanceof 연산자를 사용할 수 있다.
		// System.out.println(circle instanceof Rect);
		Object o = circle;
		System.out.println(o instanceof String);

		// 연산자 우측항이 인터페이스인 경우,
		// Hierachy 상관 없이 instanceof 연산자를 사용할 수 있다.
		System.out.println(circle instanceof Drawable);
		System.out.println(circle instanceof Runnable);
	}

	public static void draw(Drawable drawable) {
		drawable.draw();
	}

	public static void drawPoint(Point point) {
		point.show();
	}

	public static void drawShape(Shape shape) {
		shape.draw();
	}

//	public static void drawColorPoint(ColorPoint colorPoint) {
//		colorPoint.show();
//	}

//	public static void drawRect(Rect rect) {
//		rect.draw();
//	}
//	
//	public static void drawTriangel(Triangle triangle) {
//		triangle.draw();
//	}
//	public static void drawCircle(Circle circle) {
//		circle.draw();
//	}

}
