package com.program.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.program.model.Student;
import com.program.reader.StudentReader;

@Component
@Scope(value="step")
public class StudentWriter implements ItemWriter<Student> {
	@Autowired
	StudentReader studentReader;
	
	@Value("#{stepExecutionContext[name]}")
	private String threadName;

	@SuppressWarnings("unchecked")
	@Override
	public void write(List<? extends Student> students) throws Exception {
		for (Student student : students) {
			//System.out.println(threadName+" : "+student);
		}
		//studentReader.setStudents((List<Student>) students);
	}

}
