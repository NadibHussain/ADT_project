public class Node {
    public int[] coords;
    public Node left = null;
    public Node right = null;
    public int index = 0;

    public Node(int[] coords) {
        this.coords = coords;
    }

    public String toString(){
        if (left == null && right == null){
            return coords[0]+" "+coords[1];
        }
        else {
            if (index == 0){
                return "A:"+coords[index];
            }
            else {
                return "S:"+coords[index];
            }
        }
    }

}
