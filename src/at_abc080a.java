
import java.io.*;
import java.util.*;

/**
 * Problem   = at_abc080a
 * Date      = Mon Aug 15 22:35:08 PDT 2022
 */
public class at_abc080a {

    public void run() {
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int p1 = a*n;
        int p2 = b;
        out.println(Math.min(p1,p2));
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
    at_abc080a t=new at_abc080a();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
