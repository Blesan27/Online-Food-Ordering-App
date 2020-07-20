package com.example.smartmart.File;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {

    private final Path fileLocation;

    public FileService(FIleProperties fIleProperties){
        this.fileLocation = Paths.get(fIleProperties.getUploadDir()).toAbsolutePath().normalize();
    }

public Resource loadFileAsResource(String filename){
        try{
            Path filepath =this.fileLocation.resolve(filename).normalize();
            Resource resource = new UrlResource(filepath.toUri());
            if (resource.exists()){
                return resource;
            }
            else{
                return null;
            }
        }catch (MalformedURLException url){
            return null;
        }
}
}
