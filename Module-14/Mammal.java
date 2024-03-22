public class Mammal extends Animal {
    private int gestationPeriod; 
    
    public Mammal() {
        super();
        gestationPeriod = 0;
        System.out.println("mammal constructor (0 parameters)");
    } 

    public Mammal (int gPeriod){
        super();
        gestationPeriod = gPeriod;
        System.out.println("mammal constructor (1 parameters)");
    }

    public Mammal (String species, String sound, int gestationPeriod) {
        super(species, sound);
        this.gestationPeriod = gestationPeriod;
        System.out.println("mammal constructor (3 parameters)");
    }

    public String toString(){
        String s = "gestationPeriod: " +gestationPeriod+", ";
        s += super.toString(); 
        return s;
    }
}
