/*

Assignment number   :   5.2

File Name           :   Editor1 

Name                :   Nitai Aharoni

Student ID          :   203626742

Email               :   Nitai.Aharoni@post.idc.ac.il

*/

public class Editor1 {

	/**
	 * applies a given method (horizontal flip, vertical flip or grey scale)
	 * 		on a given ppm file and shows it as an image
	 */
	public static void main(String[] args) {
		String file = StdIn.readString();
		String func = StdIn.readString();
		switch (func){
		case "fh":
			ImageEditing.show(ImageEditing.flipHorizontally
					(ImageEditing.read(file)));
			break;
		case "fv":
			ImageEditing.show(ImageEditing.flipVertically
					(ImageEditing.read(file)));
			break;
		case "gr":
			ImageEditing.show(ImageEditing.greyScale
					(ImageEditing.read(file)));
			break;
		}
	}

}
