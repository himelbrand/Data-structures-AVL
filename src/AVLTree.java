

import java.io.PrintWriter;

/* Class AVLTree */
class AVLTree
{
    private AVLNode root;
    private int size;


    /* Constructor */
    public AVLTree()
    {
        root=null;
        size=0;

    }
    /* Function to check if tree is empty */
    public boolean isEmpty()
    {
        return root==null;
    }
    /* Make the tree logically empty */
    public void makeEmpty()
    {
        root=null;
    }
    /* Function to insert data */
    public void insert(Comparable data)
    {
        root = insert(data,root);
        size++;
    }
    private void heightUpdate(AVLNode t){
        t.height=max(height(t.left),height(t.right))+1;
    }
    /* Function to get height of node */
    private int height(AVLNode t )
    {
        return t==null?-1:t.height;
    }
    /* Function to max of left/right node */
    private int max(int lhs, int rhs)
    {
        return lhs>rhs?lhs:rhs;
    }
    /* Function to insert data recursively */
    private AVLNode insert(Comparable x, AVLNode t)
    {
        if(x instanceof NodeData) {
            if (t == null)
                t = new AVLNode(x);
            else if (((NodeData) x).compareTo(t.data) < 0) {
                t.left = insert(x, t.left);
                if (height(t.left) - height(t.right) == 2)
                    if (((NodeData) x).compareTo(t.left.data) < 0)
                        t = rotateWithLeftChild(t);
                    else
                        t = doubleWithLeftChild(t);
            } else if (((NodeData) x).compareTo(t.data) > 0) {
                t.right = insert(x, t.right);
                if (height(t.right) - height(t.left) == 2)
                    if (((NodeData) x).compareTo(t.right.data) > 0)
                        t = rotateWithRightChild(t);
                    else
                        t = doubleWithRightChild(t);
            }
            heightUpdate(t);
            return t;
        }
        else return null;
    }
    /* Rotate binary tree node with left child */
    private AVLNode rotateWithLeftChild(AVLNode k2)
    {
        AVLNode x = k2.left;
        k2.left = x.right;
        x.right = k2;
        heightUpdate(k2);
        heightUpdate(x);
        return x;
    }

    /* Rotate binary tree node with right child */
    private AVLNode rotateWithRightChild(AVLNode k1)
    {
        AVLNode x = k1.right;
        k1.right = x.left;
        x.left = k1;
        heightUpdate(k1);
        heightUpdate(x);
        return x;
    }
    /**
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left child */
    private AVLNode doubleWithLeftChild(AVLNode k3)
    {
        k3.left=rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }
    /**
     * Double rotate binary tree node: first right child
     * with its left child; then node k1 with new right child */
    private AVLNode doubleWithRightChild(AVLNode k1)
    {
        k1.right=rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }
    /* Functions to count number of nodes */
    public int countNodes()
    {
        return size;
    }
    /*private int countNodes(AVLNode r)
    {
        //Complete Your Code Here
    }*/
    /* Functions to search for an element */
    public boolean search(Comparable val)
    {
        return search(root,val);
    }
    private boolean search(AVLNode r, Comparable val)
    {
        if(r==null || !(r.data instanceof NodeData))
            return false;
        else if(val.compareTo(((NodeData)r.data).getIndex())>0)
            return search(r.right,val);
        else if(val.compareTo(((NodeData)r.data).getIndex())<0)
            return search(r.left,val);
        else
            return true;
    }
    /* Function for inorder traversal */
    public void inorder(PrintWriter out)
    {
        inorder(root,out);
    }
    private void inorder(AVLNode r, PrintWriter out)
    {
        if(r!=null && r.data instanceof NodeData) {
            inorder(r.left, out);
            out.print(((NodeData)r.data).getIndex() + ", ");
            inorder(r.right, out);
        }
    }

    public Pair<int[],Integer> getPrivateKey(String sIndex) {
        return getPrivateKey(root,sIndex);

    }

    private Pair<int[],Integer> getPrivateKey(AVLNode r, String sIndex) {
        Integer compCount=0;
        String rIndex;

        while (r != null) {
            compCount++;
            rIndex = ((NodeData)r.data).getIndex();
            if (sIndex.compareTo(rIndex)<0) {
                r = r.left;
            }
            else if (sIndex.compareTo(rIndex)>0) {
                r = r.right;
            }
            else
                break;
        }
        return new Pair(((NodeData)r.data).getPrivateKey(),compCount);
    }

}
