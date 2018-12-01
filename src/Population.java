import java.util.Random;

public class Population {
	public static final int POPULATION_SIZE = 100;
	private static final int SELECTION_SIZE = 8;
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
			//System.out.println("Wal");
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
		Individual[] sample = new Individual[8];
		int[] selected = new int[8];
		Random rand = new Random();
		int index = rand.nextInt(POPULATION_SIZE);
		int sampleCount = 0;
		
		while(sampleCount < 8) {
			if(!intInArray(index, selected)) {
				sample[sampleCount] = individuals[index];
				sampleCount++;
			}
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