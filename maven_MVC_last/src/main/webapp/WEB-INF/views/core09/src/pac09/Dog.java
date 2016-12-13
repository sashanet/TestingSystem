package pac09;

public class Dog extends Pet {
	
	private boolean bite;

	public Dog(String name, int age, String nick, boolean bite) {
		super(name, age, nick);
		this.bite = bite;
	}

	public boolean getBite() {
		return bite;
	}

	public void setBite(boolean bite) {
		this.bite = bite;
	}

	@Override
	public String toString() {
		return "Dog [bite=" + bite + "]";
	};
	
	
	public void voice(){
		System.out.println("hav hav hav");
	}

}
