import java.io.*;
import java.util.*;

/**
 * Problem   = Scratch
 * Date      = Tue Jul 26 13:37:46 PDT 2022
 * Status    =
 * Reading   =
 * Thinking  =
 * Coding    =
 * Debugging =
 */
public class Scratch {

    public void run() {
        System.out.println("Enter the size of the array:");
        int n = in.nextInt();
        System.out.println("Enter target value:");
        int v = in.nextInt();
        int[] a = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; ++i){
            a[i]=rand.nextInt();
        }
        Arrays.sort(a);
        // for (int i = 0; i < n; ++i){
        //     System.out.print(a[i] + "\t");
        // }
        // System.out.println();
        if (doesExist(a, v)){
            System.out.println("Yes it exists");
        } else {
            System.out.println("No");
        }

        in.nextDouble();
    }

    private boolean doesExist(int[] a, int v) {
        int l = 0;
        int r = a.length-1;
        while(l<=r){
            int m = (l+r)/2;
            if (a[m] < v){
                l = m+1;
            } else if (a[m] > v) {
                r = m-1;
            } else {
                return true;
            }
        }
        return false;
    }
    

    // private boolean doesExist(int[] a, int v) {
    //     for(int i = 0; i < a.length; ++i){
    //         if(a[i]==v)
    //             return true;
    //     }
    //     return false;
    // }

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
    Scratch t=new Scratch();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
