import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Problem CF1444A
 */
public class CF1444A {

    static final Long MAX = 10000000000L;

    static class Task extends IOHandler {
        public void run() {
            int t = in.nextInt();
            while(t-- != 0){
                Long p = in.nextLong();
                Long q = in.nextLong();
                out.println(solve(p,q));
            }
        }

        public Long solve(Long p, Long q) {
            if(p%q!=0) return p;
            Map<Long,Long> qd = divisors(q);
            Long x = 0L;
            for(Map.Entry<Long,Long> e : qd.entrySet()){
                Long pp = p;
                Long qq = pow(e.getKey(), e.getValue());
                while(pp%qq==0)
                    pp/=e.getKey();
                x=Math.max(x, pp);
            }
            return x;
        }

        private Long pow(Long key, Long value) {
            if(value==0)
                return 1L;
            if(value==1)
                return key;
            if(value%2==1L)
                return key*pow(key,value-1);
            Long v = pow(key,value/2);
            return v*v;
        }

        public Map<Long, Long> divisors(Long n) {
            Map<Long, Long> d = new HashMap<>();
            for(Long i = 2L; i*i <= n; ++i){
                if(n%i==0){
                    Long c =0L;
                    while(n%i==0) {c++; n/=i;}
                    d.put(i,c);
                }
            }
            if(n>=2L) d.put(n,1L);
            // for (Map.Entry<Long, Long> qe : d.entrySet()){
            //     System.out.print("[" + qe.getKey() + ":" + qe.getValue() + "]");
            // }
            // System.out.println();
            return d;
        }
    }

    /***********************************************************
     *                        COMMONS                          *
     ***********************************************************/    
    static class Pair<A,B> {
        public A a;
        public B b;
        public Pair(A a, B b) {
            this.a=a;
            this.b=b;
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

    static class IOHandler {
        public InputReader in = new InputReader(System.in);
        public PrintWriter out = new PrintWriter(System.out);

        public void cleanup() {
            out.close();
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

}
