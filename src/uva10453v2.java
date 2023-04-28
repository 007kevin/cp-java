
import java.io.*;
import java.util.*;

/**
 * Problem   = uva10453v2
 * Date      = Sun Sep 11 14:17:44 PDT 2022
 *
 * Reattempt based on this clean solution
 * https://github.com/rezwan4029/UVA-CODES/blob/master/10453%20-%20Make%20Palindrome.cpp
 */
public class uva10453v2 {
    int SZ = 1005;
    int[][] dp = new int[SZ][SZ];
    String s;

    public void run() {
        while(in.hasNext()){
            reset();
            s=in.next();
            out.print(solve(0,s.length()-1) + " ");
            print(0,s.length()-1);
            out.println();
        }
    }

    void reset() {
        s=null;
        for(int i = 0; i < SZ; ++i)
            for(int j = 0; j < SZ; ++j)
                dp[i][j]=-1;
    }

    int solve(int i, int j){
        if (i>=j)
            return 0;
        if (dp[i][j]!=-1)
            return dp[i][j];
        if (s.charAt(i)==s.charAt(j))
            dp[i][j]=solve(i+1, j-1);
        else
            dp[i][j]=Math.min(solve(i,j-1), solve(i+1,j))+1;
        return dp[i][j];
    }

    void print(int i, int j){
        if (i>j) return;
        char a = s.charAt(i);
        char b = s.charAt(j);
        if(a==b){
            out.print(a);
            print(i+1, j-1);
            if(i!=j) out.print(b);
        }
        else if (solve(i,j)==solve(i+1,j)+1){
            out.print(a);
            print(i+1,j);
            out.print(a);
        }
        else if(solve(i,j)==solve(i,j-1)+1){
            out.print(b);
            print(i,j-1);
            out.print(b);
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
    uva10453v2 t=new uva10453v2();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
