// Matrix and Graph - Prim Algorithm
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

public class PrimGraph
{
    public int adjMatrix[][];
    
    public int v = 0; // index value of vertex/vertices
    public int e = 0; // index value of edge/edges
    
    public ArrayList<Edges> edge = new ArrayList<Edges>();
    public ArrayList<NodePrim> node = new ArrayList<NodePrim>();
    public ArrayList<Integer> posX = new ArrayList<Integer>();
    public ArrayList<Integer> posY = new ArrayList<Integer>();

    PrimGraph()
    {
        while(v == 0){
            Vertex();
            Size();
        }
    }

    void Vertex()
    {
        while(true)
        {
            try 
            {
                System.out.print("Order (Vertices) : ");
                v = MainClassPrim.input.nextInt();
            }
            catch(InputMismatchException e)
            {
                MainClassPrim.input.next();
                System.out.println(" ");
                System.out.println("Error! Please Enter an integer only!");
                System.out.println("- - - - - - - - - - - - - - - - - -");
                Vertex();
            }
            catch(Exception e)
            {
                MainClassPrim.input.next();
                System.out.println(" ");
                System.out.println("Error! Invalid Format!");
                System.out.println(" ");
                Vertex();
            }
            adjMatrix = new int[v][v]; 
            break;
        }
    }

    void Size()
    {
        while(true)
        {
            try 
            {
                int n1 = v -1; 
                int n2 = v * n1; 
                int maxSize = n2/2;
                System.out.print("Size (Edges) : ");
                e = MainClassPrim.input.nextInt();
                if (v == 0)
                {
                    System.out.println(" ");
                    System.out.println("Error! Graph Order must not be 0!");
                    System.out.println("- - - - - - - - - - - - - - - - -");
                    break;
                }
                else
                {
                    if (e > maxSize)
                    {
                        System.out.println(" ");
                        System.out.println("Error! Maximum Size exceeded!");
                        System.out.println(" ");
                        Size();
                    } 
                    else if (e == 0)
                    {
                        System.out.println(" ");
                        System.out.println("Error! Graph Size must not be 0!");
                        System.out.println(" ");
                        Size();
                    }
                }
            }
            catch(InputMismatchException e)
            {
                MainClassPrim.input.next();
                System.out.println(" ");
                System.out.println("Error! Please Enter an integer only!");
                System.out.println(" ");
                Size();
            }
            catch(Exception e)
            {
                MainClassPrim.input.next();
                System.out.println(" ");
                System.out.println("Error! Invalid Format!");
                System.out.println(" ");
                Size();
            }
            adjMatrix = new int[v][v]; 
            break;
        }
    }

    void addEdge()
    {
        int src = 0, dest = 0, w = 0;
        createVertList();
        while(true)
        {
            for (int i = 0; i < e; i++)
            {
                
                System.out.println("\n------->Edge " + (i+1) + "<-------");
                try
                {
                    System.out.print("Source Vertex: ");
                    src = MainClassPrim.input.nextInt();
                    
            
                    System.out.print("Destination Vertex: ");
                    dest = MainClassPrim.input.nextInt(); 

                    // this stops user from entering an already-added edge.
                    if (adjMatrix[src][dest] != 0)
                    {
                        System.out.println(" ");
                        System.out.println("Edges already added!!");      
                        i--;
                    }
                    // stops user for entering with loops
                    else if (src == dest)
                    {
                        System.out.println(" ");
                        System.out.println("Loops are not allowed!!");
                        i--;
                    }
                    else 
                    {
                        System.out.print("Weight: ");
                        w = MainClassPrim.input.nextInt();
                        if (w <= 0)
                        {
                            System.out.println(" ");
                            System.out.println("Weight value should be more than zero!");
                            i--;
                        }
                        else
                        {
                            adjMatrix[src][dest] = w;
                            adjMatrix[dest][src] = w;
                            edge.add(new Edges(src,dest,w));
                        }
                    }
                    System.out.println("----------------------");   
                }
                catch (InputMismatchException e)
                {
                    i--;
                    MainClassPrim.input.nextLine();
                    System.out.println(" ");
                    System.out.println("Characters and Strings are not allowed! Please try again!!");
                    System.out.println(" ");
                }
                catch (Exception e)
                {
                    i--;
                    MainClassPrim.input.nextLine();
                    System.out.println(" ");
                    System.out.println("Vertex value out of bounds!");
                    System.out.println("The source/destination vertex must not higher than the order, it should be limited by this formula, (V-1)");
                    System.out.println("---------------------------------------------------------------------------------------------------------");
                }
            }
            break;           
        }
    }

    // blank, thus creating a vertlist
    void createVertList()
    {
        unitMath();
        for(int i = 0; i < v; i++)
        {
            node.add(new NodePrim(Integer.toString(i), posX.get(i), posY.get(i)));
        }
        
    }
    
    // Object for Adjacency Matrix
    void printMatrix() 
    {
        System.out.format("\n%1$"+(v/2)+"s | Matrix (Adjacency Matrix) |", "" + "");
        System.out.print("\n    ");
        for (int x = 0; x < v; x++) 
        {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.print("  ");
        for (int x = 0; x < (v*2); x++) 
        {
            System.out.print(" -");
        }
        System.out.println();
        for (int x = 0; x < v; x++ ) 
        {
            System.out.print(x+" | ");
            for (int y = 0; y < v; y++ ) 
            {
                if (x == y) 
                {
                    adjMatrix[x][y] = 0;
                    System.out.print(adjMatrix[x][y] + " ");
                } 
                else if (adjMatrix[x][y] == 0) 
                {
                    System.out.print("∞ ");
                } 
                else 
                {
                    System.out.print(adjMatrix[x][y] + " ");
                }
            }
            System.out.println();
        }
        System.out.println(" ");
        // degree formula
        for (int x = 0; x < v; x++) 
        {
            int degree = 0;
            for (int y = 0; y < v; y++) 
            {
                if (x == y) 
                {
                    adjMatrix[x][y] = 0;
                } 
                else if (adjMatrix[x][y] != 0) 
                {
                    degree++;
                }
            }
            System.out.println("Degree of " + x + ": " + degree);
        }
    }

    // placement of the unit circle within the pop-up window
    void unitMath()
    { 
        double rad;
        double deg = -Math.PI/2;

        for(int x = 0; x<(v); x++)
        {
            rad = 250;
            double cos = Math.cos(deg);
            double sin = Math.sin(deg);
            int posx = (int) Math.round(rad*cos)+350;
            int posy = (int) Math.round(rad*sin)+350;
            
            posX.add(posx); // keep the x coordinates 
            posY.add(posy); // keep the y coordinates
            if(deg == -Math.PI/2)
            {
                deg=(-Math.PI/2)+(Math.PI*2)/(v);
            }
            else
            {
                deg=deg+(Math.PI*2)/(v);
            }  
        }
    }
}
