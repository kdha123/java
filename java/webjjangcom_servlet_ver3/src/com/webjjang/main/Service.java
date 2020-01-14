/*
 * Service 객체를 실행하기 위해서 만들어 놓은 인터페이스
 * 모든 Service 객체들은 이 인터페이스를 반드시 상속 받아야만 한다. 
 */
package com.webjjang.main;



public interface Service {

	public Object service(Object[] objs) throws Exception;
}
