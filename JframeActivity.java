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
