# 재고 관리 시스템

재고(Item) 관리 시스템을 구축하고자 합니다.
주요 기능은 다음과 같습니다.

- item 등록
    - item은 각자의 name을 가지고 있습니다.
    - 한 item은 0 ~ 무한 개의 재고를 가질 수 있습니다.
- item 재고 추가
    - 한 요청에 여러개 가능합니다
- item 재고 소비
    - 한 요청에 여러개 소비가 가능합니다.
    - 만약 재고가 없으면 적절한 예외를 처리해야 합니다.
- item 조회
    - 전체 목록 조회가 가능합니다.
    - ID를 통한 단일 조회가 가능해야 합니다
- item 삭제
    - ID를 통한 삭제가 가능해야 합니다.

## 진행 방법

fork 한 후 해당 repo에 pull request 보내주세요!

## 참고

- 모든 요청에 **concurrency problem** 이 없어야 합니다.
- Scale out 과 scale up에 대한 고려를 해야합니다.
- 해당 프로젝트의 구조는 변경이 가능합니다.
- base code에서 필드 및 로직을 추가하셔도 됩니다.
- 프로젝트의 Entity는 예시이며 수정이 가능합니다.
- 다음 기술스택에서 변경하지 않는 선에서 라이브러리 추가가 가능합니다.
    - java 21
    - springboot 3
    - mysql 8
- Application에 대한 단위/통합 테스트는 자유롭게 가능합니다. 단, 동시성을 테스트 하기 위한 방법을 마련해야 합니다.

```java
ItemDecreaseService.java

@Transactional
public void decrease() {
  final Item item = itemRepository.findById(1L)
          .orElseThrow();
  item.decrease(1L);
}
```
- 해당 코드는 동시성 문제가 발생할 여지가 있습니다.