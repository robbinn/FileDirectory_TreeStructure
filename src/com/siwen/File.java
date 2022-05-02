package com.siwen;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class File {

    public File(String fileName) {
        this.fileName = fileName;
        this.data = "";
        updateAccessTime();
    }

    public void changeFileName(String newFileName) {
        this.fileName = newFileName;
        updateAccessTime();
    }

    public void writeToFile(String content) {
        this.data = content;
        updateAccessTime();
    }

    public String readFile() {
        updateAccessTime();
        return this.data;
    }

    public void updateAccessTime() {
        this.time = LocalDateTime.now();
    }

    public String getLastAccessTime() {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        return time.format(myFormatObj);
    }

    public int getFileLength() {
        updateAccessTime();
        return data.length();
    }

    public String getFileName() {
        updateAccessTime();
        return this.fileName;
    }

    private String fileName;
    private String data;
    private LocalDateTime time;
}
