package com.example.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.fields.Student_Fileds;
import com.example.student.service.Student_Service;

@RestController
@RequestMapping
public class Student_Controller {
@Autowired
Student_Service sc;
@PostMapping("/insert")
public String insertc(@RequestBody Student_Fileds sf)
{
	int i=sc.insert(sf);          //inserting  
	if(i>0)
	{
		return "inserted";
	}else return "not inserted";
}
@GetMapping("/get")
public List get()                //fetch the data from database
{
	return sc.getfileds();
}
@GetMapping("/id")
public List get(@RequestBody Student_Fileds sf)   //fetch single row of data by using @requestbody annotation
{
	List ls= sc.getfiled(sf);
	if(ls.isEmpty())
	{
		ls.add("no data(id) found");
		return ls;
	}else return sc.getfiled(sf);
}
@PostMapping("/insertall")
public int[] insert(@RequestBody List<Student_Fileds> sf)
{
	return sc.insertall(sf);
}
@PostMapping("/create/{tablename}")
public String create(@RequestBody String[] str,@PathVariable String tablename)
{
	return sc.createe(str, tablename);
}
@PostMapping("/update")
public String update_controler(@RequestBody Student_Fileds sf)  //update a felid
{
	int i=sc.update_serviece(sf);
	if(i>0)
	{
		return "updated";
	}else return "not updated";
}

@PostMapping("/namedparameter")
public String ninsert(@RequestBody Student_Fileds sf)
{
	int i=sc.insertnamed(sf);
	if(i>0)
	{
		return "inserted";
	}else return "not inserted";
}
}
