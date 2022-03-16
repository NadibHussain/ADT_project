import java.util.ArrayList;
import java.util.List;

public class index {
    public static void main(String[] args) {
        List<Node> list=new ArrayList<Node>();
        list.add(new Node(new int[]{25, 400}));
        list.add(new Node(new int[]{25, 160}));
        list.add(new Node(new int[]{50, 120}));
        list.add(new Node(new int[]{45, 150}));
        list.add(new Node(new int[]{20, 275}));
        list.add(new Node(new int[]{50, 175}));
        list.add(new Node(new int[]{45, 350}));
        list.add(new Node(new int[]{50, 100}));
        list.add(new Node(new int[]{30, 260}));


//        list.add(new Node(new int[]{30, 40}));
//        list.add(new Node(new int[]{5, 25}));
//        list.add(new Node(new int[]{70, 70}));
//        list.add(new Node(new int[]{10, 12}));
//        list.add(new Node(new int[]{50, 30}));
//        list.add(new Node(new int[]{35, 45}));



        KdTree kd = new KdTree(list);
//
        kd.printTree(kd.root);
//        System.out.println("--------------------------------------------------------------------------------------------");
//        kd.insert(new Node(new int[]{20, 300}));
//        kd.printTree(kd.root);
        kd.deleteNode(kd.root,new int[]{25,400});
        System.out.println("--------------------------------------------------------------------------------------------");
        kd.printTree(kd.root);

    }
}
