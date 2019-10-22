package ch07object2;

public class InterfaceImplFacFor implements InterfaceExcute {

	@Override
	public void excute() {
		// TODO Auto-generated method stub
		// 5!
		int result = 1;
		for(int i = 5; i >=1; i--)
			result *=i;
		System.out.println(result);
	}

}
