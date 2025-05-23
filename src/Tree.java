public class Tree<T extends Comparable<T>> {

    Node<T> root;

    public Tree() {
        this.root = null;
    }

    public void add( T v ) {
        Node<T> n = new Node<>(v);
        if (root==null) { root = n; return; }
        Node<T> tmp = root;
        while (true) {
            if ( v.compareTo(tmp.getValue())>=0 ) {
                if (tmp.getRight()==null) { tmp.setRight(n); break; }
                tmp = tmp.getRight();
            } else {
                if (tmp.getLeft()==null) { tmp.setLeft(n); break; }
                tmp = tmp.getLeft();                
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        visita( root, sb );
        return sb.toString();
    }

    private void visita( Node<T> n, StringBuffer s ) {
        if (n==null) return;
        if (n.getLeft()!=null) visita(n.getLeft(), s);
        s.append(n.getValue());
        if (n.getRight()!=null) visita(n.getRight(), s);
    }
    
    
}
