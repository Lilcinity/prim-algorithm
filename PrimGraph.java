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
