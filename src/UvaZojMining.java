import java.io.*;
import java.util.*;

/**
 * Problem ZojMining
 */
public class UvaZojMining {

    public void run() {
        while(in.hasNext()){
            Mining mining = new Mining(
                    in.nextInt(),
                    in.nextInt(),
                    in.nextInt(),
                    in.nextInt(),
                    in.nextInt());
            while(mining.run());
            out.println(mining.time);
        }
    }

    static class Mining {
        int S,W,C,K,M;
        int time = 0;
        Base base = new Base();
        Site site = new Site();
        List<Worker> workers = new LinkedList<>();


        Mining(int S, int W, int C, int K, int M){
            this.S=S;
            this.W=W;
            this.C=C;
            this.K=K;
            this.M=M;
        }

        boolean run(){
            if(base.resource >= 10000)
                return false;
            if(time!=0 && time%M==0 && workers.size() != K){
                workers.add(new Worker(base, site, S, W, C));
            }
            if(site.worker != null) site.worker.next();
            for(Worker worker : workers){
                if(worker.working()) continue;
                worker.next();
            }
            time++;
            return true;
        }
    }

    static class Base {
        int resource = 0;
    }

    static class Site {
        Worker worker = null;
    }

    static class Worker {
        Base base;
        Site site;
        int S,W,C;
        int p = 0, w = 0;
        boolean out = true;

        Worker(Base base, Site site, int S, int W, int C){
            this.base=base;
            this.site=site;
            this.S=S;
            this.W=W;
            this.C=C;
        }

        public void next(){
            if(out){
                if(p<S) p++;
                else {
                    if(site.worker == null) site.worker = this;
                    if(site.worker == this){
                        w++;
                        if(w==W){
                            w=0;
                            out=false;
                        }
                    }
                }
            } else {
                if(site.worker == this) site.worker = null;
                if(0<p) p--;
                else {
                    out=true;
                    base.resource+=C;
                }
            }
        }

        public boolean working(){
            return site.worker==this;
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
        UvaZojMining task = new UvaZojMining(); task.run(); task.close();}
}
