
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1743b
 * Date       = Mon Oct 17 07:43:18 PDT 2022
 * ********************
 * Read  Time =
 * Think Time =
 * Code  Time =
 * Debug Time =
 * Total Time =
 *
 */
public class cf1743b {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            out.print(1 + " ");
            for(int i = 3; i <=n; ++i)
                out.print(i + " ");
            out.println(2);
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
    cf1743b t=new cf1743b();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
