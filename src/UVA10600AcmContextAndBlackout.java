import java.io.*;
import java.util.*;

/**
 * Problem UVA10600AcmContextAndBlackout
 */
public class UVA10600AcmContextAndBlackout {

    static class Task extends IOHandler {
        public void run() {
            int t = in.nextInt();
            while(t-->0){
                int n = in.nextInt();
                int m = in.nextInt();
                List<Edge> edges = new ArrayList<>();
                for(int i = 0; i < m; ++i){
                    edges.add(new Edge(
                            in.nextInt(),
                            in.nextInt(),
                            in.nextInt()));
                }
                Collections.sort(edges);
                List<Edge> mst = mst(n, edges, null);
                int secWeight = Integer.MAX_VALUE;
                for(Edge edge : mst){
                    List<Edge> cand = mst(n,edges,edge);
                    if(cand.size() != n-1) continue;
                    secWeight = Math.min(secWeight, cand.stream().map(e -> e.w).reduce(0, (a,v) -> a+v));
                    
                }
                out.println(mst.stream().map(e -> e.w).reduce(0, (a,v) -> a+v) + " " + secWeight);
            }
        }

        public List<Edge> mst(int n, List<Edge> edges, Edge wo){
            int[] tree = new int[n+1];
            for(int i = 1; i <= n; ++i) tree[i]=i;
            List<Edge> mst = new ArrayList<>();
            for(Edge edge : edges){
                if(wo != null && edge.equals(wo)) continue;
                if(tree[edge.a] != tree[edge.b]){
                    mst.add(edge);
                    int old = tree[edge.a];
                    for(int i = 1; i <= n; ++i){
                        if(tree[i]==old) tree[i]=tree[edge.b];
                    }
                }
            }
            return mst;
        }
    }

    static class Edge implements Comparable<Edge> {
        private int a;
        private int b;
        private int w;
        public Edge(int a, int b, int w){
            this.a = a;
            this.b = b;
            this.w = w;
        }
        
        @Override
        public int compareTo(Edge that) {
            return Integer.compare(this.w, that.w);
        }

        public boolean equals(Edge that){
            return this.a == that.a
                    && this.b == that.b
                    && this.w == that.w;
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
