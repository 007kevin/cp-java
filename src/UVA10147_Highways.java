import java.io.*;
import java.util.*;

/**
 * Problem UVA10147_Highways
 */
public class UVA10147_Highways {

    static class Task extends IOHandler {
        private final Town INF = new Town(
                100,
                Integer.MAX_VALUE,
                Integer.MAX_VALUE);
        
        public void run() {
            int t = in.nextInt();
            while(t-->0){
                int n = in.nextInt();
                Map<Integer, Town> map = new HashMap<>();
                for(int i = 1; i <= n; ++i){
                    map.put(i, new Town(i, in.nextInt(), in.nextInt()));
                }
                int m = in.nextInt();
                for(int i = 1; i <= m; ++i){
                    int a = in.nextInt();
                    int b = in.nextInt();
                    map.get(a).adj.add(b);
                    map.get(b).adj.add(a);
                }
                List<Highway> highways = calculate(map);
                if(highways.isEmpty()){
                    out.println("No new highways need");
                } else {
                    for(Highway highway : highways){
                        out.println(highway.toString());
                    }
                }
                out.println();
            }
        }

        public List<Highway> calculate(Map<Integer, Town> map){
            List<Highway> highways = new LinkedList<>();
            Set<Town> towns = new HashSet<>(map.values());
            Set<Town> mst = new HashSet<>();
            Iterator<Town> iter = towns.iterator();
            mst.add(iter.next());
            iter.remove();
            while(!towns.isEmpty()){
                Town from = null;
                Town to = INF;
                for(Town A : mst){
                    for(Town B : towns){
                        if(A.distance(B) < A.distance(to)){
                            from=A;
                            to=B;
                        }
                    }
                }
                // if(from.distance(to) > 0){
                //     highways.add(new Highway(from, to));
                // }
                highways.add(new Highway(from, to));
                mst.add(to);
                towns.remove(to);
            }
            return highways;
        }
    }

    static class Town {
        int i, x,y;
        Set<Integer> adj;
        public Town(int i, int x, int y){
            this.i=i;
            this.x=x;
            this.y=y;
            this.adj = new HashSet<>();
        }

        public double distance(Town that){
            if(this.adj.contains(that.i)) return 0;
            int dx = Math.abs(this.x-that.x);
            int dy = Math.abs(this.y-that.y);
            return Math.sqrt(dx*dx+dy*dy);
        }

        @Override
        public int hashCode() {
            return i;
        }
        
    }

    static class Highway {
        Town a,b;
        public Highway(Town a, Town b){
            this.a=a;
            this.b=b;
        }
        public String toString(){
            return String.format("%s %s", a.i, b.i);
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
