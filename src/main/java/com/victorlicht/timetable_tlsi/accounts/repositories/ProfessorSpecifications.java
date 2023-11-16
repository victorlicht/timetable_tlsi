package com.victorlicht.timetable_tlsi.accounts.repositories;

import com.victorlicht.timetable_tlsi.accounts.models.AccountUser;
import com.victorlicht.timetable_tlsi.accounts.models.Grade;
import com.victorlicht.timetable_tlsi.accounts.models.Professor;
import com.victorlicht.timetable_tlsi.courses.model.Course;
import com.victorlicht.timetable_tlsi.groups.model.StudentGroup;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProfessorSpecifications {
    
    
    public static Specification<Professor> filterAndOrder(
            AccountUser accountUser,
            Set<Course> courses,
            Set<StudentGroup> studentGroups,
            Grade grade,
            boolean isAdmin,
            int yearOfTeaching,
            String orderByField,
            String sortOrder
    ) {
        {
            return (root, query, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();
                if (accountUser != null) {
                    predicates.add(criteriaBuilder.equal(root.get("accountUser"), accountUser));
                }
                if (courses != null) {
                    predicates.add(criteriaBuilder.equal(root.get("courses"), courses));
                }
                if (studentGroups != null) {
                    predicates.add(criteriaBuilder.equal(root.get("studentGroups"), studentGroups));
                }
                if (grade != null) {
                    predicates.add(criteriaBuilder.equal(root.get("grade"), grade));
                }
                if (isAdmin) {
                    predicates.add(criteriaBuilder.equal(root.get("isAdmin"), isAdmin));
                }
                if (yearOfTeaching > 0) {
                    predicates.add(criteriaBuilder.equal(root.get("yearOfTeaching"), yearOfTeaching));
                }

                if (orderByField != null) {
                    if ("ASC".equalsIgnoreCase(sortOrder)) {
                        query.orderBy(criteriaBuilder.asc(root.get(orderByField)));
                    } else if ("DESC".equalsIgnoreCase(sortOrder)) {
                        query.orderBy(criteriaBuilder.desc(root.get(orderByField)));
                    }
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };
        }
    }

}
