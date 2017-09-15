package monster.holder;

import monster.model.MarshmallowMonster;
import java.util.Scanner;


public class MonsterController
{
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
		currentMonster.setArmCount(currentMonster.getArmCount()- consumed);
		System.out.println("Ok, now " + currentMonster.getName() + "has" + currentMonster.getArmCount() + "arms left.");
		
		
	}
}
