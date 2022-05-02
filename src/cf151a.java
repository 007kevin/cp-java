import java.io.*;
import java.util.*;

/**
 * Problem   = cf151a
 * Date      = Sun May  1 19:02:43 PDT 2022
 * Status    =
 * Reading   =
 * Thinking  =
 * Coding    =
 * Debugging =
 */
public class cf151a {

    public void run() {
        int n=in.nextInt();
        int k=in.nextInt();
        int l=in.nextInt();
        int c=in.nextInt();
        int d=in.nextInt();
        int p=in.nextInt();
        int nl=in.nextInt();
        int np=in.nextInt();

        int totalDrink=k*l;
        int totalLimes=c*d;
        int totalSalt=p;
        int total=min(totalDrink/nl,totalLimes,totalSalt/np);
        out.println(total/n);

    }

    public static int min(int... a) {
        int min = Integer.MAX_VALUE;
        for (var n : a) {
            min=Math.min(min,n);
        }
        return min;
    }

IR in=new IR(System.in);PrintWriter out=new PrintWriter(System.out);void c(){
out.close();}static class IR {BufferedReader r; StringTokenizer t= null; IR (
InputStream s){r=new BufferedReader(new InputStreamReader(s), 32768);}boolean
p(){while(t==null||!t.hasMoreTokens()){try{String l=r. readLine();if(l==null)
return false; t = new StringTokenizer(l); } catch (IOException e) { throw new
RuntimeException(e);}}return true;}boolean hasNext(){return p();}String next(
){ p();return t.nextToken();}int nextInt() {return Integer.parseInt(next());}
long nextLong() { return Long.parseLong(next());} double nextDouble(){ return
Double.parseDouble( next() ); } } public static void main ( String[ ]args ) {
cf151a t=new cf151a();t.run();t.c();}}
