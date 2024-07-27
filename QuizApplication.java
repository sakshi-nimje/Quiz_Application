import java.util.List;
import java.util.Scanner;

public class QuizApplication {
    public static void main(String[] arg)
    {
        String filepath="C:\\Users\\HP\\IdeaProjects\\FirstProgram\\src\\questions.txt";
        List<Question> questions = QuestionLoader.loadQuestions(filepath);

        Scanner sc= new Scanner(System.in);
        int score=0;

        for(Question question : questions)
        {
            System.out.println(question.getQuestionText());
            List<String> options=question.getOptions();
            for (int i=0; i<options.size(); i++)
            {
                System.out.println((i+1) + ":" + options.get(i));
            }
            System.out.println("Your answer (1-" + options.size() + "): ");
            int userAnswer = sc.nextInt() - 1;

            if(question.isCorrectAnswer(userAnswer)){
                score++;
            }
        }
        System.out.println("Your score: " + score + "/" + questions.size());
        sc.close();
    }
}
