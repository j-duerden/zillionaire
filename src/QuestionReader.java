/*
 * Who Wants to be a Zillionaire? - Question Reader
 * Class for reading and writing to a text file
 * 
 * @author	James Duerden
 * @version	2016-04-07
 */

import java.io.*;
import java.util.ArrayList;

public class QuestionReader 
{
	private QuestionSet gameQuestions = new QuestionSet();
	private static final String GAME_FILE = "src/ZillionaireQuestions.txt";
	
	public QuestionReader(QuestionSet gameQuestions)
	{

	}
	
	public void writeQuestion()
	{
		try {
			FileWriter writer = new FileWriter (GAME_FILE);
			
			for (Question q : this.gameQuestions.getQuestions()){
				writer.write(q.category + "," + q.question + "," + q.answers[0].returnAnswer() + "," + q.answers[1].returnAnswer() + "," + q.answers[2].returnAnswer() + "," + q.answers[3].returnAnswer() + "," + q.difficulty);
				writer.write("\n");
			}
			
			writer.flush();
			writer.close();
		
		}
		
		catch (IOException e) {
            System.err.println ("Failed to write to " + GAME_FILE);
        }
	}
	
	public void writeQuestionBuffered()
	{
		try {
			FileWriter writer = new FileWriter (GAME_FILE);
			BufferedWriter buffWriter = new BufferedWriter (writer);
			
			for (Question q : this.gameQuestions.getQuestions()){
				buffWriter.write(q.category + "," + q.question + "," + q.answers[0].returnAnswer() + "," + q.answers[1].returnAnswer() + "," + q.answers[2].returnAnswer() + "," + q.answers[3].returnAnswer() + "," + q.difficulty);
				buffWriter.write("\n");
			}
			
			buffWriter.flush();
			buffWriter.close();
			writer.close();
		
		}
		
		catch (IOException e) {
            System.err.println ("Failed to write to " + GAME_FILE);
        }
	}
	
	public QuestionSet readAllQuestions()
    {
        try {
            FileReader reader = new FileReader (GAME_FILE);
            BufferedReader buffReader = new BufferedReader (reader);
            
            String input = "";   
            while (input != null) {
                input = buffReader.readLine ();
                if (input != null) {
                    
                	Answer[] answers = new Answer[4];
                    String[] splitQuestion = input.split(",");
                    String category = splitQuestion[0];
                    String question = splitQuestion[1];
                    answers[0] = new Answer(splitQuestion[2], true);
                    answers[1] = new Answer(splitQuestion[3], false);
                    answers[2] = new Answer(splitQuestion[4], false);
                    answers[3] = new Answer(splitQuestion[5], false);
                    String difficulty = splitQuestion[6];
                    boolean answered = false;
                                     
                    Question questionToAdd = new Question(category, question, answers, difficulty, answered);
                    gameQuestions.addQuestion(questionToAdd);
                    
                }
            }
        }
        catch (IOException e) {
            System.err.println ("Failed to read from " + GAME_FILE);
        }
		return gameQuestions;
    }
	
	public QuestionSet readGeneralQuestions()
    {
        try {
            FileReader reader = new FileReader (GAME_FILE);
            BufferedReader buffReader = new BufferedReader (reader);
            
            String input = "";   
            while (input != null) {
                input = buffReader.readLine ();
                if (input != null) {
                    
                	Answer[] answers = new Answer[4];
                    String[] splitQuestion = input.split(",");
                    String category = splitQuestion[0];
                    String question = splitQuestion[1];
                    answers[0] = new Answer(splitQuestion[2], true);
                    answers[1] = new Answer(splitQuestion[3], false);
                    answers[2] = new Answer(splitQuestion[4], false);
                    answers[3] = new Answer(splitQuestion[5], false);
                    String difficulty = splitQuestion[6];
                    boolean answered = false;
                                     
                    if(splitQuestion[0].equals("General Knowledge"))
                    {
                    	Question questionToAdd = new Question(category, question, answers, difficulty, answered);
                    	gameQuestions.addQuestion(questionToAdd);
                    }
                 
                }
            }
        }
        catch (IOException e) {
            System.err.println ("Failed to read from " + GAME_FILE);
        }
		return gameQuestions;
    }
	
	public QuestionSet readHistoryQuestions()
    {
        try {
            FileReader reader = new FileReader (GAME_FILE);
            BufferedReader buffReader = new BufferedReader (reader);
            
            String input = "";   
            while (input != null) {
                input = buffReader.readLine ();
                if (input != null) {
                    
                	Answer[] answers = new Answer[4];
                    String[] splitQuestion = input.split(",");
                    String category = splitQuestion[0];
                    String question = splitQuestion[1];
                    answers[0] = new Answer(splitQuestion[2], true);
                    answers[1] = new Answer(splitQuestion[3], false);
                    answers[2] = new Answer(splitQuestion[4], false);
                    answers[3] = new Answer(splitQuestion[5], false);
                    String difficulty = splitQuestion[6];
                    boolean answered = false;
                                     
                    if(splitQuestion[0].equals("History"))
                    {
                    	Question questionToAdd = new Question(category, question, answers, difficulty, answered);
                    	gameQuestions.addQuestion(questionToAdd);
                    }

                }
            }
        }
        catch (IOException e) {
            System.err.println ("Failed to read from " + GAME_FILE);
        }
		return gameQuestions;
    }
	
