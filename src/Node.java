public class Node {
    public int[] coords;
    public Node left = null;
    public Node right = null;
    public int index = 0;

    public Node(int[] coords) {
        this.coords = coords;
    }

    public String toString(){
        return coords[0]+" "+coords[1];
    }

}
