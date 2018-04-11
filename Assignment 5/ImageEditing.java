/*

Assignment number   :   5.1

File Name           :   ImageEditing 

Name                :   Nitai Aharoni

Student ID          :   203626742

Email               :   Nitai.Aharoni@post.idc.ac.il

*/


public class ImageEditing {

	/**
	 * Testing code - testing the print method.
	 */
	public static void main(String[] args) {
		print(read("tinypic.ppm"));
	}

	/**
	 * reading a ppm file and returning an array using StdIn.
	 * 
	 * @param filename - the file to read and show.
	 * @return 3d array of pixels
	 */
	public static int[][][] read(String filename) {
		StdIn.setInput(filename);
		StdIn.readString();
		int width = StdIn.readInt();
		int height = StdIn.readInt();
		int[][][] readPpm = new int[height][width][3];
		StdIn.readInt();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				for (int k = 0; k < 3; k++) {
					readPpm[i][j][k] = StdIn.readInt();
				}
			}
		}
		return readPpm;
	}

	 /**
	 * prints a matrix of pixels-data from a ppm file. 
	 * @param source - a 3d matrix to be printed
	 */
	private static void print(int[][][] source) {
		int height = source.length;
	 	int width = source[0].length; 
	 	for (int i = 0; i < height; i++) {
	 		for (int j = 0; j < width; j++) {
	 			for (int k = 0; k < 3; k++) {
				 	System.out.printf(" %-4d", source[i][j][k]);
	 			}
	 			System.out.printf("   ");
	 		}
	 	System.out.println(); 
	 	}
	 }

	/**
	 * returns a horizontally flipped version of a given matrix. 
	 * @param source - a 3d matrix to be horizontally flipped
	 * @return a new 3d matrix
	 */
	public static int[][][] flipHorizontally(int[][][] source) {
		int height = source.length;
		int width = source[0].length;
		int[][][] hFlipped = new int[height][width][3];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
					hFlipped[i][width - 1 - j] = source[i][j];
				}
			}
		return hFlipped;
		}

	/**
	 * returns a vertically flipped version of a given matrix. 
	 * @param source - a 3d matrix to be vertically flipped
	 * @return a new 3d matrix
	 */
	public static int[][][] flipVertically(int[][][] source) {
		int height = source.length;
		int width = source[0].length;
		int[][][] vFlipped = new int[height][width][3];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
					vFlipped[height - 1 - i][j] = source[i][j];
				}
			}
		return vFlipped;
		}

	/**
	 * calculates the luminace of RGB pixel by the luminace equation, and
	 * returns an array of 3 identical luminaces.  
	 * @param pixel - the array to be luminaced
	 * @return a new array that represents a pixel
	 */
	public static int[] luminance(int[] pixel) {
		int r = pixel[0];
		int g = pixel[1];
		int b = pixel[2];
		int lum = (int) (0.299 * r + 0.587 * g + 0.114 * b);
		int[] lumArray = new int[3];
		lumArray[0] = lum;
		lumArray[1] = lum;
		lumArray[2] = lum;
		return lumArray;
	}

	/**
	 * transforms a given matrix to it's grey scale matrix
	 * @param source - the given matrix to be grey scaled
	 * @return a new 3d array which is the grey scale of the given matrix
	 */
	public static int[][][] greyScale(int[][][] source) {
		int height = source.length;
		int width = source[0].length;
		int[][][] greyScaled = new int[height][width][3];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
					greyScaled[i][j] = luminance(source[i][j]);
				}
			}
		return greyScaled;
		}

	/**
	 * scales the given matrix to a given width and height
	 * @param source - the given matrix to be scaled
	 * @param width - the given width to be scaled to
	 * @param height - the given height to be scaled to
	 * @return a new 3d array which is the given matrix scaled
	 */
	public static int[][][] scale(int[][][] source, int width, int height) {
		double h0 = source.length;
		double w0 = source[0].length;
		int[][][] scaled = new int[height][width][3];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				scaled[i][j] = source[(int) (i * (h0 / height))]
						[(int) (j * (w0 / width))];
			}
		}
		return scaled;
	}

	/**
	 * blends two pixels elements into 1 pixel by a given ratio
	 * @param pixel1 - the first given array to be blended
	 * @param pixel2 - the second given array to be blended
	 * @param alpha - the ratio of the blend
	 * @return a new array which is a blended array
	 */
	public static int[] blend(int[] pixel1, int[] pixel2, double alpha) {
		int[] blended = new int[3];
		blended[0] = (int) (pixel1[0] * alpha + pixel2[0] * (1 - alpha));
		blended[1] = (int) (pixel1[1] * alpha + pixel2[1] * (1 - alpha));
		blended[2] = (int) (pixel1[2] * alpha + pixel2[2] * (1 - alpha));
		return blended;
	}


	/**
	 * blends two 3d array (matrices) into 1 3d array by a given ratio
	 * @param source1 - the first given 3d array to be blended
	 * @param source2 - the second given 3d array to be blended
	 * @param alpha - the ratio of the blend
	 * @return a new 3d array which is the blended matrix
	 */
	public static int[][][] combine(int[][][] source1, int[][][] source2,
			double alpha) {
		int height = source1.length;
		int width = source1[0].length;
		int[][][] combined = new int[height][width][3];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				combined[i][j] = blend(source1[i][j],source2[i][j], alpha);
				}
			}
		return combined;
		}

	/**
	 * transforms the matrix from the first given matrix to the second given
	 * matrix in a given number of steps and shows the process
	 * @param source - given matrix to start from 
	 * @param target - given matrix to transform into
	 * @param alpha - number of steps of the transformation
	 */
	public static void morph(int[][][] source, int[][][] target, double alpha){
		for (int i = 0; i<=alpha; i++){
			double alpha2 = i/alpha;
			show(combine(target, source, alpha2));
		}
	}
	
	/**
	 * Renders an image using StdDraw.
	 * The input array is assumed to contain
	 * integers in the range [0,255].
	 * With the third dimension being of size 3.
	 *
	 * @param pic - the image to show.
	 */
	public static void show(int[][][] pic) {
		StdDraw.setCanvasSize(pic[0].length, pic.length);
		int height = pic.length;
		int width = pic[0].length;
		StdDraw.setXscale(0, width);
		StdDraw.setYscale(0, height);
		StdDraw.show(30);
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				StdDraw.setPenColor(pic[i][j][0], pic[i][j][1], pic[i][j][2]);
				StdDraw.filledRectangle(j + 0.5, height - i - 0.5, 0.5, 0.5);
			}
		}
		StdDraw.show();
	}

}
