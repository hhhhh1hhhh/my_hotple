package restaurant.restaurant.dto;

import lombok.Getter;
import lombok.Setter;
import restaurant.restaurant.entity.LikesEntity;
import restaurant.restaurant.entity.MyplaceEntity;
import restaurant.restaurant.entity.MyplaceFileEntity;
import restaurant.restaurant.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class LikesDTO {
    private int id;
    private int myplaceId;
    private int userId;

    private MyplaceEntity myplaceEntity;
}
