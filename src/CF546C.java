import java.io.*;
import java.util.*;

/**
 * Problem CF546C
 */
public class CF546C {

    static class Task extends IOHandler {
        public void run() {
            Queue<Integer> q1 = new LinkedList<>();
            Queue<Integer> q2 = new LinkedList<>();
            int n = in.nextInt();
            int k1 = in.nextInt();
            for(int i = 0; i < k1; ++i) q1.add(in.nextInt());
            int k2 = in.nextInt();
            for(int i = 0; i < k2; ++i) q2.add(in.nextInt());
            War war = new War(q1,q2);
            int moves = 0;
            while(war.play()) moves++;
            int winner = war.winner();
            if(winner == -1) out.println(-1);
            else out.println(moves + " " + winner);
        }
    }

    static class War {
        Queue<Integer> firstPlay;
        Queue<Integer> secondPlay;
        Set<Integer> hash;
        public War(Queue<Integer> first, Queue<Integer> second){
            this.firstPlay = new LinkedList<>(first);
            this.secondPlay = new LinkedList<>(second);
            this.hash = new HashSet<>();
        }

        public boolean play(){
            if(!valid()) return false;
            if(firstPlay.peek().compareTo(secondPlay.peek()) < 1){
                secondPlay.add(firstPlay.remove());
                secondPlay.add(secondPlay.remove());
            } else {
                firstPlay.add(secondPlay.remove());
                firstPlay.add(firstPlay.remove());
            }

            hash.add(makeHash(firstPlay));
            hash.add(makeHash(secondPlay));
            return true;
        }

        public int makeHash(Queue<Integer> q){
            return q.toArray().hashCode();
        }

        public boolean valid(){
            if (firstPlay.isEmpty() || secondPlay.isEmpty()) return false;
            if(hash.contains(makeHash(firstPlay)) && hash.contains(makeHash(secondPlay))) return false;
            return true;
        }

        public int winner() {
            if(firstPlay.isEmpty()) return 2;
            if(secondPlay.isEmpty()) return 1;
            return -1;
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
