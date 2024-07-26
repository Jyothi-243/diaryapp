package com.jsp.springboot.mydiaryrestapi.repository;

import com.jsp.springboot.mydiaryrestapi.entities.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntryRepository extends JpaRepository<Entry,Long> {

    public List<Entry> findByUserid(long id);

}
