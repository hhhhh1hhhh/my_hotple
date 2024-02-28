package restaurant.restaurant.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restaurant.restaurant.dto.MyplaceDTO;
import restaurant.restaurant.entity.MyplaceEntity;
import restaurant.restaurant.repository.MyplaceRepository;

@Service
@RequiredArgsConstructor
public class MyplaceService {

    private final MyplaceRepository myplaceRepository;

    public void save(MyplaceDTO myplaceDTO) {
        MyplaceEntity myplaceEntity = MyplaceEntity.toSaveEntity(myplaceDTO);
        myplaceRepository.save(myplaceEntity);
    }
}
