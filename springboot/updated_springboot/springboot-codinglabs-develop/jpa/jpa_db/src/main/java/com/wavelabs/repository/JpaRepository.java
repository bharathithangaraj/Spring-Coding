package com.wavelabs.repository;

public interface JpaRepository<T> {
	public void store(T t);

	public T get();

	public T update(String name);

	public T deleteById(int id);
}
