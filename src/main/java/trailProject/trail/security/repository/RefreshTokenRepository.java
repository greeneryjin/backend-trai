package trailProject.trail.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trailProject.trail.security.entity.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    RefreshToken findByRefreshToken(String refreshToken);
}
