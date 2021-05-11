import java.io.*;
import java.util.*;

/**
 * Problem UVA1174IpTv
 */
public class UVA1174IpTv {

    static class Task extends IOHandler {
        public void run() {
            int t = in.nextInt();
            StringJoiner joiner = new StringJoiner("\n\n");
            while(t-->0){
                int m = in.nextInt();
                int n = in.nextInt();
                List<Edge> edges = new ArrayList<>();
                List<Edge> mst = new ArrayList<>();
                for(int i = 0; i < n; ++i){
                    edges.add(new Edge(in.next(), in.next(), in.nextInt()));
                }
                Collections.sort(edges);
                Dsu dsu = new Dsu();
                for(Edge edge : edges){
                    if(dsu.findSet(edge.a).equals(dsu.findSet(edge.b))) continue;
                    mst.add(edge);
                    dsu.unionSet(edge.a, edge.b);
                }
                joiner.add(String.valueOf(mst.stream().map(e -> e.w).reduce(0, (a,v) -> a+v)));
            }
            out.println(joiner);
        }
    }

    static class Edge implements Comparable<Edge> {
        String a,b;
        int w;
        public Edge(String a, String b, int w){
            this.a=a; this.b=b; this.w=w;
        }
        public int compareTo(Edge that) {
            return this.w - that.w;
        }
        
    }

    static class Dsu {
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> size = new HashMap<>();
        public String findSet(String a){
            createSet(a);
            if(map.get(a).equals(a)) return a;
            String p = findSet(map.get(a));
            map.put(a,p);
            return p;
        }

        public void unionSet(String a, String b){
            a = findSet(a);
            b = findSet(b);
            if(a.equals(b)) return;
            if(size.get(a) < size.get(b)){
                String swap = a;
                a = b;
                b = swap;
            }
            map.put(b,a);
            size.put(a, size.get(a) + size.get(b));
        }
        
        public boolean createSet(String a){
            if(!map.containsKey(a)){
                map.put(a,a);
                size.put(a,1);
                return true;
            }
            return false;
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
