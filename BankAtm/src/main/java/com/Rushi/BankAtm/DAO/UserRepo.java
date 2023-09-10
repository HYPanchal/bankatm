package com.Rushi.BankAtm.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Rushi.BankAtm.Model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>
{

}
