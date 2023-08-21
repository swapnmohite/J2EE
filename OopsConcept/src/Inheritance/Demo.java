package Inheritance;

class Demo {
	void eat() 
	{
		System.out.println("I am Eating Mango");
	}
}
class Test extends Demo{
	public static void main(String[] args) {
		Demo d= new Demo();
		d.eat();
	}
}