import java.io.*;
import java.util.*;

/**
 * Problem Uva10801
 */
public class Uva10801 {

    public void run() {
        while(in.hasNext()){
            int time = find();
            if(time<0) out.println("IMPOSSIBLE");
            else out.println(time);
        }
    }

    int find() {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] T = new int[n];
        boolean[][] F = new boolean[n][100];
        for(int i = 0; i < n; ++i) T[i]=in.nextInt();
        for(int i = 0; i < n; ++i){
            for(int f : line()){
                F[i][f]=true;
            }
        }
        if(k==0) return 0;
        List<Floor> list = new ArrayList<>(100);
        Set<Floor> marked = new HashSet<>();
        Queue<Floor> queue = new PriorityQueue<>((a,b) -> a.time - b.time);
        for(int i = 0; i < 100; ++i)
            list.add(new Floor(i, Integer.MAX_VALUE));
        Floor first = list.get(0);
        first.time=-60;
        queue.add(first);
        while(!queue.isEmpty()){
            Floor floor = queue.remove();
            if(marked.contains(floor)) continue;
            marked.add(floor);
            if(floor.floor == k) {
                return floor.time;
            }
            for(int i = 0; i < n; ++i){
                if(!F[i][floor.floor]) continue;
                for(int j = 1; j < 100; ++j){
                    if(floor.floor == j) continue;
                    if(!F[i][j]) continue;
                    Floor next = list.get(j);
                    if(marked.contains(next)) continue;
                    int nextTime = floor.time + 60 + T[i]*Math.abs(floor.floor - j);
                    if(nextTime < next.time){
                        next.time = nextTime;
                        queue.remove(next);
                        queue.add(next);
                    }
                }
            }
        }
        return -1;
    }

    static class Floor {
        int floor, time;
        Floor(int floor, int time){
            this.floor=floor;
            this.time=time;
        }
    }

    int[] line() {
        try {
            List<Integer> list = new ArrayList<>();
            StringTokenizer tokenizer = new StringTokenizer(in.reader.readLine());
            while(tokenizer.hasMoreTokens()){
                Integer n = Integer.parseInt(tokenizer.nextToken());
                list.add(n);
            }
            return list.stream().mapToInt(i -> i).toArray();
        } catch (Exception e){
            throw new RuntimeException();
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
        Uva10801 task = new Uva10801(); task.run(); task.close();}
}
