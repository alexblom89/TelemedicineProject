package com.Telemedicine.Telemedicine.Controllers;

import com.Telemedicine.Telemedicine.Models.FileUploadResponse;
import com.Telemedicine.Telemedicine.Services.FileUploadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileUploadController {
    @PostMapping("/uploadFile")
    public ResponseEntity<FileUploadResponse> uploadFile(
            @RequestParam("file") MultipartFile multipartFile)
            throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        long size = multipartFile.getSize();

        String fileCode = FileUploadService.saveFile(fileName, multipartFile);

        FileUploadResponse response = new FileUploadResponse(fileName, "/downloadFile/" + fileCode, size);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
