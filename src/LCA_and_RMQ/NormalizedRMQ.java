package LCA_and_RMQ;

/**
 * Created by guoy28 on 9/21/16.
 */

/**
 * Assume adjacent elements in the input
 * array only differ by +1 or -1, range
 * minimum query (RMQ) problem can be solved
 * in O(n) preprocessing time and O(1) query
 * time following Michael Bender and Martin
 * Colton's algorithm. Specifically, the
 * input array will be divided into blocks
 * of size lgn/2, the total 2n/lgn blocks
 * can be preprocessed and queried in <O(n),
 * O(1)> time by sparse table algorithm.
 * Within each block, RMQ answers can be
 * found quickly by normalizing the block
 * to one of sqrt(n) standard blocks.
 */
public class NormalizedRMQ implements RMQ {
    private int[] a;
    private int N;
    //array of intra-block minimums
    private int[] intraBlockMins;
    //array of indeces of intra-block minimums
    private int[] intraBlockMinIdx;
    /*
     * store all possible RMQ answers for
     * each standardized block. index of
     * a normalized block is encoded by
     * its pattern in binary format. e.g.
     * 011 would be equal to 3, 0101 would
     * be equal to 5.
     */
    private int[][][] standardizedBlockRMQ;

    public NormalizedRMQ (int[] a) {
        this.a = a;
        N = a.length;
        intraBlockMinIdx = new int[(int) (2*N/Math.log())]
    }
    }
}
