package core09a;

public class Guitar extends Instrument {
int age;






public Guitar(int weight, String type, int age) {
	super(weight, type);
	this.age = age;
}



public int getAge() {
	return age;
}



public void setAge(int age) {
	this.age = age;
}



public void play(){
	System.out.println("Guitar Play");
}

}
