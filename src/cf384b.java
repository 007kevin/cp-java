
import java.io.*;
import java.util.*;

/**
 * Problem    = cf384b
 * Date       = Fri Apr 28 22:07:21 PDT 2023
 * ********************
 * Read  Time =
 * Think Time =
 * Code  Time =
 * Debug Time =
 * Total Time = 30:16
 *
 */
public class cf384b {

    public void run() {
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                in.nextInt();
        if(m==1){
            out.println(0);
        } else {
            out.println((m * (m - 1)) / 2);
            for(int i = 1; i <= m; ++i){
                for(int j = i+1; j <= m; ++j){
                    if(k==0){
                        out.println(i + " " + j);
                    } else {
                        out.println(j + " " + i);
                    }
                }
            }
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
    cf384b t=new cf384b();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
