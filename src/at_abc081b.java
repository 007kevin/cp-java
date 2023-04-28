
import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/**
 * Problem   = at_abc081b
 * Date      = Sat Aug 20 20:45:46 PDT 2022
 */
public class at_abc081b {

    public void run() {
        Integer n = in.nextInt();
        Integer[] a = new Integer[n];
        for(int i = 0; i < n; ++i)
            a[i]=in.nextInt();
        Integer op = Stream.of(a)
                .map(this::f)
                .min(Integer::compare)
                .get();
        out.println(op);
        
    }

    public Integer f(Integer n){
        int cnt=0;
        while(n%2==0){
            cnt++;
            n/=2;
        }
        return cnt;
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
    at_abc081b t=new at_abc081b();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
