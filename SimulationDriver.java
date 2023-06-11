//CS3560 - Project 1 - IVoteSimulator
//by Kai Xue

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Simulation driver to test functionality of objects and integration of objects
//4 questions with 2 single choice and 2 multiple choice
//randomly generates 5-30 students and gives them random answers 

public class SimulationDriver{
	public static void main(String[] args){
		System.out.println("Results of Single Choice Questions: \n");

		//making single answer question 1
		String q1_question = "What is the sum of 18 and 23?";
		String[] q1_answer = {"41"};
		String[] q1_choices = {"41", "51", "45", "311"};
		Question q1 = new Question(q1_question, q1_answer, q1_choices);
		VotingService q1_test = new VotingService(q1, "single");

		simStudentAnswers(q1_test, q1_choices);
		q1.printQuestion();
		q1_test.printResult();
		System.out.println("");

		//making single answer question 2 with fucntions
		Question q2 = new Question("", new String[]{""}, new String[]{""});
		q2.setQuestion("What is the product of 4 and 4?");
		q2.setCorrectChoices(new String[] {"16"});
		q2.setChoices(new String[] {"8", "17", "14", "16"});
		VotingService q2_test = new VotingService(q2, "single");

		simStudentAnswers(q2_test, new String[] {"8", "17", "14", "16"});
		q2.printQuestion();
		q2_test.printResult();

		System.out.println("\n--------------------------------------------");

		System.out.println("\nResults of Multiple Choice Questions: \n");
		//making multiple answer question 1
		String q3_question = "Select all the set of numbers that's product is 10";
		String[] q3_correctAnswer = {"5 and 2", "1 and 10"};
		String[] q3_choices = {"8 and 3", "5 and 2", "1 and 10", "4 and 2", "7 and 3"};
		Question q3 = new Question(q3_question, q3_correctAnswer, q3_choices);
		VotingService q3_test = new VotingService(q3, "multiple");

		simStudentAnswers(q3_test, q3_choices);
		q3.printQuestion();
		q3_test.printResult();
		System.out.println("");


		//making multiple answer question 2 with fucntions
		Question q4 = new Question("", new String[] {""}, new String[] {""});
		q4.setQuestion("Select all the set of numbers that's sum is 10");
		q4.setCorrectChoices(new String[] {"4 and 6", "5 and 5", "7 and 3"});
		q4.setChoices(new String[] {"4 and 6", "5 and 2", "5 and 5", "4 and 2", "7 and 3"});
		VotingService q4_test = new VotingService(q4, "multiple");

		simStudentAnswers(q4_test, new String[] {"4 and 6", "5 and 5", "7 and 3"});
		q4.printQuestion();
		q4_test.printResult();
}
	// generates random amount of answers then answers 
	// input choices
	// output randomly generated choices
	private static void simStudentAnswers(VotingService test, String[] choices){
		Random rand = new Random();
		int min = 0, max = 100;
		int randomNum = rand.nextInt(max + 1 - min) + min;                         //student generation 
		for(int i = 0; i < randomNum; i++){
			List<String> selectedChoices = new ArrayList<String>();
			int min2 = 1, max2 = choices.length;                                  // amount of choices generation
			int randomNum2 = rand.nextInt(max2 + 1 - min2) + min2;
			
			for (int j = 0; j < randomNum2; j++){
				int randomNum3 = rand.nextInt(max2 + 1 - min2) + min2;           // choices generation 
				if (!selectedChoices.contains(choices[randomNum3-1])){
					selectedChoices.add(choices[randomNum3 - 1]);
				}
			}
			
			test.addStudent(selectedChoices.toArray(new String[0]));              //adding student choices to test
		}

	}
}
