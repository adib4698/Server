package creativecreators.Repository.CommentsRepository;

import creativecreators.Entities.Comment;
import creativecreators.Entities.UserCC;
import creativecreators.Repository.PhotosRepository.PhotosJparepository;
import creativecreators.Repository.UserRepository.UserPersistence;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@EnableJpaRepositories(basePackageClasses = CommentsJpaRepository.class)

public class CommentsDaoJpa implements CommentsRepository {
    CommentsJpaRepository commentsJpaRepository;

    public CommentsDaoJpa(CommentsJpaRepository commentsJpaRepository) {
        this.commentsJpaRepository = commentsJpaRepository;
    }

    @Override
    public List<Comment> findAllForTutorial(String idTutorial) {
        return commentsJpaRepository.findAllById(Collections.singleton(idTutorial)).stream().map(this::converCommentPersistenceToComment)
                .collect(Collectors.toList());
    }

    @Override
    public void addComment(Comment comment) {
        commentsJpaRepository.save(this.convertCommentToCommentPersistence(comment));
    }

    public Comment converCommentPersistenceToComment(CommentsPersistence commentPersistence){
        return  commentPersistence == null ? null : Comment
                .builder().idTutorial(commentPersistence.getIdTutorial())
                .userUsername(commentPersistence.getUserUsername())
                .comment(commentPersistence.getComment()).build();
    }
    public CommentsPersistence convertCommentToCommentPersistence(Comment comment){
        return comment == null ? null : CommentsPersistence.builder()
                .idTutorial(comment.getIdTutorial())
                .userUsername(comment.getUserUsername())
                .comment(comment.getComment()).build();
    }
}
