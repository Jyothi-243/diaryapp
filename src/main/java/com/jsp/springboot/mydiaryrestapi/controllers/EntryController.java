package com.jsp.springboot.mydiaryrestapi.controllers;

import com.jsp.springboot.mydiaryrestapi.entities.Entry;
import com.jsp.springboot.mydiaryrestapi.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
//@RequestMapping("/entries")
public class EntryController {
    @Autowired
    private EntryService entryService;

    @GetMapping("/entries/")
    public List<Entry> findAllEntries(){

    List<Entry> entriesList =entryService.findAll();

    return entriesList;
    }
    @PostMapping("/entries/")
    public Entry saveEntry(@RequestBody Entry entry){

    Entry savedEntry=entryService.saveEntry(entry);

    return savedEntry;
    }
    @PutMapping("/entries/")
    public Entry UpdateEntry(@RequestBody Entry entry){

       Entry updatedEntry= entryService.updateEntry(entry);

        return updatedEntry;
    }

    @GetMapping("/entries/{id}")
    public Entry getEntryById(@PathVariable("id") int id){

        Entry entry=entryService.findById(id);

        return entry;
    }
    @DeleteMapping("/entries/{id}")
    public void deleteEntryById(@PathVariable("id") int id){

        Entry entry=entryService.findById(id);
        entryService.deleteEntry(entry);

    }
    @PutMapping("/entries/{id}")
    public Entry updateEntry1(@PathVariable("id")int id, @RequestBody Entry entry){
        Entry entry1 = entryService.findById(id);// from db
        entry1.setDescription(entry.getDescription());
        entry1.setEntrydate(entry.getEntrydate());
        entry1.setUserid(entry.getUserid());
        Entry updatedEntry=entryService.updateEntry(entry);
        return updatedEntry;


    }

    @PatchMapping("/entries/{id}")
    public Entry PatchEntry(@PathVariable("id")int id, @RequestBody Entry entry){
        Entry entry1 = entryService.findById(id);  //from db
        String desc=entry.getDescription();
        Date dt=entry.getEntrydate();
        long userid=entry.getUserid();

        if(desc!=null && desc.length()>0){
            entry1.setDescription(desc);
        }
        if(dt!=null){
            entry1.setEntrydate(dt);
        }

        if(userid>0){
            entry1.setUserid(userid);
        }
        Entry updatedEntry=entryService.updateEntry(entry1);
        return updatedEntry;


    }


}
