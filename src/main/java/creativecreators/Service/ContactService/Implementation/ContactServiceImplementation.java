package creativecreators.Service.ContactService.Implementation;


import creativecreators.Entities.Contact;
import creativecreators.Repository.ContactRepository.ContactDaoJpa;
import creativecreators.Service.ContactService.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@org.springframework.stereotype.Service
@Component
@Primary
public class ContactServiceImplementation implements ContactService {

    @Autowired
    ContactDaoJpa contactDaoJpa;
    @Override
    public void addContact(String firstName, String lastName, String email, String phone, String comments) {
        contactDaoJpa.addContact(new Contact(0,firstName,lastName,email,phone,comments));
    }
}
