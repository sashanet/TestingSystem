package core09a;

public class Instrumentalist {
	public void perfomance(Instrument instr ){
		
		instr.play();
		
		
	}
	
	public void performedAll(Instrument[] instruments){
 for (int i = 0; i < instruments.length; i++) {
	instruments[i].play();
}
	}
	
	
}
