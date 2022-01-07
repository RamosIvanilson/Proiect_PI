package LoginAndRegister;

public class RedBlackTree {

    class Node {

        Books data; // holds the key
        Node parent; // pointer to the parent
        Node left; // pointer to left child
        Node right; // pointer to right child
        int color; // 1 . Red, 0 . Black
    }
    private Node root;
    private Node TNULL;

    // fix the rb tree modified by the delete operation

    private void rbTransplant(Node u, Node v) {
        if (u.parent == null) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }
    
    private void inOrderHelper(Node node) {
            if (node != TNULL) {
                    inOrderHelper(node.left);
                    System.out.print(node.data + " ");
                    inOrderHelper(node.right);
            } 
    }
    
    public void inorder() {
            inOrderHelper(this.root);
    }
    
    // fix the red-black tree
    private void fixInsert(Node k) {
        Node u;
        while (k.parent.color == 1) {
            if (k.parent == k.parent.parent.right) {
                u = k.parent.parent.left; // uncle
                if (u.color == 1) {
                    // case 3.1
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        // case 3.2.2
                        k = k.parent;
                        rightRotate(k);
                    }
                    // case 3.2.1
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    leftRotate(k.parent.parent);
                }
            } else {
                u = k.parent.parent.right; // uncle

                if (u.color == 1) {
                    // mirror case 3.1
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        // mirror case 3.2.2
                        k = k.parent;
                        leftRotate(k);
                    }
                    // mirror case 3.2.1
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    rightRotate(k.parent.parent);
                }
            }
            if (k == root) {
                break;
            }
        }
        root.color = 0;
    }

    private void printHelper(Node root, String indent, boolean last) {
        // print the tree structure on the screen
        if (root != TNULL) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "     ";
            } else {
                System.out.print("L----");
                indent += "|    ";
            }

            String sColor = root.color == 1 ? "RED" : "BLACK";
            System.out.println(root.data + "(" + sColor + ")");
            printHelper(root.left, indent, false);
            printHelper(root.right, indent, true);
        }
    }

    public RedBlackTree() {
        TNULL = new Node();
        TNULL.color = 0;
        TNULL.left = null;
        TNULL.right = null;
        root = TNULL;
    }

    // rotate left at node x
    public void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != TNULL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    // rotate right at node x
    public void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != TNULL) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    // insert the key to the tree in its appropriate position
    // and fix the tree
    public void insert(Books key) {
        // Ordinary Binary Search Insertion
        Node node = new Node();
        node.parent = null;
        node.data = key;
        node.left = TNULL;
        node.right = TNULL;
        node.color = 1; // new node must be red

        Node y = null;
        Node x = this.root;

        while (x != TNULL) {
            y = x;
            if (node.data.code < x.data.code) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        // y is parent of x
        node.parent = y;
        if (y == null) {
            root = node;
        } else if (node.data.code < y.data.code) {
            y.left = node;
        } else {
            y.right = node;
        }

        // if new node is a root node, simply return
        if (node.parent == null) {
            node.color = 0;
            return;
        }

        // if the grandparent is null, simply return
        if (node.parent.parent == null) {
            return;
        }

        // Fix the tree
        fixInsert(node);
    }

    public Node getRoot() {
        return this.root;
    }

    // print the tree structure on the screen
    public void prettyPrint() {
        printHelper(this.root, "", true);
    }
    
    private static void insertIntoShelves(Books b) {
        
        RedBlackTree romanceBlackTree = new RedBlackTree();
        RedBlackTree literaryAndFictionBlackTree = new RedBlackTree();
        RedBlackTree detectiveAndMisteryBlackTree = new RedBlackTree();
        RedBlackTree actionAndAdvatureBlackTree = new RedBlackTree();
        RedBlackTree historicalFictionBlackTree = new RedBlackTree();
        RedBlackTree classicsBlackTree = new RedBlackTree();
        
        switch (b.category) {
            case "Romance":
                romanceBlackTree.insert(b);
                break;
            case "Action and Adventure":
                actionAndAdvatureBlackTree.insert(b);
                break;
            case "Literary Fiction":
                literaryAndFictionBlackTree.insert(b);
                break;
            case "Detective and Mystery":
                detectiveAndMisteryBlackTree.insert(b);
                break;
            case "Historical Fiction":
                historicalFictionBlackTree.insert(b);
                break;
            default:
                classicsBlackTree.insert(b);
                break;
        }
//        if(romanceBlackTree.root != null) {
//            romanceBlackTree.prettyPrint();
//            System.out.println("Romance");
//        } else {
//            System.out.println("Romance tree is null!");
//        }
//        
//        if(literaryAndFictionBlackTree.root != null) {
//            literaryAndFictionBlackTree.prettyPrint();
//            System.out.println("Literary");
//        } else {
//            System.out.println("Literary tree is null!");
//        }
//        
//        if(detectiveAndMisteryBlackTree.root != null) {
//            detectiveAndMisteryBlackTree.prettyPrint();
//        } else {
//            System.out.println("Detective tree is null!");
//        }
//        
//        if(actionAndAdvatureBlackTree.root != null) {
//            actionAndAdvatureBlackTree.prettyPrint();
//        } else {
//            System.out.println("Action tree is null!");
//        }
//        
//        if(historicalFictionBlackTree.root != null) {
//            historicalFictionBlackTree.prettyPrint();
//        } else {
//            System.out.println("Historical tree is null!");
//        }
//        
//        if(classicsBlackTree.root != null) {
//            classicsBlackTree.prettyPrint();
//        } else {
//            System.out.println("Classics tree is null!");
//        }
    }
    
    public static void main(String[] args) {
        
        Books b = new Books();
        b.author = "1";
        b.category = "Romance";
        b.code = 1;
        b.info = "ish";
        b.sinopse = "ddw";
        b.title = "edede";
        
        Books cBooks = new Books();
        cBooks.author = "1";
        cBooks.category = "Classics";
        cBooks.code = 1;
        cBooks.info = "ish";
        cBooks.sinopse = "ddw";
        cBooks.title = "edede";
        
        insertIntoShelves(b);
        insertIntoShelves(cBooks);
    }

}
