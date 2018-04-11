/*

Assignment number   :   5.3

File Name           :   Editor2 

Name                :   Nitai Aharoni

Student ID          :   203626742

Email               :   Nitai.Aharoni@post.idc.ac.il

*/

public class Editor2 {

	/**
	 * scales a given matrix from a ppm file to a new width and height
	 * 		and shows the scaled image
	 */
	public static void main(String[] args) {
		String file = StdIn.readString();
		int width = StdIn.readInt();
		int height = StdIn.readInt();
		ImageEditing.show(ImageEditing.scale(ImageEditing.read(file),
				width, height));
		}
	
	}
