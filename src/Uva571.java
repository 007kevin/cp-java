import java.io.*;
import java.util.*;

/**
 * Problem Uva571
 */
public class Uva571 {

    int A,B,N;
    Set<String> set = new HashSet<>();
    String fillA = "fill A";
    String fillB = "fill B";
    String emptyA = "empty A";
    String emptyB = "empty B";
    String pourAB = "pour A B";
    String pourBA = "pour B A";
    String success = "success";

    public void run() {
        while(in.hasNext()){
            set.clear();
            A=in.nextInt();
            B=in.nextInt();
            N=in.nextInt();
            List<String> steps = new ArrayList<>();
            find(steps,0,0);
            for(String step : steps)
                out.println(step);
        }
    }

    boolean find(List<String> steps, int a, int b){
        if(b==N){
            steps.add(success);
            return true;
        }
        if(set.contains(k(a,b))) return false;
        set.add(k(a,b));
        if(a!=A){
            steps.add(fillA);
            if(find(steps,A,b)) return true;
            steps.remove(steps.size()-1);
        }
        if(b!=B){
            steps.add(fillB);
            if(find(steps,a,B)) return true;
            steps.remove(steps.size()-1);
        }
        if(a!=0){
            steps.add(emptyA);
            if(find(steps,0,b)) return true;
            steps.remove(steps.size()-1);
        }
        if(b!=0) {
            steps.add(emptyB);
            if(find(steps,a,0)) return true;
            steps.remove(steps.size()-1);
        }
        steps.add(pourAB);
        if(find(steps,Math.max(0,a-(B-b)),Math.min(B, a+b))) return true;
        steps.remove(steps.size()-1);

        steps.add(pourBA);
        if(find(steps,Math.min(A, a+b),Math.max(0,b-(A-a)))) return true;
        steps.remove(steps.size()-1);

        set.remove(k(a,b));
        return false;
    }

    String k(int a, int b){
        return a + " " + b;
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
        Uva571 task = new Uva571(); task.run(); task.close();}
}
