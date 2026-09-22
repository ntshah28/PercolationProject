import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int n;
    private int[] arr;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if(n <=0) {
            throw new IllegalArgumentException("Non-positive not allowed");
        }
        this.n=n;
        arr = new int [n*n+2];
        for(int i =0; i<arr.length;i++) {
            arr[i] = i;
        }
    }

    // opens the site (row, col) if it is not open already
    /*
    public void open(int row, int col)

    // is the site (row, col) open?
    public boolean isOpen(int row, int col)

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
