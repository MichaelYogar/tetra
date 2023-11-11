package question;

import com.michaelyogar.tetra.app.question.Question;
import com.michaelyogar.tetra.app.question.QuestionRepository;
import com.michaelyogar.tetra.app.question.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class QuestionServiceTest {
    @InjectMocks
    QuestionService questionService;

    @Mock
    QuestionRepository questionRepository;

    @Test
    void testCreateOrSaveQuestion() {
        Question question = new Question();
        questionService.save(question);
        verify(questionRepository, times(1)).save(question);
    }
}
