import java.util.ArrayList;
import java.util.List;

public class index {
    public static void main(String[] args) {
        List<Node> list=new ArrayList<Node>();
        list.add(new Node(new int[]{1340, 162}));
        list.add(new Node(new int[]{121, 1422}));
        list.add(new Node(new int[]{22, 1342}));
        list.add(new Node(new int[]{132, 1322}));

        KdTree kd = new KdTree(list);
    }
}
