import java.io.*;
import java.util.*;

/**
 * Problem Uva498PollyThePolynomial
 */
public class Uva498PollyThePolynomial {

    static class Task extends IOHandler {
        public void run() {
            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){
                List<Long> coef = parse(sc.nextLine());
                List<Long> xm = parse(sc.nextLine());
                StringJoiner joiner = new StringJoiner(" ");
                for(Long x : xm){
                    joiner.add(String.valueOf(poly(coef, x)));
                }
                out.println(joiner.toString());
            }
            sc.close();
        }

        public Long poly(List<Long> coef, Long x) {
            Long ans = 0L;
            Long n = (long) coef.size() - 1;
            for(Long c : coef){
                ans+=c*fpow(x,n--);
            }
            return ans;
        }

        public Long fpow(Long x, Long n){
            if(n==0) return 1L;
            if(n==1) return x;
            if(n%2==1) return x * fpow(x,n-1);
            Long v = fpow(x,n/2);
            return v*v;
        }

        public List<Long> parse(String s){
            StringTokenizer t = new StringTokenizer(s);
            List<Long> list = new ArrayList<>();
            while(t.hasMoreTokens()){
                list.add(Long.parseLong(t.nextToken()));
            }
            return list;
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