	public QuestionSet readGamingQuestions()
    {
        try {
            FileReader reader = new FileReader (GAME_FILE);
            BufferedReader buffReader = new BufferedReader (reader);
            
            String input = "";   
            while (input != null) {
                input = buffReader.readLine ();
                if (input != null) {
                    
                	Answer[] answers = new Answer[4];
                    String[] splitQuestion = input.split(",");
                    String category = splitQuestion[0];
                    String question = splitQuestion[1];
                    answers[0] = new Answer(splitQuestion[2], true);
                    answers[1] = new Answer(splitQuestion[3], false);
                    answers[2] = new Answer(splitQuestion[4], false);
                    answers[3] = new Answer(splitQuestion[5], false);
                    String difficulty = splitQuestion[6];
                    boolean answered = false;
                                     
                    if(splitQuestion[0].equals("Gaming"))
                    {
                    	Question questionToAdd = new Question(category, question, answers, difficulty, answered);
                    	gameQuestions.addQuestion(questionToAdd);
                    }

                }
            }
        }
        catch (IOException e) {
            System.err.println ("Failed to read from " + GAME_FILE);
        }
		return gameQuestions;
    }
	
	public QuestionSet readGenHistQuestions()
    {
        try {
            FileReader reader = new FileReader (GAME_FILE);
            BufferedReader buffReader = new BufferedReader (reader);
            
            String input = "";   
            while (input != null) {
                input = buffReader.readLine ();
                if (input != null) {
                    
                	Answer[] answers = new Answer[4];
                    String[] splitQuestion = input.split(",");
                    String category = splitQuestion[0];
                    String question = splitQuestion[1];
                    answers[0] = new Answer(splitQuestion[2], true);
                    answers[1] = new Answer(splitQuestion[3], false);
                    answers[2] = new Answer(splitQuestion[4], false);
                    answers[3] = new Answer(splitQuestion[5], false);
                    String difficulty = splitQuestion[6];
                    boolean answered = false;
                                     
                    if(!splitQuestion[0].equals("Gaming"))
                    {
                    	Question questionToAdd = new Question(category, question, answers, difficulty, answered);
                    	gameQuestions.addQuestion(questionToAdd);
                    }

                }
            }
        }
        catch (IOException e) {
            System.err.println ("Failed to read from " + GAME_FILE);
        }
		return gameQuestions;
    }
	
	public QuestionSet readGenGameQuestions()
    {
        try {
            FileReader reader = new FileReader (GAME_FILE);
            BufferedReader buffReader = new BufferedReader (reader);
            
            String input = "";   
            while (input != null) {
                input = buffReader.readLine ();
                if (input != null) {
                    
                	Answer[] answers = new Answer[4];
                    String[] splitQuestion = input.split(",");
                    String category = splitQuestion[0];
                    String question = splitQuestion[1];
                    answers[0] = new Answer(splitQuestion[2], true);
                    answers[1] = new Answer(splitQuestion[3], false);
                    answers[2] = new Answer(splitQuestion[4], false);
                    answers[3] = new Answer(splitQuestion[5], false);
                    String difficulty = splitQuestion[6];
                    boolean answered = false;
                                     
                    if(!splitQuestion[0].equals("History"))
                    {
                    	Question questionToAdd = new Question(category, question, answers, difficulty, answered);
                    	gameQuestions.addQuestion(questionToAdd);
                    }

                }
            }
        }
        catch (IOException e) {
            System.err.println ("Failed to read from " + GAME_FILE);
        }
		return gameQuestions;
    }
	
	public QuestionSet readHistGameQuestions()
    {
        try {
            FileReader reader = new FileReader (GAME_FILE);
            BufferedReader buffReader = new BufferedReader (reader);
            
            String input = "";   
            while (input != null) {
                input = buffReader.readLine ();
                if (input != null) {
                    
                	Answer[] answers = new Answer[4];
                    String[] splitQuestion = input.split(",");
                    String category = splitQuestion[0];
                    String question = splitQuestion[1];
                    answers[0] = new Answer(splitQuestion[2], true);
                    answers[1] = new Answer(splitQuestion[3], false);
                    answers[2] = new Answer(splitQuestion[4], false);
                    answers[3] = new Answer(splitQuestion[5], false);
                    String difficulty = splitQuestion[6];
                    boolean answered = false;
                                     
                    if(!splitQuestion[0].equals("General Knowledge"))
                    {
                    	Question questionToAdd = new Question(category, question, answers, difficulty, answered);
                    	gameQuestions.addQuestion(questionToAdd);
                    }

                }
            }
        }
        catch (IOException e) {
            System.err.println ("Failed to read from " + GAME_FILE);
        }
		return gameQuestions;
    }
	
	public QuestionSet readFailsafeQuestions()
    {
        try {
            FileReader reader = new FileReader (GAME_FILE);
            BufferedReader buffReader = new BufferedReader (reader);
            
            String input = "";   
            while (input != null) {
                input = buffReader.readLine ();
                if (input != null) {
                    
                	Answer[] answers = new Answer[4];
                    String[] splitQuestion = input.split(",");
                    String category = splitQuestion[0];
                    String question = splitQuestion[1];
                    answers[0] = new Answer(splitQuestion[2], true);
                    answers[1] = new Answer(splitQuestion[3], false);
                    answers[2] = new Answer(splitQuestion[4], false);
                    answers[3] = new Answer(splitQuestion[5], false);
                    String difficulty = splitQuestion[6];
                    boolean answered = false;
                                     
                    if(splitQuestion[0].equals("Empty"))
                    {
                    	Question questionToAdd = new Question(category, question, answers, difficulty, answered);
                    	gameQuestions.addQuestion(questionToAdd);
                    }

                }
            }
        }
        catch (IOException e) {
            System.err.println ("Failed to read from " + GAME_FILE);
        }
		return gameQuestions;
    }
}
