import java.util.ArrayList;

interface Human {

	public void eat();

	public void walk();

	public void pee();

}

class King implements Human {

	public void eat() {
		System.out.println("The King eats.");
	}

	public void walk() {
		System.out.println("The King walks.");
	}

	public void pee() {
		System.out.println("The King urinates.");
	}
}

class Society {

	public ArrayList<Human> humans;

	public Society() {

		this.humans = new ArrayList<Human>();

	}

	public void addHuman(Human h) {
		this.humans.add(h);
	}

	public int getPopulation() {
		return this.humans.size();
	}

	public void everyoneWalks() {
		for (Human h : this.humans) {
			h.walk();
		}
	}

}

class Number {

	int n;

	public Number(int n) {
		this.n = n;
	}

	public int getN() {
		return this.n;
	}

	public void setN(int n) {
		this.n = n;
	}

}

class Operations {

	Number a;
	Number b;

	public Operations(Number a, Number b) {
		this.a = a;
		this.b = b;
	}

	public int sum() {
		return this.a.getN() + this.b.getN();
	}

	public int minus() {
		return this.a.getN() - this.b.getN();
	}

}

public class Main {

	public static void main(String[] args) {

		Number n1 = new Number(10);
		Number n2 = new Number(7);

		Operations op = new Operations(n1, n2);

		System.out.println(op.sum());
		System.out.println(op.minus());
		
		Human h1 = new King();
		Human h2 = new King();
		Society s = new Society();
		s.addHuman(h1);
		s.addHuman(h2);
		s.everyoneWalks();

	}

}
