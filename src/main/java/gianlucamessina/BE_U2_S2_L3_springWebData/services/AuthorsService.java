package gianlucamessina.BE_U2_S2_L3_springWebData.services;

import gianlucamessina.BE_U2_S2_L2_SpringWeb.entities.Author;
import gianlucamessina.BE_U2_S2_L2_SpringWeb.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AuthorsService {
    private List<Author>authorList=new ArrayList<>();

    public List<Author>findAll(){
        return this.authorList;
    }

    public Author findById(int authorId){
        Author found=null;
        for (Author author:authorList){
            if (author.getId()==authorId) found=author;
        }
        if (found==null)throw new NotFoundException(authorId);
        return found;
    }

    public Author saveAuthor(Author body){
        Random random=new Random();
        body.setId(random.nextInt(1,20000));
        body.setAvatar("https://ui-avatars.com/api/?name="+body.getNome()+"+"+body.getCognome());
        this.authorList.add(body);
        return body;
    }

    public Author findByIdAndUpdate(int authorId,Author updatedAuthor){
        Author found=null;
        for (Author author:authorList){
            if (author.getId()==authorId) found=author;
        }
        if (found==null)throw new NotFoundException(authorId);

        found.setNome(updatedAuthor.getNome());
        found.setCognome(updatedAuthor.getCognome());
        found.setEmail(updatedAuthor.getEmail());
        found.setDataNascita(updatedAuthor.getDataNascita());
        found.setAvatar(updatedAuthor.getAvatar());

        return found;
    }

    public void findByIdAndDelete(int authorId){
        Author found=null;
        for (Author author:authorList){
            if (author.getId()==authorId) found=author;
        }
        if (found==null)throw new NotFoundException(authorId);

        this.authorList.remove(found);
    }
}
