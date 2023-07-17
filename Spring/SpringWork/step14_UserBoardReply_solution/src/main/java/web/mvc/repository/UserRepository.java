package web.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import web.mvc.domain.FreeBoard;
import web.mvc.domain.User;

public interface UserRepository extends JpaRepository<User, String>  {
 
}
