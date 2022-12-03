package com.Telemedicine.Telemedicine.Services;

import com.Telemedicine.Telemedicine.Models.FileModel;
import com.Telemedicine.Telemedicine.Models.Patient;
import com.Telemedicine.Telemedicine.Repositories.FileRepository;
import com.Telemedicine.Telemedicine.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class FileUploadService {

    private final FileRepository fileRepository;
    private final PatientRepository patientRepository;

    @Autowired
    FileUploadService(FileRepository fileRepository, PatientRepository patientRepository) {
        this.fileRepository = fileRepository;
        this.patientRepository = patientRepository;
    }

    /**
     * Function to store file in database
     * @param file
     * @return
     * @throws IOException
     */
    public FileModel store(MultipartFile file) throws IOException {
        Patient patient = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        patient= patientRepository.findPatientByEmail(authentication.getName());
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileModel fileModel = new FileModel(fileName, file.getContentType(), file.getBytes(),patient );
        return fileRepository.save(fileModel);
    }

    public FileModel getFile(String id) {
        return fileRepository.findById(id).get();
    }

    public void deleteFile(String fileName) {
        fileRepository.deleteByName(fileName);
    }

    public Stream<FileModel> getAllFiles() {
        return fileRepository.findAll().stream();
    }

    public Stream<FileModel> getFilesByPatientId(Long id) {
        return fileRepository.findFilesByPatientId(id).stream();
    }
}
