package com.program.reader;

import java.io.Serializable;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import com.program.model.Student;

@Component
public class StudentReader implements ItemReader<Student>,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Student> students;
	private int count = 0;

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public Student read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		if (count < students.size()) {
			return students.get(count++);
		} else {
			count=0;
			return null;
		}
	}

}
