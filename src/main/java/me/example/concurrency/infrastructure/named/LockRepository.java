package me.example.concurrency.infrastructure.named;


import me.example.concurrency.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LockRepository extends JpaRepository<Item, Long> {
    @Query(value = "select get_lock(:key, 10000)", nativeQuery = true)
    void getLock(@Param("key") String key);

    @Query(value = "select release_lock(:key)", nativeQuery = true)
    void releaseLock(@Param("key") String key);
}
