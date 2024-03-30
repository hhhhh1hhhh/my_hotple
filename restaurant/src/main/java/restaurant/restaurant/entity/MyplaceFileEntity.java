package restaurant.restaurant.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="myplace_file_entity")
public class MyplaceFileEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String originalFileName;

    @Column
    private String storedFileName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "myplace_id")
    private MyplaceEntity myplaceEntity;

    public static MyplaceFileEntity toMyplaceFileEntity(MyplaceEntity myplaceEntity, String originalFileNamemm, String storedFileName) {
        MyplaceFileEntity myplaceFileEntity = new MyplaceFileEntity();
        myplaceFileEntity.setOriginalFileName(originalFileNamemm);
        myplaceFileEntity.setStoredFileName(storedFileName);
        myplaceFileEntity.setMyplaceEntity(myplaceEntity);

        return myplaceFileEntity;
    }

}