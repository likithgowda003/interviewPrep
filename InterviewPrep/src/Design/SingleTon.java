package Design;

public class SingleTon {
	    private static SingleTon obj; 
	  
	    private SingleTon() {} 
	  
	    // Only one thread can execute this at a time 
	    public static synchronized SingleTon getInstance() 
	    { 
	        if (obj==null) 
	            obj = new SingleTon(); 
	        return obj; 
	    } 
	

}
