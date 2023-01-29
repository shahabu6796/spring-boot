package com.db.practice.SpringDbPractice.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper
{
    public final String UPLOAD_DIRECTORY = "D:\\JavaPractice\\upload-files";

    public boolean isUploaded(MultipartFile file)
    {
        boolean uploaded = false;
        //        try
        //        {
        //            InputStream inputStream = file.getInputStream();
        //            byte[] data = new byte[inputStream.available()];
        //            inputStream.read(data);
        //            //write
        //            FileOutputStream fos = new FileOutputStream(UPLOAD_DIRECTORY + File.separator + file.getOriginalFilename());
        //            fos.write(data);
        //            fos.flush();
        //            fos.close();
        //            uploaded = true;
        //        }
        //        catch (Exception e)
        //        {
        //            e.printStackTrace();
        //        }
        try
        {
            Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIRECTORY + File.separator + file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            uploaded = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return uploaded;
    }
}
