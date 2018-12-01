import java.util.Random;
import java.util.Scanner;

public class Main {
	private static final int copyRate = 40;
	private static final int crossRate = 60;
	private static final int generations = 50;
	private static int arrayIndex;

	public static void main(String[] args) {
		/*
		Population test = initialPopulation();
		
		Population next = nextGeneration(test);
		for(int i = 0; i < 100; i++) {
			printIndividual(next.getFittest());
		}
		*/
		
		Population currentGeneration = initialPopulation();
		int generationCounter = 0;
		
		for(int i = 0; i < generations; i++) {
			System.out.println("Generation #" + generationCounter);
			printPopulation(currentGeneration);
			currentGeneration = nextGeneration(currentGeneration);
			generationCounter++;
		}
		
		
	}
	
	private static Individual getFittest(Population population) {
		Individual fittest = new Individual();
		int sampleSize = 10;
		int sampleCount = 0;
		
		while(sampleCount < sampleSize) {
			
		}
		
		return fittest;
	}
	
	/*Creates a random individual*/
	private static Individual randomIndividual() {
		Individual individual = new Individual(0, coords());
		return individual;
	}
	
	private static Population initialPopulation() {
		Individual[] individuals = new Individual[100];
		
		for(int i = 0; i < 100; i++) {
			individuals[i] = randomIndividual();
			individuals[i].setNumber(i+1);
		}
		
		Population initPop = new Population(individuals);
		
		return initPop;
	}
	
	private static Population nextGeneration(Population currentGeneration) {
		Population nextGeneration = new Population();
		
		nextGeneration = performCopies(currentGeneration, nextGeneration);
		nextGeneration = performCrossovers(currentGeneration, nextGeneration);
		
		return nextGeneration;
	}
	
	private static void performCrossover(Population source, Population target){
		/*potential reference/value problem*/
		/*modifying original population individual? does it even matter?*/
		Individual mother = source.getFittest();
		Individual father = source.getFittest();
		//System.out.print(arrayIndex);
		//System.out.print(" Mother: " + mother.getFitness());
		//System.out.print(" Father: " + father.getFitness());
		Individual crossed = new Individual(arrayIndex, crossover(mother.getCoords(), father.getCoords()));
		//System.out.println(" Crossed: " + crossed.getFitness());
		crossed.mutationRoulette();
		crossed.recalculateFitness();
		target.individuals[arrayIndex] = crossed;
		arrayIndex++;
	}
	
	private static Population performCrossovers(Population source, Population target) {
		for (int i = 0; i < crossRate; i++) {
			performCrossover(source, target);
		}
		
		return target;
	}
	
	/**/
	private static void performCopy(Population source, Population target) {
		/*potential reference/value problem*/
		/*modifying original population individual? does it even matter?*/
		Individual randomIndividual = source.getFittest();
		//System.out.print(arrayIndex);
		//System.out.print(" RandFit: " + randomIndividual.getFitness());
		Individual copy = new Individual(arrayIndex, randomIndividual.getCoords());
		//System.out.print(" Premutate: " + copy.getFitness());
		copy.mutationRoulette();
		//System.out.println(" CopyFit: " + copy.getFitness());
		
		target.individuals[arrayIndex] = copy;
		arrayIndex++;
	}
	
	/**/
	private static Population performCopies(Population source, Population target) {
		arrayIndex = 0;
		for (int i = 0; i < copyRate; i++){
			performCopy(source, target);
		}
		
		return target;
	}
	
	/*Cross Over*/	
	private static int[] crossover(int[] sourceOne, int[] sourceTwo) {
		Random rand = new Random();
		int[] crossOne = sourceOne.clone();
		int[] crossTwo = sourceTwo.clone();
		int[] crossed = new int[8];
		int splitPoint = rand.nextInt(7) + 1;
		
		for(int i = 0; i < 8; i++) {
			if(i < splitPoint) {
				crossed[i] = crossOne[i];
			}else {
				crossed[i] = crossTwo[i];
			}
		}
		
		return crossed;
	}
	
	/*Copies the input coords and modifies one piece position*/
	/*Returns copy*/
	/*Write mutation method on individual?*/
	private static int[] mutation(int[] source) {
		Random rand = new Random();
		int randomIndex = rand.nextInt(8);
		int randomValue = rand.nextInt(8);
		
		while(randomValue == source[randomIndex]) {
			randomValue = rand.nextInt(8);
		}
		
		int[] mutated = source.clone();
		mutated[randomIndex] = randomValue;
		
		return mutated;
	}

	/*Generate a set of coords*/
	private static int[] coords() {
		int[] coords = new int[8];
		Random rand = new Random();
		for ( int i = 0; i < 8; i++ ) {
			coords[i] = rand.nextInt(8);
		}
		
		return coords;
	}
	
	/*Generate a set of coords of length len*/
	private static int[] coords(int len) {
		int[] coords = new int[8];
		Random rand = new Random();
		for ( int i = 0; i < len; i++ ) {
			coords[i] = rand.nextInt(8);
		}
		
		return coords;
	}
	/*
	private static void printPopulation(Population population) {
		//Scanner scanner = new Scanner(System.in);
		//int woop;
		for (Individual individual : population.individuals) {
			printIndividual(individual);
			//if(individual.getFitness() == 0) {
			//	woop = scanner.nextInt();
			//}
		}
		System.out.println("Population Average Fitness: " + population.averageFitness() + "\n");
	}
	*/
	
	private static void printPopulation(Population population) {
		int winners = 0;
		for(Individual individual : population.individuals) {
			if(individual.getFitness() == 0) {
				winners++;
			}
		}
		System.out.println("\nAverage Fitness: " + population.averageFitness());
		System.out.println(winners + " winners.\n");
	}
	
	private static void printIndividual(Individual individual) {
		System.out.print("Individual #: " + individual.getNumber());
		System.out.print("  Fitness: " + individual.getFitness());
		System.out.print("  Coords: "); printIntArray(individual.getCoords());
	}
	
	private static void printIntArray(int[] input) {
		System.out.print("(");
		for (int i : input) {
			System.out.print(i);
		}
		System.out.println(")");
	}
}
