package com.springdatajpa.Services;

import com.springdatajpa.Entity.Course;
import com.springdatajpa.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course saveCourse(Course course){
        return courseRepository.save(course);
    }

    public List<Course> saveCourse(){
        return courseRepository.findAll();
    }

    public long[] findAllPagination(){
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords =
                PageRequest.of(1,2);

        List<Course> courses =
                courseRepository.findAll(secondPageWithTwoRecords)
                        .getContent();

        long totalElements =
                courseRepository.findAll(secondPageWithTwoRecords)
                        .getTotalElements();

        long totalPages =
                courseRepository.findAll(secondPageWithTwoRecords)
                        .getTotalPages();

        long a[] = new long[10];
        a[0]=totalPages;
        a[1]=totalElements;
        System.out.println("courses = " + courses);
        return a;
    }

    public List<Course> findAllSorting() {
        Pageable sortByTitle =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                );
        Pageable sortByCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("credit").descending()
                );

        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                                .descending()
                                .and(Sort.by("credit"))
                );

        List<Course> courses
                = courseRepository.findAll(sortByTitle).getContent();

        return courses;
    }

    public List<Course> printFindByTitleContaining(String str) {
        Pageable firstPageTenRecords =
                PageRequest.of(0,10);

        List<Course> courses =
                courseRepository.findByTitleContaining(
                        str,
                        firstPageTenRecords).getContent();

        return courses;
    }


}
