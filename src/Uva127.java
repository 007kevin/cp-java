import java.io.*;
import java.util.*;

/**
 * Problem Uva127
 */
public class Uva127 {

    public void run() {
        while(true){
            List<Deque<Card>> list = new ArrayList<>(52);
            for(int i = 0; i < 52; ++i){
                String s = in.next();
                if("#".equals(s)) return;
                Deque<Card> stack = new ArrayDeque<>(52);
                stack.push(new Card(s));
                list.add(stack);
            }
            boolean cont = true;
            while(cont){
                cont=false;
                Deque<Card> first = null;
                Deque<Card> second = null;
                Deque<Card> third = null;
                for(int i = 0; i < list.size(); ++i){
                    Deque<Card> cur = list.get(i);
                    if(cur.isEmpty()) continue;
                    if(match(third, cur)){
                        cont = true;
                        third.push(cur.pop());
                        break;
                    }
                    if(match(first, cur)){
                        cont = true;
                        first.push(cur.pop());
                        break;
                    }
                    third=second;
                    second=first;
                    first=cur;
                }
            }
            int piles = (int) list
                    .stream()
                    .filter(stack -> !stack.isEmpty())
                    .count();
            StringJoiner joiner = new StringJoiner(" ");
            list.stream()
                    .filter(stack -> !stack.isEmpty())
                    .map(stack -> String.valueOf(stack.size()))
                    .forEach(joiner::add);
            out.println(String.format("%s %s remaining: %s",
                            piles,
                            piles == 1 ? "pile" : "piles",
                            joiner));
        }
    }

    public boolean match(Deque<Card> stack, Deque<Card> cur){
        if(stack == null || stack.isEmpty()) return false;
        if(cur == null || cur.isEmpty()) return false;
        return stack.peek().match(cur.peek());
    }

    static class Card {
        char face,suit;
        public Card(String s){
            face=s.charAt(0);
            suit=s.charAt(1);
        }

        public boolean match(Card that){
            return this.face==that.face
                || this.suit == that.suit;
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
        Uva127 task = new Uva127(); task.run(); task.close();}
}
