
import java.io.File;
import java.io.RandomAccessFile;

/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
public class BSTree {

    Node root;
    int count;
    Node q123;

    BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void clear() {
        root = null;
    }

    void visit(Node p) {
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void breadth(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }

    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }

    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder(p.left, f);
        postOrder(p.right, f);
        fvisit(p, f);
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    String f0() {//input your RollNumber
        String RollNum = "HExxxxx";
        return RollNum;
    }

    void insert(String xType, int xRate, int xWing) {
        //You should insert here statements to complete this function
        if (xType.charAt(0) != 'B' && xRate <= 10) {
            Node var4 = new Node(new Bird(xType, xRate, xWing));
            if (this.root == null) {
                this.root = var4;
            } else {
                Node var5 = this.root;
                Node var6 = this.root;

                while (var5 != null) {
                    var6 = var5;
                    if (var5.info.rate < xRate) {
                        var5 = var5.right;
                    } else {
                        if (var5.info.rate <= xRate) {
                            return;
                        }

                        var5 = var5.left;
                    }
                }

                if (var6.info.rate > xRate) {
                    var6.left = var4;
                } else {
                    var6.right = var4;
                }
            }

        }

    }

//Do not edit this function. Your task is to complete insert function above only.
    void f1(int line) throws Exception {

        clear();
        loadData(line);
        String fname = "fout.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void breadthf2(Node var1, RandomAccessFile var2) throws Exception {
        if (var1 != null) {
            Queue var3 = new Queue();
            var3.enqueue(var1);

            while (!var3.isEmpty()) {
                Node var4 = var3.dequeue();
                if (var4.info.wing >= 4 && var4.info.wing <= 10) {
                    this.fvisit(var4, var2);
                }

                if (var4.left != null) {
                    var3.enqueue(var4.left);
                }

                if (var4.right != null) {
                    var3.enqueue(var4.right);
                }
            }

        }
    }

