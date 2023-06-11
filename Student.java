//CS3560 - Project 1 - IVoteSimulator
//by Kai Xue

import java.util.ArrayList;

//Student class contains setID, setAnswers, getAnswers, getID.
public class Student{
	private ArrayList<String> studentAnswer = new ArrayList<String>();
	private String studentID;

	public Student(String studentID, String[] choices){
		this.setID(studentID);
		for(int i=0; i < choices.length; i++){
			setAnswers(choices[i]);
		}
	}

	//Setting ID for student 
	public void setID(String studentID){
		this.studentID = studentID;
	}

	//Setting answer for student 
	public void setAnswers(String studentAnswer){
		this.studentAnswer.add(studentAnswer);
	}

	//Getting answer of a student
	public ArrayList<String> getAnswers(){
		return this.studentAnswer;
	}

	//Getting ID of a student
	public String getID(){
		return this.studentID;
	}

	//Printing the students ID and answer (not used in sim added for funcationality)
	public void printStudent(){
		System.out.println("This Students ID: " + this.getID());
		System.out.println("This Students Answer: " + this.getAnswers());
	}
}