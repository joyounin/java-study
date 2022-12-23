package prob6;

public class RectTriangle extends Shape {
	public double width;
	public double height;
	
	public RectTriangle(int i, int j) {
		this.width = i;
		this.height = j;
	}

	@Override
	public double getArea() {
		return (width * height) / 2;
	}

	@Override
	public double getPerimeter() {
		return (width + height + Math.sqrt(width*width + height*height));
	}

}
