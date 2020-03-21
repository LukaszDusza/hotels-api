package akadamia.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

  @Query("select r from Role r where r.roleId = ?1")
  Role findRoleById(long roleId);

  @Query("select r from Role r where r.role = ?1")
  Role findRoleByName(String role);
}
