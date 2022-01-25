package sconelee.board.dto;

import lombok.*;
import sconelee.board.domain.entity.Board;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private String author;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    @Builder
    public BoardDto(Long id, String author, String title, String content, LocalDateTime createDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }

    public Board toEntity(){
        Board build = Board.builder()
                .id(id)
                .author(author)
                .title(title)
                .content(content)
                .build();

        return build;
    }


}
