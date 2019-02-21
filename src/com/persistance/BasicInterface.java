package com.persistance;

import java.util.List;

public interface BasicInterface<T> {

	public List<T> list(T t);
	public int add(T t);
	public int del(T t);
	public int mod(T t);
}
