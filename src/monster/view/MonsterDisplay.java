package monster.view;
//had to import javax
import javax.swing.JOptionPane;


public class MonsterDisplay
{
//this let us make popup windows
	public void displayText(String textToDisplay)
	{
		JOptionPane.showMessageDialog(null, textToDisplay);
	}


		public String getResponse(String questionAsked)
		{
			String response = "";
			
			response += JOptionPane.showInputDialog(null, questionAsked);
			
			return response;
			
		}
}

