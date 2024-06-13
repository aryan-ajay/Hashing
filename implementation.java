import java.util.*;

public class Ajay{
    static class HashMap<K, V> { // generic 
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }
        private int n; //n
        private int N;
        private LinkedList<Node> buckets[]; //N   buckets.length

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i=0; i<4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hc = hashCode();
            return Math.abs(hc) % N;  // it means size lies beetween 0 to 3
        }

        private int SearchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0;

            for(int i=0; i<ll.size(); i++) {
                Node node = ll.get(i);
                if(node.key == key) {
                    return di;
                }
                di++;
            }
            return -1;
        }

        private void rehash() {
            LinkedList<Node> oldbuck[] = buckets;
            buckets = new LinkedList[N*2];
            N = N*2;
            for(int i=0; i<buckets.length; i++) {
                buckets[i] = new LinkedList<>();    
            }

            //nodes -> add in a buckets
            for(int i=0; i<oldbuck.length; i++) {
                LinkedList<Node> ll = oldbuck[i];
                for(int j=0; j<ll.size(); j++){
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }
        public void put(K key, V value) {
            int bi = hashFunction(key); // 0 to 3         bi=bucket index
            int di = SearchInLL(key, bi); // it return valid or -1,  di=data index

            if(di != -1){ //it means key is exit in bucket then update the value    
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double)n/N;

            if(lambda > 2.0) {
                rehash();
            }
        }
        public boolean containsKey(K key) {
            int bi = hashFunction(key); // 0 to 3         bi=bucket index
            int di = SearchInLL(key, bi); // it return valid or -1,  di=data index

            if(di != -1){ //it means key is exit in bucket then update the value    
                return true;
            } else {
                return false;
            }
        }
        public V get(K key) {
            int bi = hashFunction(key); // 0 to 3         bi=bucket index
            int di = SearchInLL(key, bi); // it return valid or -1,  di=data index

            if(di != -1){ //it means key is exit in bucket then update the value    
                Node node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }
        public V remove(K key) {
            int bi = hashFunction(key); // 0 to 3         bi=bucket index
            int di = SearchInLL(key, bi); // it return valid or -1,  di=data index

            if(di != -1){ //it means key is exit in bucket then update the value    
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();

            for(int i=0; i<buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }
    }
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 150);
        hm.put("China", 130);
        

        ArrayList<String> keys = hm.keySet();
        for (String key : keys) {
            System.out.println(key);
        }

        System.out.println("Space");
        System.out.println(hm.remove("India"));
        System.out.println(hm.get("India"));
    }
}
