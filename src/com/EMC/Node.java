package com.EMC;

import java.util.ArrayList;
import java.util.List;

public class Node {

    int id;
    List<String> p;
    List<Node> next, pre;
    int visited;

    public Node(int id) {
        this.id = id;
        this.p = new ArrayList<>();
        this.next = new ArrayList<>();
        this.pre = new ArrayList<>();
        this.visited = 0;
    }

    public Node(int id, List<String> p) {
        this.id = id;
        this.p = p;
        this.next = new ArrayList<>();
        this.pre = new ArrayList<>();
        this.visited = 0;
    }

    public void addNext(Node n) {
        this.next.add(n);
    }

    public void print() {
        System.out.println("id: " + id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getP() {
        return p;
    }

    public void setP(List<String> p) {
        this.p = p;
    }

    public List<Node> getNext() {
        return next;
    }

    public void setNext(List<Node> next) {
        this.next = next;
    }

    public List<Node> getPre() {
        return pre;
    }

    public void setPre(List<Node> pre) {
        this.pre = pre;
    }

    public int getVisited() {
        return visited;
    }

    public void setVisited(int visited) {
        this.visited = visited;
    }
}
