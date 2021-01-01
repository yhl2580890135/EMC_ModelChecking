package com.EMC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Node> nodes;

    public static void main(String[] args) {
        //create state machine
        createStateMachine1();
//        DFS(nodes.get(0));

        //input expression and run model checker
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        parseExpression(expression);

    }

    private static void parseExpression(String expression) {

    }

    private static void DFS(Node node) {
        System.out.println("visit: "+node.getId());
        node.setVisited(1);
        for (Node n: node.getNext()) {
            if (n.getVisited() == 0) {
                DFS(n);
            }
        }
    }

    public static void createStateMachine1() {
        try {
            String encoding="GBK";
            File file=new File("resource/input.txt");
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                nodes = new ArrayList<>();
                while((lineTxt = bufferedReader.readLine()) != null){
//                    System.out.println("1 "+lineTxt);
                    if (lineTxt.equals("Node:")) {
                        String lineTxt2 = null;
                        while((lineTxt2 = bufferedReader.readLine()) != null){
                            if (lineTxt2.equals("end")) {
                                break;
                            }
//                            System.out.println("2 "+lineTxt2);
                            String [] s = lineTxt2.split("\\s+");
                            nodes.add(new Node(Integer.parseInt(s[0]), new ArrayList<String>(){{add(s[1]);add(s[2]);}}));
                        }
                    }
                    if (lineTxt.equals("Relation:")) {
                        String lineTxt2 = null;
                        while((lineTxt2 = bufferedReader.readLine()) != null){
                            if (lineTxt2.equals("end")) {
                                break;
                            }
//                            System.out.println("3 "+lineTxt2);
                            String [] s = lineTxt2.split("\\s+");
                            nodes.get(Integer.parseInt(s[0])).addNext(nodes.get(Integer.parseInt(s[1])));
                        }
                    }
                }
                read.close();
            }else{
                System.out.println("找不到指定的文件");
            }
            for (int i=0; i<=8; i++) {
                System.out.println("node "+i+"'s next state:");
                for (Node n: nodes.get(i).getNext()) {
                    n.print();
                }
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

    }

//    public static void createStateMachine1_() {
//        nodes = new ArrayList<>();
//        nodes.add(new Node(0, new ArrayList<String>(){{add("N");add("N");}}));
//        nodes.add(new Node(1, new ArrayList<String>(){{add("T");add("N");}}));
//        nodes.add(new Node(2, new ArrayList<String>(){{add("N");add("T");}}));
//        nodes.add(new Node(3, new ArrayList<String>(){{add("C");add("N");}}));
//        nodes.add(new Node(4, new ArrayList<String>(){{add("T");add("T");}}));
//        nodes.add(new Node(5, new ArrayList<String>(){{add("T");add("T");}}));
//        nodes.add(new Node(6, new ArrayList<String>(){{add("N");add("C");}}));
//        nodes.add(new Node(7, new ArrayList<String>(){{add("C");add("T");}}));
//        nodes.add(new Node(8, new ArrayList<String>(){{add("T");add("C");}}));
//        nodes.get(0).addNext(nodes.get(1));
//        nodes.get(0).addNext(nodes.get(2));
//        nodes.get(1).addNext(nodes.get(3));
//        nodes.get(1).addNext(nodes.get(4));
//        nodes.get(2).addNext(nodes.get(5));
//        nodes.get(2).addNext(nodes.get(6));
//        nodes.get(3).addNext(nodes.get(0));
//        nodes.get(3).addNext(nodes.get(7));
//        nodes.get(4).addNext(nodes.get(7));
//        nodes.get(5).addNext(nodes.get(8));
//        nodes.get(6).addNext(nodes.get(0));
//        nodes.get(6).addNext(nodes.get(8));
//        nodes.get(7).addNext(nodes.get(2));
//        nodes.get(8).addNext(nodes.get(1));
//        for (int i=0; i<=8; i++) {
//            System.out.println("node "+i+"'s next state:");
//            for (Node n: nodes.get(i).getNext()) {
//                n.print();
//            }
//        }
//    }

}
