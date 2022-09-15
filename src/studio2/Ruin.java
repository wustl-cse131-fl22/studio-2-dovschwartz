package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Start Amount: ");
		double startAmount = in.nextDouble();
		System.out.println("Win Chance: ");
		double winChance=in.nextDouble();
		System.out.println("Win Limit: ");
		double winLimit = in.nextDouble();
		System.out.println("Total Simulations: ");
		int totalSimulations= in.nextInt();
		double totalMoney=startAmount;
		int innerCount=0;
		int winCount=0;
		int loseCount=0;
		int simulationsCount=0;
		while(simulationsCount<totalSimulations) {
			while((totalMoney < winLimit) && (totalMoney>0)) {
				double diceRoll=(double) (Math.random())*2;
				if (diceRoll>=winChance)
				{
					totalMoney++;
					//System.out.println("Win. Total Money " + totalMoney);
				}
				else
				{
					totalMoney--;
					//System.out.println("Loss: Total Money " + totalMoney);
				}
				innerCount++;
					//System.out.println("Count: "+innerCount);
				}
				if(totalMoney==winLimit)
				{
					winCount++;
					System.out.println("Simulation "+(simulationsCount+1)+": "+innerCount + " WIN");
					innerCount=0;
					totalMoney=startAmount;
				}
				else
				{
					loseCount++;
					System.out.println("Simulation "+(simulationsCount+1)+": "+innerCount + " LOSS");
					innerCount=0;
					totalMoney=startAmount;
				}
				simulationsCount++;
			
		
		}
		System.out.println("Losses: "+ loseCount + " Simulations: "+ totalSimulations);
		double ruinRate=(double)loseCount/totalSimulations;
		double expectedRuin=0;
		double alpha = (1-winChance)/(winChance);
		if (winChance==0.5)
		{
			expectedRuin=(1-((double)startAmount/winLimit));
		}
		else
		{
			expectedRuin=(Math.pow(alpha,startAmount)-Math.pow(alpha,winLimit))/(1-Math.pow(alpha, winLimit));
		}
		System.out.print("Ruin Rate from Simulation: "+ruinRate + " ");
		System.out.print("Expected Ruin Rate: " + expectedRuin);
	}

}
