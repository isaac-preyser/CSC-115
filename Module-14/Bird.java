public class Bird extends Animal {
    private int wingspan; 
    private boolean canFly; 

    public Bird(){
        super();
        wingspan = -1;
        canFly = false;
        System.out.println("bird constructor (0 parameters)");
    }


    public Bird(int w, boolean c, String species, String sound) {   
        super(species, sound); //so super instantiates an object of the superclass, and we can pass in constructor parameters
        wingspan = w;
        canFly = c;
        System.out.println("bird constructor (4 parameters)");
    }

    public void fly() {
        if (canFly) {
            System.out.println("I am a "+ super.species +" and I can fly");
        } else {
            System.out.println("I cannot fly");
        }
    }
}