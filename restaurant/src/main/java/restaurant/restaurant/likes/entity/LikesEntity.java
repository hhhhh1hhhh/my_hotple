package restaurant.restaurant.likes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import restaurant.restaurant.user.entity.UserEntity;
import restaurant.restaurant.myplace.entity.MyplaceEntity;

@Entity
@Getter
@Setter
@Table(name = "like_entity")
public class LikesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "myplaceId", referencedColumnName = "id")
    private MyplaceEntity myplace;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private UserEntity user;


    public void setMyplaceId(int myplaceId) {
        this.myplace = new MyplaceEntity();
        this.myplace.setId(myplaceId);
    }

    public void setUserId(int userId) {
        this.user = new UserEntity();
        this.user.setId(userId);
    }

}
