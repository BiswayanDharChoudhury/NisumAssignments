package com.example.user.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    EmailSender emailSender;

    @InjectMocks
    UserService userService;

    @Test
    void testProcessUser_fallbackAndException_thenSendEmail() {
        String userId = "1";
        User user = new User(userId, "Alice");

        when(userRepository.findUserById(userId)).thenReturn(null, user);
        UserService spyUserService = Mockito.spy(userService);

        assertThrows(UserNotFoundException.class, () -> {
            spyUserService.processUser(userId);
        });
        verify(spyUserService, times(1)).handleMissingUser(userId);

        spyUserService.processUser(userId);
        ArgumentCaptor<Email> emailCaptor = ArgumentCaptor.forClass(Email.class);
        verify(emailSender, times(1)).send(emailCaptor.capture());
        Email sentEmail = emailCaptor.getValue();
        assertEquals("Welcome", sentEmail.getSubject());
    }
}
