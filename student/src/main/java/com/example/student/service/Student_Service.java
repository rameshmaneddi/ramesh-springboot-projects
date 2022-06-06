package com.example.student.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import com.example.student.fields.Student_Fileds;

@Service
public class Student_Service {
	
@Autowired
JdbcTemplate jdbc;

@Autowired
NamedParameterJdbcTemplate njdbc;
public int insert(Student_Fileds sf)   //insert one row
{
	int id=sf.getId();
	String name=sf.getName();
	String email=sf.getEmail();
	return jdbc.update("insert into student1 values(?,?,?)",id,name,email);
}

public List getfileds()            //fetch data
{
	List<Map<String,Object>> getdata=new ArrayList<Map<String,Object>>();
	getdata=jdbc.queryForList("select * from student1");
	return getdata;
}
public List getfiled(Student_Fileds sf)    //fetch one row
{
	int id=sf.getId();
	List<Map<String,Object>> getdata=new ArrayList<Map<String,Object>>();
	getdata=jdbc.queryForList("select * from student1 where id=?",id);
	return getdata;
}
public int[] insertall(List<Student_Fileds> sf)   //insert multiple rows row
{
	List<Object[]> listff = new ArrayList<Object[]>();
	
	for(Student_Fileds sff:sf) {
		Object[] obj =  {sff.getId(),sff.getName(),sff.getEmail()};
		listff.add(obj);
	}
	String s=( "insert into student1 values(?,?,?)");
	return jdbc.batchUpdate(s,listff);
}

public String createe(String[] str,String tablename)
{
	String str1="",str2;
	for(int i=0;i<str.length;i++)
	{
		if(i==0)
		{
			 str1=str1+""+str[i];
		}
		else {
		 str1=str1+", "+str[i];
		}
		//String str1=str1.concat(str[i]);
	}
	str2="create table "+tablename+"("+str1+")";
	
	jdbc.execute(str2);
	return "new table created";
}
public int update_serviece(Student_Fileds sf)
{
	String name=sf.getName();
	int id=sf.getId();
	return jdbc.update("update student1 set name=? where id=?",name,id);
}


public int insertnamed(Student_Fileds sf)      //namedparameter jdbc tempate
{
	SqlParameterSource sqlparam=new MapSqlParameterSource() 
	.addValue("id", sf.getId())
	.addValue("name", sf.getName())
	.addValue("email", sf.getEmail());
	return njdbc.update("insert into student1 values(:id,:name,:email)", sqlparam);
	
}
}
