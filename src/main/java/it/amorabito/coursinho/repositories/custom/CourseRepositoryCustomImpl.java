package it.amorabito.coursinho.repositories.custom;

import it.amorabito.coursinho.model.dtos.CourseFilter;
import it.amorabito.coursinho.model.entities.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.Collection;

public class CourseRepositoryCustomImpl implements CourseRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Collection<Course> findFiltered(CourseFilter courseFilter) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
        Root<Course> root = criteriaQuery.from(Course.class);

        criteriaQuery.select(root);
        criteriaQuery.where(applyFilter(root, courseFilter));

        TypedQuery<Course> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    private Expression<Boolean> applyFilter(Root<Course> root, CourseFilter courseFilter) {
        // todo filters
        if (courseFilter == null) {
            return null;
        }

        if (courseFilter.getMaximumPrice() != null) {

        }
        return null;
    }
}
