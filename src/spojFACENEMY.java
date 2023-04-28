
import java.io.*;
import java.util.*;

/**
 * Problem    = spojFACENEMY
 * Date       = Mon Oct  3 22:09:46 PDT 2022
 * ********************
 * Read  Time =
 * Think Time =
 * Code  Time =
 * Debug Time = 0:31:57
 * Total Time =
 *
 * Good resource https://cp-algorithms.com/geometry/basic-geometry.html
 * This problem can be solved using enough precision. Java's double is not
 * enough but works for c++'s long double. I can solve this using BigDecimal
 * but would rather move on to more interesting problems.
 */
public class spojFACENEMY {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            Person p1 = new Person(
                    in.nextInt(),
                    in.nextInt(),
                    in.nextInt(),
                    in.nextInt());
            Person p2 = new Person(
                    in.nextInt(),
                    in.nextInt(),
                    in.nextInt(),
                    in.nextInt());
            double a1 = p1.calc(p2);
            double a2 = p2.calc(p1);
            a1=Math.min(Math.abs(360-a1), a1);
            a2=Math.min(Math.abs(360-a2), a2);
            if (a1 < a2) out.println("Hero");
            else if (a1>a2) out.println("Heroine");
            else out.println("0");
        }
    }

    public class Person {
        int x,y,u,v;
        public Person(int x, int y, int u, int v){
            this.x=x;
            this.y=y;
            this.u=u;
            this.v=v;
        }

        public double calc(Person that){
            int[] a = new int[]{u-x, v-y};
            int[] b = new int[]{that.x - x, that.y - y};
            double dot = a[0]*b[0] + a[1]*b[1];
            double sca = Math.sqrt(a[0]*a[0] + a[1]*a[1]) * Math.sqrt(b[0]*b[0] + b[1]*b[1]);
            return Math.acos(dot/sca);
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
    spojFACENEMY t=new spojFACENEMY();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
