import java.io.*;
import java.util.*;

/**
 * Problem   = cf431c
 * Date      = Tue Jul  5 20:54:38 PDT 2022
 * Status    =
 * Reading   =
 * Thinking  =
 * Coding    =
 * Debugging =
 */
public class cf431c {

    int mod = 1000000007;

    public void run() {
        int n=in.nextInt();
        int k=in.nextInt();
        int d=in.nextInt();
        int dp[][] = new int[n+1][2];
        dp[0][0]=1;
        for(int i = 0; i < n; ++i){
            for(int j = 1; j <= k; j++){
                if(i+j <= n){
                    if (j < d) {
                        dp[i+j][0]=(dp[i+j][0]+dp[i][0])%mod;
                    } else {
                        dp[i+j][1]=(dp[i+j][1] + dp[i][0])%mod;
                    }
                    dp[i+j][1] = (dp[i+j][1] + dp[i][1])%mod;
                }
            }
        }
        out.println(dp[n][1]);
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
    cf431c t=new cf431c();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
