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
        if((row<=0)||(row>n)||(col<=0)||(col>n)) {
            throw new IllegalArgumentException("not allowed");
        }
        if(isOpen(row,col)) {
            return;
        }
        this.boolArr[index] = true;

        if(row==1) {
            uf.union(index,0);
        }
        if(row==n) {
            uf.union(index,n*n+1);
        }
        if (row > 1 && isOpen(row - 1,col)) {
            uf.union(index, (row-2)*n +col);
        }
        if (row < n && isOpen(row+1,col)) {
            uf.union(index, row * n + col);
        }
        if (col > 1 && isOpen(row, col-1)) {
            uf.union(index, (row - 1) * n + (col - 1));
        }
        if (col < n && isOpen(row, col + 1)) {
            uf.union(index, (row-1) * n + (col+ 1));
        }


    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) throws IllegalArgumentException{

        if((row<=0)||(row>n)||(col<=0)||(col>n)) {
            throw new IllegalArgumentException("not allowed");
        }

        return boolArr[(row-1)*n+col];

    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if(row<=0||row>n||col<=0||col>n) {
            throw new IllegalArgumentException("Out of bounds");
        }
        int index = (row-1)*n+col;
        return isOpen(row,col) && (uf.connected(0,index));
    }


    // returns the number of open sites
    public int numberOfOpenSites() {
        int count = 0;
        for(int i = 1; i<arr.length;i++) {
            if(boolArr[i] == true) {
                count++;
            }
        }
        return count;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.connected(0,n*n+1);
    }
/*
    // test client (optional)
    public static void main(String[] args)

     */
}
