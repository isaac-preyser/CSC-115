public class Rectangle implements Shape {

	private int length; //length units along x axis
	private int height;  //height units along y axis
	private Point position; // position is the (x,y) coordinates of lower left corner of the rectangle

	/*
	 * Purpose: initializes this Rectangle with length and height of 0
	 *   and position to new Point at 0,0
	 * Parameters: none
	 */
	public Rectangle() {
		this.length = 0;
		this.height = 0;
		this.position = new Point();
	}

	/*
	 * Purpose: initializes this Rectangle with given length and height
	 *   and position to new Point at 0,0
	 * Parameters: int length, int height
	 * Precondition: given length and height >=0
	 */
	public Rectangle(int length, int height) {
		this.length = length;
		this.height = height;
		this.position = new Point();
	}

	/*
	 * Purpose: initializes this Rectangle with given length, height and position
	 * Parameters: int length, int height, Point position
	 * Precondition: given length and height >=0, position is not null
	 */
	public Rectangle(int length, int height, Point position) {
		this.length = length;
		this.height = height;
		this.position = position;
	}

	/*
	 * Purpose: prints a message about the characteristics of this Rectangle
	 * Parameters: none
	 * Returns: void
	 */
	public void printCharacteristics() {
		if (length > height) {
			System.out.println("long rectangle");
		} else if (height > length) {
			System.out.println("tall rectangle");
		} else {
			System.out.println("square");
		}
	}

	public String toString() {
		return "Rectangle of dimensions: " + length + " by " + height + " at Point: " + position;
	}


	public boolean contains(Point p) {
		//a point is defined as the bottom left corner of the rectangle. 
		//therefore, if p.x is between position.x and position.x + length, and p.y is between position.y and position.y + height, then p is within the rectangle
		//so, if p.x is less than position.x, or is greater than position.x + length, then p is not within the rectangle. the same is true for p.y. 

		if(p.getX() < position.getX() || p.getX() > position.getX() + this.length) {
			return false;
		}

		if(p.getY() < position.getY() || p.getY() > position.getY() + this.height) {
			return false;
		}
		
		return true;
	}

	public double area() {
		return this.height * this.length;
	}

	public double perimeter() {
		return (this.height * 2) + (this.length * 2);
	}




	

}
