package creativecreators.Repository.Contact;

import creativecreators.Repository.TutorialRepository.ContactPersistence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactJparepository extends JpaRepository<ContactPersistence, String> {
}
