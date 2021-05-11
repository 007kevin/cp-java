import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem CF515C
 */
public class CF515C {

    static class Task extends IOHandler {
        
        public void run() {
            int n = in.nextInt();
            String a = in.next();
            List<Character> list = new ArrayList<>();
            for(int i = 0; i < a.length(); ++i){
                if(a.charAt(i) == '9'){
                    list.add('7');
                    list.add('3');
                    list.add('3');
                    list.add('2');
                }
                if(a.charAt(i) == '8'){
                    list.add('7');
                    list.add('2');
                    list.add('2');
                    list.add('2');
                }
                if(a.charAt(i) == '7'){
                    list.add('7');
                }
                if(a.charAt(i) == '6'){
                    list.add('3');
                    list.add('5');
                }
                if(a.charAt(i) == '5'){
                    list.add('5');
                }
                if(a.charAt(i) == '4'){
                    list.add('3');
                    list.add('2');
                    list.add('2');
                }
                if(a.charAt(i) == '3'){
                    list.add('3');
                }
                if(a.charAt(i) == '2'){
                    list.add('2');
                }
            }
            Collections.sort(list, Comparator.reverseOrder());
            out.println(list.stream().map(String::valueOf).collect(Collectors.joining()));
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
