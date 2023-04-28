
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1743c
 * Date       = Mon Oct 17 07:52:46 PDT 2022
 * ********************
 * Read  Time =
 * Think Time =
 * Code  Time =
 * Debug Time =
 * Total Time =
 *
 */
public class cf1743c {

    public static char LID='1';

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            char[] l = in.next().toCharArray();
            int[] a = new int[n];
            for(int i = 0; i < n; ++i) a[i]=in.nextInt();
            long[][] dp = new long[n][2];
            dp[0][0]=l[0]==LID?a[0]:0;
            dp[0][1]=0;
            for(int i = 1; i < n; ++i){
                if(l[i]!=LID){
                    dp[i][0]=Math.max(dp[i-1][0], dp[i-1][1]);
                    dp[i][1]=dp[i][0];
                } else {
                    dp[i][0]=Math.max(dp[i-1][0], dp[i-1][1]) + a[i];
                    dp[i][1]=Math.max(
                            dp[i-1][1] + a[i-1],
                            dp[i-1][0] - a[i]);
                }
            }
            out.println(Math.max(dp[n-1][0],dp[n-1][1]));
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
    cf1743c t=new cf1743c();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
