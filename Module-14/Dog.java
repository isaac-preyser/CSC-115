public class Dog extends Mammal{
    private String breed;
    private String name;

    public Dog(){
        super("dog", "bark", 60); //no matter what, we have a dog. 
        breed = "unknown breed";
        name = "unknown name";
        System.out.println("dog constructor (0 parameters)");
    }

    public Dog(String breed, String name, String species, String sound, int gestationPeriod){
        super(species, sound, gestationPeriod);
        this.breed = breed;
        this.name = name;
        System.out.println("dog constructor (5 parameters)");
    }

    public void fetch(){
        System.out.println("I am a "+ super.species +" and I can fetch");
    }

    public String toString(){
        String s = "breed: " + breed + ", ";
        s += "name: " + name + ", ";
        s += super.toString();
        return s;
    }

    public void speak(){
        System.out.println("My name is "+ name + " and ");
        super.speak();
    }
}
