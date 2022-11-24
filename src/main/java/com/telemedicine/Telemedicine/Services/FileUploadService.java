package com.Telemedicine.Telemedicine.Services;

import com.Telemedicine.Telemedicine.Models.FileModel;
import com.Telemedicine.Telemedicine.Models.Patient;
import com.Telemedicine.Telemedicine.Repositories.FileRepository;
import com.Telemedicine.Telemedicine.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

@Service
public class FileUploadService {



    private final FileRepository fileRepository;

    private final UserRepository userRepository;

    @Autowired
    FileUploadService(FileRepository fileRepository, UserRepository userRepository) {
        this.fileRepository = fileRepository;
        this.userRepository = userRepository;
    }

    public FileModel store(MultipartFile file) throws IOException {
        Patient patient = null;

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            patient = (Patient)auth.getPrincipal();
        }

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        FileModel fileModel = new FileModel(fileName, file.getContentType(), file.getBytes(), patient);

        return fileRepository.save(fileModel);
    }

    public FileModel getFile(String id) {
        return fileRepository.findById(id).get();
    }

    public Stream<FileModel> getAllFiles() {
        return fileRepository.findAll().stream();
    }

    public Stream<FileModel> getFilesByPatientId(Long id) {
        return fileRepository.findFilesByPatientId(id).stream();
    }
}
