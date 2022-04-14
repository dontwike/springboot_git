package com.springdatajpa.Controller;

import com.springdatajpa.Entity.Course;
import com.springdatajpa.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/saveCourse")
    public Course saveCourse(@RequestBody Course course){
        return courseService.saveCourse(course);
    }

    @GetMapping("/printCourse")
    public List<Course> printCourse(){
        return courseService.saveCourse();
    }

    @GetMapping("/findAllPagination")
    public long[] findAllPagination(){
        return courseService.findAllPagination();
    }

    @GetMapping("/findAllSorting")
    public List<Course> findAllSorting() {
        return courseService.findAllSorting();
    }

    @GetMapping("/printFindByTitleContaining/{str}")
    public List<Course> printFindByTitleContaining(@PathVariable String str) {
        return courseService.printFindByTitleContaining(str);
    }
}
