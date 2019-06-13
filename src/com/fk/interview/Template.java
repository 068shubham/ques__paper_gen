package com.fk.interview;

import java.util.Map;

import com.fk.interview.enums.AttributeType;

public class Template {
	
	private Integer totalMarks;
	
	private AttributeType attributeType;
	
	private Map<String, Integer> attributeToMarksMap;

	public Template(Integer totalMarks, AttributeType attributeType, Map<String, Integer> attributeToMarksMap) {
		super();
		this.totalMarks = totalMarks;
		this.attributeType = attributeType;
		this.attributeToMarksMap = attributeToMarksMap;
	}

	public Integer getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(Integer totalMarks) {
		this.totalMarks = totalMarks;
	}

	public AttributeType getAttributeType() {
		return attributeType;
	}

	public void setAttributeType(AttributeType attributeType) {
		this.attributeType = attributeType;
	}

	public Map<String, Integer> getAttributeToMarksMap() {
		return attributeToMarksMap;
	}

	public void setAttributeToMarksMap(Map<String, Integer> attributeToMarksMap) {
		this.attributeToMarksMap = attributeToMarksMap;
	}

	@Override
	public String toString() {
		return "Template [totalMarks=" + totalMarks + ", attributeType=" + attributeType + ", attributeToMarksMap="
				+ attributeToMarksMap + "]";
	}
	
	
}
