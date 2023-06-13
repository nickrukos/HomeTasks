package Curs3;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileToSend implements Serializable
{
    private String fileName;
    private String fileDescription;
    private String fileContent;
    private long fileSize;

    public FileToSend(String fileName, String description) throws IOException
    {
        Path path = Paths.get(fileName);
        if(!Files.exists(path))
        {
            System.out.println("”казанный файл несуществует!");
            return;
        }
        this.fileName = fileName;
        FileChannel fileChannel = FileChannel.open(path);
        this.fileDescription = description;
        this.fileContent = new String(Files.readAllBytes(Paths.get(fileName)));
        this.fileSize = fileChannel.size();
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public String getFileContent() {
        return fileContent;
    }

    public long getFileSize() {
        return fileSize;
    }
}
