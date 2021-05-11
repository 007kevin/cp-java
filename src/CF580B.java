import java.io.*;
import java.util.*;

/**
 * Problem CF580B
 */
public class CF580B {

    static class Task extends IOHandler {
        public void run() {
            long n = in.nextLong();
            long d = in.nextLong();
            List<Friend> list = new ArrayList<>();
            for(int i = 0; i < n; ++i){
                list.add(new Friend(in.nextLong(), in.nextLong()));
            }
            Collections.sort(list);
            Deque<Friend> deque = new LinkedList<>();
            long ans = 0, factor=0;
            for(int i = 0; i < n; ++i){
                factor+=list.get(i).s;
                deque.addLast(list.get(i));
                while(deque.peekLast().m -  deque.peekFirst().m >= d){
                    Friend f = deque.removeFirst();
                    factor-=f.s;
                }
                ans=Math.max(factor,ans);
            }
            out.println(ans);
        }
    }

    static class Friend implements Comparable<Friend> {
        long m,s;
        public Friend(long m, long s){
            this.m=m; this.s=s;
        }
        @Override
        public int compareTo(Friend that) {
            return Long.compare(this.m, that.m);
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
