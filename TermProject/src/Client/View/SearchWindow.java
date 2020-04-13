package Client.View;
//
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SearchWindow extends JFrame implements Standardization{
	private JLabel studentName, studentID;
	private JLabel subTitleLabel = new JLabel("Search Window");
	private JButton searchB = new JButton("Search");
	private JButton viewB = new JButton("View All Courses");
	private JButton backB = new JButton("Back To Main Menu");
	private JPanel north = new JPanel();
	private JPanel center = new JPanel();
	private JPanel south = new JPanel();
	
	public SearchWindow() {
		super("Search Window");
		setSize(500,500);
		setTitle("Search Window");
		setLayout(new BorderLayout());
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.setBackground(Color.red);
		south.setBackground(Color.red);
		titleLabel.setFont(titleFont);
		subTitleLabel.setFont(subTitleFont);
		searchB.setFont(buttonFont);
		searchB.setBackground(Color.white);
		viewB.setFont(buttonFont);
		viewB.setBackground(Color.white);
		backB.setFont(buttonFont);
		backB.setBackground(Color.white);
		getStudentInfo();
		north.add(titleLabel);
		north.add(subTitleLabel);
		north.add(studentName);
		north.add(studentID);
		
		south.add(searchB);
		south.add(viewB);
		south.add(backB);
		
		add("North", north);
		add("South", south);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addSearchListener(ActionListener listener) {
		searchB.addActionListener(listener);
	}
	
	public void addViewListener(ActionListener listener) {
		viewB.addActionListener(listener);
	}
	
	public void addBackListener(ActionListener listener) {
		backB.addActionListener(listener);
	}
	
	public String [] getCourse() {
		String input ="";
		String [] course;
		while (true) {
			input = JOptionPane.showInputDialog("Please enter the course you would like to add");
			course = input.split(" ");
			if (course[0].length()==4 && course[1].length()==3) {
				break;
			}
			displayMessage("Error. Invalid format. Enter your choice as a 4-letter word followed by the 3-digit number.");
		}
		
		return course;
	}
	
	public void displayMessage(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	
	public void getStudentInfo() {
		//method to get student's name
		//get student's name from controller?
		String name = "Name: Student's Name";
		studentName = new JLabel(name);
		studentName.setFont(studentFont);
		//get student's ID from controller?
		String id = "ID: 000000";
		studentID = new JLabel(id);
		studentID.setFont(studentFont);
	}
	
	public static void main (String []args) {
		SearchWindow search = new SearchWindow();
		search.setVisible(true);
	}
}
