package com.example.Library.repository;

import com.example.Library.models.Library;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LibraryRepository extends MongoRepository<Library, UUID> {
}
