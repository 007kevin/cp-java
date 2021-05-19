import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem Cf437B
 */
public class Cf437B {

    static class Task extends IOHandler {
        public void run() {
            int sum = in.nextInt();
            int limit = in.nextInt();
            Map<Integer, Set<Integer>> lbs = new HashMap<>();
            Map<Integer, Set<Integer>> lbl = new HashMap<>();
            for(int i = 1; i <= sum; ++i){
                lbs.computeIfAbsent(Integer.lowestOneBit(i), (k) -> new HashSet<>()).add(i);
            }
            for(int i = 1; i <= limit; ++i){
                lbl.computeIfAbsent(Integer.lowestOneBit(i), (k) -> new HashSet<>()).add(i);
            }
            List<Integer> set = findSet(lbs, lbl);
            if(set==null) out.println(-1);
            else {
                out.println(set.size());
                for(Integer val : set){
                    out.print(val + " ");
                }
                out.println();
            }

        }
        public List<Integer> findSet(
                Map<Integer, Set<Integer>> lbs,
                Map<Integer, Set<Integer>> lbl){
            List<Integer> set = new LinkedList<>();
            for(Map.Entry<Integer, Set<Integer>> entry : lbs.entrySet()){
                if(!lbl.containsKey(entry.getKey())) return null;
                if(lbl.get(entry.getKey()).size() < entry.getValue().size()) return null;
                set.addAll(lbl.get(entry.getKey()).stream().limit(entry.getValue().size()).collect(Collectors.toList()));
            }
            return set;
        }

    }

    /***********************************************************
     *                      BOILERPLATE                        *
    /***********************************************************/
    public static void main(String[] args) {
        Task task = new Task(); task.run(); task.close();}
    static class IOHandler  {
        public InputReader in = new InputReader(System.in);
        public PrintWriter out = new PrintWriter(System.out);
        public void close() {out.close();}}
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
}
