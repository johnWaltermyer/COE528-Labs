package lab1;

/**
 * @author ur_dad
 */
public class NonMember extends Passenger {
    public NonMember(String name, int age) {
        super(name, age);
    }

    @Override
    public double applyDiscount(double p) {
        if (this.getAge() > 65) {
            return (p*0.9);
        }
        return p;
    }
    
    @Override
    public String toString(){
        return "NonMember: " + this.getName()+", "+this.getAge();
    }
}