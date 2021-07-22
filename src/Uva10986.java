import java.io.*;
import java.util.*;

/**
 * Problem Uva10986
 */
public class Uva10986 {

    String unreachable = "unreachable";

    public void run() {
        int cse = 1;
        int test = in.nextInt();
        while(test-->0){
            int latency = find();
            out.println(String.format(
                "Case #%s: %s",
                cse++,
                latency < 0 ? unreachable : latency));
        }
    }

    int find() {
        int n = in.nextInt();
        int m = in.nextInt();
        int S = in.nextInt();
        int T = in.nextInt();
        List<Server> list = new ArrayList<>(n);
        for(int i = 0; i < n; ++i)
            list.add(new Server(i));
        for(int i = 0; i < m; ++i){
            int a = in.nextInt();
            int b = in.nextInt();
            int l = in.nextInt();
            list.get(a).add(b,l);
            list.get(b).add(a,l);
        }
        Queue<Server> queue = new PriorityQueue<>((a,b) -> a.dist - b.dist);
        Set<Server> visited = new HashSet<>();
        list.get(S).dist=0;
        queue.add(list.get(S));
        while(!queue.isEmpty()){
            Server s = queue.remove();
            if(visited.contains(s)) continue;
            visited.add(s);
            if(s.id == T) return s.dist;
            for(Map.Entry<Integer, Integer> entry : s.con.entrySet()){
                Server t = list.get(entry.getKey());
                int l = entry.getValue();
                if(!visited.contains(t)){
                    if(s.dist + l < t.dist){
                        queue.remove(t);
                        t.dist = s.dist + l;
                        queue.add(t);
                    }
                }
            }
        }
        return -1;
    }

    static class Server {
        int id, dist = Integer.MAX_VALUE;
        Map<Integer, Integer> con;
        Server(int id) {
            this.id = id;
            con=new HashMap<>();
        }

        void add(int b, int l){
            con.put(b,l);
        }
    }



    /***********************************************************
     *                      BOILERPLATE                        *
    /***********************************************************/
    public InputReader in = new InputReader(System.in);
    public PrintWriter out = new PrintWriter(System.out);
    public void close() {out.close();}
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
    public static void main(String[] args) {
        Uva10986 task = new Uva10986(); task.run(); task.close();}
}
