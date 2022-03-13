import java.util.*;
public class KdTree {
    private int dimensions;
    private Node root = null;

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

}
