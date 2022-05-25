package it.amorabito.coursinho.repositories.custom;

import it.amorabito.coursinho.model.dtos.CourseFilter;
import it.amorabito.coursinho.model.entities.Course;
import it.amorabito.coursinho.model.entities.Course_;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CourseRepositoryCustomImpl implements CourseRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Collection<Course> findFiltered(CourseFilter courseFilter) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
        Root<Course> root = criteriaQuery.from(Course.class);

        criteriaQuery.select(root);
        criteriaQuery.where(applyFilter(root, criteriaBuilder, courseFilter));

        TypedQuery<Course> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    private Predicate[] applyFilter(Root<Course> root, CriteriaBuilder criteriaBuilder, CourseFilter courseFilter) {
        if (courseFilter == null) {
            return new Predicate[0];
        }

        List<Predicate> predicates = new ArrayList<>();

        if (courseFilter.getMaximumPrice() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(Course_.price), courseFilter.getMaximumPrice()));
        }
        if (courseFilter.getMinimumPrice() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(Course_.price), courseFilter.getMinimumPrice()));
        }
        return predicates.toArray(new Predicate[0]);
    }
}
