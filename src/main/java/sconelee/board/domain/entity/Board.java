package sconelee.board.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
/*Entity나 DTO사용시 자주 사용
*   PROTECTED: 무분별한 객체 생성에 대해 한번 더 체크 가능*  */
@EntityListeners(AuditingEntityListener.class)
public class Board {
    //#, 글쓴이, 제목, 내용, 작성일
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private String author;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime crateDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Builder //객체 생성엔 빌더 패턴주로
    public Board(Long id, String author, String title, String content) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
    }
}
