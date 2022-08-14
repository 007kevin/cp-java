import java.io.*;
import java.util.*;

/**
 * Problem   = Main
 * Date      = Wed Jun  1 22:00:14 PDT 2022
 * Status    =
 * Reading   =
 * Thinking  =
 * Coding    =
 * Debugging =
 */
public class cf221c {

    public void run() {
        int n = in.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        for(int i = 0; i < n; ++i){
            a[i]=b[i]=in.nextInt();
        }
        Arrays.sort(a);
        int d = 0;
        for(int i = 0; i < n; ++i){
            if(a[i]!=b[i]) d++;
            if(d>2){
                out.println("NO");
                return;
            }
        }
        out.println("YES");
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
    Main t=new Main();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
