//CS3560 - Project 1 - IVoteSimulator
//by Kai Xue

import java.util.ArrayList;
import java.util.UUID;

public class VotingService{
	private Question question;
	private String questionType;
	private int[] answerCount;
	private ArrayList<String> availableChoices = new ArrayList<String>();
	private ArrayList<Student> Students = new ArrayList<Student>();

	//used to hold data of question and print results
	public VotingService(Question question, String type){
		this.question = question;
		this.questionType = type;
		this.availableChoices = question.getChoices();
		answerCount = new int[question.getAmountOfChoices()];
	}

	//adding students to question
	public void addStudent(String[] answers){
		if (this.questionType.equals("single") && answers.length <= 1){
			Students.add(new Student(UUID.randomUUID().toString(), answers));
		}
		else if (this.questionType.equals("multiple") && answers.length > 1){
			Students.add(new Student(UUID.randomUUID().toString(), answers));
		}
	}

	//counting amount of students that voted for answer
	private int[] countAnswers(){
		for(int i = 0; i < this.Students.size(); i++){
			for(int j = 0; j < this.availableChoices.size(); j++){
					for(int k = 0; k < this.Students.get(i).getAnswers().size(); k++){
						if (this.Students.get(i).getAnswers().get(k).equals(this.availableChoices.get(j))){
							this.answerCount[j]++;
						}
					}
			}
		}
		return answerCount;
	}

	//print results of the question
	public void printResult(){
		System.out.println("\nResults for " + question.getQuestion() + ":");
		System.out.println("Number of Participants: " + Students.size());
		System.out.println("Choices: Number of Students selected");
		this.countAnswers();

		for(int i = 0; i < this.availableChoices.size(); i ++){
			System.out.print(this.availableChoices.get(i) + ": ");
			System.out.println(this.answerCount[i]);
		}
	}
}