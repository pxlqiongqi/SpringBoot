package com.pxl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pxl.daos.PeopleMapper;
import com.pxl.pojos.People;
@Service
public class PeopleService {
	@Autowired
	private PeopleMapper peopleMapper;
	public int insertPeople(People people) {
		peopleMapper.insert(people);
		return people.getId();
	}
	public People selectPeople(People people) {
		return peopleMapper.selectByPrimaryKey(people.getId());
	}
}