    void f2(int line) throws Exception {
        clear();
        loadData(line);
        String fname = "fout.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        breadthf2(root, f);
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    Node findFather(Node var1) {
        Node var2 = this.root;

        while (var2.left != var1 && var2.right != var1) {
            if (var2.info.rate > var1.info.rate) {
                var2 = var2.left;
            } else {
                var2 = var2.right;
            }
        }

        return var2;
    }

    void preOrderf3(Node var1, RandomAccessFile var2) throws Exception {
        if (var1 != null) {
            ++this.count;
            if (this.count % 2 == 1) {
                this.fvisit(var1, var2);
            }

            this.preOrderf3(var1.left, var2);
            this.preOrderf3(var1.right, var2);
        }
    }

    void f3(int line) throws Exception {
        clear();
        loadData(line);
        String fname = "fout.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        preOrderf3(root, f);
//------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    void inOrderf4(Node var1, RandomAccessFile var2) throws Exception {
        if (var1 != null) {
            this.inOrderf4(var1.left, var2);
            if (var1.info.rate > 6 && var1.info.wing < 4) {
                this.fvisit(var1, var2);
            }

            this.inOrderf4(var1.right, var2);
        }
    }

    void f4(int line) throws Exception {
        clear();
        loadData(line);
        String fname = "fout.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        inOrderf4(root, f);
//------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    void postOrderf5(Node var1, RandomAccessFile var2) throws Exception {
        if (var1 != null) {
            this.postOrderf5(var1.left, var2);
            this.postOrderf5(var1.right, var2);
            if (var1.info.type.charAt(0) == 'A' || var1.info.type.charAt(0) == 'C') {
                this.fvisit(var1, var2);
            }

        }
    }

    void f5(int line) throws Exception {
        clear();
        loadData(line);
        String fname = "fout.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        postOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        postOrderf5(root, f);
//------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    void inOrderf6(Node var1, RandomAccessFile var2) throws Exception {
        if (var1 != null) {
            this.inOrderf6(var1.left, var2);
            ++this.count;
            if (this.count == 5 && this.q123 == null) {
                this.q123 = var1;
            } else {
                this.inOrderf6(var1.right, var2);
            }
        }
    }

    int numofchildren(Node var1) {
        if (var1.left == null && var1.right == null) {
            return 0;
        } else if (var1.left != null && var1.right == null) {
            return -1;
        } else {
            return var1.left == null && var1.right != null ? 1 : 2;
        }
    }

    void deleteByCopy(int var1) {
        if (!this.isEmpty()) {
            Node var2 = this.root;
            Node var3 = this.root;
            Node var4 = this.root;

            while (var2 != null && var2.info.rate != var1) {
                var3 = var2;
                if (var2.info.rate > var1) {
                    var2 = var2.left;
                } else {
                    var2 = var2.right;
                }
            }

            if (var2 != null) {
                if (this.numofchildren(var2) == 0) {
                    var3 = null;
                }

                if (this.numofchildren(var2) == 1) {
                    if (var3.left == var2) {
                        var3.left = var2.right;
                    } else {
                        var3.right = var2.right;
                    }
                } else {
                    var4 = var2.left;

                    Node var5;
                    for (var5 = var2; var4.right != null; var4 = var4.right) {
                        var5 = var4;
                    }

                    var2.info = var4.info;
                    if (var5.left == var4) {
                        var5.left = var4.left;
                    } else {
                        var5.right = var4.left;
                    }
                }

            }
        }
    }

    void f6(int line) throws Exception {
        clear();
        loadData(line);
        String fname = "fout.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        inOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/

        //------------------------------------------------------------------------------------
        inOrderf6(root, f);
        if (this.q123 != null) {
            Node var5 = this.findFather(this.q123);
            this.deleteByCopy(var5.info.rate);
            this.inOrder(this.root, f);
        }
        f.writeBytes("\r\n");
        f.close();
    }

    void deleteByMerging(int var1) {
        if (!this.isEmpty()) {
            Node var2 = this.root;
            Node var3 = this.root;
            Node var4 = this.root;
            if (this.root.info.rate == var1) {
                switch (this.numofchildren(this.root)) {
                    case 0:
                        this.root = null;
                        break;
                    case 1:
                        this.root = this.root.right;
                        break;
                    case -1:
                        this.root = this.root.left;
                        break;
                    default:
                        for (var4 = this.root.left; var4.right != null; var4 = var4.right) {
                        }
                        var4.right = this.root.right;
                        this.root = this.root.left;
                        break;
                }

            } else {
                while (var2 != null && var2.info.rate != var1) {
                    if (var2.info.rate > var1) {
                        var3 = var2;
                        var2 = var2.left;
                    } else {
                        var3 = var2;
                        var2 = var2.right;
                    }
                }

                if (var2 != null) {
                    if (var2.left == null && var2.right == null) {
                        if (var3.left == var2) {
                            var3.left = null;
                        } else {
                            var3.right = null;
                        }
                    } else if (var2.left != null && var2.right == null) {
                        if (var3.left == var2) {
                            var3.left = var2.left;
                        } else {
                            var3.right = var2.left;
                        }
                    } else if (var2.left == null && var2.right != null) {
                        if (var3.left == var2) {
                            var3.left = var2.right;
                        } else {
                            var3.right = var2.right;
                        }
                    } else {
                        for (var4 = var2.left; var4.right != null; var4 = var4.right) {
                        }

                        if (var3.left == var2) {
                            var3.left = var2.left;
                        } else {
                            var3.right = var2.left;
                        }

                        var4.right = var2.right;
                    }

                }
            }
        }
    }

    void postOrderf7(Node var1, RandomAccessFile var2) throws Exception {
        if (var1 != null) {
            this.postOrderf7(var1.left, var2);
            this.postOrderf7(var1.right, var2);
            ++this.count;
            if (this.count == 6 && this.q123 == null) {
                this.q123 = var1;
            }

        }
    }

    void f7(int line) throws Exception {
        clear();
        loadData(line);
        String fname = "fout.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        postOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        this.q123 = null;
        this.postOrderf7(this.root, f);
        if (this.q123 != null) {
            this.deleteByMerging(this.q123.info.rate);
        }

        
        //------------------------------------------------------------------------------------
        postOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    //=============================================================
    void breadthf8(Node var1, RandomAccessFile var2) throws Exception {
        if (var1 != null) {
            Queue var3 = new Queue();
            var3.enqueue(var1);

            while (!var3.isEmpty()) {
                Node var4 = var3.dequeue();
                ++this.count;
                if (this.count == 4 && this.q123 == null) {
                    this.q123 = var4;
                    return;
                }

                if (var4.left != null) {
                    var3.enqueue(var4.left);
                }

                if (var4.right != null) {
                    var3.enqueue(var4.right);
                }
            }

        }
    }

    int height(Node var1) {
        if (var1.left == null && var1.right == null) {
            return 1;
        } else if (var1.left == null && var1.right != null) {
            return 1 + this.height(var1.right);
        } else {
            return var1.left != null && var1.right == null ? 1 + this.height(var1.left) : 1 + this.max(this.height(var1.left), this.height(var1.right));
        }
    }

    int max(int var1, int var2) {
        return var1 > var2 ? var1 : var2;
    }

    void f8(int line) throws Exception {
        clear();
        loadData(line);
        String fname = "fout.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        this.q123 = null;
        this.breadthf8(this.root, f);
        if (this.q123 != null) {
            int var5 = this.height(this.q123);
            this.q123.info.wing = var5;
            this.breadthf8(this.root, f);
        }
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    void preOrderf9(Node var1, RandomAccessFile var2) throws Exception {
        if (var1 != null) {
            ++this.count;
            if (this.count == 6 && this.q123 == null) {
                this.q123 = var1;
            }

            this.preOrderf9(var1.left, var2);
            this.preOrderf9(var1.right, var2);
        }
    }

    void f9(int line) throws Exception {
        clear();
        loadData(line);
        String fname = "fout.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        this.q123 = null;
        this.preOrderf9(this.root, f);
        if (this.q123 != null) {
            int var5 = this.height(this.q123);
            this.q123.info.wing = var5;
            this.preOrderf9(this.root, f);

        }
        //------------------------------------------------------------------------------------
        preOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    void inOrderf10(Node var1, RandomAccessFile var2) throws Exception {
        if (var1 != null) {
            this.inOrderf10(var1.left, var2);
            ++this.count;
            if (this.numofchildren(var1) == 2 && var1.info.rate < 5 && this.q123 == null) {
                this.q123 = var1;
            }

            this.inOrderf10(var1.right, var2);
        }
    }

    Node rightRotate(Node var1) {
        if (var1 == null) {
            return null;
        } else if (var1.left == null) {
            return var1;
        } else {
            Node var2 = var1.left;
            var1.left = var2.right;
            var2.right = var1;
            return var2;
        }
    }

    void rightRotate(int var1) {
        Node var2 = this.root;
        Node var3 = var2;

        while (var2 != null && var2.info.rate != var1) {
            var3 = var2;
            if (var2.info.rate > var1) {
                var2 = var2.left;
            } else {
                var2 = var2.right;
            }
        }

        if (var2 != null) {
            if (var2 == this.root) {
                this.root = this.rightRotate(var2);
            } else if (var3.left == var2) {
                var3.left = this.rightRotate(var2);
            } else if (var3.right == var2) {
                var3.right = this.rightRotate(var2);
            }

        }
    }

    void f10(int line) throws Exception {
        clear();
        loadData(line);
        String fname = "fout.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        this.q123 = null;
        this.inOrderf10(this.root, f);
        if (this.q123 != null) {
            this.rightRotate(this.q123.info.rate);
            this.inOrderf10(this.root, f);
        }
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    void postOrderf11(Node var1, RandomAccessFile var2) throws Exception {
        if (var1 != null) {
            this.postOrderf11(var1.left, var2);
            this.postOrderf11(var1.right, var2);
            if (var1.right != null && var1.info.rate > 7 && this.q123 == null) {
                this.q123 = var1;
            }

        }
    }

    void leftRotate(int var1) {
        Node var2 = this.root;
        Node var3 = var2;

        while (var2 != null && var2.info.rate != var1) {
            var3 = var2;
            if (var2.info.rate > var1) {
                var2 = var2.left;
            } else {
                var2 = var2.right;
            }
        }

        if (var2 != null) {
            if (var2 == this.root) {
                this.root = this.leftRotate(var2);
            } else if (var3.left == var2) {
                var3.left = this.leftRotate(var2);
            } else if (var3.right == var2) {
                var3.right = this.leftRotate(var2);
            }

        }
    }

    Node leftRotate(Node var1) {
        if (var1 == null) {
            return null;
        } else if (var1.right == null) {
            return var1;
        } else {
            Node var2 = var1.right;
            var1.right = var2.left;
            var2.left = var1;
            return var2;
        }
    }

    void f11(int line) throws Exception {
        clear();
        loadData(line);
        String fname = "fout.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        this.q123 = null;
        this.postOrderf11(this.root, f);
        if (this.q123 != null) {
            this.leftRotate(this.q123.info.rate);
            this.postOrderf11(this.root, f);
        }
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

}
