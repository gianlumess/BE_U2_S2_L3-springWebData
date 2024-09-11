package gianlucamessina.BE_U2_S2_L3_springWebData.services;

import gianlucamessina.BE_U2_S2_L3_springWebData.entities.BlogPost;
import gianlucamessina.BE_U2_S2_L3_springWebData.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class BlogPostsService {
    private List<BlogPost> blogPostsList=new ArrayList<>();

    public List<BlogPost>findAll(){
        return this.blogPostsList;
    }

    public BlogPost findById(UUID blogPostId){
        BlogPost found=null;
        for (BlogPost blogPost: this.blogPostsList) {
            if(blogPost.getId()==blogPostId) found=blogPost;
        }
        if(found==null)throw new NotFoundException(blogPostId);
        return found;
    }

    public BlogPost saveBlogPost(BlogPost body){
        Random random=new Random();
        this.blogPostsList.add(body);
        return body;
    }

    public BlogPost findByIdAndUpdate(UUID blogPostId, BlogPost updatedBlogPost){
        BlogPost found=null;
        for (BlogPost blogPost: this.blogPostsList) {
            if(blogPost.getId()==blogPostId) found=blogPost;
        }
        if (found==null)throw new NotFoundException(blogPostId);

        found.setCategoria(updatedBlogPost.getCategoria());
        found.setTitolo(updatedBlogPost.getTitolo());
        found.setCover(updatedBlogPost.getCover());
        found.setContenuto(updatedBlogPost.getContenuto());
        found.setTempoLettura(updatedBlogPost.getTempoLettura());

        return found;
    }

    public void findByIdAndDelete(UUID blogPostId){
        BlogPost found=null;
        for (BlogPost blogPost: this.blogPostsList) {
            if(blogPost.getId()==blogPostId) found=blogPost;
        }
        if (found==null)throw new NotFoundException(blogPostId);

        this.blogPostsList.remove(found);
    }
}
