
public class BinarySearchTree {

	public static  Node root;


	public BinarySearchTree() {
		this.root = null;
	}
	
	
	public boolean search_data(String data)
	{
		Node temp=root;
		while(temp!=null)
		{
			if(temp.getData().equals(data))
				return true;
			else if(temp.getData().compareTo(data)<0)
				temp=temp.getRight();
			else
				temp=temp.getLeft();
				
		}
		return false;
	}
	

	
	public void insert_data(String value)
	{

			Node element=new Node(value, null, null,0);
			if(root==null)
			{
				root=element;
			}
			else{
				Node copy=root;
				while(true)
				{
					if(value.compareTo(copy.getData())<0)
					{
						if(copy.getLeft()==null)
						{
							copy.setLeft(element);
							return;
						}
						else
							copy=copy.getLeft();

						
					}
					else if(value.compareTo(copy.getData())>0)
					{
						if(copy.getRight()==null)
						{
							copy.setRight(element);
							return;
						}
						else
							copy=copy.getRight();
						
					}
					else
					{
						return;
					}
				}
			}				
		
	}
	
	
	public void delete_data(String value)
	{
		boolean left_root = false;
		Node temp=root;
		Node current=root;

		while(!current.getData().equals(value))
		{
			temp=current;
			if(current.getData().compareTo(value)<0)
			{
				current=current.getRight();
				left_root=false;
			}
			else
			{
				current=current.getLeft();
				left_root=true;
			}
		}
		if(current.getLeft()==null && current.getRight()==null)
		{
			if(left_root==true)
				temp.setLeft(null);
			else
				temp.setRight(null);
		}
		
		else if(current.getLeft()==null)
		{
			if(current==root)
				root=current.getRight();
			else if(left_root==true)
				temp.setLeft(current.getRight());
			else
				temp.setRight(current.getRight());
		}
		
		else if(current.getRight()==null)
		{
			if(current==root)
				root=current.getLeft();
			else if(left_root==true)
				temp.setLeft(current.getLeft());
			else
				temp.setRight(current.getLeft());
		}
		else
		{
			Node x=control_node(current);
			if(current==root)
				root=x;
			else if(left_root==true)
				temp.setLeft(x);
			else
				temp.setRight(x);
			x.setLeft(current.getLeft());
		}
			
		
	}
	
	
	
	public Node control_node(Node delete_node)
	{
		Node temp=null;
		Node temp_parent=null;
		Node current=delete_node.getRight();
		while(current!=null)
		{
			temp_parent=temp;
			temp=current;
			current=current.getLeft();
		}
		if(!temp.equals(delete_node.getRight()))
		{
			temp_parent.setLeft(temp.getRight());
			temp.setRight(delete_node.getRight());
		}
		return temp;
	}
	
	
	
	
	public void display(Node root){
		if(root!=null){
			display(root.getLeft());
			System.out.print(root.getData());
			display(root.getRight());
		}
	}
	
	
	
}
	