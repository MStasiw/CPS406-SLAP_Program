/**
 * 
 */
package slap;
import javax.swing.JFrame;


/**
 * @author Michael
 *
 */
@SuppressWarnings("serial")
public class Main extends JFrame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Sample (Test) Accounts with credentials for purpose of demoing
		Account testStudent = new Student("Student1", "Test", "student", "student");
		Account testStaff = new Instructor("Instructor1", "Test", "instructor", "instructor");
		Account testAdmin = new Administrator("Administrator1", "Test", "admin", "admin");
		
		String[] infos = {testStudent.getUsername(), testStudent.getPsw(), testStaff.getUsername(), testStaff.getPsw(),testAdmin.getUsername(), testAdmin.getPsw()};
		
		Login a = new Login(infos);
		a.execute();
		
	}
	


}
