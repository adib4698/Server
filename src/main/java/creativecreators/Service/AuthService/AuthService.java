package creativecreators.Service.AuthService;

import creativecreators.dto.AuthenticationResponse;

public interface AuthService {
    AuthenticationResponse login(String username, String password);
}
