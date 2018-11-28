
public class Individual {
	private int[] coords;
	private int fitness;
	private int number;
	
	Individual(int number, int[] coords){
		this.coords = coords;
		this.number = number;
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
}
