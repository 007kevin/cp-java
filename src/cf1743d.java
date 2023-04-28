
import java.io.*;
import java.util.*;

/**
 * Problem    = cf1743d
 * Date       = Mon Oct 17 08:19:07 PDT 2022
 * ********************
 * Read  Time =
 * Think Time =
 * Code  Time =
 * Debug Time =
 * Total Time =
 *
 */
public class cf1743d {

    public void run() {
        int n = in.nextInt();
        char[] s = in.next().toCharArray();
        char[] a = new char[n];
        char[] b = new char[n];
        for(int i = 1; i < n; ++i) a[i-1]=s[i];
        for(int i = 0; i < n-1; ++i) b[i+1]=s[i];
        for(int i = 0; i < n; ++i) if (a[i]!='1') a[i]=s[i];
        for(int i = 0; i < n; ++i) if (b[i]!='1') b[i]=s[i];
        if(count(a) > count(b)){
            out.println(format(a));
        } else {
            out.println(format(b));
        }

    }

    int count(char[] s){
        int c=0;
        for(int i = 0; i < s.length; ++i)
            if(s[i]=='1') c++;
        return c;
    }

    String format(char[] s){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i<s.length && s[i] == '0') i++;
        for(; i < s.length; ++i) sb.append(s[i]);
        return sb.toString();
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
    cf1743d t=new cf1743d();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
