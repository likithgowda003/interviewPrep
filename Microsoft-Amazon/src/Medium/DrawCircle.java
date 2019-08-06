package Medium;

public class DrawCircle {
	/* Following program uses a simple concept. Let the radius of the circle be r. 
	 * Consider a square of size (2r+1)*(2r+1) around the circle to be drawn. 
	 * Now walk through every point inside the square. 
	 * For every every point (x,y), if (x, y) lies inside the circle (or x^2+ y^2 < r^2), 
	 * then print it, otherwise print space.
	 */
	
	public void circle(int r) {
		int N = 2*r+1; // Consider a rectangle of size N*N 
		int x, y; //Coordinates inside the rectangle 
		
		// Draw a square of size N*N.
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				
				// Start from the left most corner point 
				x = i-r;
				y = j-r;
				
				// If this point is inside the circle, print it
				if(x*x + y*y <= r*r + 1) {
					System.out.println(".");
				}
				else {
					System.out.println(" ");
				}
				System.out.println(" ");
			}
			System.out.println();
		}
	}
}
