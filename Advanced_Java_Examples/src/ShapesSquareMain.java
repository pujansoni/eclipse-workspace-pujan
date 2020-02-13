
public class ShapesSquareMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Square s = new Square(4);
		
		Shapes shapes = Square::calculateArea;
//		The above code is short cut which uses method references instead of the code given below:
//		Shapes shapes = (Square square) -> {
//			return square.calculateArea();
//		};
		
		System.out.println("Area: " + shapes.getArea(s));
	}

}
