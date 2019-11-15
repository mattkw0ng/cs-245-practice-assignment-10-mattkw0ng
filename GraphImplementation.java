import java.lang.Exception;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

public class GraphImplementation implements Graph{

	int vert;
	int[][] graph;

	GraphImplementation(int v){
		
		this.vert = v;
		graph = new int[v][v];
		for(int i = 0; i<v ; i++){
			for(int j = 0 ; j<v ; j++){
				graph[i][j] = 0;		//initializes the graph to all 0
			}
		}
		
	}

	public void addEdge(int v1, int v2) throws Exception{
		if(v1 < vert && v2 < vert){
			graph[v1][v2] = 1;
		}else{
			throw new Exception();
		}
	}
	public List<Integer> topologicalSort(){
		List<Integer> sorted = new ArrayList<>();
		try{
			//System.out.println("sorting...");
			//List<Integer> sorted = new ArrayList<>();
			ArrayStack<Integer> stack = new ArrayStack<>();
			boolean[] visited = new boolean[vert];
			visited[0] = true;
			stack.push(0);
			while(!stack.empty()){
				//System.out.println("inside first while loop");
				int next = stack.pop();
				sorted.add(next);
				//System.out.println("added: "+next);
				ListIterator<Integer> it = neighbors(next).listIterator();
				while(it.hasNext()){
					//System.out.println("inside second while loop");
					int neigh = it.next();
					if(!visited[neigh]){
						stack.push(neigh);
						visited[neigh] = true;
					}
				}

			}
			//System.out.println(sorted.size());
			return sorted;
		}catch(Exception e){
			//System.out.println("error");
			return sorted;
		}
	}
	public List<Integer> neighbors(int vertex) throws Exception{
		List<Integer> neighs = new ArrayList<>();
		if(vertex < vert){
			for(int i = 0 ; i<vert ; i++){
				if(graph[vertex][i]==1){
					neighs.add(i);
				}
			}
		}else{
			throw new Exception();
		}
		return neighs;
	}
}