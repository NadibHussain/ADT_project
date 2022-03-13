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
        }

    }

    public void insert(Node node){
        if(root == null){
            root = node;
            System.out.println("added "+root);

        }else{
            Node current = root;
            Node parent;
            while(true){
                parent = current;
                System.out.println("added "+current);
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
