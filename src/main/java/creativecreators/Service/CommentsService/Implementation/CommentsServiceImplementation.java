package creativecreators.Service.CommentsService.Implementation;

import creativecreators.Entities.Comment;
import creativecreators.Repository.CommentsRepository.CommentsDaoJpa;
import creativecreators.Repository.CommentsRepository.CommentsJpaRepository;
import creativecreators.Service.CommentsService.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;


@org.springframework.stereotype.Service
@Component
@Primary
public class CommentsServiceImplementation implements CommentsService {
    @Autowired
    CommentsDaoJpa commentsDaoJpa;

    @Override
    public List<Comment> findCommentsFromTutorial(String idTutorial) {
        return commentsDaoJpa.findAllForTutorial(idTutorial);
    }

    @Override
    public void addComment(String idTutorial, String userUsername, String comment) {
        commentsDaoJpa.addComment(new Comment(idTutorial,userUsername,comment));
    }
}
