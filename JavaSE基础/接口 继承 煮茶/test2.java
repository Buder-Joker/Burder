package project1;
/*���ýӿ���������д��������������ɼӼ��˳����㡣 
��1������һ���ӿ�Compute����һ������int computer(int n, int m)�� 
��2������ĸ���ֱ�ʵ�ִ˽ӿڣ���ɼӼ��˳����㡣 
��3�����һ����UseCompute�����к��з�����public void useCom(Compute com, int one, int two)���˷����ܹ��ô���
   �����Ķ������computer����������㣬���������Ľ���� 
��4�����һ������Test������UseCompute�еķ���useCom����ɼӼ��˳����㡣 
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
