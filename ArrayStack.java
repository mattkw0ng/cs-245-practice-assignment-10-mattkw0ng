public class ArrayStack<T>{
	public T[] a = (T[]) new Object[10];
	public int top = -1;

	public void push(T item){
		if(top+1 == a.length){ //if there is no more space in the array, calls grow_array
			grow_array();
		}else{
			a[++top] = item;	//increments top and then sets it to the item
		}
	}

	public T pop() //throws Exception
	{
		//if (empty()){throw new Exception();} else{follow code below}
		return a[top--]; //returns a[top] and decrements top

	}

	public T peek() //throws Exception
	{
		//if (empty()){throw new Exception();} else{follow code below}
		return a[top];
	}

	public boolean empty(){
		if (top == -1){
			return true;
		}else{
			return false;
		}
	}

	private void grow_array(){
		int len = a.length;
		T[] new_a = (T[]) new Object[len*2];
		for(int i = 0 ; i<len ; i++){
			new_a[i] = a[i];
		}
		a = new_a;
		top++;
	}
}	