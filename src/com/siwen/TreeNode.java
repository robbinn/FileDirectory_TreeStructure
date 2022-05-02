package com.siwen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeNode {

    public TreeNode(String name) {
        this.name = name;
        this.children = new ArrayList<>();
        this.file = null;
    }

    public void createFile(File file) {
        this.file = file;
    }

    public List<TreeNode> getChildrenPointer() {
        return children;
    }

    public void appendChild(String name) {
        TreeNode newNode = new TreeNode(name);
        this.children.add(newNode);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void writeFile(String content) {
        this.file.writeToFile(content);
    }

    public String readFile() {
        return this.file.readFile();
    }

    public String getLastAccessTime() {
        return this.file.getLastAccessTime();
    }

    public void renameFile(String newName) {
        this.file.changeFileName(newName);
    }

    public int getFileLength() {
        return this.file.getFileLength();
    }

    private boolean hasFile() {
        return this.file != null;
    }

    public boolean hasChildren() {
        return this.getChildrenPointer().size() != 0;
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder(50);
        print(buffer, "", "");
        return buffer.toString();
    }

    private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        if (file != null) {
            buffer.append(name).append(" ── [").append(file.getFileName()).append("]");
        }
        else {
            buffer.append(name);
        }
        buffer.append('\n');
        for (Iterator<TreeNode> it = children.iterator(); it.hasNext();) {
            TreeNode next = it.next();
            if (it.hasNext()) {
                next.print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");

            } else {
                next.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
            }
        }
    }

    private String name;
    private final List<TreeNode> children;
    private File file;
}

