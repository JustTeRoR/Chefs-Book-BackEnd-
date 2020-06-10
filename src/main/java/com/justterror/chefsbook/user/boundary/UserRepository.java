package com.justterror.chefsbook.user.boundary;

import com.justterror.chefsbook.user.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}