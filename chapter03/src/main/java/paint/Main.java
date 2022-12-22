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
