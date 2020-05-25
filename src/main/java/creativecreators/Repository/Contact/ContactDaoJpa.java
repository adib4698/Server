package creativecreators.Repository.Contact;

import creativecreators.Entities.Contact;
import creativecreators.Entities.Tutorial;
import creativecreators.Repository.TutorialRepository.ContactPersistence;
import creativecreators.Repository.TutorialRepository.TutorialJparepository;
import creativecreators.Repository.TutorialRepository.TutorialPersistence;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@Component
@EnableJpaRepositories(basePackageClasses = ContactJparepository.class)
public class ContactDaoJpa {
    private ContactJparepository jpaRepository;
    public ContactPersistence convertContactToContactPersistence(Contact contact){
        return contact == null ? null : ContactPersistence.builder()
                .id(contact.getId())
                .firstName(contact.getFirstName())
                .lastName(contact.getLastName())
                .email(contact.getEmail())
                .phone(contact.getPhone())
                .comment(contact.getComment())
                .build();
    }
    public void addContact(Contact contact){
        jpaRepository.save(convertContactToContactPersistence(contact));
    }
}
