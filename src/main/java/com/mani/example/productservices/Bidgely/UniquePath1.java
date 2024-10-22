package com.mani.example.productservices.Bidgely;

public class UniquePath1 {
    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        int result = uniquePaths(m, n);
        System.out.println(result);
    }
    public static int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 || j==0)
                {
                    dp[i][j] =  1;
                }
                else
                {
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
//public void add(int data) {
//    Node newNode = new Node(data);
//    if (head == null) {
//        head = newNode;
//        return;
//    }
//    Node current = head;
//    while (current.next != null) {
//        current = current.next;
//    }
//    current.next = newNode;
//}
//
//// Method to remove duplicates
//public void removeDuplicates() {
//    HashSet<Integer> seen = new HashSet<>();
//    Node current = head;
//    Node prev = null;
//
//    while (current != null) {
//        if (seen.contains(current.data)) {
//            prev.next = current.next; // Remove the current node
//        } else {
//            seen.add(current.data); // Add the data to the set
//            prev = current; // Move prev pointer
//        }
//        current = current.next; // Move to the next node
//    }
//}
//
//// Method to print the linked list
//public void printList() {
//    Node current = head;
//    while (current != null) {
//        System.out.print(current.data + " ");
//        current = current.next;
//    }
//    System.out.println();
//}
//
//public static void main(String[] args) {
//    LinkedList list = new LinkedList();
//    list.add(1);
//    list.add(2);
//    list.add(3);
//    list.add(2);
//    list.add(4);
//    list.add(1);
//
//    System.out.println("Original list:");
//    list.printList();
//
//    list.removeDuplicates();
//
//    System.out.println("List after removing duplicates:");
//    list.printList();
//}
//}