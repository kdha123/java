package ch07object2;

public class InterfaceImplFacRecall implements InterfaceExcute {

	@Override
	public void excute() {
		// TODO Auto-generated method stub
		// 5!
		int result = factorial(5);
		System.out.println(result);
	}

	
	public int factorial(int n) {
		if(n==1) return 1;
		return n * factorial(n-1);
	}
}
