package project1;
/*
 * 描述一个图形，圆形，矩形三个类，不管哪个类都具备计算面积和周长的行为，只不过计算的方式不同。
 *  
 */
abstract class TuXing{
	String name;
	public TuXing(String name) {
		this.name = name;
	}
	public abstract void getArea();
	public abstract void getLength();
}
class yuan extends TuXing{
	int r;
	public static final double PI = 3.14;
	public yuan(String name,int r) {
		super(name);
		this.r = r;
	}
	public void getArea() {
		System.out.println(name+"的面积为:"+r*PI*r);
	}
	public void getLength() {
		System.out.println(name+"的周长为:"+2*PI*r);
	}
}
class juxing extends TuXing{
	int width;
	int higth;
	public juxing(String name,int width,int higth){
		super(name);
		this.higth=higth;
		this.width=width;
	}
	public void getArea() {
		System.out.println(name+"的面积为:"+width*higth);
	}
	public void getLength() {
		System.out.println(name+"的周长为:"+2*(width+higth));
	}
}
public class Demo4 {
	public static void main(String[] args) {
		/*yuan y = new yuan("圆形",3);
		y.getArea();
		y.getLength();
		juxing j = new juxing("矩形",3,4);
		j.getArea();
		j.getLength();
		*/
		TuXing y = new yuan("圆形",3);
		get(y);
		TuXing t = new juxing("矩形",3,4);
		get(t);
	}
	//使用一个函数可以接收任意类型的图形，然后算出面积和周长。
	public static void get(TuXing Tx) {
		Tx.getArea();
		Tx.getLength();
	}
}
