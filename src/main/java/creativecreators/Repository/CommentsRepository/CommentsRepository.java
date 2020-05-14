package creativecreators.Repository.CommentsRepository;

import creativecreators.Entities.Comment;

import java.util.List;

public interface CommentsRepository {
    public List<Comment> findAllForTutorial(String idTutorial);
    public void addComment(Comment comment);
}
