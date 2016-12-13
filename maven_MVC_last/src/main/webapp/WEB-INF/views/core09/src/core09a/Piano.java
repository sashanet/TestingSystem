package core09a;

public class Piano extends Instrument {
	private int age;

	public Piano(int weight, String type, int age) {
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
		return "Piano [age=" + age + "]";
	}
	
	public void play(){
		System.out.println("Piano Play");
	}
	
}
