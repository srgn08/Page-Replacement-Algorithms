import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;


public class Queue {
	private int size;
	private int head;
	private int tail;
	private Queue_Node[] array;
	public static String chance_arrray[]=new String[100];
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getHead() {
		return head;
	}

	public void setHead(int head) {
		this.head = head;
	}

	public int getTail() {
		return tail;
	}

	public void setTail(int tail) {
		this.tail = tail;
	}

	public Queue_Node[] getArray() {
		return array;
	}

	public void setArray(Queue_Node[] array) {
		this.array = array;
	}

	public Queue(int size, int head, int tail, Queue_Node[] array) {
		this.size = size;
		this.head = head;
		this.tail = tail;
		this.array = array;
	}
	
	
	public void enqueue(Queue_Node data)
	{
		array[tail]=data;
		tail=tail+1;
	}
	
	
	
	
	public void enqueue_after_dequeue(String deleted_data,String new_data,int bit)
	{
		for(int i=0;i<array.length;i++)
		{
			if(deleted_data.equals(array[i].getValue()))
			{
				array[i].setValue(new_data);
				array[i].setBit(bit);
			}
				
		}
	}
		
	public void bit_control(String value)
	{
		for(int i=0;i<tail;i++)
		{
			if(array[i].getValue().equals(value))
				array[i].setChance(1);;
		}
	}
	
	
	public String dequeue_second_chance(double index)
	{
		double min=1000000000;
		Queue_Node temp = null;
		double control=index-1;
		int k=0;
		while(true)
		{
			for(int i=0;i<array.length;i++)
			{
				if(array[i].getBit()<min)
				{
					temp=(Queue_Node) array[i];
					min=array[i].getBit();					
				}
				
			}
			if(temp.getChance()==1)
			{
				chance_arrray[k]=temp.getValue();
				control=control+0.01;
				temp.setBit(control);
				temp.setChance(0);
				min=1000000000;
				k++;
			}
			else 
				break;

		}
	
		return temp.getValue();
	}
	
	
	public String dequeue()
	{
		double min=1000000000;
		Queue_Node temp = null;
		for(int i=0;i<array.length;i++)
		{
			if(array[i].getBit()<min)
			{
				temp=(Queue_Node) array[i];
				min=array[i].getBit();
			}				
		}
		return temp.getValue();
	}
	
	public void display(BufferedWriter bw,int page_change) throws IOException
	{
	
		if(page_change==1)
			bw.write("Page Fault"+"		");
		else
			bw.write("			    ");
		for(int i=0;i<tail;i++)
		{
				bw.write(array[i].getValue()+" ");
		}
		int ii=0;
		while(chance_arrray[ii]!=null)
		{
			if(ii==0)
			{
				bw.write("  Second Chance"+" "+chance_arrray[ii]+" ");
			}
			else 
				bw.write(chance_arrray[ii]+" ");
			ii++;
		}
		
		bw.write("\n");
		String temp_array[]=new String[100];
		chance_arrray=temp_array;
		
		
		
	}
	
	
	


}
