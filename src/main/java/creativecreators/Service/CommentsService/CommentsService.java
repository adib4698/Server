package creativecreators.Service.CommentsService;

import creativecreators.Entities.Comment;

import java.util.List;

public interface CommentsService {

    public List<Comment> findCommentsFromTutorial(String idTutorial);
    public void addComment(String idTutorial, String userUsername, String comment);

}
