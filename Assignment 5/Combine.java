/*

Assignment number   :   5.5

File Name           :   Combine 

Name                :   Nitai Aharoni

Student ID          :   203626742

Email               :   Nitai.Aharoni@post.idc.ac.il

*/

public class Combine {

	public static void main(String[] args) {
		String file1 = StdIn.readString();
		String file2 = StdIn.readString();
		double alpha = StdIn.readDouble();
		int height = ImageEditing.read(file1).length;
		int width = ImageEditing.read(file1)[0].length;

		ImageEditing.show(ImageEditing.combine(ImageEditing.read(file1), 
				ImageEditing.scale(ImageEditing.read(file2), width, height),
					alpha));
		}
	
	}
