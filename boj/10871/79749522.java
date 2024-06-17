import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int a = Integer.parseInt(reader.readLine().split(" ")[1]);
    	StringTokenizer str = new StringTokenizer(reader.readLine());
    	
    	while(str.hasMoreTokens()) {
    		int b = Integer.parseInt(str.nextToken());
    		
    		if(b < a)
    	    	writer.write(b + " ");
    			
    	}
    	
    	writer.flush();
    }
}