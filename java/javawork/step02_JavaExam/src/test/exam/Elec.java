package test.exam;

public class Elec {
	
	private String code;
	private int cost;
	
	public Elec() {}
	
	public Elec(String code, int price) {
		this.code = code;
		this.cost = price;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int price) {
		this.cost = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("code=");
		builder.append(code);
		builder.append(", cost=");
		builder.append(cost);
		return builder.toString();
	}
	
	
	
}
