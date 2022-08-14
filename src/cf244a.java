import java.io.*;
import java.util.*;

/**
 * Problem   = cf244a
 * Date      = Wed May 25 21:40:10 PDT 2022
 * Status    =
 * Reading   =
 * Thinking  =
 * Coding    =
 * Debugging =
 */
public class cf244a {

    public void run() {
        int n = in.nextInt();
        int k = in.nextInt();
        int s[] = new int[n*k+1];
        for(int i = 1; i <= n*k; ++i) s[i]=i;
        for(int i = 1; i <= k; ++i){
            int a = in.nextInt();
            int j=1;
            for(;s[j]!=a;j++);
            int b = s[n*(i-1)+1];
            s[n*(i-1)+1]=a;
            s[j]=b;
        }
        for(int i = 0; i < k; ++i){
            for(int j = 0; j < n; ++j){
                out.print(s[(i*n)+j+1] + " ");
            }
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
    cf244a t=new cf244a();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
