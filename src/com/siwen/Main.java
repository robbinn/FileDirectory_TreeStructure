package com.siwen;

public class Main {

    public static void main(String[] args) {

        TreeNode root = new TreeNode("Root");
        FileMap fp = new FileMap(root);

        fp.createPath("/ x");
        fp.createPath("/ y");
        fp.createPath("/x z");
        fp.createPath("/x r");
        fp.createPath("/x t");

        fp.createPath("/x/z n");
        fp.createPath("/x/z m");
        fp.createPath("/x/z k");
        fp.createPath("/x/r h");
        fp.createPath("/x/r p");
        fp.createPath("/x/t e");
        fp.createPath("/x/t f");

        fp.createPath("/x/z/m b");
        fp.createPath("/x/z/m c");

        fp.createPath("/y c");
        fp.createPath("/y n");
        fp.createPath("/y a");

        fp.addFile("/y/c f1");
        fp.addFile("/y/n f2");
        fp.addFile("/y/a f3");
        fp.addFile("/x/z/n f4");
        fp.addFile("/x/z/k f5");
        fp.addFile("/x/r/h f6");
        fp.addFile("/x/r/p f7");
        fp.addFile("/x/t/e f8");
        fp.addFile("/x/t/f f9");
        fp.addFile("/x/z/m/b f10");
        fp.addFile("/x/z/m/c f11");


//        fp.writeToFile("/x/z/m/c Happy Friday");
//        fp.readFile("/x/z/m/c");
//
//        fp.getLastAccessTime("/x/z/m/c");
//        fp.renameFile("/x/z/m/c f20");
//        fp.getFileLength("/x/z/m/c");
//        fp.printTree();


//        fp.createPath("/y d");
//        fp.rename("/x/t/e g");
//
//        fp.move("/x/z/k /x/r");
//
        fp.printTree();
//
//        fp.find("c");
//        System.out.println();
//        fp.list("/x/r");
//
//        fp.delete("/x/z");
//        System.out.println("After delete:");
//        fp.printTree();
    }
}
