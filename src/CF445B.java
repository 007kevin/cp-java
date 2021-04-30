import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Problem CF445B
 */
public class CF445B {

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            int m = in.nextInt();
            List<Set<Integer>> list = Stream
                    .generate(HashSet<Integer>::new)
                    .limit(n+1).collect(Collectors.toList());
            for(int i = 0; i <m; ++i){
                int x = in.nextInt();
                int y = in.nextInt();
                list.get(x).add(y);
                list.get(y).add(x);
            }
            Set<Integer> visited = new HashSet<>();
            Long ans = 1L;
            for(Integer i = 1; i <= n; ++i){
                if(!visited.contains(i)){
                    Long count = dfs(visited, list, i);
                    ans*=(long) Math.pow(2,count-1);
                }
            }
            out.println(ans);
        }

        private Long dfs(
                Set<Integer> visited,
                List<Set<Integer>> list,
                Integer i) {
            if(visited.contains(i)) return 0L;
            visited.add(i);
            Long count = 1L;
            for(Integer neigh : list.get(i)){
                count+=dfs(visited, list, neigh);
            }
            return count;
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
