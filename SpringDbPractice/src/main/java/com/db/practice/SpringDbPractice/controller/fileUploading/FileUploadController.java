package com.db.practice.SpringDbPractice.controller.fileUploading;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.db.practice.SpringDbPractice.helper.FileUploadHelper;

@RestController
public class FileUploadController
{
    @Autowired
    FileUploadHelper fileUploadHelper;

    @PostMapping("upload-file")
    public ResponseEntity<String> fileUpload(@RequestParam MultipartFile file)
    {
        if (file.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file..");
        }
        if (!file.getContentType().equals("image/jpeg"))
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only jpeg file is allowed");
        }
        //file upload code
        //1. where to upload the file on server
        //2.
        boolean uploaded = fileUploadHelper.isUploaded(file);
        if (uploaded)
        {
            return ResponseEntity.ok("upload successfully");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }
}
