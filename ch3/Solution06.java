import java.util.LinkedList;

public class Solution06{
	static class animal{
		String name;
		int seq;
		public animal(String n, int s){
			seq=s;
			name=n;
		}
	}
	static class AnimalQueue{
		LinkedList<animal> dogs;
		LinkedList<animal> cats;
		int order;
		public AnimalQueue(){
			dogs=new LinkedList<animal>();
			cats=new LinkedList<animal>();
			order=0;
		}
		public void enqueue(String category, String n){
			if(category.equals("cat")){
				cats.add(new animal(n,order));
				order++;
			}
			else{
				dogs.add(new animal(n,order));
				order++;
			}
		}
		public animal dequeueAny(){
			if(cats.isEmpty())
				return dogs.poll();
			else if(dogs.isEmpty())
				return cats.poll();
			animal oldest_dog=dogs.peek();
			animal oldest_cat=cats.peek();
			if(oldest_dog.seq<oldest_cat.seq){
				return dogs.poll();
			}
			else{
				return cats.poll();
			}
		}
		public animal dequeueDog(){
			return dogs.poll();
		}
		public animal dequeueCat(){
			return cats.poll();
		}
	}
	public static void main(String [] args){
		AnimalQueue test= new AnimalQueue();
		test.enqueue("cat","cat1");
		test.enqueue("cat","cat2");
		test.enqueue("dog", "dog1");
		test.enqueue("dog","dog2");
		test.enqueue("cat","cat3");
		System.out.println("dequeue any: "+test.dequeueAny().name);
		System.out.println("dequeue dog: "+test.dequeueDog().name);
		System.out.println("dequeue cat: "+test.dequeueCat().name);
		System.out.println("dequeue any: "+test.dequeueAny().name);
		System.out.println("dequeue any: "+test.dequeueAny().name);
	}
}
