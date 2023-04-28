
import java.io.*;
import java.util.*;

/**
 * Problem   = uva662
 * Date      = Wed Sep 21 21:35:57 PDT 2022
 * ********************
 * Read  Time = 0:02:25
 * Think Time = 0:57:21
 * Code  Time =
 * Debug Time =
 * Total Time =
 * ********************
 * Could not think of a solution in an hour.
 */
public class uva662 {
    static int MAX = 100000007;

    int d[] = new int[201];
    int cdp[][] = new int[201][201];
    int dp[][] = new int[201][31];

    public void reset(){
        for(int i = 0; i < dp.length; ++i){
            for(int j = 0; j < dp[i].length; ++j){
                dp[i][j]=MAX;
            }
        }
        for(int i = 0; i < cdp.length; ++i){
            for(int j = 0; j < cdp.length; ++j){
                cdp[i][j]=MAX;
            }
        }
    }

    public void run() {
        int chain = 1;
        while(true){
            int n=in.nextInt();
            int k=in.nextInt();
            if (n==0 && k == 0) break;
            reset();
            for(int i = 1; i <= n; ++i){
                d[i]=in.nextInt();
            }
            out.println("Chain " + chain++);
            print(n,k);
            out.println("Total distance sum = " + solve(n,k));
            out.println();
        }
    }

    public int solve(int n, int k){
        if (n<=k) return 0;
        if (k==1) return cost(1,n);
        if (k==0) return 10000007;
        if (dp[n][k]!=MAX) return dp[n][k];
        for(int i = 0; i < n; ++i){
            dp[n][k]=Math.min(dp[n][k], solve(i,k-1) + cost(i+1, n));
        }
        return dp[n][k];
    }

    public void print(int n, int k){
        for(int i = n-1; i >= 0; --i){
            if(solve(i, k-1) + cost(i+1,n) == solve(n,k)){
                print(i,k-1);
                int depot = k;
                int atRest = (i+1+n)/2;
                int fromRest = i+1;
                int toRest = n;
                if (fromRest == toRest) {
                    out.printf("Depot %d at restaurant %d serves restaurant %d\n", depot, atRest, fromRest);
                } else {
                    out.printf("Depot %d at restaurant %d serves restaurants %d to %d\n", depot, atRest, fromRest, toRest);
                }
                return;
            }
        }
    }

    public int cost(int a, int b){
        if (cdp[a][b] != MAX) return cdp[a][b];
        int mid = (a+b)/2;
        int c = 0;
        for(int i = a; i <= b; ++i){
            c+=Math.abs(d[i]-d[mid]);
        }
        return cdp[a][b] = c;
    }

    /////////////////////////////////////////////////////////////////////////////
    IR in=new IR(System.in);PrintWriter out=new PrintWriter(System.out);void c(){
    out.close();}static class IR {BufferedReader r; StringTokenizer t= null; IR (
    InputStream s){r=new BufferedReader(new InputStreamReader(s), 32768);}boolean
    p(){while(t==null||!t.hasMoreTokens()){try{String l=r. readLine();if(l==null)
    return false; t = new StringTokenizer(l); } catch (IOException e) { throw new
    RuntimeException(e);}}return true;}boolean hasNext(){return p();}String next(
    ){ p();return t.nextToken();}int nextInt() {return Integer.parseInt(next());}
    long nextLong() { return Long.parseLong(next());} double nextDouble(){ return
    Double.parseDouble( next() ); } } public static void main ( String[ ]args ) {
    uva662 t=new uva662();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
