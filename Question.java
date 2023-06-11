//CS3560 - Project 1 - IVoteSimulator
//by Kai Xue

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Question{
	private ArrayList<String> availableChoices = new ArrayList<String>();
	private List<String> correctChoices = new ArrayList<String>();
	private String questionSTR;

	// creating question object
	public Question(String question, String[] answer, String[] choices){
		setQuestion(question);
		setCorrectChoices(answer);
		setChoices(choices);
	}

	//setting question
	public void setQuestion(String question){
		this.questionSTR = question;
	}

	//setting avaiable choices to choose from
	public void setChoices(String[] choice){
		availableChoices.removeAll(availableChoices);
		Collections.addAll(this.availableChoices, choice);
	}

	//setting correct choices/answers
	public void setCorrectChoices(String[] answer){
		correctChoices.removeAll(correctChoices);
		Collections.addAll(this.correctChoices, answer);
	}

	//getting the question
	public String getQuestion(){
		return this.questionSTR;
	}

	//getting avaiable choices
	public ArrayList<String> getChoices(){
		return this.availableChoices;
	}

	//getting the correct choices/answers
	public String[] getCorrectChoices(){
		return this.correctChoices.toArray(new String[0]);
	}

	//getting amount of choices to choose from
	public int getAmountOfChoices(){
		return this.availableChoices.size();
	}

	//getting amount of correct answers
	public int getAmountOfAnswers(){
		return this.correctChoices.size();
	}

	// printing question and choices available 
	public void printQuestion(){
		int count = 1;
		System.out.println("Question: " + this.getQuestion());
		System.out.println(this.getAmountOfAnswers() + " Correct Answers, " +this.getAmountOfChoices() + " Choices Avaliable: ");
		for(int i = 0; i < this.getAmountOfChoices(); i ++){
			System.out.println(count + ") " + this.getChoices().get(i));
			count++;
		}
	}
	}