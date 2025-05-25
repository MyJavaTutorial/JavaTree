public class Tree<T extends Comparable<T>> {

    protected Node<T> root;

    public Tree() {
        this.root = null;
    }

    public void iterativeAdd( T v ) {
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

    private void recursiveAdd( T v, Node<T> start ) {
        if (root==null) { root = new Node<>(v); return; }
        if ( v.compareTo(start.getValue()) >= 0 ) {
            if (start.getRight()==null) { start.setRight(new Node<>(v)); return; }
            else recursiveAdd( v, start.getRight() );
        } else {
            if (start.getLeft()==null) { start.setLeft(new Node<>(v)); return; }
            else recursiveAdd( v, start.getLeft() );
        }
    }

    public void add( T v ) { recursiveAdd(v, root); }

    private void visita( Node<T> n, StringBuffer s ) {
        if (n==null) return;
        if (n.getLeft()!=null) visita(n.getLeft(), s);
        s.append(n);
        if (n.getRight()!=null) visita(n.getRight(), s);
    }

      @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        visita( root, sb );
        return sb.toString();
    }

    public void print() { printTree(root, 0); }

    private void printTree(Node<T> node, int level) {
        if (node == null) return;
        // Stampa l'indentazione in base al livello
        for (int i = 0; i < level; i++) {
            System.out.print(" - "); // spazia ogni livello
        }
        System.out.println(node.getValue()); // Stampa il valore del nodo

        // Stampa ricorsivamente i figli
        if (node.getLeft() != null) {
            printTree(node.getLeft(), level + 1);
        }
        if (node.getRight() != null) {
            printTree(node.getRight(), level + 1);
        }
    }

    
}
