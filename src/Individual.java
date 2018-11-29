import java.util.Random;

public class Individual {
	private Random rand = new Random();
	private final int mutationRate = 50;
	private int[] coords;
	private int fitness;
	private int number;
	
	Individual(int number, int[] coords){
		this.coords = coords;
		this.number = number;
		//assign fitness metric
	}
	
	public void mutate() {
		int randomIndex = rand.nextInt(8);
		int randomValue = rand.nextInt(8);
		
		while(randomValue == coords[randomIndex]) {
			randomValue = rand.nextInt(8);
		}
		
		coords[randomIndex] = randomValue;
	}
	
	public void mutationRoulette() {
		if (rand.nextInt(100) < mutationRate) {
			mutate();
		}
	}
	
	public int[] getCoords() {
		return coords;
	}
	
	public int getFitness() {
		return fitness;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	private String arrayToString(int[] coords) {
		String coordString = "";
		
		for(int i : coords) {
			coordString = coordString + i;
		}
		
		return coordString;
	}
}
