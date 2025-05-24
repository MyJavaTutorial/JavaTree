public class Tree<T extends Comparable<T>> {

    protected Node<T> root;

    public Tree() {
        this.root = null;
    }

    public void addIterative( T v ) {
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

    public void addRecursive( T v ) { addRecursive(root, v); }

    private void addRecursive( Node<T> nStart, T value ) {
        Node<T> n = new Node<>(value);
        if (root==null) { root = n; return; }
        if ( value.compareTo(nStart.getValue() ) >=0 ) {
            if (nStart.getRight()==null) { nStart.setRight(n); return; }
            else addRecursive( nStart.getRight(), value );
        } else {
            if (nStart.getLeft()==null) { nStart.setLeft(n); return; }
            else addRecursive( nStart.getLeft(), value );
        }
    }

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

    
}
