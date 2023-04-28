
import java.io.*;
import java.util.*;

/**
 * Problem    = uva757
 * Date       = Sat Oct  1 13:32:06 PDT 2022
 * ********************
 * Read  Time = 0:08:52
 * Think Time = 0:22:57
 * Code  Time = 0:55:14
 * Debug Time =
 * Total Time =
 * x/
 */
public class uva757 {
    static int MAXN = 25;
    static int MAXM = 193;
    int N;
    int[] f = new int[MAXN];
    int[] d = new int[MAXN];
    int[] t = new int[MAXN];
    int[][] dp = new int[MAXN][MAXM];
    int[][] edp = new int[MAXN][MAXM];

    public void reset() {
        for(int i = 0; i < MAXN; ++i){
            f[i]=0;
            d[i]=0;
            t[i]=0;
            for(int j = 0; j < MAXM; ++j){
                dp[i][j]=-1;
                edp[i][j]=-1;
            }
        }
    }

    public void run() {
        boolean start = true;
        while(true){
            reset();
            N = in.nextInt();
            if (N==0) return;
            if (!start){
                out.println();
            }
            start=false;
            int m = (in.nextInt() * 60 / 5);
            for(int i = 0; i < N; ++i) f[i]=in.nextInt();
            for(int i = 0; i < N; ++i) d[i]=in.nextInt();
            for(int i = 0; i < N - 1; ++i) t[i]=in.nextInt();
            List<Integer> list = new ArrayList<>();
            find(list, 0,m);
            while(list.size() < N) list.add(0);
            StringJoiner joiner = new StringJoiner(", ");
            list.stream().map(i -> Integer.toString(i)).forEach(joiner::add);
            out.println(joiner.toString());
            out.println("Number of fish expected: " + solve(0, m));
        }
    }

    public int solve(int n, int m){
        if(n>=N) return 0;
        if(m<=0) return 0;
        if(dp[n][m]!=-1) return dp[n][m];
        for(int i = 0; i <= m; ++i){
            dp[n][m] = Math.max(dp[n][m], solve(n+1, m-i-t[n]) + e(n,i));
        }
        return dp[n][m];
    }

    public int e(int n, int m){
        if (edp[n][m]!=-1) return edp[n][m];
        int fish = 0;
        for(int i = 0; i < m; ++i){
            fish+=Math.max(0, f[n] - d[n]*i);
        }
        return edp[n][m] = fish;
    }

    public void find(List<Integer> list, int n, int m){
        if(n>=N) return;
        if(m<=0) return;
        for (int i = m; i >= 0; --i){
            if (e(n,i) + solve(n+1, m-i-t[n]) == solve(n,m)){
                list.add(i*5);
                find(list, n+1, m-i-t[n]);
                return;
            }
        }
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
    uva757 t=new uva757();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
