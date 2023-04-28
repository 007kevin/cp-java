
import java.io.*;
import java.util.*;

/**
 * Problem   = at_abc080b
 * Date      = Mon Aug 15 22:44:12 PDT 2022
 */
public class at_abc080b {

    public void run() {
        int n = in.nextInt();
        if (n%f(Integer.toString(n))==0){
            out.println("Yes");
        } else
            out.println("No");
    }

    public int f(String x){
        int s=0;
        for(char c : x.toCharArray()){
            s+=c-'0';
        }
        return s;
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
    at_abc080b t=new at_abc080b();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
