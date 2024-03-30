package restaurant.restaurant.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restaurant.restaurant.repository.MyplaceFileRepository;

import java.io.File;

@Service
@RequiredArgsConstructor
public class MyplaceFileService {

    private final MyplaceFileRepository myplaceFileRepository;

    public void deleteFileByOriginalFileName(String originalFileName) {
        // 여기에 실제 파일 삭제 또는 파일 정보 삭제 작업을 수행하는 코드를 작성합니다.
        // 예시: 파일 시스템에서 파일 삭제
         File fileToDelete = new File("/path/to/your/files/" + originalFileName);
         if (fileToDelete.exists()) {
             fileToDelete.delete();
         }

        // 예시: 데이터베이스에서 파일 정보 삭제
         myplaceFileRepository.deleteByOriginalFileName(originalFileName);
    }
}
