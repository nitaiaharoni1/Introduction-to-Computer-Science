/*

Assignment number   :   5.4

File Name           :   Morph 

Name                :   Nitai Aharoni

Student ID          :   203626742

Email               :   Nitai.Aharoni@post.idc.ac.il

*/

public class Morph {

	public static void main(String[] args) {
		String sourceFile = StdIn.readString();
		String targetFile = StdIn.readString();
		double N = StdIn.readDouble();
		int height = ImageEditing.read(sourceFile).length;
		int width = ImageEditing.read(sourceFile)[0].length;
		ImageEditing.morph(ImageEditing.scale(ImageEditing.read(targetFile),
				width, height), ImageEditing.read(sourceFile), N);
	}
}
