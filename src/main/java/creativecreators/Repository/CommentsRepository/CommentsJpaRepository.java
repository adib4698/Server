package creativecreators.Repository.CommentsRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsJpaRepository extends JpaRepository<CommentsPersistence, String> {
}
