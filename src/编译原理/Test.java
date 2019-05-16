package ±àÒëÔ­Àí;
  public class Test {
	  public int x=1;
	  final int y=2;
	  static int z=3;
	  private int u=4;
	  protected int v=5;
	    class a{
	    	int one =1;
	    	 private   int func() {
	    		 return z;
	    	 }
	  }
	  public class b{
		  
	  }
	public static int fun() {
		Test b =new Test();
		Test.a c =b.new a();
		
		return c.func();
	  }
	public static void main(String[] args) {
		Test one =new Test();
		
		System.out.println(one.fun());
	}
	
}