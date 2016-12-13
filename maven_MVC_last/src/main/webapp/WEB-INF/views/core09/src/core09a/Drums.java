package core09a;

public class Drums extends Instrument {
	private int age;

	public Drums(int weight, String type, int age) {
		super(weight, type);
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Drums [age=" + age + "]";
	}
	
}
