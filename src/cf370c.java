
import java.io.*;
import java.util.*;

/**
 * Problem    = 370C
 * Date       = Thu Apr 27 22:05:57 PDT 2023
 * ********************
 * Read  Time =
 * Think Time =
 * Code  Time =
 * Debug Time =
 * Total Time =
 *
 */
public class cf370c {

    public void run() {
        int n = in.nextInt();
        int m = in.nextInt();
        Integer[] c = new Integer[n];
        int[] f = new int[m+1];
        int max = 0;
        for(int i = 0; i < n; ++i){
            c[i]=in.nextInt();
            f[c[i]]++;
            max=Math.max(max, f[c[i]]);
        }
        Arrays.sort(c, (a, b) -> f[b]-f[a]==0?a-b:f[b]-f[a]);
        int cnt=0;
        for(int i = 0; i < n; ++i){
            int j = (i+max)%n;
            if(c[i]!=c[j]) cnt++;
        }
        out.println(cnt);
        for(int i = 0; i < n; i++){
            int j = (i+max)%n;
            out.println(c[i] + " " + c[j]);
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
    cf370c t=new cf370c();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
