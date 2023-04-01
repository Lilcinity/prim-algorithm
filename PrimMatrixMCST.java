// MatrixMCST - Prim Algorithm
// Mendoza, Aaron L.
// ITE133 - IT3N.1
// January 2023

/* 
   Program Description: The program must able to create a set of matrices, the minimum cost spanning tree and its matrices, and the graph connectivity.
   The user is asked for the size (edges) and order (vertices). This program will also asked for the source and the destination vertex of each edges.
   
   The result is depending for the user's preference for the implementation of the code.
   
   1. Matrix (Adjacency Matrix)
   2. Minimum Cost Spanning Tree (MCST)
   3. Matrix (MCST)
   4. Topological Graph
   5. Restart the program
   6. The program ends.
 */

/* 
   Input/s: Graph Size, Graph Order, Weight, Source & Destination Vertex    
   Output/s: Adjacency Matrix, MCST, Printed Prim Graph, MCST Matrix
 */

/*
   Revised Algorithm Format:
   1. Ask for the minimum number of vertices
   2. Ask for the number of edges
   3. After that, input the value of source and destination vertex of each edge as well as the weighted cost
   4. Repeat steps 1-3 until each edge have inputted with its source and destination vertex, and weight
   5. Choose 4 options for implementing the code (Adj. Matrix, Minimum Cost Spanning Tree, Matrix: MCST, Topological Graph)
   6. For Matrix, display the adjacency matrix
   7. For Minimum Cost Spanning Tree, it will be prompted to the lowest cost of the edge until it will display the implemented MCST and it will show the MCST graph
   8. For Matrix: MCST, it will display the matrix within the MCST, with key values translated as infinite
   9. For Topological Graph, display all edges and vertices along with its weighted value. It will show the printed graph
   10. Restart or terminate the program
 */

/*
   Prim's Algorithm Pseudocode
   
    1. T = ∅;
    2. U = { 1 };
    3. while (U ≠ V)
        a. let (u, v) be the lowest cost edge such that u ∈ U and v ∈ V - U;
            i.  T = T ∪ {(u, v)}
            ii. U = U ∪ {v}
 */

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