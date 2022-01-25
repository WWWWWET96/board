package sconelee.board.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sconelee.board.domain.entity.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}
