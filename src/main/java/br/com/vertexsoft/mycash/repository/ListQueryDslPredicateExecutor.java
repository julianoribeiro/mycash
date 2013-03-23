package br.com.vertexsoft.mycash.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.Predicate;

public interface ListQueryDslPredicateExecutor<T> extends QueryDslPredicateExecutor<T> {

	@Override
	public Iterable<T> findAll(Predicate predicate);
	
	@Override
	public Iterable<T> findAll(Predicate predicate, OrderSpecifier<?>... orders);
	
}