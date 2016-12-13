package core09a;

public class Instrument {
	private int weight;
	private String Type;
	@Override
	public String toString() {
		return "Instrument [weight=" + weight + ", Type=" + Type + "]";
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	
	
	public Instrument(int weight, String type) {
		super();
		this.weight = weight;
		Type = type;
	}
	
	public void play(){
		System.out.println("Play");
	}
	
	
}
