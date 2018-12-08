import java.util.Random;

public class Population {
	public static final int POPULATION_SIZE = 100;
	private static final int SELECTION_SIZE = 20;
	public static Individual[] individuals = new Individual[POPULATION_SIZE];
	
	Population() {
		
	}
	
	Population(Individual[] individuals) {
		this.individuals = individuals;
	}
	
	public double averageFitness() {
		double fitnessSum = 0.00;
		double average;
		
		for (Individual individual : individuals) {
			fitnessSum = fitnessSum + individual.getFitness();
		}
		
		average = fitnessSum / POPULATION_SIZE;
		
		return average;
	}
	
	public Individual selectIndividual() {
		Random rand = new Random();
		
		return individuals[rand.nextInt(POPULATION_SIZE)];
	}
	
	public Individual getFittest() {
		Individual[] sample = sampleIndividuals();
		
		Individual leader = sample[0];
		for (Individual individual : sample) {
			if((leader.getFitness() > individual.getFitness())) {
				leader = individual;
			}
		}
		
		return leader;
	}
	
	public void emptyPopulation() {		
		individuals = null;
	}
	
	public Individual copyIndividual(Individual individual) {
		int[] coords = individual.getCoords().clone();
		Individual copy = new Individual(0, coords);
		
		return copy;
	}
	
	public Individual[] sampleIndividuals() {
		Individual[] sample = new Individual[SELECTION_SIZE];
		Random random = new Random();
		
		for(int i = 0; i < SELECTION_SIZE; i++) {
			sample[i] = individuals[random.nextInt(POPULATION_SIZE)];
		}

		return sample;
	}
	
	public boolean intInArray(int check, int[] intArray) {
		boolean contained = false;
		
		for(int i : intArray) {
			if(check == i) {
				contained = true;
			}
		}
		
		return contained;
	}
}