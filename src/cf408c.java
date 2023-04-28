
import java.io.*;
import java.util.*;

/**
 * Problem    = cf408c
 * Date       = Wed Oct  5 22:01:40 PDT 2022
 * ********************
 * Read  Time =
 * Think Time =
 * Code  Time =
 * Debug Time =
 * Total Time =
 *
 */
public class cf408c {
    static Map<Integer, Integer> psq = new HashMap<>();
    static {for(int i = 1; i <= 1000; ++i) psq.put(i*i, i);}

    public void run() {
        Pair a = find(in.nextInt());
        Pair b = find(in.nextInt());
        if (a==null || b == null){
            out.println("NO");
            return;
        }
        Pair gcda = a.gcd();
        Pair gcdb = b.gcd();
        if (gcda.x == gcdb.x && gcda.y == gcdb.y){
            if (a.x != b.y || a.y != b.x){
                out.println("YES");
                out.println("0 0");
                out.println(a.x + " " + a.y);
                out.println((-b.y) + " " + (b.x));
                return;
            }
        }
        out.println("NO");
    }

    Pair find(int a){
        int sq=a*a;
        for(int i = 1; i <= sq/2; ++i){
            if (psq.containsKey(i) && psq.containsKey(sq-i)){
                return new Pair(psq.get(i), psq.get(sq-i));
            }
        }
        return null;
    }

    public class Pair {
        int x, y;
        Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
        Pair gcd() {
            int gcd = findGCD(x,y);
            return new Pair(x/gcd, y/gcd);
        }
    }

    int findGCD(int a, int b){
        return b == 0 ? a : findGCD(b, a%b);
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
    cf408c t=new cf408c();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
