package com.Telemedicine.Telemedicine.Repositories;

import com.Telemedicine.Telemedicine.Models.FileModel;
import com.Telemedicine.Telemedicine.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface FileRepository extends JpaRepository<FileModel, String> {
    List<FileModel> findFilesByPatientId(long id);
    String deleteByName(String name);
}
