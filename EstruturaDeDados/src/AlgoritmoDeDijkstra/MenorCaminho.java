package AlgoritmoDeDijkstra;


	import java.util.ArrayDeque;
	import java.util.Deque;
	import java.util.Scanner;
	/*
	Coloquei mais dois métodos para verificar se há um caminho entre dois vértices 
	após o processamento (a raiz ficará com -1) e um método para obter 
	o caminho, que no caso, caminha dentro do edgeTo
	*/

	/*
	Embaixo é a representação do array edgeTo são as distâncias somadas 
	das arestas da fonte até o destino
	*/

	public class MenorCaminho {

	    private int V = 10;
	    private int[] dist;
	    private int[] edgeTo;
	    private boolean[] sptSet;

	    public MenorCaminho( int[][] graph, int src ) {
	        dijkstra( graph, src );
	    }
	    
	    private int minDistance( int dist[], boolean sptSet[] ) {

	        int min = Integer.MAX_VALUE, min_index = -1;

	        for ( int v = 0; v < V; v++ ) {
	            if ( sptSet[v] == false && dist[v] <= min ) {
	                min = dist[v];
	                min_index = v;
	            }
	        }

	        return min_index;

	    }

	    private void printSolution() {
	        System.out.println( "Vertex \t Distance from Source \t Edge To" );
	        for ( int i = 0; i < V; i++ ) {
	            System.out.println( i + " \t " + dist[i] + " \t\t\t " + edgeTo[i] );
	        }
	    }

	    private void dijkstra( int[][] graph, int src ) {

	        V = graph.length;

	        dist = new int[V];
	        edgeTo = new int[V];
	        sptSet = new boolean[V];

	        for ( int i = 0; i < V; i++ ) {
	            dist[i] = Integer.MAX_VALUE;
	            edgeTo[i] = -1;
	            sptSet[i] = false;
	        }

	        dist[src] = 0;

	        for ( int count = 0; count < V - 1; count++ ) {

	            int u = minDistance( dist, sptSet );
	            sptSet[u] = true;

	            for ( int v = 0; v < V; v++ ) {
	                if ( !sptSet[v] && 
	                     graph[u][v] != 0 && 
	                     dist[u] != Integer.MAX_VALUE &&
	                     dist[u] + graph[u][v] < dist[v] ) {
	                    
	                    dist[v] = dist[u] + graph[u][v];
	                    edgeTo[v] = u;
	                }
	            }
	        }

	        printSolution();

	    }

	    private boolean hasPathTo( int v ) {
	        return dist[v] < Integer.MAX_VALUE;
	    }
	    
	    public Iterable<Integer> pathTo( int v ) throws IllegalArgumentException {
	        
	        if ( !hasPathTo( v ) ) {
	            return null;
	        }
	        
	        Deque<Integer> path = new ArrayDeque<>();
	        
	        for ( int atual = v; atual != -1; atual = edgeTo[atual] ) {
	            path.push( atual );
	        }
	        
	        return path;
	        
	    }
	    
	    public static void main( String[] args ) {

	        int[][] graph = new int[][]{
	            { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
	            { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
	            { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
	            { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
	            { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
	            { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
	            { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
	            { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
	            { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
	        };

	        Scanner scanner = new Scanner( System.in );
	        System.out.println( "Digite a vértice de partida:" );
	        int input = scanner.nextInt();

	        MenorCaminho t = new MenorCaminho( graph, input );

	        System.out.println( "Digite a vértice de destino:" );
	        input = scanner.nextInt();
	        
	        scanner.close();
	        
	        boolean first = true;
	        
	        for ( int v : t.pathTo( input ) ) {
	            
	            if ( !first ) {
	                System.out.print( " -> " );
	            }
	            
	            System.out.print( v );
	            first = false;
	            
	        }
	        System.out.println();

	    }

	}

