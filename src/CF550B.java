import java.io.*;
import java.util.*;

/**
 * Problem CF550B
 */
public class CF550B {

    static class Task extends IOHandler {
        int n;
        long l,r,x;
        long[] c;
        long ans=0;
        
        public void run() {
            n = in.nextInt();
            l = in.nextLong();
            r = in.nextLong();
            x = in.nextLong();
            c = new long[n];
            for(int i = 0; i < n; ++i)
                c[i]=in.nextLong();
            dfs(new long[n],0);
            out.println(ans);
        }

        private void dfs(long[] a, int i) {
            if(i==n){
                if(valid(a)) ans++;
                return;
            }
            dfs(a, i+1);
            a[i]=c[i];
            dfs(a, i+1);
            a[i]=0;
        }

        private boolean valid(long[] a) {
            long min=Long.MAX_VALUE;
            long max=Long.MIN_VALUE;
            long sum=0;
            for(int i = 0; i < a.length; ++i){
                sum+=a[i];
                if(a[i]!=0) min=Math.min(a[i],min);
                max=Math.max(a[i],max);
            }
            return max-min>=x && l <= sum && sum <= r;
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
