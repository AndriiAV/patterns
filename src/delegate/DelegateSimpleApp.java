package delegate;

public class DelegateSimpleApp {

	public static void main(String[] args) {
		A a = new A();
		a.f();
		
		B b = new B();
		b.f();
	}

}

class A{
	void f() {
		System.out.println("f()");
	}
}

class B{
	A a = new A();
	void f() {
	a.f();
	}
}