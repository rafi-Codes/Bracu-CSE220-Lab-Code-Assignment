// Task 01
public static String checkSimilar(Node building1, Node building2) {
      Node curr1 = building1;
      Node curr2 = building2;

      while (curr1 != null && curr2 != null) {
          if (!curr1.elem.equals(curr2.elem)) {
              return "Not Similar";
          }
          curr1 = curr1.next;
          curr2 = curr2.next;
      }

      if (curr1 != null || curr2 != null) {
          return "Not Similar";
      }

      return "Similar";
}

// Task 02
public static Node organizeBooks(Node head, Integer[] popularity) {
        
        Node lastSort = null;
        for (int i = 0; i < popularity.length - 1; i++) {
            Node curr;
            
            if (lastSort == null){
                curr = head;
            } else {
                curr = lastSort.next;
            }

            Node maxHead = curr;
            Node maxPrev = lastSort;
            Node prev = maxHead;
            int maxIdx = i;

            for (int j = i + 1; j < popularity.length; j++) {
                Node point = prev.next;
                if (popularity[j] > popularity[maxIdx]) {
                    maxIdx = j;
                    maxHead = point;
                    maxPrev = prev;
                }
                prev = point;
            }

            if (maxIdx != i) {

                maxPrev.next = maxHead.next;
                maxHead.next = curr;
                
                if (lastSort == null) {
                    head = maxHead;
                } else {
                    lastSort.next = maxHead;
                }

                int temp = popularity[maxIdx];
                for (int j = maxIdx; j > i; j--) {
                    popularity[j] = popularity[j - 1];
                }
                popularity[i] = temp;
            }

            lastSort = maxHead;
        }

        return head;
}

// Task 03
public static Node alternateMerge( Node head1, Node head2 ){
        
        Node start1 = head1.next;
        Node start2 = head2;
        Node point = head1;

        while(start1 != null){
            point.next = start2;
            start2 = start2.next;
            point.next.next = start1;
            point = start1;
            start1 = point.next;
        }

        point.next = start2;
        start2 = null;
        
        return head1;
}

// Task 04
public static Node idGenerator(Node head1, Node head2, Node head3) {
        
        Node curr = head1;
        Node next = null;
        Node id = null;;
        Node nextStep = null;

        while(curr != null){
            id = new Node(curr.elem,next);
            if (next == null){
                nextStep = id;
            }
            next = id;
            curr = curr.next;
        }

        Node curr1 = head2;
        Node curr2 = head3;
        while(curr1 != null || curr2 != null){
            int elem = ((int)curr1.elem + (int)curr2.elem) % 10;
            Node newN = new Node(elem);
            nextStep.next = newN;
            curr1 = curr1.next;
            curr2 = curr2.next;
            nextStep = newN;

        }
        return id; 
}

// Task 05
public static void sumOddAppend(Node dh) {
        Node prev = dh;
        Node curr = dh.next;
        int sum = 0;
        while(curr != dh){
          
            if((int)curr.elem % 2 != 0){
                sum += (int)curr.elem;
                prev.next = curr.next;
                curr.next = null;
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        Node newN = new Node(sum);
        prev.next = newN;
        newN.next = dh;
}

// Task 06
public static void pairJoin(DNode dh1, DNode dh2) {
        DNode start1 = dh1.next.next;
        DNode start2 = dh2.next;
        DNode point = dh1.next;

        while(start1 != null){
            point.next = start2;
            start2.prev = point;
            start2 = start2.next;
            point.next.next = start1;
            start1.prev = point.next;
            point = start1;
            start1 = point.next;
        }
        point.next = start2;
        start2.prev = point;
        start2.next = dh1;
        dh1.prev = start2;
        dh2.next = null;
}
