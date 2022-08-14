import java.io.*;
import java.util.*;

/**
 * Problem   = cf136c
 * Date      = Sun May 29 20:48:33 PDT 2022
 * Status    =
 * Reading   =
 * Thinking  =
 * Coding    =
 * Debugging =
 */
public class cf136c {

    public void run() {
        int n = in.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; ++i)
            a[i]=in.nextInt();
        Arrays.sort(a);
        if (a[n-1] == 1) {
            for(int i = 0; i < n-1; ++i){
                out.print("1 ");
            }
            out.println("2");
        } else {
            out.print("1 ");
            for(int i = 0; i < n-1; ++i)
                out.print(a[i] + " ");
            out.println();
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
    cf136c t=new cf136c();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
