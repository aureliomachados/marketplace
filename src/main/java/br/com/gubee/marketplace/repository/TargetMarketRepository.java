package br.com.gubee.marketplace.repository;

import br.com.gubee.marketplace.entity.TargetMarket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TargetMarketRepository extends JpaRepository<TargetMarket, Long> {
}
