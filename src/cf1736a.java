
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1736a
 * Date       = Mon Oct 10 07:35:33 PDT 2022
 * ********************
 * Read  Time =
 * Think Time =
 * Code  Time =
 * Debug Time =
 * Total Time =
 *
 */
public class cf1736a {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for(int i = 0; i < n; ++i) a[i]=in.nextInt();
            for(int i = 0; i < n; ++i) b[i]=in.nextInt();
            int op1 = 0;
            for(int i = 0; i < n; ++i) op1+=a[i]!=b[i]?1:0;
            int op2 = 1;
            Arrays.sort(a);
            Arrays.sort(b);
            for(int i = 0; i < n; ++i) op2+=a[i]!=b[i]?1:0;
            out.println(Math.min(op1,op2));
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
    cf1736a t=new cf1736a();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
