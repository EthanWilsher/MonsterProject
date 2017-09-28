package monster.holder;
//we had to import stuff from our different classes to use them in this class
import monster.model.MarshmallowMonster;
import java.util.Scanner;
import monster.view.MonsterDisplay;
import java.util.List;
import java.util.ArrayList;

public class MonsterController
{

	private MonsterDisplay popup;
	private List<MarshmallowMonster> monsterList;

	public MonsterController()
	{
		popup = new MonsterDisplay();
		monsterList = new ArrayList<MarshmallowMonster>();
	}

	public void start()
	{
		boolean finished = true;
		int count = 0;
//		while(count < 100)
//		{
//			popup.displayText("I am so neat!" + count);
//			count += 1;
//		}
		
//		for(int loop = 0; loop < 15; loop += 1)
//		{
//			popup.displayText("I am looping " + (loop + 1 ) + " times out of 15");
//		}
		MarshmallowMonster sample = new MarshmallowMonster();
		// System.out.println(sample);
		popup.displayText(sample.toString());
		MarshmallowMonster realMonster = new MarshmallowMonster("Ricardo", 8, 6, 6.7, true);

		// System.out.println(realMonster);
		popup.displayText(realMonster.toString());
		// System.out.println("Ethan is hungry, so he is going to eat some tentacles");
		popup.displayText("Ethan is hungry so he is going to eat some tentacles");
		realMonster.setTentacleAmount(2.2);
		// System.out.println(realMonster);
		popup.displayText(realMonster.toString());
		interactWithTheMonster(realMonster);
		
		monsterList.add(realMonster);
		monsterList.add(sample);
		testList();

	}

	private void testList()
	{
		for(int index = 0; index < monsterList.size(); index++)
		{
			MarshmallowMonster currentMonster = monsterList.get(index);
			popup.displayText(currentMonster.getName());
			
		}
	}
	
	private void interactWithTheMonster(MarshmallowMonster currentMonster)
	{
		// System.out.println(currentMonster.getName() + "wants to know what to eat next");
		// System.out.println(currentMonster.getName() + " suggests arms, they have" +
		// currentMonster.getArmCount());
		// System.out.println("How many do you want to eat?");
		popup.displayText(currentMonster.getName() + " wants to know what to eat next");
		popup.displayText(currentMonster.getName() + " suggests arms, they have " + currentMonster.getArmCount());
		popup.getResponse("How many do you want to eat?");
		int specialAnswer = 0;
		String unconverted = popup.getResponse("How many do you want to eat?");

		while(!isValidInteger(unconverted))
		{
			popup.displayText("Try again!");
			unconverted = popup.getResponse("How many arms???");
		}
		
//		if (isValidInteger(unconverted))
//		{
//			specialAnswer = Integer.parseInt(unconverted);
//		}
		
		
		
		Scanner myScanner = new Scanner(System.in);
		int consumed = 0;
//		String answerNumber = popup.getResponse("Q to ask");
//		while(!isValidDouble(answerNumber))
//		{
////			answerNumber = popup.getResponse("you must type in a double.");
////		}
////		double validNumber = Double.parseDouble(answerNumber);
		consumed = specialAnswer;
		
		
		if (consumed < 0)
		{
			// System.out.println("You cannot eat a negative amount silly human.");
			popup.displayText("You cannot eat a negative amount silly human.");
			consumed = 0;
		}
		else if (consumed == 0)
		{
			// System.out.println("Not that hungry are you?");
			popup.displayText("Not that hungry are you?");
		}
		else if (consumed > currentMonster.getArmCount())
		{
			// System.out.println("That is impossible - I only have " + currentMonster.getArmCount() + "
			// arms!!!");
			popup.displayText("That is impossible - I only have " + currentMonster.getArmCount() + " arms!!!");
		}
		else
		{
			currentMonster.setArmCount(currentMonster.getArmCount() - consumed);
			// System.out.println("Thank you so much! I only have this many arms now: " +
			// currentMonster.getArmCount());
			popup.displayText("Thank you so much! I only have this many arms now: " + currentMonster.getArmCount());
		}

		System.out.println(currentMonster.getName() + "wants to know what to eat next");
		System.out.println(currentMonster.getName() + " suggests eyes, he has " + currentMonster.getEyeCount());
		System.out.println("How many eyes do you want to eat?");
		Scanner eyeScanner = new Scanner(System.in);
		int consumedEyes = eyeScanner.nextInt();

		if (consumedEyes < 0)
		{
			System.out.println("You cannot eat more than i have you fool!");
			consumed = 0;
		}
		else if (consumedEyes == 0)
		{
			System.out.println("Fine.. I didn't want to be eaten anyway :'(");
		}
		else if (consumedEyes > currentMonster.getEyeCount())
		{
			System.out.println("Boi you really trying to do that I only have " + currentMonster.getArmCount() + " eyes!");
		}
		else
		{
			currentMonster.setEyeCount(currentMonster.getArmCount() - consumedEyes);
			System.out.println(" Dude you the best i love that you ate my eyes now i have " + currentMonster.getArmCount() + " left.");
		}

		popup.displayText("hey look at me heheheheheheheheheheh!!!!");
		String answer = popup.getResponse("Hey how many meals are you eating today");
		System.out.println(answer);
		popup.displayText(answer);
	}

	// Helper methods
	private boolean isValidInteger(String sample)
	{
		boolean valid = false;
		
		try
		{
			Integer.parseInt(sample);
			valid = true;
		}
		//the catch stops the program from freaking out when something doesn't go right.
		catch (NumberFormatException error)
		{
			popup.displayText("Only integer values are valid: " + sample + " is not");
		}

		return valid;
	}
	
	private boolean isValidDouble(String sampleDouble)
	{
		boolean valid = false;
		
		try
		{
			Double.parseDouble(sampleDouble);
			valid = true;	
		}
		catch (NumberFormatException error)
		{
			popup.displayText("only double values are valid: " + sampleDouble + " is not.");
		}
		return valid;
	}
	
	private boolean isValidBoolean(String sampleBoolean)
	{
		boolean valid = false;
		
		try
		{
			Boolean.parseBoolean(sampleBoolean);
			valid = true;
		}
		catch (NumberFormatException error)
		{
			popup.displayText("only boolean values are valid: " + sampleBoolean + " is not.");
		}
		return valid;
	}
	
}
