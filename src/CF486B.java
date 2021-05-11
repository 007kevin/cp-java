import java.io.*;
import java.util.*;

/**
 * Problem CF486B
 */
public class CF486B {

    static class Task extends IOHandler {
        public void run() {
            int m = in.nextInt();
            int n = in.nextInt();
            int[][] b = new int[m][n];
            int[][] a = new int[m][n];
            for(int i = 0; i < m; ++i){
                for(int j = 0; j < n; ++j){
                    a[i][j]=1;
                }
            }
            for(int i = 0; i < m; ++i){
                for(int j = 0; j < n; ++j){
                    b[i][j]=in.nextInt();
                }
            }
            for(int i = 0; i < m; ++i){
                for(int j = 0; j < n; ++j){
                    if(b[i][j]==0){
                        for(int r = 0; r < m; ++r){
                            a[r][j]=0;
                        }
                        for(int c = 0; c < n; ++c){
                            a[i][c]=0;
                        }
                    }
                }
            }
            for(int i = 0; i < m; ++i){
                for(int j = 0; j < n; ++j){
                    if(b[i][j]==1){
                        boolean check = false;
                        for(int r = 0; r < m; ++r){
                            if(a[r][j]==1) check = true;
                        }
                        for(int c = 0; c < n; ++c){
                            if(a[i][c]==1) check = true;;
                        }
                        if(!check) {
                            out.println("NO");
                            return;
                        }
                    }
                }
            }
            out.println("YES");
            for(int i = 0; i < m; ++i){
                for(int j = 0; j < n; ++j){
                    out.print(a[i][j] + " ");
                }
                out.println();
            }
        }
    }


    /***********************************************************
     *                      BOILERPLATE                        *
     ***********************************************************/
    public static void main(String[] args) {
        Task task = new Task();
        task.run();
        task.cleanup();
    }
    static class IOHandler  {
        public InputReader in = new InputReader(System.in);
        public PrintWriter out = new PrintWriter(System.out);
        public void cleanup() {out.close();}
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer = null;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
        }
        private boolean prime() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    if(line==null) return false; // EOF
                    tokenizer = new StringTokenizer(line);
                } catch (IOException e) {throw new RuntimeException(e);}
            }
            return true;
        }
        public boolean hasNext() {return prime();}
        public String next() {prime(); return tokenizer.nextToken();}
        public int nextInt() {return Integer.parseInt(next());}
        public long nextLong() {return Long.parseLong(next());}
        public double nextDouble() {return Double.parseDouble(next());}
    }
}
