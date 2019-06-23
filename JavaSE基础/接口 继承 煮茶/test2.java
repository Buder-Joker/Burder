package project1;
/*利用接口做参数，写个计算器，能完成加减乘除运算。 
（1）定义一个接口Compute含有一个方法int computer(int n, int m)。 
（2）设计四个类分别实现此接口，完成加减乘除运算。 
（3）设计一个类UseCompute，类中含有方法：public void useCom(Compute com, int one, int two)，此方法能够用传递
   过来的对象调用computer方法完成运算，并输出运算的结果。 
（4）设计一个主类Test，调用UseCompute中的方法useCom来完成加减乘除运算。 
 * */
 
interface Computer{
	public int computer(int m,int n);
}
class Add implements Computer{
	public int computer(int m,int n) {
		return m+n;
	}
}
class Sub implements Computer{
	public int computer(int m,int n) {
		return m-n;
	}
}
class Mul implements Computer{
	public int computer(int m,int n) {
		return m*n;
	}
}
class Div implements Computer{
	public int computer(int m,int n) {
		return m/n;
	}
}
class UseCompute{
	public double useCom(Computer com, int one, int two) {
		return com.computer(one, two);
	}
}
public class test2 {

	public static void main(String[] args) {
		Computer A = new Add();
		Computer S = new Sub();
		Computer M = new Mul();
		Computer D = new Div();
		//double ans = new UseCompute().useCom(S, 1, 2);
		//System.out.println(ans);
		UseCompute use = new UseCompute();
		System.out.println(use.useCom(A,4,2));
		System.out.println(use.useCom(S,4,2));
		System.out.println(use.useCom(M,4,2));
		System.out.println(use.useCom(D,4,2));
	}
}
