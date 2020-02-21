package com.cve.cve.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class StorageService {


    private String path=System.getProperty("user.dir")+"/src/main/resources/static/assets/images/";

    public String uploadFile(MultipartFile file,Long long1) {
  
        String newFile;
        do{
        newFile=generateUniqueFileName() + file.getOriginalFilename();

        }
        while(new File(path+newFile).exists());

        try {

            Files.copy(file.getInputStream(), Paths.get(path +newFile),
                    StandardCopyOption.REPLACE_EXISTING);
                    return newFile;
        } catch (IOException e) {

            //var msg = String.format("Failed to store file", file.getName());

            //throw new StorageException(msg, e);
           
        }
        return "";

    }
       public String generateUniqueFileName () {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HHmmss").format(new Date());
        timeStamp.replace(":", "");
        timeStamp.replace("-", "");
        return timeStamp ;
    }
}
