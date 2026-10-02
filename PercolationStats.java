import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private static final double c95 = 1.96;
    private double[] threshold;
    private int trials;
    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials){
        if (n <= 0||trials <= 0) {
            throw new IllegalArgumentException("n and trials must be positive");
        }



        this.trials =trials;
        threshold =new double[trials];

        for (int i=0; i < trials; i++) {
            Percolation perc = new Percolation(n);
            while (!perc.percolates()) {
                int row = (int)(Math.random() * n) + 1;
                int col=(int)(Math.random() * n) + 1;
                perc.open(row, col);
            }
            threshold[i]=(double) perc.numberOfOpenSites() / (n * n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        double sum = 0;
        for(int i=0; i<trials; i++) {
            sum+=threshold[i];
        }
        return sum/trials;
    }

    // sample standard deviation of percolation threshold
    public double stddev() throws IllegalArgumentException{
        if(trials==1) {
            return Double.NaN;
        }
        double avg = mean();
        double ssd = 0.0;
        for(int i = 0; i < trials; i++) {
            double diff = threshold[i]-avg;
            ssd += diff*diff;
        }
        return Math.sqrt(ssd/(trials-1));
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - (c95*stddev()/Math.sqrt(trials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + (c95*stddev()/Math.sqrt(trials));

    }

    // test client (see below)
    /*
    public static void main(String[] args)

 */

}
