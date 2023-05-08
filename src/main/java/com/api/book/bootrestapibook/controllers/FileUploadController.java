package com.api.book.bootrestapibook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.book.bootrestapibook.helper.FileUpload;

@RestController
public class FileUploadController {
    
    @Autowired
    private FileUpload fileupload;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file){
       
        try {
            if(file.isEmpty())
        {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request must contain file");
        }
        
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getName());
        System.out.println(file.getSize());
        System.out.println(file.getContentType());
        
        // File Upload code 
       boolean f= fileupload.uploadFile(file);
        // If file uploaded the f will be true. and this condition will work
       if(f){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("file is uploaded Succesfully");
       }
         

        } catch (Exception e) {
            
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!! Try again....");
    }
}
