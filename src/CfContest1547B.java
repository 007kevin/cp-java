import java.io.*;
import java.util.*;

/**
 * Problem CfContest1547B
 */
public class CfContest1547B {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            char[] s = in.next().toCharArray();
            out.println(
                unique(s) && poss(s) && find(s,0,s.length - 1, '~') ? "YES" : "NO");
        }
    }

    boolean find(char[] s, int i, int j, char m){
        if(i==j){
            return s[i]=='a';
        }
        if(s[i]<s[j]&&s[j]<m){
            return find(s,i,j-1,s[j]);
        } else if (s[i]>s[j]&&s[i]<m){
            return find(s,i+1,j,s[i]);
        }
        return false;
    }

    boolean unique(char[] s){
        char[] c = new char[256];
        for(int i = 0; i < s.length; ++i){
            if(c[s[i]] != 0) return false;
            c[s[i]]=1;
        }
        return true;
    }

    boolean poss(char[] s){
        char[] c = s.clone();
        Arrays.sort(c);
        for (int i = 0; i < c.length-1; i++) {
            if(c[i]+1!=c[i+1]) return false;
        }
        return true;
    }

    /***********************************************************
     *                      BOILERPLATE                        *
    /***********************************************************/
    public InputReader in = new InputReader(System.in);
    public PrintWriter out = new PrintWriter(System.out);
    public void close() {out.close();}
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokens = null;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);}
        private boolean prime() {
            while (tokens == null || !tokens.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    if(line==null) return false; // EOF
                    tokens = new StringTokenizer(line);
                } catch (IOException e) {throw new RuntimeException(e);}
            } return true;}
        public boolean hasNext() {return prime();}
        public String next() {prime(); return tokens.nextToken();}
        public int nextInt() {return Integer.parseInt(next());}
        public long nextLong() {return Long.parseLong(next());}
        public double nextDouble() {return Double.parseDouble(next());}
    }
    public static void main(String[] args) {
        CfContest1547B task = new CfContest1547B(); task.run(); task.close();}
}
