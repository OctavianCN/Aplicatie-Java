package service;

import exceptions.InexistentFileException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class FileService {

    private FileService(){

    }
    public void writeFile(String path,String content){

        if(!Files.exists(Paths.get(path))) {
            try (PrintStream out = new PrintStream(path)) {
                out.append(content);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try (PrintStream out = new PrintStream( new FileOutputStream(path, true))) {
                out.append("\n");
                out.append(content);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public List<String> getFile(String path){
        Path file = Paths.get(path);
        List<String> list = null;
        try {
            if(!Files.exists(file)){
                throw new InexistentFileException();
            }
           list = Files.readAllLines(file);

        }catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static FileService getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static FileService INSTANCE = new FileService();
    }
}
