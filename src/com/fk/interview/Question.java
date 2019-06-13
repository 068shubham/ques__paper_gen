package com.fk.interview;

import java.util.HashMap;
import java.util.Map;

import com.fk.interview.enums.AttributeType;

public class Question {
	
	private String statement;
	
	private Integer marks;
	
	private Map<AttributeType, String> attrTypeToAttributeMap = new HashMap<AttributeType, String>();

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public Map<AttributeType, String> getAttrTypeToAttributeMap() {
		return attrTypeToAttributeMap;
	}

	public void setAttrTypeToAttributeMap(Map<AttributeType, String> attrTypeToAttributeMap) {
		this.attrTypeToAttributeMap = attrTypeToAttributeMap;
	}

	public Question(String statement, Integer marks, Map<AttributeType, String> attrTypeToAttributeMap) {
		super();
		this.statement = statement;
		this.marks = marks;
		this.attrTypeToAttributeMap = attrTypeToAttributeMap;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attrTypeToAttributeMap == null) ? 0 : attrTypeToAttributeMap.hashCode());
		result = prime * result + ((marks == null) ? 0 : marks.hashCode());
		result = prime * result + ((statement == null) ? 0 : statement.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (attrTypeToAttributeMap == null) {
			if (other.attrTypeToAttributeMap != null)
				return false;
		} else if (!attrTypeToAttributeMap.equals(other.attrTypeToAttributeMap))
			return false;
		if (marks == null) {
			if (other.marks != null)
				return false;
		} else if (!marks.equals(other.marks))
			return false;
		if (statement == null) {
			if (other.statement != null)
				return false;
		} else if (!statement.equals(other.statement))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Question - " + "marks: " + marks + " " + attrTypeToAttributeMap;
	}
	
	
}
