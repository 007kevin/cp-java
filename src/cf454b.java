import java.io.*;
import java.util.*;

/**
 * Problem   = cf454b
 * Date      = Tue May  3 20:50:33 PDT 2022
 * Status    =
 * Reading   =
 * Thinking  =
 * Coding    =
 * Debugging =
 */
public class cf454b {

    public void run() {
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; ++i)
            a[i]=in.nextInt();
        int start=-1;
        for(int i = 1; i <= n; ++i){
            if(a[i-1]>a[i%n]){
                if(start != -1 || a[0]<a[i%n]){
                    out.println(-1);
                    return;
                }
                start=i;
            }
        }
        out.println(start==-1?0:n-start);
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
    cf454b t=new cf454b();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
