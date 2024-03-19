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
    private String commentWriterEmail;
    private String commentContents;
    private int myplaceId;
    private LocalDateTime commentCreatedTime;
    private LocalDateTime commentUpdatedTime;
    private String placeName;

    public static CommentDTO toCommentDTO(CommentEntity commentEntity, Integer myplaceId) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(commentEntity.getId());
        commentDTO.setCommentWriter(commentEntity.getCommentWriter());
        commentDTO.setCommentWriterEmail(commentEntity.getCommentWriterEmail());
        commentDTO.setCommentContents(commentEntity.getCommentContents());
        commentDTO.setCommentCreatedTime(commentEntity.getCreatedTime());
        commentDTO.setCommentUpdatedTime(commentEntity.getUpdatedTime());
//        commentDTO.setMyplaceId(commentEntity.getMyplaceEntity().getId());
        commentDTO.setMyplaceId(myplaceId);

        return commentDTO;
    }

    public static CommentDTO toCommentDTO2(CommentEntity commentEntity, String commentWriterEmail) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(commentEntity.getId());
        commentDTO.setCommentWriter(commentEntity.getCommentWriter());
        commentDTO.setCommentWriterEmail(commentEntity.getCommentWriterEmail());
        commentDTO.setCommentContents(commentEntity.getCommentContents());
        commentDTO.setCommentCreatedTime(commentEntity.getCreatedTime());
        commentDTO.setCommentUpdatedTime(commentEntity.getUpdatedTime());
        commentDTO.setMyplaceId(commentEntity.getMyplaceEntity().getId());
        commentDTO.setPlaceName(commentEntity.getMyplaceEntity().getPlaceName());
//        commentDTO.setMyplaceId(myplaceId);

        return commentDTO;
    }
}
