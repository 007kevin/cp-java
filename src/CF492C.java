import java.io.*;
import java.util.*;

/**
 * Problem CF492C
 */
public class CF492C {

    static class Task extends IOHandler {
        public void run() {
            long n = in.nextLong();
            long r = in.nextLong();
            long target = in.nextLong() * n;
            long current = 0;
            long essays = 0;
            List<Exam> exams = new ArrayList<>();
            for(int i = 0; i < n; ++i){
                long a = in.nextLong();
                long b = in.nextLong();
                current+=a;
                exams.add(new Exam(a,b));
            }
            Collections.sort(exams);
            for(Exam exam : exams){
                if(current > target) break;
                if(exam.a == r) continue;
                long points = Math.min(r-exam.a, target - current);
                essays+=points * exam.b;
                current+=points;
            }
            out.println(essays);
        }
    }

    static class Exam implements Comparable<Exam> {
        long a,b;
        public Exam(long a, long b){
            this.a=a;
            this.b=b;
        }
        public int compareTo(Exam that){
            return Long.compare(this.b, that.b);
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
