public class AnimalTester{

	public static void main(String args[]) {
		
		Animal a1 = new Animal();
		Animal a2 = new Animal("lion", "roar");
		Mammal m1 = new Mammal();
		Mammal m2 = new Mammal("Kangaroo", "chirp", 30);
		Bird b1 = new Bird();
		Bird b2 = new Bird(10, true, "eagle", "screech");
		Dog d1 = new Dog();
		Dog d2 = new Dog("chiuaua", "fido", "chiuaua", "yip yap", 60);


		a1.speak();
		a2.speak();
		m1.speak();
		m2.speak();

		d1.speak();
		d1.fetch();
		d2.speak();
		d2.fetch();

		System.out.println("a1: " + a1);
		System.out.println("a2: " + a2);
		System.out.println("m1: " + m1);
		System.out.println("m2: " + m2);
		System.out.println("b1: " + b1);
		System.out.println("b2: " + b2);
		System.out.println("d1: " + d1);
		System.out.println("d2: " + d2);

	}
}