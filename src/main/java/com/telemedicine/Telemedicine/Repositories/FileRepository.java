package com.Telemedicine.Telemedicine.Repositories;

import com.Telemedicine.Telemedicine.Models.FileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileModel, String> {
}
