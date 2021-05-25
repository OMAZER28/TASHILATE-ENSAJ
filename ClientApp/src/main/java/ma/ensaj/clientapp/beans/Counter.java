package ma.ensaj.clientapp.beans;

public class Counter {
	private static Counter instance = null; 
	int count = 0;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

    public static Counter getInstance() 
    { 
        if (instance == null) 
        	instance = new Counter(); 
  
        return instance;
    } 
}
