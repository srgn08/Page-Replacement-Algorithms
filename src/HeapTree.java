import java.io.BufferedWriter;
import java.io.IOException;


public class HeapTree {
	private String[] heap_array;
	private int current_size;
	private int max_size;
	private int front=0;
	private String[] array;
	

	
	public HeapTree(int max_size) {
		this.max_size = max_size;
		this.current_size=0;
		heap_array=new String[this.max_size];
		array=new String[this.max_size];
	}
	
	
	private int parent_control(int position)
    {
        return position / 2;
    }
	
	private int left_control(int position)
    {
        return (2 * position);
    }
 
    private int right_control(int position)
    {
        return (2 * position) + 1;
    }
 
    
    private boolean leaf_control(int position)
    {
        if (position >=  (current_size / 2)  &&  position <= current_size)
        {
            return true;
        }
        return false;
    }
    
    

    private void maxHeapify(int position)
    {
        if (!leaf_control(position))
        { 
            if ( heap_array[position].compareTo(heap_array[left_control(position)])<0  || heap_array[position].compareTo(heap_array[right_control(position)])<0)
            {
                if (heap_array[left_control(position)].compareTo(heap_array[right_control(position)])>0)
                {
                    swap(position, left_control(position));
                    maxHeapify(left_control(position));
                }else
                {
                    swap(position, right_control(position));
                    maxHeapify(right_control(position));
                }
            }
        }
    }
    
    
    
    public void maxHeap()
    {
        for (int position = (current_size / 2); position >= 1; position--)
        {
            maxHeapify(position);
        }
    }
 
    public String remove()
    {
        String pop_element = heap_array[front];
        heap_array[front] = heap_array[--current_size]; 
        maxHeapify(front);
        return pop_element;
    }
    
    public void insert_after_delete(String new_data,String deleted_data)
    {
    	for(int i=0;i<current_size;i++)
    	{
    		if(array[i].equals(deleted_data))
    			array[i]=new_data;
    	}
    }
    
    
    
    private void swap(int position1,int position2)
    {
        String temp;
        temp = heap_array[position1];
        heap_array[position1] = heap_array[position2];
        heap_array[position2] = temp;
    }
 
	
	public void insert_data(String value)
	{
		heap_array[current_size]=value;
		int current_number=current_size;
		while(heap_array[current_number].compareTo(heap_array[parent_control(current_number)])>0)
		{
			 swap(current_number,parent_control(current_number));
			 current_number = parent_control(current_number);
		}
		array[current_size]=value;
		current_size++;
		
	}
	
	
	
	public void display(BufferedWriter bw,int page_change) throws IOException
    {
		if(page_change==1)
			bw.write("Page Fault"+"		");
		else
			bw.write("		        ");
		for (int i = 0; i <current_size; i++ )
        {
        	 bw.write(array[i]+" ");
        }
        bw.write("\n");
    }

	
	
	

}
