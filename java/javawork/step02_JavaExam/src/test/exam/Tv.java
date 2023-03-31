package test.exam;

public class Tv extends Elec implements ElecFunction {

	private int channel;
	
	public Tv() {}
	
	public Tv(int channel) {
		this.channel = channel;
	}
	
	public Tv(String code, int cost, int channel) {
		super(code, cost);
		this.channel = channel;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println(super.getCode()+"제품 "+ getClass().getSimpleName()+"를 " + channel + "을 본다");
	}
	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(", channel=");
		builder.append(channel);
		builder.append("]");
		return builder.toString();
	}

	
}

