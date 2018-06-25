
public class Queue_Node {
	private String value;
	private double bit;
	private int chance;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public double getBit() {
		return bit;
	}

	public void setBit(double bit) {
		this.bit = bit;
	}
	
	public int getChance() {
		return chance;
	}

	public void setChance(int chance) {
		this.chance = chance;
	}


	public Queue_Node(String value, double bit,int chance) {
		this.value = value;
		this.bit = bit;
	}

	
	

}
