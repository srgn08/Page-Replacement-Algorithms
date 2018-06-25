import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Assignment2 {
	public static void main(String[] args) throws IOException {
		
		String filename=args[0];
		boolean result;
		int insert_count=0;
		String[] input=null;
		FileRead fr=new FileRead();
		input=fr.readfile(filename);
		int setMemory=Integer.parseInt(input[0]);
		String setReplacement=input[1];
		String setSerarchStructure=input[2];
		Queue_Node[] array=new Queue_Node[setMemory];
		Queue queue=new Queue(setMemory,0,0,array);
		
		BufferedWriter bw = null;
		FileWriter fw = null;			
		fw = new FileWriter("output.txt");
		bw = new BufferedWriter(fw);
		
		BinarySearchTree b = new BinarySearchTree();
		int page_control=0;
		HeapTree maxHeap = new HeapTree(setMemory);

			
		bw.write("Memory"+setMemory);
		bw.write("\n");
		bw.write(setReplacement+" "+"Page Replacement");
		bw.write("\n");
		bw.write("Binary Search Tree");
		bw.write("\n");
		bw.write("");
		
		double startTime = System.nanoTime();
		
		
		for(int i=3;i<input.length;i++)
		{
			result=b.search_data(input[i]);
			if(result==true)
			{
				if(setReplacement.equals("SecondChance"))
				{
					queue.bit_control(input[i]);
					queue.display(bw,0);
				}
				else if(setReplacement.equals("FIFO"))
					queue.display(bw,0);	
				else if(setReplacement.equals("PriorityQueue"))
					maxHeap.display(bw,0);
				
			}
			else if(result==false && insert_count<setMemory)
			{
				if(setReplacement.equals("PriorityQueue"))
				{
					maxHeap.insert_data(input[i]);
					b.insert_data(input[i]);
					insert_count=insert_count+1;
					maxHeap.display(bw,1);
					page_control++;	
				}
				else
				{
					Queue_Node temp=new Queue_Node(input[i],i,0);
					queue.enqueue(temp);
					queue.display(bw,1);
					b.insert_data(input[i]);
					insert_count=insert_count+1;
					page_control++;
				}
				
			}
			else if(result==false && insert_count==setMemory)
			{
					if(setReplacement.equals("FIFO"))
					{
						String delete=queue.dequeue();
						queue.enqueue_after_dequeue(delete, input[i],i);
						b.delete_data(delete);
						b.insert_data(input[i]);
						queue.display(bw,1);
						page_control++;	
					}
					else if(setReplacement.equals("SecondChance"))
					{
						String delete=queue.dequeue_second_chance(i);
						queue.enqueue_after_dequeue(delete, input[i],i);
						b.delete_data(delete);
						b.insert_data(input[i]);
						queue.display(bw,1);
						page_control++;	
					}
					else if(setReplacement.equals("PriorityQueue"))
					{
						String delete=maxHeap.remove();
						b.delete_data(delete);
						b.insert_data(input[i]);
						maxHeap.insert_data(input[i]);
						maxHeap.insert_after_delete(input[i], delete);
						maxHeap.display(bw,1);
						page_control++;	
					}
					
								
			}
			

		}
		StringBuilder sb = new StringBuilder();
		sb.append("");
		sb.append(page_control);
		String strI = sb.toString();
		bw.write(strI);
		bw.write("\n");
		double endTime = System.nanoTime();
		double duration = (endTime - startTime)/1000000000 ;
		bw.write("Execution Time:"+""+duration);
		bw.close();
		fw.close();

		
	}
	

}
