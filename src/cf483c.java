import java.io.*;
import java.util.*;

/**
 * Problem   = cf483c
 * Date      = Sun May 29 20:30:54 PDT 2022
 * Status    =
 * Reading   =
 * Thinking  =
 * Coding    =
 * Debugging =
 */
public class cf483c {

    public void run() {
        int n = in.nextInt();
        int k = in.nextInt();
        int l = 1;
        int h = n;
        int i = 0;
        for (; i < k-1; ++i){
            if(i%2==0){
                out.print(l++ + " ");
            } else {
                out.print(h-- + " ");
            }
        }
        if (i%2==0){
            for(;i < n; ++i){
                out.print(l++ + " ");
            }
        } else {
            for(;i < n; ++i){
                out.print(h-- + " ");
            }
        }
        out.println();
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
    cf483c t=new cf483c();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
