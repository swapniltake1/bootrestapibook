package com.api.book.bootrestapibook.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUpload {
    
    public final String UPLOAD_DIR="E:\\Spring & SpringBoot Practice\\vscode workspace\\bootrestapibook\\src\\main\\resources\\static\\img";

    public boolean uploadFile(MultipartFile multipartFile){
        boolean f=false;

        try {
           /*  InputStream is=multipartFile.getInputStream(); 
            byte data[]=new byte[is.available()];
            is.read(data);
            // Write file in our directory.
            FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename());
            fos.write(data);
            fos.flush();
            fos.close(); */

            Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
            f=true;
           
        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }
}
