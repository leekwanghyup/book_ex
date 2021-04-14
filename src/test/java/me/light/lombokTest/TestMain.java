package me.light.lombokTest;

public class TestMain {
	public static void main(String[] args) {
		Member member = new Member(); 
		member.setId("test id");
		member.setPassword("1234");
		member.setName("lee");
		System.out.println(member.toString());
	}
}
