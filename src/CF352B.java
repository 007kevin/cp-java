import java.io.*;
import java.util.*;

/**
 * Problem CF352B
 * O(nlogn) solution because for each a (n), we insert into treemap (logn)
 */
public class CF352B {

    static class Task extends IOHandler {
        public void run() {
            Map<Integer,List<Integer>> map = new TreeMap<>();
            int n = in.nextInt();
            for(int i = 0; i < n; ++i) {
                int a = in.nextInt();
                map.computeIfAbsent(a, (key) -> new ArrayList<>()).add(i);
            }
            List<Pair> ans = new ArrayList<>();
            for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
                int p = prog(entry.getValue());
                if(p>=0){
                    ans.add(new Pair(entry.getKey(), p));
                }
            }
            out.println(ans.size());
            for(Pair p : ans){
                out.println("%s %s", p.a, p.b);
            }
            
            
        }

        public int prog(List<Integer> list){
            if(list.isEmpty()) return -1;
            if(list.size()==1) return 0;
            int p = list.get(1)-list.get(0);
            for(int i = 0; i < list.size()-1; ++i){
                if(list.get(i+1) - list.get(i) != p)
                    return -1;
            }
            return p;
        }
    }

    static class Pair {
        int a;
        int b;
        public Pair(int a, int b){
            this.a=a;
            this.b=b;
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
        public OutputWriter out = new OutputWriter(System.out);
        public void cleanup() {out.close();}
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
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
    static class OutputWriter extends PrintWriter {
        public OutputWriter(OutputStream out) {super(out);}
        public void println(String format, Object... args) {
            this.println(String.format(format, args));}
        public void print(String format, Object... args) {
            this.print(String.format(format, args));}
    }
}
