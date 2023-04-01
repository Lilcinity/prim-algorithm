// import required classes and packages 
import java.util.*;
     
public class PrimMatrixMCST 
{
    // stores values of edges
    public ArrayList<Edges> edges = new ArrayList<Edges>();
    public int MatrixMCST[][];
    public static int toCost; // cost 

    PrimMatrixMCST(int adjMat[][], int v) // Adjancency Matrix (MCST)
    { 
        MCST(adjMat, v);
    }
    
    public void MCST(int G[][], int V) 
    {
        MatrixMCST = new int[V][V];
        int num = 99999999; // set the number to 99999999
    
        int noOfEdge; // number of edges
        noOfEdge = 0; // Set the edge count to 0.
    
        // Array for the selected vertex
        boolean[] selected = new boolean[V]; // boolean sets to true if selected, otherwise, false
        Arrays.fill(selected, false); // initialize selected as boolean false
        
        /* When V is the number of vertices in the graph, keep it mind that the minimum cost spanning tree 
           will be always fewer by 1 in contrast to the vertex, hence the formula (V-1)
         */
   
        selected[0] = true; // set the vertex to true if selected into it
    
        // Edge: (weight)
    
        /* Measure the distance from the vertex chosen for each vertex
         * If vertex already existed in the set, remove
         * If not, choose to the next closest selected vertex
         */
        while (noOfEdge < V - 1) 
        {
            int min = num; // min
            int x = 0; // index value for row number
            int y = 0; // index value for column number
            
            for (int i = 0; i < V; i++) 
            {
                if (selected[i] == true) 
                {
                    for (int j = 0; j < V; j++) 
                    { 
                        if (!selected[j] && G[i][j] != 0) // not selected, edge exists
                        { 
                            if (min > G[i][j]) 
                            {
                                min = G[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }
            edges.add(new Edges(x, y, G[x][y]));
            selected[y] = true;
            noOfEdge++;
        }
        
        // Matrix: MCST 
        for (int i = 0; i  < edges.size(); i++)
        {
            MatrixMCST[edges.get(i).source][edges.get(i).destination] = Integer.parseInt(edges.get(i).Weight);
            MatrixMCST[edges.get(i).destination][edges.get(i).source] = Integer.parseInt(edges.get(i).Weight);
            
            toCost += Integer.parseInt(edges.get(i).Weight);
        }
    }
    
    // constructor for Matrix MCST
    void MatrixMCST(int V)
    {
        System.out.format("\n%1$"+(V/2)+"s | The Matrix: MCST |", "" + "");
        System.out.print("\n    ");
        for (int x = 0; x < V; x++) 
        {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.print("  ");
        for (int x = 0; x < (V * 2); x++) 
        {
            System.out.print(" -");
        }
        System.out.println();
        for (int y = 0; y < V; y++)
        {
            System.out.print(y+" | ");
            for (int x = 0; x < V; x++)
            {
                if (x == y) 
                {
                    MatrixMCST[y][x] = 0;
                    System.out.print(MatrixMCST[y][x] + " ");
                } 
                else if (MatrixMCST[y][x] == 0) 
                {
                    System.out.print("∞ ");
                } 
                else 
                {
                    System.out.print(MatrixMCST[y][x] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
