package project1;
/*
 * ����һ��ͼ�Σ�Բ�Σ����������࣬�����ĸ��඼�߱�����������ܳ�����Ϊ��ֻ��������ķ�ʽ��ͬ��
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
		System.out.println(name+"�����Ϊ:"+r*PI*r);
	}
	public void getLength() {
		System.out.println(name+"���ܳ�Ϊ:"+2*PI*r);
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
		System.out.println(name+"�����Ϊ:"+width*higth);
	}
	public void getLength() {
		System.out.println(name+"���ܳ�Ϊ:"+2*(width+higth));
	}
}
public class Demo4 {
	public static void main(String[] args) {
		/*yuan y = new yuan("Բ��",3);
		y.getArea();
		y.getLength();
		juxing j = new juxing("����",3,4);
		j.getArea();
		j.getLength();
		*/
		TuXing y = new yuan("Բ��",3);
		get(y);
		TuXing t = new juxing("����",3,4);
		get(t);
	}
	//ʹ��һ���������Խ����������͵�ͼ�Σ�Ȼ�����������ܳ���
	public static void get(TuXing Tx) {
		Tx.getArea();
		Tx.getLength();
	}
}
