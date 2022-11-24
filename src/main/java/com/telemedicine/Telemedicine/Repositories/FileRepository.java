package com.Telemedicine.Telemedicine.Repositories;

import com.Telemedicine.Telemedicine.Models.FileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<FileModel, String> {
    List<FileModel> findFilesByPatientId(long id);
}
