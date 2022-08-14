import java.io.*;
import java.util.*;

/**
 * Problem   = cf102c
 * Date      = Wed Jun  1 21:09:01 PDT 2022
 * Status    =
 * Reading   =
 * Thinking  =
 * Coding    =
 * Debugging =
 */
public class cf102c {

    public void run() {
        char[] s = in.next().toCharArray();
        int k = in.nextInt();
        if (k >= s.length) {
            out.println(0);
            return;
        }
        List<Freq> l = new ArrayList<>();
        for(char c = 0; c < 256; c++){
            l.add(new Freq(c,0));
        }
        for(char c : s){
            l.get(c).f++;
        }
        l.sort((a,b) -> a.f - b.f);
        for(Freq freq : l) {
            if (freq.f == 0){
                continue;
            }
            for(int i = 0; i < s.length; ++i){
                if (k==0) break;
                if (s[i]==freq.c){
                    s[i]=0;
                    freq.f--;
                    k--;
                }
            }
            if(k==0) break;
        }
        int count = (int)l.stream().filter(freq -> freq.f > 0).count();
        if (count == 0){
            out.println(count);
        } else {
            StringBuilder sb = new StringBuilder();
            for(char c : s){
                if (c!=0){
                    sb.append(c);
                }
            }
            out.println(count);
            out.println(sb);
        }
    }

    static class Freq {
        char c;
        int f;
        Freq(char c, int f){
            this.c=c;
            this.f=f;
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
    cf102c t=new cf102c();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
