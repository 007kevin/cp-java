
import java.io.*;
import java.util.*;

/**
 * Problem   = uva116
 * Date      = Sat Aug 13 20:49:16 PDT 2022
 */
public class uva116 {

    public void run() {
        while(in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] matrix = new int[n][m];
            int[][] mpath = new int[n][m];
            for(int i = 0; i < n; ++i){
                for (int j = 0; j < m; ++j){
                    matrix[i][j] = in.nextInt();
                    mpath[i][j] = Integer.MAX_VALUE;
                }
            }
            for(int i = 0; i < n; ++i)
                mpath[i][m-1]=matrix[i][m-1];
            for(int j = m-1; j > 0; --j){
                for(int i = 0; i < n; ++i){
                    mpath[wrap(n,i-1)][j-1] = Math.min(mpath[wrap(n,i-1)][j-1], matrix[wrap(n,i-1)][j-1] + mpath[i][j]);
                    mpath[i][j-1] = Math.min(mpath[i][j-1], matrix[i][j-1] + mpath[i][j]);
                    mpath[wrap(n,i+1)][j-1] = Math.min(mpath[wrap(n,i+1)][j-1], matrix[wrap(n,i+1)][j-1] + mpath[i][j]);
                }
            }
            int mi = 0;
            for(int i = 0; i < n; ++i)
                if(mpath[mi][0] > mpath[i][0]) mi = i;
            int ci = mi;
            out.print(ci+1);
            if(m != 1)
                out.print(" ");
            for(int j = 0; j < m-1; ++j){
                ci=pmin(mpath, j+1, wrap(n, ci-1), ci, wrap(n, ci+1));
                out.print(ci+1);
                if (j != m - 2)
                    out.print(" ");
            }
            out.println();
            out.println(mpath[mi][0]);
        }
    }

    public int wrap(int b, int i) {
        if (b <= i) return 0;
        if (i < 0) return b-1;
        return i;
    }

    public int pmin(int[][] mpath, int m, int a, int b, int c){
        int[] o = new int[]{a,b,c};
        Arrays.sort(o);
        if(mpath[o[0]][m] <= mpath[o[1]][m] && mpath[o[0]][m] <= mpath[o[2]][m]) return o[0];
        if(mpath[o[1]][m] <= mpath[o[0]][m] && mpath[o[1]][m] <= mpath[o[2]][m]) return o[1];
        return o[2];
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
    uva116 t=new uva116();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
