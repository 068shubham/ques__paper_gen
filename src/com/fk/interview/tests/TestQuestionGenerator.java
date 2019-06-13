package com.fk.interview.tests;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.fk.interview.Question;
import com.fk.interview.QuestionGenerator;
import com.fk.interview.Template;
import com.fk.interview.enums.AttributeType;

public class TestQuestionGenerator {
	
	public static void main(String args[]) throws Exception {
		Map<AttributeType, String> attrTypeToAttributeMap = new HashMap<AttributeType, String>();
		
		attrTypeToAttributeMap.put(AttributeType.DIFFICULTY, "Easy");
		attrTypeToAttributeMap.put(AttributeType.TOPIC, "OS");
		
		Question q1 = new Question("This is a 10 marks easy OS question.", 10, attrTypeToAttributeMap);
		
		attrTypeToAttributeMap = new HashMap<AttributeType, String>();
		
		attrTypeToAttributeMap.put(AttributeType.DIFFICULTY, "Easy");
		attrTypeToAttributeMap.put(AttributeType.TOPIC, "Algo");
		
		Question q2 = new Question("This is a 10 marks easy Algo question.", 10, attrTypeToAttributeMap);
		
		attrTypeToAttributeMap = new HashMap<AttributeType, String>();
		
		attrTypeToAttributeMap.put(AttributeType.DIFFICULTY, "Easy");
		attrTypeToAttributeMap.put(AttributeType.TOPIC, "OS");
		
		Question q3 = new Question("This is a 20 marks easy OS question.", 20, attrTypeToAttributeMap);
		
		attrTypeToAttributeMap = new HashMap<AttributeType, String>();
		
		attrTypeToAttributeMap.put(AttributeType.DIFFICULTY, "Medium");
		attrTypeToAttributeMap.put(AttributeType.TOPIC, "Algo");
		
		Question q4 = new Question("This is a 30 marks medium Algo question.", 30, attrTypeToAttributeMap);
		
		attrTypeToAttributeMap = new HashMap<AttributeType, String>();
		
		attrTypeToAttributeMap.put(AttributeType.DIFFICULTY, "Hard");
		attrTypeToAttributeMap.put(AttributeType.TOPIC, "OS");
		
		Question q5 = new Question("This is a 10 marks hard OS question.", 10, attrTypeToAttributeMap);
		
		attrTypeToAttributeMap = new HashMap<AttributeType, String>();
		
		attrTypeToAttributeMap.put(AttributeType.DIFFICULTY, "Hard");
		attrTypeToAttributeMap.put(AttributeType.TOPIC, "Algo");
		
		Question q6 = new Question("This is a 20 marks hard Algo question.", 20, attrTypeToAttributeMap);
		
		QuestionGenerator qg = new QuestionGenerator();
		
		qg.addQuestionToQuestionBank(q1);
		
		qg.addQuestionToQuestionBank(q2);
		
		qg.addQuestionToQuestionBank(q3);
		
		qg.addQuestionToQuestionBank(q4);
		
		qg.addQuestionToQuestionBank(q5);
		
		qg.addQuestionToQuestionBank(q6);
		
		Map<String, Integer> attributeToMarksMap = new HashMap<String, Integer>();

		attributeToMarksMap.put("Easy", 40);
		attributeToMarksMap.put("Medium", 30);
		attributeToMarksMap.put("Hard", 30);
		
		Template template1 = new Template(100, AttributeType.DIFFICULTY, attributeToMarksMap);

		attributeToMarksMap = new HashMap<String, Integer>();
		attributeToMarksMap.put("OS", 40);
		attributeToMarksMap.put("Algo", 60);
		
		Template template2 = new Template(100, AttributeType.TOPIC, attributeToMarksMap);
		
		Set<Question> questionPaper = qg.generateQuestion(Arrays.asList(template1, template2));
		
		questionPaper.forEach(q -> System.out.println(q));
		
	}

}
