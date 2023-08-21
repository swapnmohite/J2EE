package Polymerphism;

public class constructorOverloading {
	constructorOverloading()
	{
		System.out.println("constructorOverloading()");
	}
	constructorOverloading(int a)
	{
		System.out.println("constructorOverloading(int)");
	}
 public static void main(String[] args) {
	 constructorOverloading co =  new constructorOverloading(2);
}
}
