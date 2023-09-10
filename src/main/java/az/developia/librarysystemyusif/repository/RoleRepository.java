package az.developia.librarysystemyusif.repository;

import az.developia.librarysystemyusif.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long>{
//    @Query("SELECT r FROM Role r WHERE r.role_name = :roleName")
//    Role findByRoleName(@Param("roleName") String roleName);
    Role findByName(String name);
}
