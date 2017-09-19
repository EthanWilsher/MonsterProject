package monster.holder;

import monster.model.MarshmallowMonster;
import java.util.Scanner;
import monster.view.MonsterDisplay;
public class MonsterController
{
	
	private MonsterDisplay popup;
	
	public MonsterController()
	{
		popup = new MonsterDisplay();
	}
	
	
	public void start()
	{
		MarshmallowMonster sample = new MarshmallowMonster();
		System.out.println(sample);
		MarshmallowMonster realMonster = new MarshmallowMonster("Ricardo", 8, 6, 6.7, true);

		System.out.println(realMonster);
		System.out.println("Ethan is hungry, so he is going to eat the bloop excistence");
		realMonster.setTentacleAmount(2.2);
		System.out.println(realMonster);

		interactWithTheMonster(realMonster);

	}

	private void interactWithTheMonster(MarshmallowMonster currentMonster)
	{
		System.out.println(currentMonster.getName() + "wants to know what to eat next");
		System.out.println(currentMonster.getName() + " suggests arms, they have" + currentMonster.getArmCount());
		System.out.println("How many do you want to eat?");
		Scanner myScanner = new Scanner(System.in);
		int consumed = myScanner.nextInt();

		if (consumed < 0)
		{
			System.out.println("You cannot eat a negative amount silly human.");
			consumed = 0;
		}
		else if (consumed == 0)
		{
			System.out.println("Not that hungry are you?");
		}
		else if (consumed > currentMonster.getArmCount())
		{
			System.out.println("That is impossible - I only have " + currentMonster.getArmCount() + " arms!!!");
		}
		else
		{
			currentMonster.setArmCount(currentMonster.getArmCount() - consumed);
			System.out.println("Thank you so much! I only have this many arms now: " + currentMonster.getArmCount());
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
	}

}
