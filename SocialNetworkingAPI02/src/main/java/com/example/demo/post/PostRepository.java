package com.example.demo.post;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface PostRepository extends CrudRepository<Post,String> {
//search post by date
	@Query("Select p From Post p Where p.postdate=:date")
	public List<Post>getByDate(@Param("date")String date);

	public List<Post> getPostByPostdate(String postdate);

	public Post getReferenceById(String id);
}
