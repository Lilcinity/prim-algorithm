// Jframe Actiyity - Prim Algorithm
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
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

public class JframeActivity extends JPanel implements MouseInputListener
{
    private int mx, my;
    private int temp;
    private boolean drag = false;
    public static ArrayList<Edges> edge;
    public static ArrayList<NodePrim> node;
    JframeActivity(ArrayList<Edges> edg, ArrayList<NodePrim> nod)
    {
        edge = edg;
        node = nod;
        this.setSize(800,800);
        this.setVisible(true);
        this.setLayout(new FlowLayout());
        Frame();
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Color windowbg = new Color(255, 255, 255); // set color for pop-up window background
        Color circle = new Color(128, 0, 0); // set color for the circle (vertices)
        Color text = new Color(0, 0, 0); // font color of the text (vertices)
        Color weightcolor = new Color(0, 0, 0); // font color of the weight
        g.setColor(windowbg); 
        g.fillRect(0,0,10000,10000);
        g.setColor(Color.black); 
        
        for(int i = 0; i < edge.size() ; i++)
        {
            g.drawLine(node.get(edge.get(i).source).posX, node.get(edge.get(i).source).posY, 
                       node.get(edge.get(i).destination).posX, node.get(edge.get(i).destination).posY);
            
            g.setColor(weightcolor);
            g.setFont(new Font("Times New Roman", Font.BOLD, 20));
            g.drawString(edge.get(i).Weight,
                       ((node.get(edge.get(i).source).posX + node.get(edge.get(i).destination).posX)/2)+15,
                       ((node.get(edge.get(i).source).posY + node.get(edge.get(i).destination).posY)/2)+20);
        }
        
        for(int x=0; x < node.size(); x++)
        {
            g.setColor(Color.yellow);
            g.fillOval(node.get(x).posX-21, node.get(x).posY-20, 40, 40);
            g.setColor(text.blue);// stroke
            g.drawOval(node.get(x).posX-21, node.get(x).posY-20, 40, 40);
            g.setColor(text);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString(node.get(x).Name, node.get(x).posX-6,node.get(x).posY+8);
        }
        
        if (MainClassPrim.option.equals("B") || MainClassPrim.option.equals("b") || MainClassPrim.option.equals("2"))
        {
            g.setFont(new Font("Calibri", Font.PLAIN, 25));
            g.drawString("Total Cost: " + Integer.toString(PrimMatrixMCST.toCost), 300, 600);
        }
    }
    
    // methods for the pop-up windows
    void Frame()
    {
        JFrame frame = new JFrame();
        frame.setTitle("Graph Representation: Topology");
        frame.setSize(800,800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(this);
    }
    
    // subsequent methods were the mouse events
    @Override
    public void mouseMoved(MouseEvent e) 
    {
        mx = e.getX();
        my = e.getY();
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {       
        mouseMoved(e);
        for (int i = 0; i < node.size(); i++)
            if (mx <= node.get(i).posX+20 && mx >= node.get(i).posX-20 && my <= node.get(i).posY+20 && my >= node.get(i).posY-20)
            {
                temp = i;
                drag = true;
            }
    }

    @Override
    public void mouseDragged(MouseEvent e) 
    {
        mouseMoved(e);
        if (drag == true) 
        {
            node.get(temp).posX = mx;
            node.get(temp).posY = my;
            repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) 
    {
        
    }
    
    @Override
    public void mouseReleased(MouseEvent e) 
    {      
        drag = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) 
    {      
        
    }
    
    @Override
    public void mouseExited(MouseEvent e) 
    {
        
    }
}