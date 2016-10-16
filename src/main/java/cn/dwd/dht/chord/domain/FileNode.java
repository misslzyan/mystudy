package cn.dwd.dht.chord.domain;

/**
 * 存储文件内容的结点
 * Created by xiaoyanzi on 16/10/16.
 */
public class FileNode {
    /*ID*/
    private int id;

    /*文件名*/
    private String fileName;

    /*文件内容*/
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FileNode{" +
                "content='" + content + '\'' +
                ", id=" + id +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
