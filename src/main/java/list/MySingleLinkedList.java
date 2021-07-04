package list;

import java.util.Scanner;

/**
 * @Description
 * @Author zdk
 * @Date 2020/9/27 21:08
 */

public class MySingleLinkedList<T> {
    /**
     * 节点类
     */
    class Node {
        T val;
        Node next;

        Node() {
        }

        public Node(T val) {
            this.val = val;
        }
    }

    Node head;

    public MySingleLinkedList() {
        head = new Node(null);
    }

    /**
     * 增加一个值为val的节点在链表的头部
     */
    public void addAtHead(T val) {
        Node node = new Node(val);
        node.next = head.next;
        head.next = node;
    }

    /**
     * 增加一个值为val的节点在链表的尾部
     */
    public void addAtTail(T val) {
        Node node = new Node(val);
        Node p;
        p = head;
        int cnt = 0;
        while (p.next != null && cnt != this.getListLength()) {
            p = p.next;
        }
        p.next = node;
    }

    /**
     * 获得第index个节点的值
     */
    public T get(int index) {
        if (index <= 0 || index > this.getListLength()) {
            return null;
        } else {
            Node p;
            p = head;
            int cnt = 0;
            while (p.next != null && cnt != index) {
                p = p.next;
                cnt++;
            }
            return p.val;
        }
    }

    /**
     * 在第index个节点之前添加值为val的节点
     */
    public void addAtIndex(int index, T val) {
        Node p;
        p = head;
        int cnt = 0;
        while (p.next != null && cnt != index - 1) {
            p = p.next;
            cnt++;
        }
        Node n = new Node(val);
        n.next = p.next;
        p.next = n;
    }

    /**
     * 如果索引index 有效，则删除链表中的第index 个节点
     */
    public void deleteAtIndex(int index) {
        if (index > this.getListLength() || index <= 0) {
            System.out.println("输入无效");
        } else {
            Node q;
            q = head;
            int cnt = 0;
            while (q.next != null && cnt != index - 1) {
                q = q.next;
                cnt++;
            }
            q.next = q.next.next;
        }
    }

    /**
     * 获取链表的最后一个元素
     */
    public T getTail() {
        Node p;
        p = head;
        int cnt = 0;
        while (p.next != null && cnt != this.getListLength()) {
            p = p.next;
        }
        return p.val;
    }

    /**
     * 删除指定值的节点
     */
    public void deleteAtValue(T val) {
        boolean flag = false;
        Node p;
        p = head;
        while (p.next != null) {
            if (p.next.val == val) {
                flag = true;
                if (p.next.next == null) {
                    p.next = null;
                    break;
                } else {
                    p.next = p.next.next;
                }
            }
            p = p.next;
        }
        if (!flag) {
            System.out.printf("链表中无值为%d的节点\n", val);
        }
    }

    /**
     * 获得链表的长度
     */
    public int getListLength() {
        int length = 0;
        Node p;
        p = head;
        while (p.next != null) {
            p = p.next;
            length++;
        }
        return length;
    }

    /**
     * 将链表输出展示
     */
    public void showList() {
        Node p;
        p = head;
        while (p.next != null) {
            System.out.print(p.next.val + "->");
            p = p.next;
        }
        System.out.println();
    }
}

class MySingleLinkedListTest {
    public static void main(String[] args) {
        MySingleLinkedList<Integer> test = new MySingleLinkedList<>();
        test.addAtHead(10);
        test.addAtHead(9);
        test.addAtHead(8);
        test.addAtHead(7);
        test.addAtHead(6);
        test.addAtHead(5);
        test.addAtTail(11);
        test.showList();
        System.out.printf("链表的长度为:%d\n", test.getListLength());

        System.out.print("请输入要查询链表第几个节点的值:");
        int index1 = new Scanner(System.in).nextInt();

        if (test.get(index1) != null) {
            System.out.printf("链表中第%d个节点的值为:%d\n", index1, test.get(index1));
        } else {
            System.out.println("输入无效");
        }

        System.out.print("请输入要删除第几个节点的值:");
        int index2 = new Scanner(System.in).nextInt();
        test.deleteAtIndex(index2);
        test.showList();

        System.out.print("请输入要删除的链表节点的值:");
        int index3 = new Scanner(System.in).nextInt();
        test.deleteAtValue(index3);
        test.showList();
    }
}