
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1735b
 * Date       = Sun Oct  2 08:36:04 PDT 2022
 * ********************
 * Read  Time =
 * Think Time =
 * Code  Time =
 * Debug Time =
 * Total Time =
 *
 */
public class cf1735b {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; ++i) a[i]=in.nextInt();
            Arrays.sort(a);
            int min = a[0];
            long cut = 0;
            for(int i = 1; i < n; ++i){
                cut+=find(a[i],min);
            }
            out.println(cut);
        }
    }

    long find(int a, int m){
        long ans = -1;
        long start = 1;
        long end = a;
        while(start <= end){
            long mid = (start+end)/2;
            if((2*m - (a%mid>0?1:0))*mid > a){
                ans=mid-1;
                end=mid-1;
            } else {
                start=mid+1;
            }
        }
        return ans;
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
    cf1735b t=new cf1735b();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
