// Node - Prim Algorithm
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

import java.util.*;

public class NodePrim 
{
    // initialize for class node!
    int posX;
    int posY;
    String Name;
    public NodePrim (String myName, int posiX, int posiY) 
    {
        posX = posiX;
        posY = posiY;
        Name = myName;
    }
}