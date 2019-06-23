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
		System.out.println("把水烧开");
	}
	void caffeineIncup() {
		System.out.println("把饮料倒进杯子");
	}
	boolean customerWant() {
		return true;
	}
}
class Tea extends caffeineDrink{
	void brew() {
		System.out.println("用热水泡茶");
	}
	void addsomething() {
		System.out.println("加入柠檬 ");
	}
}
class Coffee extends caffeineDrink{
	void brew() {
		System.out.println("用热水泡咖啡");
	}
	void addsomething() {
		System.out.println("加入牛奶或糖 ");
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
	System.out.println("是否加入糖或牛奶");
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
		//System.out.println("我要喝茶");
		//tea.prepareRecipe();
		System.out.println("我要喝咖啡");
		coffee.prepareRecipe();
	}
 }

