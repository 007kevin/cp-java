
import java.io.*;
import java.util.*;

/**
 * Problem    = cf465c
 * Date       = Wed Oct  5 21:25:18 PDT 2022
 * ********************
 * Read  Time = 0:01:19
 * Think Time =
 * Code  Time =
 * Debug Time =
 * Total Time =
 *
 */
public class cf465c {

    public void run() {
        int n=in.nextInt();
        int p=in.nextInt();
        char[] s=in.next().toCharArray();
        for(int i = n-1; i >= 0; --i){
            if (valid(s,i,p)){
                out.println(new String(s));
                return;
            }
        }
        out.println("NO");
    }

    boolean valid(char[] s, int i, int p){
        int n = s.length;
        int j = 1;
        while(s[i]-'a'+j < p){
            char c = (char)(s[i]+j++);
            if(i < n-1 && c == s[i+1]) continue;
            if(i < n-2 && c == s[i+2]) continue;
            if(i > 0 && c == s[i-1]) continue;
            if(i > 1 && c == s[i-2]) continue;
            s[i]=c;
            return true;
        }
        return false;
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
    cf465c t=new cf465c();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
