import java.util.Scanner;

public class Sequence<E>{
    protected Object[] data;
    protected int size;

    public Sequence(int n) throws IllegalArgumentException{
        if(n<0){
            throw new IllegalArgumentException();}
        this.data=new Object[n];
        this.size=0;
    }

    public int size(){
        return this.size;
    }

    public void append(E element){            
        if(this.size<this.data.length){
            this.data[this.size]=element;
        }
        else{
            Object[] temp=new Object[this.size+1];
            System.arraycopy(this.data, 0, temp, 0, this.size);
            this.data=temp;
            this.data[this.size]=element;
        }
        this.size++;    
    }

    public Object get(int k) throws IndexOutOfBoundsException{
            if(k<0 || k>=this.size){
                throw new IndexOutOfBoundsException();}
            return this.data[k];
    }

	public void print(){
		System.out.print("\nCurrent Sequence: ");
		for(int i=0;i<this.size();i++){
            System.out.print(this.get(i)+" ");
        }
		System.out.println();
	}
	
    public void insert(int index, E newElement){
    	//IMPLEMENT ME
    }

	public void delete(int index){
		//IMPLEMENT ME
	}
	
    public static void main (String[] args){
		Scanner in = new Scanner(System.in);
		Sequence<Integer> s = new Sequence<Integer>(5);
		s.append(1);
		s.append(2);
		s.append(3);
		s.append(4);
		s.append(5);
		s.print();
		
		//INSERT CONTROL LOOP HERE
		int choice = 0;
		
		while(choice!=3){
			System.out.println("Please enter 1 to insert, 2 to delete, or 3 to quit.");
			choice = Integer.parseInt(in.nextLine());
			
			if(choice==1){
				System.out.println("Please enter a value to insert.");
				int value = Integer.parseInt(in.nextLine());
				System.out.println("Please enter the index to insert.");
				int index = Integer.parseInt(in.nextLine());
				s.insert(index, value);
				s.print();
			} else if(choice==2){
				System.out.println("Please enter the index to delete.");
				int index = Integer.parseInt(in.nextLine());
				s.delete(index);
				s.print();
			} else if(choice==3){
				System.out.println("Goodbye");
				continue;
			} else {
				System.out.println("Invalid choice\nPlease enter either 1, 2 or 3");
			}
		} 
		
		
    }   //End main
}   //End class