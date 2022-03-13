import java.util.ArrayList;
import java.util.List;

public class index {
    public static void main(String[] args) {
        List<Node> list=new ArrayList<Node>();
        list.add(new Node(new int[]{1340, 162}));
        list.add(new Node(new int[]{121, 1422}));
        list.add(new Node(new int[]{22, 1342}));
        list.add(new Node(new int[]{132, 1322}));
        list.add(new Node(new int[]{1440, 1422}));
        list.add(new Node(new int[]{1350, 1500}));
        list.add(new Node(new int[]{1320, 1322}));
        list.add(new Node(new int[]{1350, 1100}));
        list.add(new Node(new int[]{1320, 1422}));

        KdTree kd = new KdTree(list);
        kd.printTree(kd.root);
    }
}
