package com.victorlicht.timetable_tlsi.accounts.repositories;

import com.victorlicht.timetable_tlsi.accounts.models.*;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class AccountUserSpecifications {

    public static Specification<AccountUser> filterAndOrder(
            String phoneNumber,
            String firstName,
            String lastName,
            String email,
            String username,
            Date dateOfBirth,
            Gender gender,
            Wilaya wilaya,
            AccountType accountType,
            String orderByField,
            String sortOrder
    ) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (phoneNumber != null) {
                predicates.add(criteriaBuilder.equal(root.get("phoneNumber"), phoneNumber));
            }
            if (firstName != null) {
                predicates.add(criteriaBuilder.equal(root.get("fullName"), firstName));
            }
            if (lastName != null) {
                predicates.add(criteriaBuilder.equal(root.get("lastName"), lastName));
            }
            if (email != null) {
                predicates.add(criteriaBuilder.equal(root.get("email"), email));
            }
            if (username != null) {
                predicates.add(criteriaBuilder.equal(root.get("username"), username));
            }
            if (dateOfBirth != null) {
                predicates.add(criteriaBuilder.equal(root.get("dateOfBirth"), dateOfBirth));
            }
            if (gender != null) {
                predicates.add(criteriaBuilder.equal(root.get("gender"), gender));
            }
            if (wilaya != null) {
                predicates.add(criteriaBuilder.equal(root.get("wilaya"), wilaya));
            }
            if (accountType != null) {
                predicates.add(criteriaBuilder.equal(root.get("accountType"), accountType));
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

