import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class FileRead {
	public String[]readfile(String filename) throws IOException
	{	
		
		File file =new File(filename);
		Scanner sc = new Scanner(file);
		int row=0;
			 
		while (sc.hasNextLine())
		{
			row++;
			sc.nextLine();
		}

		sc.close();
		String[] array=new String[row];
		
        BufferedReader br = null;
        String line = "";
        String split = " ";
        int i=0;

        br = new BufferedReader(new FileReader(filename));
        while ((line = br.readLine()) != null)
        {

        		String[] temp = line.split(split);
        		array[i]=temp[1];
        		i++;
        		
        		
        }
        	 	
     
        
        br.close();
		
		
		return array;
	}
}
