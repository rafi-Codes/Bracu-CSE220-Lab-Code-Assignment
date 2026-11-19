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

// Task 03
public static Stack conditionalReverse(Stack stack) {
        Stack ans = new Stack();
        ans.push(stack.pop());
        while(!stack.isEmpty()){
            if(!ans.peek().equals(stack.peek())){
                ans.push(stack.pop());
            }else{
                stack.pop();
            }
        }
        return ans; 
}

// Task 04
public static String hotPotato(String[] players, int k) {
        LinkedListQueue queue = new LinkedListQueue();
        for(String player : players){
            queue.enqueue(player);
        }
        int count = 0;
        String ans = "";
        while(!queue.isEmpty()){
            if(count == k){
                queue.dequeue();
                count = 0;
            }else {
                ans = (String) queue.dequeue();
                if(queue.isEmpty()) return ans;
                queue.enqueue(ans);
                count++;
            }
        }
        return ans;
}

// Task 05
public static void dance_pair(Stack stk) {
        Queue maleQueue = new Queue();
        Queue femaleQueue = new Queue();
        int pairNumber = 0;

        while (!stk.isEmpty()) {
            Dancer first = (Dancer) stk.pop();

            if (stk.isEmpty()) {
                if (first.getGender() == 'M') {
                    maleQueue.enqueue(first);
                } else {
                    femaleQueue.enqueue(first);
                }
                break;
            }

            Dancer next = (Dancer) stk.peek();
            if (first.getGender() != next.getGender()) {
                stk.pop();
                pairNumber++;
                System.out.println("#" + pairNumber + ": " + first + " & " + next);
            } else if (first.getGender() == 'F') {
                femaleQueue.enqueue(first);
            } else if (!femaleQueue.isEmpty()) {
                Dancer female = (Dancer) femaleQueue.dequeue();
                pairNumber++;
                System.out.println("#" + pairNumber + ": " + first + " & " + female);
            } else {
                maleQueue.enqueue(first);
            }
        }

        boolean hasExtraPairs = !maleQueue.isEmpty() && !femaleQueue.isEmpty();
        if (hasExtraPairs) {
            System.out.println("Extra Pair:");
        }
        while (!maleQueue.isEmpty() && !femaleQueue.isEmpty()) {
            Dancer male = (Dancer) maleQueue.dequeue();
            Dancer female = (Dancer) femaleQueue.dequeue();
            pairNumber++;
            System.out.println("#" + pairNumber + ": " + male + " & " + female);
        }

        Queue unpaired = null;
        String msg = "Unpaired ";
        if(!maleQueue.isEmpty()){
            unpaired = maleQueue;
            msg += "Male:";
        } else if(!femaleQueue.isEmpty()){
            unpaired = femaleQueue;
            msg += "Female:";
        }
        

        if(unpaired != null){
            System.out.println(msg);
            boolean first = true;
            while (!unpaired.isEmpty()) {
                if (!first) {
                    System.out.print(", ");
                }
                System.out.print(unpaired.dequeue());
                first = false;
            }
            System.out.println();
        } 
        
}
