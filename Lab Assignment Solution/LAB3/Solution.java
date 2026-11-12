// Task 01
public void remove( Integer key ){
        int idx = hashFunction(key);
        PairNode curr = ht[idx];
        PairNode prev = null;

        while (curr != null && !curr.key.equals(key)) {
            prev = curr;
            curr = curr.next;
        }

        if (curr == null) {
            return;
        }

        if (prev == null) {
            ht[idx] = curr.next;
        } else {
            prev.next = curr.next;
        }

        curr.next = null;
}

// Task 02
private int hashFunction( String key ){
        if(key.length()%2 == 1){
            key = key + "N";
        }
        int sum = 0;
        for(int i = 0; i < key.length(); i+=2){
            String temp = Integer.toString((int)(key.charAt(i))) + Integer.toString((int)(key.charAt(i + 1)));
            int num = Integer.parseInt(temp);
            sum += num;
        }
        int idx = sum % ht.length;
        return idx; 
}

public String searchHashtable( Object[] keyValuePair ){
        String key = (String) keyValuePair[0];
        int idx = hashFunction(key);
        PairNode head = ht[idx];

        while (head != null) {
            if (head.key.equals(key)) {
                return "Found";
            }
            head = head.next;
        }

        return "Not Found";
}

