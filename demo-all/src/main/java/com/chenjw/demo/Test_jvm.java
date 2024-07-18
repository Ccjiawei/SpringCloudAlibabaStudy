package com.chenjw.demo;

public class Test_jvm {

    public static void main(String[] args) {
        Test_jvm jvm = new Test_jvm();
        jvm.jvm();

        // 显示调用垃圾回收
        closeOrFreeMemory(jvm);
    }

    private int jvm() {
        int a = 1;
        int b = 2;
        int c = a + b;

        System.out.println(c);
        return c;
    }

    protected static void closeOrFreeMemory(Object object){ //引用传递？？？ 那这个object=null 是不是不影响传参的jvm？
        object = null;
        System.gc();
    }

    /**
     * 覆写finalize()方法
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize.........");
    }

}

class LinkedListDemo<E>{

    transient Node<E> first;
    transient Node<E> last;

    void add(E e){
        Node<E> node = new Node<>(null, e, null);
        add(node);
    }
    public void add(Node<E> node){
        if (first == null){
            first = node;
            last = node;
        }else {
            last.next = node;
            node.prev = last;
            last = node;
        }
    }

    public void get(Node<E> node){
    }

    public void remove(Node<E> node){
        if (node == first){
            first = node.next;
        }else {
            node.prev.next = node.next;
        }
    }

    protected static final class Node<E>{
        E item;
        Node<E> next;
        Node<E> prev;
        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
