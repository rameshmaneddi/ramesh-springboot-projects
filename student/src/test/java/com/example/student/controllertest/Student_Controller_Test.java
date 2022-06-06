package com.example.student.controllertest;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.student.controller.Student_Controller;
import com.example.student.fields.Student_Fileds;
import com.example.student.service.Student_Service;

@SpringBootTest
public class Student_Controller_Test {

	@InjectMocks
	Student_Controller student_Controller;

	@Mock
	Student_Service student_Service;

	@Mock
	Student_Fileds student_Fileds;

	@Test
	void insert() {
		Mockito.when(student_Service.insert(student_Fileds)).thenReturn(1);
		String response = student_Controller.insertc(student_Fileds);
		System.out.println(response);
		assertEquals("inserted", response);
	}

	@Test
	void get() {
		List<Map<String, Object>> list1 = null;
		Mockito.when(student_Service.getfileds()).thenReturn(list1);
		list1 = student_Controller.get();
		assertEquals(list1, list1);
	}

}
