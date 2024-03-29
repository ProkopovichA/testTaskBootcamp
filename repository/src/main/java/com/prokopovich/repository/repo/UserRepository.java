package com.prokopovich.repository.repo;

import com.prokopovich.repository.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAllByOrderByEmail();
    User findByEmail(String email);

    Page<User> findAllByOrderByEmail(Pageable pageable);

}
