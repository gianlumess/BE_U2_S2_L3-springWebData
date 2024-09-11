package gianlucamessina.BE_U2_S2_L3_springWebData.controllers;

import gianlucamessina.BE_U2_S2_L2_SpringWeb.entities.Author;
import gianlucamessina.BE_U2_S2_L2_SpringWeb.services.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {
    @Autowired
    AuthorsService authorsService;
    //GET LIST
    @GetMapping
    private List<Author> getAllAuthors(){
        return authorsService.findAll();
    }

    //POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Author createAuthor(@RequestBody Author body){
        return authorsService.saveAuthor(body);
    }

    //GET AUTHOR BY ID
    @GetMapping("/{authorId}")
    private Author getAuthorById(@PathVariable int authorId){
        return authorsService.findById(authorId);
    }

    //PUT
    @PutMapping("/{authorId}")
    private Author findAuthorByIdAndDelete(@PathVariable int authorId,@RequestBody Author body){
        return authorsService.findByIdAndUpdate(authorId,body);
    }

    //DELETE
    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void findAuthorByIdAndDelete(@PathVariable int authorId){
        authorsService.findByIdAndDelete(authorId);
    }


}
