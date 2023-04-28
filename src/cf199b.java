
import java.io.*;
import java.util.*;

/**
 * Problem    = cf199b
 * Date       = Sun Oct  2 21:53:34 PDT 2022
 * ********************
 * Read  Time =
 * Think Time =
 * Code  Time =
 * Debug Time =
 * Total Time =
 *
 */
public class cf199b {

    public void run() {

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
    cf199b t=new cf199b();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
