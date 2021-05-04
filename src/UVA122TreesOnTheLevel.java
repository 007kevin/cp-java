import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Problem UVA122TreesOnTheLevel
 */
public class UVA122TreesOnTheLevel {
    
    private static Pattern pattern = Pattern.compile("\\(([0-9]+),([LR]*)\\)");
    
    static class Task extends IOHandler {
        public void run() {
            BinaryTree bTree = new BinaryTree();
            while(in.hasNext()){
                while(true) {
                    Matcher matcher = pattern.matcher(in.next());
                    if(!matcher.matches()) break;
                    int value = Integer.parseInt(matcher.group(1));
                    Queue<Character> path = matcher
                            .group(2)
                            .chars()
                            .mapToObj(c -> (char) c)
                            .collect(Collectors.toCollection(LinkedList<Character>::new));
                    bTree.insert(value, path);
                }
                List<Integer> orderLevel = bTree.getOrderlevel();
                if(orderLevel.stream().anyMatch(i -> i<1)){
                    out.println("not complete");
                } else {
                    StringJoiner joiner = new StringJoiner(" ");
                    orderLevel.stream().map(String::valueOf).forEach(joiner::add);
                    out.println(joiner.toString());
                }
                bTree.clear();
            }
        }
    }

    static class BinaryTree {
        Node head;

        public void clear(){
            head=null;
        }

        public List<Integer> getOrderlevel() {
            Map<Integer, List<Integer>> map = new HashMap<>();
            orderLevel(map,head,0);
            List<Map.Entry<Integer, List<Integer>>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, (a,b) -> Integer.compare(a.getKey(), b.getKey()));
            List<Integer> ans = new ArrayList<>();
            for(Map.Entry<Integer, List<Integer>> entry : list){
                for(Integer value : entry.getValue()){
                    ans.add(value);
                }
            }
            return ans;
        }

        private void orderLevel(Map<Integer, List<Integer>> map, Node node, int level){
            if(node==null) return;
            map.computeIfAbsent(level, (key) -> new ArrayList<>()).add(node.value);
            orderLevel(map, node.left, level+1);
            orderLevel(map, node.right, level+1);
        }
        
        public boolean isComplete(){
            return isComplete(head);
        }

        private boolean isComplete(Node node){
            if(node==null) return true;
            if(node.value==0 || node.value==-1){
                return false;
            }
            return isComplete(node.left) && isComplete(node.right);
        }
        
        public void insert(int value, Queue<Character> path){
            head = insert(head, value, path);
        }
        private Node insert(Node node, int value, Queue<Character> path){
            if(node==null){
                node=new Node();
            }
            if(path.isEmpty()){
                node.value = node.value == 0 ? value : -1;
            } else {
                Character c = path.remove();
                if(c=='L'){
                    node.left = insert(node.left, value, path);
                } else {
                    node.right = insert(node.right, value, path);
                }
            }
            return node;
        }
    }

    static class Node {
        int value;
        Node left,right;
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
