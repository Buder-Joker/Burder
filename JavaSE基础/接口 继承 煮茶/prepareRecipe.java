package project1;
import java.util.Scanner;
abstract class caffeineDrink{
	final void prepareRecipe() {
		boilWater();
		brew();
		caffeineIncup();
		if(customerWant()) {
			addsomething();
		}
	}
	abstract void brew();
	abstract void addsomething();
	void boilWater() {
		System.out.println("��ˮ�տ�");
	}
	void caffeineIncup() {
		System.out.println("�����ϵ�������");
	}
	boolean customerWant() {
		return true;
	}
}
class Tea extends caffeineDrink{
	void brew() {
		System.out.println("����ˮ�ݲ�");
	}
	void addsomething() {
		System.out.println("�������� ");
	}
}
class Coffee extends caffeineDrink{
	void brew() {
		System.out.println("����ˮ�ݿ���");
	}
	void addsomething() {
		System.out.println("����ţ�̻��� ");
	}
public boolean customerWant() {
	String answer = UersInput();
	if(answer.equals("yes")) {
		return true;
	}
	else {
		return false;
	}
}
private String UersInput() {
	
	String answer = null;
	System.out.println("�Ƿ�����ǻ�ţ��");
	Scanner scanner = new Scanner(System.in);
	answer = scanner.nextLine();
	scanner.close();
	return answer;
 }
}
public class prepareRecipe {
	public static void main(String[] args) {
		//caffeineDrink tea = new Tea();
		caffeineDrink coffee = new Coffee();
		//System.out.println("��Ҫ�Ȳ�");
		//tea.prepareRecipe();
		System.out.println("��Ҫ�ȿ���");
		coffee.prepareRecipe();
	}
 }

