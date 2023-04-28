
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1749a
 * Date       = Thu Oct 20 07:27:50 PDT 2022
 * ********************
 * Read  Time =
 * Think Time =
 * Code  Time =
 * Debug Time =
 * Total Time =
 *
 */
public class cf1749av1 {

    public void run() {
        int t = in.nextInt();
        int c = 1;
        while(t-->0){
            System.out.println("Test: " + c++);
            int n = in.nextInt();
            int m =  in.nextInt();
            int[][] b = new int[n+1][n+1];
            List<Rook> rooks = new ArrayList<>();
            for(int i = 0; i < m; ++i){
                int x = in.nextInt();
                int y = in.nextInt();
                rooks.add(new Rook(x,y));
                for(int j = 1; j <= n; ++j){
                    b[x][j]++;
                    b[j][y]++;
                }
            }
            System.out.printf("%d %d\n", n, m);
            for(Rook r : rooks){
                System.out.println(r.x + " " + r.y);
            }
            continue;

            // int yes = 0;
            // for(Rook rook : rooks){
            //     boolean flag=false;
            //     for(int i = 1; i <= n; ++i){
            //         if(b[rook.x][i] == 1 || b[i][rook.y] == 1){
            //             flag=true;
            //             break;
            //         }
            //     }
            //     if (flag) yes++;
            // }
            // if(yes==1) out.println("YES");
            // else out.println("NO");
        }
    }

    public class Rook {
        int x,y;
        Rook(int x, int y){
            this.x=x;
            this.y=y;
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
    cf1749av1 t=new cf1749av1();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
