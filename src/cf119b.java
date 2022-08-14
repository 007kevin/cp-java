import java.io.*;
import java.util.*;

/**
 * Problem   = cf119b
 * Date      = Thu Jun  2 21:33:50 PDT 2022
 * Status    =
 * Reading   =
 * Thinking  =
 * Coding    =
 * Debugging =
 */
public class cf119b {

    public void run() {
        Ring r1 = new Ring(
                in.nextInt(),
                in.nextInt(),
                in.nextInt(),
                in.nextInt());
        Ring r2 = new Ring(
                in.nextInt(),
                in.nextInt(),
                in.nextInt(),
                in.nextInt());
        int cnt = 0;
        if (!(r1.internal.intersect(r2.internal) || r1.internal.intersect(r2.external))) {
            cnt++;
        }
        if (!(r1.external.intersect(r2.internal) || r1.external.intersect(r2.external))) {
            cnt++;
        }
        if (!(r2.internal.intersect(r1.internal) || r2.internal.intersect(r1.external))) {
            cnt++;
        }
        if (!(r2.external.intersect(r1.internal) || r2.external.intersect(r1.external))) {
            cnt++;
        }
        out.println(cnt);
        out.println(r1);
        out.println(r2);
        out.println(r2.internal.intersect(r1.internal));
    }

    static class Ring {
        Circle internal,external;
        Ring(int x,int y, int r, int R){
            this.internal = new Circle(x,y,r);
            this.external = new Circle(x,y,R);
        }
        public String toString() {
            return String.format("inner(%d %d %f), outer(%d %d %f)",
                    this.internal.x,
                    this.internal.y,
                    this.internal.r,
                    this.external.x,
                    this.external.y,
                    this.external.r);
        }
    }

    static class Circle {
        int x,y, r;
        Circle(int x, int y, int r){
            this.x=x;
            this.y=y;
            this.r=r;
        }

        boolean intersect(Circle that) {
            int x = this.x-that.x;
            int y = this.y-that.y;
            int d = x*x+y*y;
            int r = this.r;
            return false;
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
    cf119b t=new cf119b();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
