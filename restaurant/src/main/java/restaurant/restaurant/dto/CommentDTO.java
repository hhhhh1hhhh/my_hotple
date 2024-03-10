package restaurant.restaurant.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import restaurant.restaurant.entity.CommentEntity;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CommentDTO {
    private int id;
    private String commentWriter;
    private String commentContents;
    private int myplaceId;
    private LocalDateTime commentCreatedTime;

    public static CommentDTO toCommentDTO(CommentEntity commentEntity, Integer myplaceId) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(commentEntity.getId());
        commentDTO.setCommentWriter(commentEntity.getCommentWriter());
        commentDTO.setCommentContents(commentEntity.getCommentContents());
        commentDTO.setCommentCreatedTime(commentEntity.getCreatedTime());
//        commentDTO.setMyplaceId(commentEntity.getMyplaceEntity().getId());
        commentDTO.setMyplaceId(myplaceId);

        return commentDTO;
    }
}
