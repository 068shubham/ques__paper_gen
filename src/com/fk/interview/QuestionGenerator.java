package com.fk.interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.fk.interview.enums.AttributeType;
import com.fk.interview.exception.InvalidQuestionException;

public class QuestionGenerator {

	private QuestionBank QUESTION_BANK = new QuestionBank();

	/**
	 * 
	 * @param template
	 * @return
	 * @throws Exception
	 */
	public Set<Question> generateQuestion(List<Template> templates) throws Exception {

		if (templates.size() == 0) {
			throw new Exception("Invalid template.");
		}

		Map<AttributeType, Template> attrTypeToTemplates = new HashMap<AttributeType, Template>();

		for (Template templ : templates) {
			attrTypeToTemplates.put(templ.getAttributeType(), templ);
		}

		Set<Question> currentQuestions = new HashSet<Question>();

		boolean isPossible = getQuestions(attrTypeToTemplates, currentQuestions);

		if (isPossible) {
			return currentQuestions;
		} else {
			throw new Exception("Not enough questions for this template.");
		}
	}

	private boolean isTemplateSatisfied(Map<AttributeType, Template> attrTypeToTemplates) {
		if (attrTypeToTemplates == null) {
			return true;
		}

		for (Entry<AttributeType, Template> templateEntry : attrTypeToTemplates.entrySet()) {
			Map<String, Integer> attributeToMarksMap = templateEntry.getValue().getAttributeToMarksMap();

			for (Entry<String, Integer> attrToMarksEntry : attributeToMarksMap.entrySet()) {
				if (attrToMarksEntry.getValue() != 0) {
					return false;
				}
			}

		}
		return true;

	}

	public boolean getQuestions(Map<AttributeType, Template> attrTypeToTemplates, Set<Question> currentQuestions) {

		if (attrTypeToTemplates == null || attrTypeToTemplates.size() == 0 || isTemplateSatisfied(attrTypeToTemplates)) {
			return true;
		}

		for (Entry<AttributeType, Template> template : attrTypeToTemplates.entrySet()) {

			Map<String, Integer> attributeToMarksMap = template.getValue().getAttributeToMarksMap();

			for (Entry<String, Integer> attrs : attributeToMarksMap.entrySet()) {

				Integer marksRequiredForAttr = attrs.getValue();

				List<Question> allValidQuestions = QUESTION_BANK.getQuestionsHavingMarksLessThanOrEqualTo(marksRequiredForAttr);
				
				if(allValidQuestions == null) {
					continue;
				}
				
				for (Question curQues : allValidQuestions) {
					if(currentQuestions.contains(curQues)) {
						continue;
					}
					boolean isQuestionValid = true;
					for(Entry<AttributeType, String> attrTypeToAttr: curQues.getAttrTypeToAttributeMap().entrySet()) {
						Template curTemp = attrTypeToTemplates.get(attrTypeToAttr.getKey());
						Integer curMarks = curTemp.getAttributeToMarksMap().get(attrTypeToAttr.getValue());
						if(curMarks - curQues.getMarks() >= 0) {
							curTemp.getAttributeToMarksMap().put(attrTypeToAttr.getValue(), curMarks - curQues.getMarks());
						}
						else {
							isQuestionValid = false;
							continue;
						}
					}
					if(!isQuestionValid) {
						continue;
					}
					currentQuestions.add(curQues);
					if (getQuestions(attrTypeToTemplates, currentQuestions)) {
						return true;
					}
					currentQuestions.remove(curQues);
					for(Entry<AttributeType, String> attrTypeToAttr: curQues.getAttrTypeToAttributeMap().entrySet()) {
						Template curTemp = attrTypeToTemplates.get(attrTypeToAttr.getKey());
						Integer curMarks = curTemp.getAttributeToMarksMap().get(attrTypeToAttr.getValue());
						curTemp.getAttributeToMarksMap().put(attrTypeToAttr.getValue(), curMarks + curQues.getMarks());
					}
				}

			}

		}

		return false;

	}

	public void addQuestionToQuestionBank(Question question) throws InvalidQuestionException {
		QUESTION_BANK.addQuestion(question);
	}

	public void deleteQuestionFromQuestionBank(Question question) {
		QUESTION_BANK.removeQuestion(question);
	}

	public void updateQuestionInQuestionBank(Question oldQuestion, Question newQuestion) throws InvalidQuestionException {
		deleteQuestionFromQuestionBank(oldQuestion);
		addQuestionToQuestionBank(newQuestion);
	}

}
