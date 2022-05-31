package com.example.Library.services;

import com.example.Library.models.Address;
import com.example.Library.models.Library;
import com.example.Library.models.Mobile;
import com.example.Library.repository.LibraryRepository;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Service

public class LibraryServices {

    @Autowired
    private LibraryRepository libraryRepository;


    // TO CREATE LIBRARY
    public Library createLibrary(Library library) {
        library.getLibraryAddress().setCountry("India");
        library.getMobileNumber().setCountryCode("91");
        return libraryRepository.save(library);
    }

    //TO SHOW ALL LIBRARY
    public List<Library> showAllLibrary() {
        return libraryRepository.findAll();
    }

    //TO SHOW ONE LIBRARY
    public Optional<Library> showOneLibrary(UUID libraryId) {
        return libraryRepository.findById(libraryId);
    }

    //TO DELETE LIBRARY
    public String deleteLibrary(UUID libraryId) {
        libraryRepository.deleteById(libraryId);
        return "Library Deleted";
    }

    //TO UPDATE LIBRARY
    public Library updateLibrary(Library library) {
        AtomicReference<Library> libraryAtomicReference =new AtomicReference<>();
        Optional<Library> existingLibrary = libraryRepository.findById(library.getLibraryId());
        existingLibrary.ifPresentOrElse(l->{
            l.setLibraryName(!TextUtils.isEmpty(library.getLibraryName()) ? library.getLibraryName() : l.getLibraryName());

            Address address = l.getLibraryAddress();
            if (library.getLibraryAddress() != null) {
                address.setAddressLine1(!TextUtils.isEmpty(library.getLibraryAddress().getAddressLine1()) ? library.getLibraryAddress().getAddressLine1() : address.getAddressLine1());
                address.setCity(!TextUtils.isEmpty(library.getLibraryAddress().getCity()) ? library.getLibraryAddress().getCity() : address.getCity());
                address.setLocality(!TextUtils.isEmpty(library.getLibraryAddress().getLocality()) ? library.getLibraryAddress().getLocality() : address.getLocality());
                address.setState(!TextUtils.isEmpty(library.getLibraryAddress().getState()) ? library.getLibraryAddress().getState() : address.getState());
            }
            l.setLibraryAddress(address);

            Mobile mobile = l.getMobileNumber();
            if (library.getMobileNumber() != null){
                mobile.setNumber(!TextUtils.isEmpty(library.getMobileNumber().getNumber()) ? library.getMobileNumber().getNumber() : mobile.getNumber());
            }
            l.setMobileNumber(mobile);

            libraryAtomicReference.set(libraryRepository.save(l));
        },()->{
            try {
                throw new Exception("Library not found");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        return libraryAtomicReference.get();
    }
}
