package 哈希表;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 MyHashMap obj = new MyHashMap();
		 obj.put(1,10);
		 obj.put(2,20);
		 int param_2 = obj.get(1);
		 System.out.println(param_2);
		 obj.remove(1);
		 
		 System.out.println("------------");
		 int param_3 = obj.get(1);
		 System.out.println(param_3);
		 
		 System.out.println("------------");
		 int param_4 = obj.get(2);
		 System.out.println(param_4);
	}

}
