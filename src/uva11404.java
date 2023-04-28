
import java.io.*;
import java.util.*;

/**
 * Problem    = uva11404
 * Date       = Sat Oct  1 10:01:52 PDT 2022
 * ********************
 * Read  Time = 0:01:37
 * Think Time = 0:06:01
 * Code  Time = 1:08:08
 * Debug Time =
 * Total Time =
 *
 */
public class uva11404 {
    static int MAX = 1001;
    char[] s;
    int[][] dp = new int[MAX][MAX];

    public void run() {
        while(in.hasNext()){
            s = in.next().toCharArray();
            reset();
            int ans = solve(0,s.length-1);
            StringBuilder suffix = find(0,s.length-1);
            out.println(build(suffix, ans));
        }
    }

    public void reset(){
        for(int i = 0; i < s.length; ++i){
            for(int j = 0; j < s.length; ++j){
                dp[i][j]=0;
            }
        }
    }

    public int solve(int i, int j){
        if(i>j) return 0;
        if(i==j) return 1;
        if(dp[i][j]!=0) return dp[i][j];
        if(s[i]==s[j])
            return dp[i][j]=solve(i+1,j-1) + 2;
        return dp[i][j]=Math.max(solve(i+1,j), solve(i,j-1));
    }

    public StringBuilder find(int i, int j){
        if(i>j) return new StringBuilder();
        if(s[i]==s[j]){
            return find(i+1,j-1).append(s[i]);
        }
        int left = solve(i+1,j);
        int right = solve(i,j-1);
        if (left > right) {
            return find(i+1,j);
        }
        if (left < right) {
            return find(i,j-1);
        }
        StringBuilder s1 = find(i+1,j);
        StringBuilder s2 = find(i,j-1);
        char c1 = s1.charAt(s1.length()-1);
        char c2 = s2.charAt(s2.length()-1);
        return c1 < c2 ? s1:s2;
    }

    public String build(StringBuilder suffix, int ans){
        StringBuilder sb = new StringBuilder();
        for(int i = suffix.length() - 1; i >= 0 + ans%2; --i){
            sb.append(suffix.charAt(i));
        }
        return sb.append(suffix).toString();
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
    uva11404 t=new uva11404();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
