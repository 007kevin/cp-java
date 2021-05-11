import java.io.*;
import java.util.*;

/**
 * Problem UVA105TheSkylineProblem
 */
public class UVA105TheSkylineProblem {

    static enum Side {
        Left,
        Right
    }
    
    static class Task extends IOHandler {
        public void run() {
            Map<Integer, List<Event>> map = new TreeMap<>();
            List<Integer> seq = new ArrayList<>();
            while(in.hasNext()){
                int l = in.nextInt();
                int h = in.nextInt();
                int r = in.nextInt();
                map.computeIfAbsent(l, key -> new ArrayList<>())
                        .add(new Event(Side.Left, h));
                map.computeIfAbsent(r, key -> new ArrayList<>())
                        .add(new Event(Side.Right, h));
            }
            Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for(Map.Entry<Integer, List<Event>> events : map.entrySet()){
                Integer last = pq.isEmpty() ? 0 : pq.peek();
                for(Event event : events.getValue()){
                    if(event.type == Side.Left) pq.add(event.h);
                    if(event.type == Side.Right) pq.remove(event.h);
                }
                Integer after = pq.isEmpty() ? 0 : pq.peek();
                if(last != after){
                    seq.add(events.getKey());
                    seq.add(pq.isEmpty() ? 0 : pq.peek());
                }
            }
            StringJoiner joiner = new StringJoiner(" ");
            seq.stream().map(String::valueOf).forEach(joiner::add);
            out.println(joiner);
        }
    }

    static class Event {
        Side type;
        int h;
        public Event(Side type, int h){
            this.type=type;
            this.h=h;
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
