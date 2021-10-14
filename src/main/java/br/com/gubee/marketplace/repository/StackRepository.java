package br.com.gubee.marketplace.repository;

import br.com.gubee.marketplace.entity.Stack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StackRepository extends JpaRepository<Stack, Long> {
}
