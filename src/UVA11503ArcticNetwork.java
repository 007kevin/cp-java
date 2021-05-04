import java.io.*;
import java.util.*;

/**
 * Problem UVA11503ArcticNetwork
 */
public class UVA11503ArcticNetwork {

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            while(n-->0){
                int s = in.nextInt();
                int p = in.nextInt();
                int[][] o = new int[p][2];
                for(int i = 0; i < p; ++i){
                    o[i][0]=in.nextInt();
                    o[i][1]=in.nextInt();
                }
                List<Edge> edges = new ArrayList<>();
                List<Edge> mst = new ArrayList<>();
                int[] tree = new int[p];
                for(int i = 0; i < p; ++i) tree[i]=i;
                for(int i = 0; i < p; ++i){
                    for(int j = i+1; j < p; ++j){
                        edges.add(new Edge(i,j,dist(o[i],o[j])));
                    }
                }
                Collections.sort(edges);
                for(Edge edge : edges){
                    if(tree[edge.a]!=tree[edge.b]){
                        mst.add(edge);
                        int old = tree[edge.a];
                        for(int i = 0; i < p; ++i){
                            if(tree[i]==old) tree[i]=tree[edge.b];
                        }
                    }
                }
                Collections.reverse(mst);
                out.println(String.format("%.2f", mst.get(s-1).d));
            }
        }

        public double dist(int[] a, int[] b){
            double x = a[0]-b[0];
            double y = a[1]-b[1];
            return Math.sqrt(x*x + y*y);
        }
    }

    static class Edge implements Comparable<Edge> {
        private int a;
        private int b;
        private double d;

        public Edge(int a, int b, double d){
            this.a = a;
            this.b = b;
            this.d = d;
        }

        @Override
        public int compareTo(Edge that){
            return Double.compare(this.d, that.d);
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
