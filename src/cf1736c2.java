
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1736c1
 * Date       = Mon Oct 10 07:53:17 PDT 2022
 * ********************
 * Read  Time =
 * Think Time =
 * Code  Time =
 * Debug Time =
 * Total Time =
 *
 */
public class cf1736c2 {
    public void run() {
        int n = in.nextInt();
        int[] a = new int[n+1];
        int[] b = new int[n+1];
        for(int i = 1; i <= n; ++i){
            a[i]=in.nextInt();
        }
        b[1]=1;
        for(int i = 2; i <= n; ++i){
            if(a[i]>b[i-1]) b[i]=b[i-1]+1;
            else b[i]=Math.min(b[i-1], a[i]);
        }
        int q = in.nextInt();
        while(q-->0){
            int p = in.nextInt();
            int x = in.nextInt();
            out.println(b[p]-b[x-1]);
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
    cf1736c2 t=new cf1736c2();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
