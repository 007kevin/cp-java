
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1743a
 * Date       = Mon Oct 17 07:33:39 PDT 2022
 * ********************
 * Read  Time =
 * Think Time =
 * Code  Time =
 * Debug Time =
 * Total Time =
 *
 */
public class cf1743a {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; ++i) a[i]=in.nextInt();
            int ans = 0;
            int m = 10-n;
            for(int i = 1; i <= m; ++i)
                for(int j = i+1; j <= m; ++j)
                    ans+=6;
            out.println(ans);
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
    cf1743a t=new cf1743a();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
