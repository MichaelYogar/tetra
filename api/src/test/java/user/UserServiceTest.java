package user;

import com.michaelyogar.tetra.app.user.User;
import com.michaelyogar.tetra.app.user.UserRepository;
import com.michaelyogar.tetra.app.user.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Test
    void testCreateOrSaveUser() {
        String email = "asdf@gmail.com";
        User user = new User();
        user.setEmailAddress(email);
        userService.createUser(user);
        verify(userRepository, times(1)).save(user);
    }
}
