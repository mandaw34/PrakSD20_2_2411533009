package Pekan6;

public class HapusDLL {
	public static NodeDLL delHead(NodeDLL head) {

	   // Devina Amanada Putri, 2411533009
	        if (head == null) {
	            return null;
	        }
	        NodeDLL temp = head;
	        head = head.next;
	        if (head != null) {
	            head.prev = null;
	        }
	        return head;
	    }
	    public static NodeDLL delLast(NodeDLL head) {
	        if (head == null) {
	            return null;
	        }
	        if (head.next == null) {
	            return null;
	        }
	        NodeDLL curr = head;
	        while (curr.next != null) {
	            curr = curr.next;
	        }

	        // update pointer previous node
	        if (curr.prev != null) {
	            curr.prev.next = null;
	        }
	        return head;
	    }
	
public static NodeDLL delPos(NodeDLL head, int pos) {
	if (head == null) {
		return head; }
	NodeDLL curr =  head;
	for (int i = 1; curr != null && i < pos; ++i) {
		curr = curr.next; }
		if (curr != null) {
			curr.prev.next = curr.next; }
		if (curr.next != null) {
			curr.next.prev = curr.prev; }
		if (curr.next != null) {
			head = curr.next; }
		return head;}
	
	public static void printList (NodeDLL head) {
		NodeDLL curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			
		}
	
	}

public static void main (String[] args) {
	NodeDLL head = new NodeDLL(1);
	head.next = new NodeDLL (2);
	head.next.prev = head;
	head.next.next = new NodeDLL (3);
	head.next.next.prev = head.next;
	head.next.next.next = new NodeDLL (4);
	head.next.next.next.prev =  head.next.next;
	head.next.next.next.next = new NodeDLL (5);
	head.next.next.next.next.prev = head.next.next.next;
	
	System.out.print("DLL Awal: ");
	printList(head);
	
	System.out.print("Setelah head dihapus: ");
	head = delHead(head);
	printList(head);
	
	System.out.print("setelah node terakahir di hapus: " );
	head = delHead(head);
	printList(head);
	
	System.out.print("menghapus node ke 2: ");
	head = delLast(head);
	
	printList(head);
	
	System.out.println("Devina Amanada Putri, 2411533009");
	
}
}
	
	
	












	
