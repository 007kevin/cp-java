
import java.io.*;
import java.util.*;

/**
 * Problem    = cf270c
 * Date       = Wed Oct 19 21:37:00 PDT 2022
 * ********************
 * Read  Time = 0:05:05
 * Think Time =
 * Code  Time =
 * Debug Time =
 * Total Time = 0:44:37
 *
 */
public class cf270c {

    public void run() {
        int n = in.nextInt();
        long[] k = new long[n];
        long[] a = new long[n];
        for(int i = 0; i < n; ++i){
            k[i]=in.nextLong();
            a[i]=in.nextLong();
        }
        long ans = 0;
        for(int i = 0; i < n; ++i){
            long b = k[i] + f(a[i]);
            ans = ans < b ? b : ans;
        }
        out.println(ans);
    }

    public long f(long a){
        if (a <= 4) return 1;
        long count = 0;
        while(a!=1){
            a = roundUp(a)/4;
            count++;
        }
        return count;
    }

    public long roundUp(long a){
        while(a%4!=0)a++;
        return a;
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
    cf270c t=new cf270c();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
