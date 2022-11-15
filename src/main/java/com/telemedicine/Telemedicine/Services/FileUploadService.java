package com.Telemedicine.Telemedicine.Services;

import com.Telemedicine.Telemedicine.Models.FileModel;
import com.Telemedicine.Telemedicine.Repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class FileUploadService {

    private final FileRepository fileRepository;
    @Autowired
    FileUploadService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public FileModel store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileModel fileModel = new FileModel(fileName, file.getContentType(), file.getBytes());

        return fileRepository.save(fileModel);
    }

    public FileModel getFile(String id) {
        return fileRepository.findById(id).get();
    }

    public Stream<FileModel> getAllFiles() {
        return fileRepository.findAll().stream();
    }
}
