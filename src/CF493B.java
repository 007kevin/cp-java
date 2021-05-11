import java.io.*;
import java.util.*;

/**
 * Problem CF493B
 */
public class CF493B {

    static class Task extends IOHandler {
        public void run() {
            Wrestler w1 = new Wrestler();
            Wrestler w2 = new Wrestler();
            int n = in.nextInt();
            for(int i = 0; i < n; ++i){
                long p = in.nextLong();
                if(p>0) w1.points.add(p);
                else w2.points.add(-p);
                if(i==n-1){
                    if(p>0) w1.last=true;
                    else w2.last=true;
                }
            }
            if(w1.compareTo(w2) > 0) out.println("first");
            else out.println("second");
        }
    }

    static class Wrestler implements Comparable<Wrestler> {
        List<Long> points = new ArrayList<>();
        boolean last = false;

        @Override
        public int compareTo(Wrestler that){
            long aTotal = this.points.stream().reduce(0L, (acc,val) -> acc+val);
            long bTotal = that.points.stream().reduce(0L, (acc,val) -> acc+val);
            if(aTotal > bTotal) return 1;
            if(aTotal < bTotal) return -1;
            
            int a = this.points.size();
            int b = that.points.size();
            
            for(int i = 0; i < Math.min(a,b); ++i){
                if(this.points.get(i) > that.points.get(i)) return 1;
                if(this.points.get(i) < that.points.get(i)) return -1;
            }
            if(a > b) return 1;
            if(a < b) return -1;

            if(this.last) return 1;
            if(that.last) return -1;
            
            return 0;
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
