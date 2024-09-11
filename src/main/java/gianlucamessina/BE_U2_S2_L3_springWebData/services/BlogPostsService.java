package gianlucamessina.BE_U2_S2_L3_springWebData.services;

import gianlucamessina.BE_U2_S2_L3_springWebData.entities.BlogPost;
import gianlucamessina.BE_U2_S2_L3_springWebData.exceptions.NotFoundException;
import gianlucamessina.BE_U2_S2_L3_springWebData.payloads.BlogPostPayload;
import gianlucamessina.BE_U2_S2_L3_springWebData.repositories.BlogPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BlogPostsService {
    @Autowired
    private BlogPostsRepository blogPostsRepository;



    public List<BlogPost>findAll(){
        return this.blogPostsRepository.findAll();
    }

    public BlogPost findById(UUID blogPostId){
        return this.blogPostsRepository.findById(blogPostId).orElseThrow(()->new NotFoundException(blogPostId));

    }

    public BlogPost saveBlogPost(BlogPost body){

        return blogPostsRepository.save(body);
    }

    public BlogPost findByIdAndUpdate(UUID blogPostId, BlogPostPayload updatedBlogPost){
        BlogPost found=this.findById(blogPostId);

        
        found.setCategoria(updatedBlogPost.getCategoria());
        found.setTitolo(updatedBlogPost.getTitolo());
        found.setCover(updatedBlogPost.getCover());
        found.setContenuto(updatedBlogPost.getContenuto());
        found.setTempoLettura(updatedBlogPost.getTempoLettura());

        return this.blogPostsRepository.save(found);
    }

    public void findByIdAndDelete(UUID blogPostId){
        BlogPost found=this.findById(blogPostId);
        this.blogPostsRepository.delete(found);
    }
}
