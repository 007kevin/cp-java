import java.io.*;
import java.util.*;

/**
 * Problem CF791B
 */
public class CF791B {

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            int m = in.nextInt();
            Map<Integer,Set<Integer>> map = new HashMap<>();
            for(int i = 0; i < m; ++i){
                int a = in.nextInt();
                int b = in.nextInt();
                map.computeIfAbsent(a, key->new HashSet<>()).add(b);
                map.computeIfAbsent(b, key->new HashSet<>()).add(a);
            }
            Set<Integer> visited = new HashSet<>();
            for(int i = 1; i <= n; ++i) {
                if(!visited.contains(i)
                        && map.containsKey(i)
                        && !bfs(visited, map, i)){
                    out.println("NO");
                    return;
                }
            }
            out.println("YES");
        }

        private boolean bfs(
                Set<Integer> visited,
                Map<Integer, Set<Integer>> map,
                Integer i) {
            Queue<Integer> q = new LinkedList<>();
            List<Integer> compoent = new ArrayList<>();
            q.add(i);
            while(!q.isEmpty()){
                Integer current = q.remove();
                if(visited.contains(current)) continue;
                compoent.add(current);
                visited.add(current);
                for(Integer neigh : map.get(current)){
                    if(!visited.contains(neigh)){
                        q.add(neigh);
                    }
                }
            }
            return compoent.stream().allMatch(num -> map.get(num).size() == compoent.size()-1);
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
