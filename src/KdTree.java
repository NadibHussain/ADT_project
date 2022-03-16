import java.util.*;
public class KdTree {
    private int dimensions;
    public Node root = null;

    public KdTree(List<Node> nodes) {
        create_tree(nodes);
    }

    public void create_tree(List<Node> nodes){
        for (Node node:nodes) {
            insert(node);
            System.out.println("added "+node);
        }

    }

    public void insert(Node node){
        if(root == null){
            root = node;
        }else{
            Node current = root;
            Node parent;
            while(true){
                parent = current;
                if(node.coords[current.index] < current.coords[current.index]){
                    current = current.left;
                    if(current == null){
                        node.index = parent.index ^ 1;
                        parent.left = node;
                        return;
                    }
                }else{
                    current = current.right;
                    if(current == null){
                        node.index = parent.index ^ 1;
                        parent.right = node;
                        return;
                    }
                }
            }
        }
    }

    // A utility function to find minimum of three integers
    public Node minNode(Node x, Node y, Node z, int d)
    {
        Node res = x;
        if (y != null && y.coords[d] < res.coords[d])
            res = y;
        if (z != null && z.coords[d] < res.coords[d])
            res = z;
        return res;
    }

    // Recursively finds minimum of d'th dimension in KD tree
    // The parameter depth is used to determine current axis.
    public Node findMinRec(Node root, int d, long depth)
    {
        // Base cases
        if (root == null)
            return null;

        // Current dimension is computed using current depth and total
        // dimensions (k)
        long cd = depth % 2;

        // Compare point with root with respect to cd (Current dimension)
        if (cd == d)
        {
            if (root.left == null)
                return root;
            return findMinRec(root.left, d, depth+1);
        }

        // If current dimension is different then minimum can be anywhere
        // in this subtree
        return minNode(root,
                findMinRec(root.left, d, depth+1),
                findMinRec(root.right, d, depth+1), d);
    }

    // A wrapper over findMinRec(). Returns minimum of d'th dimension
    public Node findMin(Node root, int d)
    {
        // Pass current level or depth as 0
        return findMinRec(root, d, 0);
    }

    // A utility method to determine if two Points are same
    // in K Dimensional space
    public boolean arePointsSame(int point1[], int point2[])
    {
        // Compare individual pointinate values
        for (int i = 0; i < 2; ++i)
            if (point1[i] != point2[i])
                return false;

        return true;
    }

    // Copies point p2 to p1
    void copyPoint(int p1[], int p2[])
    {
        for (int i=0; i<2; i++)
            p1[i] = p2[i];
    }

    // Function to delete a given point 'point[]' from tree with root
    // as 'root'.  depth is current depth and passed as 0 initially.
    // Returns root of the modified tree.
    public Node deleteNodeRec(Node root, int point[], int depth)
    {
        // Given point is not present
        if (root == null)
            return null;

        // Find dimension of current node
        int cd = depth % 2;

        // If the point to be deleted is present at root
        if (arePointsSame(root.coords, point))
        {
            // 2.b) If right child is not null
            if (root.right != null)
            {
                // Find minimum of root's dimension in right subtree
                Node min = findMin(root.right, cd);

                // Copy the minimum to root
                copyPoint(root.coords, min.coords);

                // Recursively delete the minimum
                root.right = deleteNodeRec(root.right, min.coords, depth+1);
            }
            else if (root.left != null) // same as above
            {
                Node min = findMin(root.left, cd);
                copyPoint(root.coords, min.coords);
                root.left = deleteNodeRec(root.left, min.coords, depth+1);
            }
            else // If node to be deleted is leaf node
            {
                root = null;
                return null;
            }
            return root;
        }

        // 2) If current node doesn't contain point, search downward
        if (point[cd] < root.coords[cd])
            root.left = deleteNodeRec(root.left, point, depth+1);
        else
            root.right = deleteNodeRec(root.right, point, depth+1);
        return root;
    }

    // Function to delete a given point from K D Tree with 'root'
    public void deleteNode(Node root, int point[])
    {
        // Pass depth as 0
        deleteNodeRec(root, point, 0);
    }

    public void printTree(Node root) {
        LinkedList<Node> tree = new LinkedList<>();
        tree.add(root);
        LinkedList<Node> temp = new LinkedList<>();
        int height = getHeightOfTree(root)-1;
        //System.out.println(height);
        double numberOfElements = (Math.pow(2 ,(height + 1)) - 1);
        //System.out.println(numberOfElements);
        int counter = 0;
        while (counter <= height) {
            Node node = tree.removeFirst();
            if (temp.isEmpty()) {
                printSpace(numberOfElements / Math.pow(2 , counter + 1), node);
            } else {
                printSpace(numberOfElements / Math.pow(2 , counter), node);
            }
            if (node == null) {
                temp.add(null);
                temp.add(null);
            } else {
                temp.add(node.left);
                temp.add(node.right);
            }

            if (tree.isEmpty()) {
                System.out.println("");
                System.out.println("");
                tree = temp;
                temp = new LinkedList<>();
                counter++;
            }

        }
    }

    public static void printSpace(double n, Node node){
        for(;n>0;n--) {
            System.out.print("\t");
        }
        if(node == null){
            System.out.print(" ");
        }
        else {
            System.out.print(node);
        }
    }

    public static int getHeightOfTree(Node root){
        if(root==null){
            return 0;
        }
        return 1+ Math.max(getHeightOfTree(root.left), getHeightOfTree(root.right));
    }



}
