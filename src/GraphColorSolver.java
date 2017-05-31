//Author:Sayeed Gulmahamad
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GraphColorSolver {
	
	public static int count = 0;

	public static void readInputFileAndSolve(String filename)
	{		
		BufferedReader br = null;
		
		try 
		{
			// read the input file through buffered reader
			br = new BufferedReader(new FileReader(filename));
		    String line = null;

		    // read until you get null line
		    while ((line = br.readLine()) != null) 
		    {
		        
		    	// get the number of vertices.
		    	int v = Integer.parseInt(line);
	        	int[][] graph = new int[v][v];
	        	
	        	// read the edges line by line
		    	for (int i = 0; i < v; i++)
		    	{
		    		String edgeLines = br.readLine();
		    		
		    		if (edgeLines == null)
		    		{
		    			System.out.println("Error");
		    			System.exit(0);
		    		}
		    		else
		    		{
		    			// separate out the edges by a space
		    			String[] edges = edgeLines.split(" ");
		    			
		    			for (int e = 0; e < edges.length; e++)
		    			{
		    				graph[i][e] = Integer.parseInt(edges[e]);
		    			}
		    			   
		    		}
		    	 }
		    	
		    	System.out.println("*******************************************");
		    	System.out.println("Printing graph");
		    	// print the extracted graph from the file
		    	for (int m = 0; m < v; m++ )
		    	{
		    		for (int n = 0; n < v; n++)
		    		{
		    			System.out.print(graph[m][n]);
		    			System.out.print(" ");
		    		}
		    		System.out.println();
		    	}
		    	
		    	count = 1;
		    	System.out.println();
		    	System.out.println("Coloring the graph");
		    	GraphColoringHelper gch = new GraphColoringHelper(v);
		    	gch.firstTime = true;
		    	// call the graphcoloring method to solve the problem, for the extracted graph from the file
		    	gch.graphColoring(graph, 4);
		    	System.out.println("*******************************************");
		    	
		     }
		    
		  
		  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
