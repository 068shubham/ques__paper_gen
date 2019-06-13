package com.fk.interview;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.fk.interview.exception.InvalidQuestionException;

public class QuestionBank {

	SortedMap<Integer, Set<Question>> marksToQuestionsMap = new TreeMap<Integer, Set<Question>>();

	public List<Question> getQuestionsHavingMarksLessThanOrEqualTo(Integer maxMarks) {
		List<Question> res = marksToQuestionsMap.subMap(0, maxMarks).entrySet().stream()
				.flatMap(e -> e.getValue().stream()).collect(Collectors.toList());
		if (res != null && marksToQuestionsMap.get(maxMarks) != null) {
			res.addAll(marksToQuestionsMap.get(maxMarks));
		}
		return res;
	}

	public void addQuestion(Question question) throws InvalidQuestionException {
		synchronized (this) {
			Set<Question> questionwWithsameMarks = marksToQuestionsMap.get(question.getMarks());

			if (questionwWithsameMarks == null) {
				questionwWithsameMarks = new HashSet<Question>();
				marksToQuestionsMap.put(question.getMarks(), questionwWithsameMarks);
			}

			questionwWithsameMarks.add(question);
		}
	}

	public void removeQuestion(Question question) {
		synchronized (this) {
			if (marksToQuestionsMap.get(question.getMarks()) != null) {
				marksToQuestionsMap.get(question.getMarks()).remove(question);
			}
		}
	}

}
