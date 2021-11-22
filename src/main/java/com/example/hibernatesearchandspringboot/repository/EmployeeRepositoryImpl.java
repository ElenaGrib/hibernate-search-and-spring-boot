package com.example.hibernatesearchandspringboot.repository;

import com.example.hibernatesearchandspringboot.model.Employee;
import lombok.RequiredArgsConstructor;
import org.hibernate.search.jpa.FullTextEntityManager;

import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.BooleanJunction;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepositoryExt {
    private final EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Employee> search(final String keywords) {

        final FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);

        // Search query builder
        final QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder()
                .forEntity(Employee.class).get();

        // Use a boolean junction and then add queries to it
        final BooleanJunction<BooleanJunction> outer = queryBuilder.bool();
        outer.must(queryBuilder.keyword().onFields("firstName", "lastName").matching(keywords).createQuery());

        @SuppressWarnings("unchecked")
        List<Employee> resultList = fullTextEntityManager.createFullTextQuery(outer.createQuery(), Employee.class)
                .getResultList();
        return resultList;
    }
}
