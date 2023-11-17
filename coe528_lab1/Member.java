package lab1;

/**
 * @author ur_dad
 */
public class Member extends Passenger {
    private int yearsOfMembership;

    public Member(String name, int age, int yearsOfMembership) {
        super(name, age);
        this.yearsOfMembership = yearsOfMembership;
    }

    public int getYearsOfMembership() {
        return yearsOfMembership;
    }

    public void setYearsOfMembership(int yearsOfMembership) {
        this.yearsOfMembership = yearsOfMembership;
    }

    @Override
    public double applyDiscount(double p) {
        if (yearsOfMembership > 5) {
            return (p*0.5);
        } else if (yearsOfMembership > 1) {
            return (p*0.9);
        } else {
            return p;
        }
    }
    
    @Override
    public String toString(){
        return "Member for " + yearsOfMembership + " year" + ((yearsOfMembership>1)?"s: ":": ") + this.getName()+", "+this.getAge();
    }
}