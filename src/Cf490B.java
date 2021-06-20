import java.io.*;
import java.util.*;

/**
 * Problem Cf490B
 */
public class Cf490B {

    public void run() {
        int n = in.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> rmap = new HashMap<>();
        List<Integer> list1;
        List<Integer> list2;
        for(int i = 0; i < n; ++i){
            int a = in.nextInt();
            int b = in.nextInt();
            map.put(a,b);
            rmap.put(b,a);
        }
        if(n%2==0){
            list1 = extract(map, false);
            list2 = extract(rmap, true);
            for(int i = 0; i < list2.size(); ++i){
                out.print(list2.get(i) + " " + list1.get(i) + " ");
            }
        } else {
            list1 = extract(map, false);
            list2 = oddExtract(new HashSet<Integer>(list1), map, rmap);
            for(int i = 0; i < list2.size(); ++i){
                out.print(list2.get(i) + " ");
                if(i < list1.size()){
                    out.print(list1.get(i) + " ");
                }
            }            
        }
        out.println();


    }

    public List<Integer> extract(Map<Integer, Integer> map, boolean reverse){
        List<Integer> list = new ArrayList<>(100000);
        int p = 0;
        while(map.containsKey(p)){
            p = map.get(p);
            if(p!=0) list.add(p);
            if(p==0) break;
        }
        if(reverse) Collections.reverse(list);
        return list;
    }

    public List<Integer> oddExtract(
            Set<Integer> set,
            Map<Integer, Integer> map,
            Map<Integer, Integer> rmap){
        List<Integer> list = new ArrayList<>(100000);
        int start = 0;
        for(Integer v : map.keySet()){
            if(v != 0 && !set.contains(v)){
                start = v;
                while(map.containsKey(start)) {
                    start=map.get(start);
                }
                break;
            }
        }
        list.add(start);
        while(rmap.containsKey(start)){
            start=rmap.get(start);
            list.add(start);
        }
        Collections.reverse(list);
        return list;
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
        Cf490B task = new Cf490B(); task.run(); task.close();}
}
