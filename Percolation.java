import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int n;
    private int[] arr;
    private boolean[] boolArr;
    private WeightedQuickUnionUF uf;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if(n <=0) {
            throw new IllegalArgumentException("Non-positive not allowed");
        }
        this.n=n;
        arr = new int [n*n+2];
        boolArr = new boolean[arr.length];
        for(int i =0; i<arr.length;i++) {
            arr[i] = i;
            boolArr[i] = false;
        }
        uf = new WeightedQuickUnionUF(n*n+2);
    }

    // opens the site (row, col) if it is not open already

    public void open(int row, int col) throws IllegalArgumentException{
        int index = (row-1)*n+col;
        if(((row-1)*n+col)<=0||((row-1)*n+col)>n*n) {
            throw new IllegalArgumentException("not allowed");
        }
        this.boolArr[index] = true;

    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) throws IllegalArgumentException{

        if(((row-1)*n+col)<=0||((row-1)*n+col)>n*n) {
            throw new IllegalArgumentException("not allowed");
        }
        return boolArr[(row-1)*n+col];

    }

        /*
    // is the site (row, col) full?
    public boolean isFull(int row, int col)

    // returns the number of open sites
    public int numberOfOpenSites()

    // does the system percolate?
    public boolean percolates()

    // test client (optional)
    public static void main(String[] args)

     */
}
