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
        if(uploadFile != null) this.uploadFile = uploadFile;
    }

    public String getText()
    {
        if(fileToSend == null) return text;
        return text + "\n������� ����:\n" + fileToSend.getFileName()
                + "\n�������� �����:\n" + fileToSend.getFileDescription()
                + "\n���������� �����:\n" + fileToSend.getFileContent();
    }
    public String getFileDescription()
    {
        return fileToSend.getFileDescription();
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
    public void setText(String text)
    {
        this.text = text;
    }
    public String getTextOnly()
    {
        return text;
    }
}
