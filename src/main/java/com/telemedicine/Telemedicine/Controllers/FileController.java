package com.Telemedicine.Telemedicine.Controllers;

import com.Telemedicine.Telemedicine.Http.ResponseFile;
import com.Telemedicine.Telemedicine.Http.ResponseMessage;
import com.Telemedicine.Telemedicine.Models.FileModel;
import com.Telemedicine.Telemedicine.Services.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin()
public class FileController {

    private final FileUploadService fileUploadService;

    @Autowired
    public FileController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @RequestMapping(value = "/api/upload", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ResponseMessage> uploadFile(
            @RequestParam("file") MultipartFile file) {

        String message = "";

        try {
            fileUploadService.store(file);

            message = "File uploaded successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));

        } catch (Exception e) {
            message = "Could not upload file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/files/{patientId}")
    public ResponseEntity<List<ResponseFile>> getFilesList(
            @PathVariable("patientId") Long patientId
    ) {
        List<ResponseFile> files = fileUploadService.getFilesByPatientId(patientId).map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/file/")
                    .path(dbFile.getId())
                    .toUriString();

            return new ResponseFile(
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/file/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {

        FileModel fileModel = fileUploadService.getFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileModel.getName() + "\"")
                .body(fileModel.getData());
    }

    @DeleteMapping("/files/{fileName}")
    public void deleteFile(@PathVariable String fileName) {
        fileUploadService.deleteFile(fileName);
    }
}
