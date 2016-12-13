package pac09;

public class Fish extends Pet{
	private int dive;

	public Fish(String name, int age, String nick, int dive) {
		super(name, age, nick);
		this.dive = dive;
	}

	public int getDive() {
		return dive;
	}

	public void setDive(int dive) {
		this.dive = dive;
	}

	@Override
	public String toString() {
		return "Fish [dive=" + dive + "]";
	}
	

}
