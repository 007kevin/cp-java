
import java.io.*;
import java.util.*;

/**
 * Problem    = cf160c
 * Date       = Sat Oct 22 22:04:57 PDT 2022
 * ********************
 * Read  Time =
 * Think Time =
 * Code  Time = 0:08:27
 * Debug Time =
 * Total Time =
 *
 */
public class cf160c {

    public void run() {
        int n = in.nextInt();
        long k = in.nextLong();
        int[] a = new int[n];
        for(int i = 0; i < n; ++i) a[i]=in.nextInt();
        Arrays.sort(a);
        int p1 = (int)((k-1)/n);
        int p2 = (int)((k-1)%n);
        int dup1 = 0;
        int dup2 = 0;
        for(int i = p1; i > 0 && a[i-1]==a[i]; --i) dup1++;
        for(int i = p1; i < n-1 && a[i+1]==a[i]; ++i) dup2++;
        int p3 = 0;
        for(int i = 0; i <= p2+(n*dup1-1); i+=(dup1+dup2+1))p3++;
        out.printf("p1=%d, p2=%d, dup1=%d, p3=%d\n", p1, p2,dup1,p3);
        out.println(a[p1] + " " + a[p3]);
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
    cf160c t=new cf160c();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
