package Curs3;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Message implements Serializable {
    private String text;
    private FileToSend fileToSend;
    private String uploadFile;
    public Message(String text, FileToSend fileToSend, String uploadFile)
    {
        this.text = text;
        if(fileToSend != null) this.fileToSend = fileToSend;
        if(uploadFile != null) this.fileToSend = fileToSend;
    }

    public String getText()
    {
        if(fileToSend == null) return text;
        return text + "\n Получен файл: " + fileToSend.getFileName()
                + "\n" + fileToSend.getFileDescription()
                + "\n" + fileToSend.getFileContent();
    }
    public String getFileDescription()
    {
        if(fileToSend == null) return text;
        return text + "\n Получен файл: " + fileToSend.getFileName()
                + "\n" + fileToSend.getFileDescription();
    }
    public FileToSend getFileToSend()
    {
        if(this.fileToSend == null) return null;
        return this.fileToSend;
    }
    public void setFileToSend(FileToSend fileToSend)
    {
        this.fileToSend = fileToSend;
    }

    public String getUploadFile() {
        return uploadFile;
    }
}
