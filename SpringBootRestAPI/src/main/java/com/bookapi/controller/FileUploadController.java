package com.bookapi.controller;

import com.bookapi.helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Objects;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper helper;
    @PostMapping("/upload-file")
    public ResponseEntity<String> getUpload(@RequestParam("file")MultipartFile file){

//        System.out.println(file.getOriginalFilename());
//        System.out.println(file.getSize());
//        System.out.println(file.getContentType());
//        System.out.println(file.getName());

        try {
            // Validation
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request must contain file");
            }

            if (!Objects.equals(file.getContentType(), "image/jpeg")) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only jpg content types are allowed ");

            }

            // file upload code

            boolean uploadFile = helper.uploadFile(file);
            if (uploadFile) {
               // return ResponseEntity.ok("File uploaded successfully");
                return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
            }else{
                return ResponseEntity.ok("File uploaded Failed");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!! Try again");
    }



}
