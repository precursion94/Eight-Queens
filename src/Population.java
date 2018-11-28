import java.util.Random;

public class Population {
	public static final int POPULATION_SIZE = 100;
	private static final int SELECTION_SIZE = 8;
	private static Individual[] individuals = new Individual[POPULATION_SIZE];
	
	Population(Individual[] individuals) {
		this.individuals = individuals;
	}
	
	public static double averageFitness() {
		int fitnessSum = 0;
		double average;
		
		for (Individual individual : individuals) {
			fitnessSum = fitnessSum + individual.getFitness();
		}
		
		average = fitnessSum / POPULATION_SIZE;
		
		return average;
	}
	
	public static Individual selectIndividual() {
		Random rand = new Random();
		
		return individuals[rand.nextInt(POPULATION_SIZE)];
	}
	
	public static Individual getFittest() {
		Individual leader = null;
		for (Individual individual : individuals) {
			if((leader.getFitness() < individual.getFitness()) || (leader == null) ) {
				leader = individual;
			}
		}
		
		return leader;
	}
}
