import java.util.*;

class TreeAncestor {

    private int n;
    private int[][] d; 

    public TreeAncestor(int n, int[] parent) {
        this.n = n;
        this.d = new int[20][n];
        for(int i = 0; i < n; ++i)
            d[0][i]=parent[i];
        for(int i = 1; i < 20; ++i){
            for(int node = 0; node < n; ++node){
                int pnode = d[i-1][node];
                if(pnode!=-1) d[i][node] = d[i-1][pnode];
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        if(node==0&&k>0) return -1;
        if(k==0) return node;
        return getKthAncestor(d[k&-k][node], k-(k&-k));
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
