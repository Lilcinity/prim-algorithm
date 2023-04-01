// Prim Algorithm
// Mendoza, Aaron L.
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

// Main Class
public class MainClassPrim
{
    public static Scanner input = new Scanner(System.in);
    public static String option;
    
    // Main Argument/Method
    public static void main(String[] args) 
    {
        PrimGraph prim = new PrimGraph(); // constructor class
        prim.addEdge(); // method  
        PrimMatrixMCST MinCostSpanTree = new PrimMatrixMCST(prim.adjMatrix, prim.v);

        // while loop used for to repeat specific block of codes until such conditions will be met
        while(true)
        {
            System.out.println("");
            System.out.println("Please Choose an Option");
            System.out.println("For Instance: If you choose Print Matrix, then choose A.");
            System.out.println("Note: This is not case sensitive! (e.g., B or b)");
            System.out.println("Note: Alphabets can also be interchanged in numeric equivalents (A = 1, B = 2, etc.)");
            System.out.println("");
            System.out.println("A. Print Matrix ");
            System.out.println("B. Print Minimum Cost Spanning Tree ");
            System.out.println("C. Print Matrix: MCST");
            System.out.println("D. Print Topological Graph ");
            System.out.println("E. Start Another Program ");
            System.out.println("F. Program ends ");
            try
            {
                // Conditions where users can select the options
                System.out.println("");
                option = input.next();
                if (option.equals("A") || option.equals("a") || option.equals ("1"))
                {
                    prim.printMatrix();
                }else if (option.equals("B") || option.equals("b") || option.equals ("2"))
                {
                    new JframeActivity(MinCostSpanTree.edges, prim.node);
                }
                else if (option.equals("C") || option.equals("c") || option.equals ("3"))
                {
                    MinCostSpanTree.MatrixMCST(prim.v);
                }
                else if (option.equals("D") || option.equals("d") || option.equals ("4"))
                {             
                    new JframeActivity(prim.edge, prim.node);
                }
                else if (option.equals("E") || option.equals("e") || option.equals ("5"))
                {
                    prim.node.clear();
                    MinCostSpanTree.edges.clear();
                    prim.edge.clear();
                    MinCostSpanTree.toCost = 0;
                    prim.v = 0;
                    main(null);
                    System.out.println("\n");
                }
                else if (option.equals("F") || option.equals("f") || option.equals ("6"))
                {
                    System.out.println(" ");
                    System.out.println("The Program has been Terminated!!");
                    System.exit(0);
                    break;
                }
                else
                {
                    System.out.println(" ");
                    System.out.println("Error! Invalid Input!");
                    System.out.println("Please Try Again!");
                    System.out.println(" ");
                }                
            }
            catch(Exception e)
            {
                input.nextLine();
                System.out.println(" ");
                System.out.println("Error! Invalid Input! Please Try Again!");
                System.out.println("Please Try Again!");
                System.out.println(" ");
            }       
        }          
    }
}
