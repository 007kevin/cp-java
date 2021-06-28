import java.io.*;
import java.util.*;

/**
 * Problem Uva196
 */
public class Uva196 {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            int col = in.nextInt();
            int row = in.nextInt();
            String[][] s = new String[row+1][col+1];
            for(int i = 1; i <= row; ++i){
                for(int j = 1; j <= col; ++j){
                    s[i][j]=in.next();
                }
            }
            for(int i = 1; i <= row; ++i){
                for(int j = 1; j <= col; ++j){
                    calc(s, i, j);
                }
            }
            for(int i = 1; i <= row; ++i){
                StringJoiner joiner = new StringJoiner(" ");
                for(int j = 1; j <= col; ++j){
                    joiner.add(s[i][j]);
                }
                out.println(joiner.toString());
            }
        }
    }

    public void calc(String[][] s, int r, int c){
        if(s[r][c].charAt(0) != '=') return;
        StringTokenizer tok = new StringTokenizer(s[r][c].substring(1), "+");
        int v = 0;
        while(tok.hasMoreTokens()){
            int[] cell = get(tok.nextToken());
            calc(s, cell[0], cell[1]);
            v+=Integer.parseInt(s[cell[0]][cell[1]]);
        }
        s[r][c]=String.valueOf(v);
    }

    public int[] get(String x){
        String col = "";
        int i;
        for(i = 0; i < x.length(); i++)
        {
            if(x.charAt(i)>='0'&&x.charAt(i)<='9')
                break;
            col += x.charAt(i);
        }
        int factor = 1;
        int c = 0;
        for(int k = 0; k < i; k++)
        {
            c += factor * (col.charAt(i-k-1) - 'A' + 1);
            factor *= 26;
        }
            
        int r = Integer.parseInt(x.substring(i));
        return new int[]{r,c};
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
        Uva196 task = new Uva196(); task.run(); task.close();}
}
