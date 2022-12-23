package prob6;

public class Rectangle extends Shape implements Resizable  {
	public double width;
	public double height;
	
	public Rectangle(int i, int j) {
		this.width = i;
		this.height = j;
	}

	@Override
	public double getArea() {
		return width * height;
	}

	@Override
	public double getPerimeter() {
		return (width + height) * 2;
	}

	@Override
	public void resize(double s) {
		width = width * s;
		height = height * s;
	}

}
