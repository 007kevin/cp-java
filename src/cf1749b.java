
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1749b
 * Date       = Sat Oct 22 10:46:20 PDT 2022
 * ********************
 * Read  Time =
 * Think Time =
 * Code  Time =
 * Debug Time =
 * Total Time =
 *
 */
public class cf1749b {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for(int i = 0; i < n; ++i) a[i]=in.nextInt();
            for(int i = 0; i < n; ++i) b[i]=in.nextInt();
            int i = 0, j = n-1;
            long ans = 0;
            while(i<j){
                if (b[i] < b[j]){
                    ans+=a[i]+b[i];
                    i++;
                } else {
                    ans+=a[j]+b[j];
                    j--;
                }
            }
            ans+=a[i];
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
    cf1749b t=new cf1749b();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
