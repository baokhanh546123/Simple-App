package LTGD;
import java.util.*;
public class Number {
	int people , machine ; 
	public Number() {
		this.machine = generate();
	}
	
	public int input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input a number");
		people = sc.nextInt();
		return people;
	}
	
	public int generate() {
		Random rand = new Random();
		return rand.nextInt(101);
	}
	
	public void guess() {
		int count = 0 ;
		if (people == machine) {
			System.out.println("True");
			return;
		}else {
			
			System.out.println("False");
			while (count < 5) {
				input();
				count += 1 ;
				if (people == machine) {
					System.out.println("True");
					return;
				}else {
	                System.out.println("False! Attempts left: " + (5 - count));
	            }
			}
			System.out.println("Game Over");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Number n = new Number();
        n.input();
        n.guess();
		
	}

}
