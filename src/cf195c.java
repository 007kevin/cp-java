import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Problem cf195c
 */
public class cf195c {

    static final Pattern patternThrow = Pattern.compile("throw\\s*\\(\\s*(.*)\\s*\\)");
    static final Pattern patternCatch = Pattern.compile("catch\\s*\\(\\s*(.*),\\s*\"(.*)\"\\)");

    public void run() {
        int n = in.nextInt();
        LinkedList<Block> stack = new LinkedList<>();
        stack.push(new Block());
        while(n-->0){
            String line = in.nextLine();
            if (isTry(line)) {
                Block top = stack.peek();
                Block next = new Block();
                top.nextBlocks.add(next);
                stack.push(next);
            }
            if (isCatch(line)) {
                Block top = stack.pop();
                top.blockCatch = line;
            }
            if (isThrow(line)) {
                Block top = stack.pop();
                top.exception = line;
            }
        }
    }

    static class Block {
        List<Block> nextBlocks = new LinkedList<>();
        String exception;
        String blockCatch;
        public Block() {
        }

        public void setException(String line) {
            this.exception = matchThrow(line);
        }

        public void setCatch(String line) {

        }
    }

    private static String matchThrow(String s) {
        Matcher m = patternThrow.matcher(s);
        if (!m.find()){
            return null;
        }
        return m.group(1).trim();
    }

    private static String matchCatch(String e, String s) {
        if (e == null){
            return null;
        }
        Matcher m = patternCatch.matcher(s);
        if (!m.find()){
            return null;
        }
        String g1 = m.group(1);
        String g2 = m.group(2);
        if (e.equals(g1)) {
            return g2.trim();
        }
        return null;
    }

    private static boolean isTry(String s){
        return "try".equals(s);
    }
    private static boolean isCatch(String s){
        return s.startsWith("catch");
    }
    private static boolean isThrow(String s){
        return s.startsWith("throw");
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
        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) {
        cf195c task = new cf195c(); task.run(); task.close();}
}
