import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class QuestionLoader {
    public static List<Question> loadQuestions(String filepath)
    {
        List<Question> questions= new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filepath)))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                String[] parts=line.split(";");
                String questionText= parts[0];
                List<String> options = Arrays.asList(parts[1].split(","));
                int correctAnswerIndex = Integer.parseInt(parts[2]);
                questions.add(new Question(questionText, options, correctAnswerIndex));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return questions;
    }
}
