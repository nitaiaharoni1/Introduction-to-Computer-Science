/*

Assignment number   :   5.4

File Name           :   FadeToGrey 

Name                :   Nitai Aharoni

Student ID          :   203626742

Email               :   Nitai.Aharoni@post.idc.ac.il

*/

public class FadeToGrey {

	/**
	 * shows the transformation of a given matrix from a ppm file to
	 * 		it's grey scale form in a given number of steps
	 */
	public static void main(String[] args) {
		String sourceFile = StdIn.readString();
		double N = StdIn.readDouble();
		ImageEditing.morph(ImageEditing.read(sourceFile),
				ImageEditing.greyScale(ImageEditing.read(sourceFile)), N);
	}
}
