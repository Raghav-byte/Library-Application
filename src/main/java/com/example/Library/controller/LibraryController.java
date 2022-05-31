package com.example.Library.controller;


import com.example.Library.models.Library;
import com.example.Library.services.BookServices;
import com.example.Library.services.LibraryServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/library")

public class LibraryController {

    @Autowired
    private LibraryServices libraryServices;

    @Autowired
    private BookServices bookServices;

    @ApiOperation("This api is to create library")
    @PostMapping("/createLibrary")
    public Library createLibrary(@RequestBody Library library) {
        return libraryServices.createLibrary(library);
    }

    @ApiOperation("This api is to show all library")
    @GetMapping("/showLibrary")
    public List<Library> showAllLibrary() {
        return libraryServices.showAllLibrary();
    }

    @ApiOperation("This api is to show one library")
    @GetMapping("/{libraryId}")
    public Optional<Library> showOneLibrary(@PathVariable UUID libraryId) {
        return libraryServices.showOneLibrary(libraryId);
    }

    @ApiOperation("This api is to delete library")
    @DeleteMapping("/{libraryId}")
    public String deleteLibrary(@PathVariable UUID libraryId) {
        return libraryServices.deleteLibrary(libraryId);
    }

    @ApiOperation("This api is to update library")
    @PutMapping("/updateLibrary")
    public Library updateLibrary(@RequestBody Library library) {
        return libraryServices.updateLibrary(library);
    }

    //filter
    //search
    //add book in library
    //remove book from library
    //mark book as trending

}
