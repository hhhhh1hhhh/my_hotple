package restaurant.restaurant.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import restaurant.restaurant.dto.CommentDTO;

@Entity
@Getter
@Setter
@Table(name = "comment_table")
public class CommentEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 20, nullable = false)
    private String commentWriter;

    private String commentContents;

    /* Myplace:Comment = 1:N */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "myplace_id")
    private MyplaceEntity myplaceEntity;

    public static CommentEntity toSaveEntity(CommentDTO commentDTO, MyplaceEntity myplaceEntity) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setCommentWriter(commentDTO.getCommentWriter());
        commentEntity.setCommentContents(commentDTO.getCommentContents());
        commentEntity.setMyplaceEntity(myplaceEntity);

        return commentEntity;
    }
}
