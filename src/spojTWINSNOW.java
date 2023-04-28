
import java.io.*;
import java.util.*;

/**
 * Problem    = spojTWINSNOW
 * Date       = Mon Oct  3 21:17:37 PDT 2022
 * ********************
 * Read  Time =
 * Think Time =
 * Code  Time = 0:19:43
 * Debug Time =
 * Total Time = 0:41:03
 *
 * -- Approach was correct but took multiple attempts due to tle. First used string concat, then List<Integer>, then
 * finally primitive arrays.
 * -- Actually sorting is not the correct solution. Still TLE. We should actually use has to make O(n)
 */
public class spojTWINSNOW {

    public void run() {
        int n = in.nextInt();
        int[][] list = new int[n][6];
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < 6; ++j){
                list[i][j]=in.nextInt();
            }
            Arrays.sort(list[i]);
            set.add(toList(list[i]));
        }
        if (set.size() != n){
            out.println("Twin snowflakes found.");
            return;
        }
        out.println("No two snowflakes are alike.");
    }

    public List<Integer> toList(int[] a){
        List<Integer> list = new ArrayList<>();
        for(int x : a) list.add(x);
        return list;
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
    spojTWINSNOW t=new spojTWINSNOW();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
