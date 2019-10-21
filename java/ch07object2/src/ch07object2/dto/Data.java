package ch07object2.dto;

public class Data {

	public int pubInt;
	protected int proInt;
	int defInt;
	private int priInt;
	
	@Override
	public String toString() {
		return "Data [pubInt=" + pubInt + ", proInt=" + proInt + ", defInt=" + defInt + ", priInt=" + priInt + "]";
	}
	
}
