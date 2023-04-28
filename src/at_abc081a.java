
import java.io.*;
import java.util.*;

/**
 * Problem   = at_abc081a
 * Date      = Tue Aug 16 21:37:48 PDT 2022
 */
public class at_abc081a {

    public void run() {
        String s = in.next();
        int sum = 0;
        for(char c : s.toCharArray()){
            sum+=c-'0';
        }
        out.println(sum);
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
    at_abc081a t=new at_abc081a();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
