package com.siwen;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileMap {

    public FileMap(TreeNode root) {
        this.root = root;
    }

    public void printTree() {
        System.out.println(root);
    }

    public TreeNode locateWalker(String path) {
        String[] pth = path.split("/");
        TreeNode walker = root;

        for (String p : pth) {
            for (TreeNode node : walker.getChildrenPointer()) {
                if (Objects.equals(node.getName(), p)) {
                    walker = node;
                    break;
                }
            }
        }
        return walker;
    }

    public void createPath(String str) {
        // remove the first '/'
        if (str.charAt(0) == '/') {
            str = str.substring(1);
        }

        // split the path and newNode name
        String[] arrOfStr = str.split(" ");
        String newNodeName = arrOfStr[1];

        TreeNode walker = locateWalker(arrOfStr[0]);

        walker.appendChild(newNodeName);
    }

    public void rename(String str) {
        // remove the first '/'
        if (str.charAt(0) == '/') {
            str = str.substring(1);
        }

        // split the path and newNode name
        String[] arrOfStr = str.split(" ");
        String newNodeName = arrOfStr[1];

        TreeNode walker = locateWalker(arrOfStr[0]);
        walker.setName(newNodeName);
    }

    public void addFile(String str) {
        if (str.charAt(0) == '/') {
            str = str.substring(1);
        }

        // split the path and File name
        String[] arrOfStr = str.split(" ");
        String fileName = arrOfStr[1];

        TreeNode walker = locateWalker(arrOfStr[0]);

        File f = new File(fileName);
        walker.createFile(f);
    }

    public void move(String str) {
        String[] arrOfStr = str.split(" ");

        String[] path = arrOfStr[0].split("/");
        TreeNode walkerL = root;
        List<TreeNode> childrenPointerL = null;
        for (String p : path) {
            childrenPointerL = walkerL.getChildrenPointer();
            for (TreeNode node : childrenPointerL) {
                if (Objects.equals(node.getName(), p)) {
                    walkerL = node;
                    break;
                }
            }
        }

        String[] pathR = arrOfStr[1].split("/");
        TreeNode walkerR = root;
        List<TreeNode> childrenPointerR;
        for (String p : pathR) {
            childrenPointerR = walkerR.getChildrenPointer();
            for (TreeNode node : childrenPointerR) {
                if (Objects.equals(node.getName(), p)) {
                    walkerR = node;
                    break;
                }
            }
        }

        walkerR.getChildrenPointer().add(walkerL);

        assert childrenPointerL != null;
        childrenPointerL.remove(walkerL);
    }

    public void find(String nodeName) {
        System.out.println("Find " + nodeName + ":");
        List<String> res = new ArrayList<>();
        helperFind(root, nodeName, "/", res);
        System.out.println(res);
    }

    private void helperFind(TreeNode node, String targetName, String currPath, List<String> res) {
        currPath = currPath + node.getName();

        if (node.getName().equals(targetName)) {
            res.add(currPath);
        }

        else {
            for (TreeNode n : node.getChildrenPointer()) {
                helperFind(n, targetName, currPath + "/", res);
            }
        }
    }

    public void list(String path) {
        System.out.println("List " + path + ":");
        String[] pth = path.split("/");
        TreeNode walker = root;
        List<TreeNode> childrenPointerL = null;
        for (String p : pth) {
            childrenPointerL = walker.getChildrenPointer();
            for (TreeNode node : childrenPointerL) {
                if (Objects.equals(node.getName(), p)) {
                    walker = node;
                    break;
                }
            }
        }

        System.out.println(walker);
    }

    public void delete(String path) {
        String[] pth = path.split("/");
        TreeNode walker = root;
        List<TreeNode> childrenPointer = null;
        for (String p : pth) {
            childrenPointer = walker.getChildrenPointer();
            for (TreeNode node : childrenPointer) {
                if (Objects.equals(node.getName(), p)) {
                    walker = node;
                    break;
                }
            }
        }

        assert childrenPointer != null;
        childrenPointer.remove(walker);
    }

    public void writeToFile(String str) {
        if (str.charAt(0) == '/') {
            str = str.substring(1);
        }

        // split the path and File name
        String[] arrOfStr = str.split(" ");
        StringBuilder content = new StringBuilder();
        for (int i = 1; i < arrOfStr.length; i++) {
            content.append(arrOfStr[i]);
            content.append(" ");
        }

        TreeNode walker = locateWalker(arrOfStr[0]);
        walker.writeFile(content.toString());
    }

    public void readFile(String path) {
        System.out.println("File content:");
        TreeNode walker = locateWalker(path);
        System.out.println(walker.readFile());
    }

    public void getLastAccessTime(String path) {
        TreeNode walker = locateWalker(path);
        System.out.println("Last Access Time:");
        System.out.println(walker.getLastAccessTime());
    }

    public void renameFile(String str) {
        if (str.charAt(0) == '/') {
            str = str.substring(1);
        }

        // split the path and File name
        String[] arrOfStr = str.split(" ");
        TreeNode walker = locateWalker(arrOfStr[0]);
        String newName = arrOfStr[1];
        walker.renameFile(newName);
    }

    public void getFileLength(String path) {
        TreeNode walker = locateWalker(path);
        System.out.println("File Length:");
        System.out.println(walker.getFileLength());
    }

    private final TreeNode root;
}
