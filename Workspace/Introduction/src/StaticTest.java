
class StaticClass{
	
	public static int a = 0;
	
	public static void load(){
		a = 1;
	}
	
}

public class StaticTest {

	public StaticTest() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		System.out.println(StaticClass.a);
		StaticClass.load();
		System.out.println(StaticClass.a);
	}

}
