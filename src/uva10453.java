
import java.io.*;
import java.util.*;

/**
 * Problem   = uva10453
 * Date      = Sat Sep 10 09:57:40 PDT 2022
 */
public class uva10453 {

    public void run() {
        while(in.hasNext()){
            String raw = in.next();
            CharView s = new CharView(raw.toCharArray(), 0, raw.length());
            int n = s.length();
            CharView a = null;
            for(int i = 0; i < n; ++i){
                CharView left1 = s.subSequence(0, i);
                CharView right1 = s.subSequence(i+1, n).reverse();
                CharView lcs1 = lcs(left1, right1);
                int rem1len = left1.length() + right1.length() - 2*lcs1.length();
                int p1len = 2*(rem1len + lcs1.length()) + 1;
                // out.println(p1);
                if (a == null || p1len < a.length()){
                    CharView rem1 = rem(lcs1, left1, right1);
                    a = concat(
                            rem1,
                            lcs1,
                            new CharView(new char[]{s.charAt(i)}, 0, 1),
                            lcs1.reverse(),
                            rem1.reverse());
                }
                CharView left2 = left1;
                CharView right2 = s.subSequence(i+1, n).reverse();
                CharView lcs2 = lcs(left2, right2);
                int rem2len = left2.length() + right2.length() - 2*lcs2.length();
                int p2len = 2*(rem2len + lcs2.length()) + 2;
                // out.println(p2);
                if (a == null || p2len < a.length()){
                    CharView rem2 = rem(lcs2, left2, right2);
                    a = concat(
                            rem2,
                            lcs2,
                            lcs2.reverse(),
                            rem2.reverse());
                }
            }
            out.printf("%d %s\n", a.length() - s.length(), a);
        }
    }

    public static class CharView implements CharSequence {
        char[] c;
        int start, end;

        public CharView(char[] c, int start, int end) {
            this.c=c;
            this.start=start;
            this.end=end;
        }

        @Override
        public int length() {
            return this.end-this.start;
        }

        @Override
        public char charAt(int index) {
            return this.c[this.start+index];
        }

        @Override
        public CharView subSequence(int start, int end) {
            return new CharView(this.c, this.start + start, this.start + end);
        }

        public CharView reverse() {
            int n = this.start + this.length();
            char[] r = new char[n];
            for(int i = start; i < n; ++i){
                r[n-i-1]=c[i];
            }
            return new CharView(r, n-this.end, n-this.start-1);
        }

        public String toString() {
            System.out.println(this.start + " " + this.end);
            return new String(this.c, this.start, this.end-this.start);
        }
    }

    public CharView concat(CharView... ss) {
        int n = 0;
        for(CharView s : ss){
            System.out.println(s + " " + s.length());
            n+=s.length();
        }
        char[] c = new char[n];
        int i = 0;
        for(CharView s : ss){
            for(int j = s.start; j < s.end; ++j){
                c[i++]=s.charAt(j);
            }
        }
        return new CharView(c,0,n);
    }

    public CharView lcs(CharView a, CharView b) {
        // out.println("------------------");
        // out.println("[" + a + "|" + b + "]");
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= m; ++j){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                } else {
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        char[] lcs = new char[1000];
        int lcsi =0 ;
        int[][] f = new int[256][2];
        int i = n, j = m;
        while(i>0&&j>0){
            while(j > 0 && dp[i][j-1] == dp[i][j]) j--;
            while(i > 0 && dp[i-1][j] == dp[i][j]) i--;
            if (i > 0)
                lcs[lcsi++] = a.charAt(i-1);
                        i--;
            j--;
        }
        return new CharView(lcs,0,lcsi).reverse();
    }

    public CharView rem(CharView lcs, CharView a, CharView b){
        char[] rem = new char[1000];
        int remi = 0;
        int[][] freq = new int[256][2];
        for(int i = 0; i < lcs.length(); ++i){
            freq[lcs.charAt(i)][0]++;
            freq[lcs.charAt(i)][1]++;
        }
        for(int i = 0; i < a.length(); ++i){
            if (freq[a.charAt(i)][0]--<=0)
                rem[remi++]=a.charAt(i);
        }
        for(int i = 0; i < b.length(); ++i){
            if (freq[b.charAt(i)][1]--<=0)
                rem[remi++]=b.charAt(i);
        }
        return new CharView(rem, 0,  remi);
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
                                                                              uva10453 t=new uva10453();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
