import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

//For piano scenarios all over the code with their own displayed picture
public class Scenario {
	private String name;
	private File imageFile;
	private BufferedImage image;
	private double recordScore; //default 0.0
	private double passingScore;
	private JFrame lessonDisplay;
	//TODO: Future Classes to hold actual lesson scoring rubric
	//currently working on LessonBoard class
	//Other settings go here
	
	public Scenario(String name, double pScore, String imgFile) {
		this.name = name;
		this.passingScore = pScore;
		this.recordScore = 0.0;
		this.imageFile = new File(imgFile);
		this.image = null;
		
	}
	
	//Getters
	//..
	public File getImageFile() {
		return this.imageFile;
	}
	//Don't use yet
	public Image getImage() {
		return this.image;
	}
	public String getScenarioName() {
		return this.name;
	}
	public double getCurrentScore() {
		return this.recordScore;
	}
	public double getRequiredScore() {
		return this.passingScore;
	}
	//End of getters
	
	public void initializeImage() {
		try {
			this.image = ImageIO.read(this.imageFile);
		}
		catch(FileNotFoundException ex) {
			System.out.println("Image file has been removed");
		}
		catch(IOException ex) {
			System.out.println("IO Error");
		}
		catch(NullPointerException ex) {
			System.out.println("***Null Pointer Error");

		}
		
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(new JLabel(new ImageIcon(image)));
		frame.pack();
		this.lessonDisplay = frame;
	}
	
	//for testing purposes, display image file 
	public void displayImage() {
		this.lessonDisplay.setVisible(true);
	}
	//load data depending on menu options
	public void loadData() {
		
	}
	
	//future: score anaylsis
	public void submitScore(int sc){
		
	}
	
	public static void main(String[] args) {
		//System.out.println("Hiya");
		Scenario f = new Scenario("Scen1", 5.0, "notes.jpg" );
		f.initializeImage();
		f.displayImage();
	}
}





