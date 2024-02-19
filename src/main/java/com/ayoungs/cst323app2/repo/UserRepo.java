package com.ayoungs.cst323app2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ayoungs.cst323app2.models.User;


public interface UserRepo extends JpaRepository<User, Long>
{

}
