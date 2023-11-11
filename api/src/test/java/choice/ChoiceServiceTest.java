package choice;

import com.michaelyogar.tetra.app.choice.Choice;
import com.michaelyogar.tetra.app.choice.ChoiceRepository;
import com.michaelyogar.tetra.app.choice.ChoiceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ChoiceServiceTest {
    @InjectMocks
    ChoiceService choiceService;

    @Mock
    ChoiceRepository choiceRepository;

    @Test
    void testCreateOrSaveChoice() {
        Choice choice = new Choice();
        choiceService.save(choice);
        verify(choiceRepository, times(1)).save(choice);
    }
}
