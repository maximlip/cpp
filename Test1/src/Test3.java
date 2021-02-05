import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class Test3 {
	static String n = "5";
	
	static void method() {
		System.out.println(Thread.currentThread().getName());
	}
	

	@Override
	public String toString() {
		return "Test3 []";
	}


	public static void main(String[] args) throws InterruptedException {

		System.out.println(n);
		Thread.currentThread();

		Runnable task = () -> {
			System.out.println(Thread.currentThread().getName());
		};

		new Thread(task).start();


		new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
		
		Set<String> ts = new TreeSet<String>((String a, String b) -> {return a.compareTo(b);});
		ts.add("Aaaaaaa");
		ts.add("bbb");
		System.out.println(ts);
		
		//System.in.read()
		
		Stream<String> st = ts.stream().peek(s -> System.out.println(s));
		System.out.println(st);
		System.out.println(Arrays.toString(st.toArray()));
		
		new Thread(Test3::method) {}.start();
		
		Thread.sleep(10000);
		
		Stream<String> st2 = ts.stream().filter(s -> s.length() > 2);
		System.out.println(Arrays.toString(st2.toArray()));
	}

}
