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
