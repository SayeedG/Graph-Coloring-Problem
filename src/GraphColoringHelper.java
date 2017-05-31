//Author:Sayeed Gulmahamad
import java.util.Random;

public class GraphColoringHelper {

	int V;
    int color[];
    String[] colorNames = {"", "Red", "Green" , "Blue" , "Yellow"};
    public static boolean firstTime = true;
    public static  Random lastColor = new Random();
    
    
    public GraphColoringHelper(int v)
    {
    	V = v;
    }
    /* A utility function to check if the current
       color assignment is safe for vertex v */
     boolean isSafe(int v, int graph[][], int color[],
                   int c)
    {
        for (int i = 0; i < V; i++)
            if (graph[v][i] == 1 && c == color[i])
                return false;
        return true;
    }
 
    /* A recursive utility function to solve m
       coloring  problem */
    boolean graphColoringUtil(int graph[][], int m,
                              int color[], int v)
    {
        /* base case: If all vertices are assigned
           a color then return true */
        if (v == V)
            return true;
 
        /* Consider this vertex v and try different
           colors */
        for (int c = 1 ; c <= m ; c++)
        {
        	
        	/* Check if the assignment of color c to v
               is fine*/
            if (isSafe(v, graph, color, c))
            {
                color[v] = c;
                
 
                /* use of recursion to assign colors
                   to the rest of the vertices */
                if (graphColoringUtil(graph, m,
                                      color, v + 1))
                {
                	
                	return true;
                }
                else
                {
                	 /* If assigning color c doesn't lead
                    to a solution then remove it */
                	color[v] = 0;
                	
                }     
            }
            else
            {
            	
            	
            	int lastVertex = lastColor.nextInt((V - 4) + 1) + 4;

            	if ((firstTime && (v == lastVertex))  || (firstTime &&(v == V - 1)))
            	{
            		System.out.println();
            		System.out.println("The first backtracking starts at Vertex(causes backtracking to start) : " + (v ) );
                	System.out.println("Nodes processed so far:");
                	int l = 0;
                	while (color[l] != 0 && (l < V))
                	{
                		System.out.println("Vertex " + l + " is colored " + colorNames[color[l]]);
                		l++;
                	}
                	
                	firstTime = false;
            	}
            	
            }
        }
 
        /* If no color can be assigned to this vertex
           then return false */
        return false;
    }
 
    /* This function solves the m Coloring problem using
       Backtracking. It mainly uses graphColoringUtil()
       to solve the problem. It returns false if the m
       colors cannot be assigned, otherwise return true
       and  prints assignments of colors to all vertices.
       */
    boolean graphColoring(int graph[][], int m)
    {
        // Initialize all color values as 0. 
        // This initialization is needed for the correct functioning of isSafe()
        color = new int[V];
        for (int i = 0; i < V; i++)
            color[i] = 0;
 
        // Call graphColoringUtil() for vertex 0
        if (!graphColoringUtil(graph, m, color, 0))
        {
            System.out.println("Solution does not exist");
            return false;
        }
 
        // Print the solution
        printSolution(color);
        return true;
    }
 
    /* A utility function to print the solution */
    void printSolution(int color[])
    {
        
    	System.out.println();
    	System.out.println("Final solution: The following" +
                           " are the assigned colors");
        for (int i = 0; i < V; i++)
            System.out.println("Vertex " + (i) + " " + colorNames[color[i] % 5] + " ");
        System.out.println();
    }
}
