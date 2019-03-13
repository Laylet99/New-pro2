package sin;

import java.util.concurrent.atomic.AtomicInteger;

public class GlobalCounter {

	public static int value;
	
	public static AtomicInteger aValue = 
			new AtomicInteger(0);
		
	}
	

}
}