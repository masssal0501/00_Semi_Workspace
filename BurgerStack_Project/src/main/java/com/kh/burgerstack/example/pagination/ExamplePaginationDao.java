package com.kh.burgerstack.example.pagination;

import org.springframework.stereotype.Repository;

@Repository
public class ExamplePaginationDao {
	public int getTotalCount() {
		return 123; // sqlSession.selectOne("count", condition);
	}
}
