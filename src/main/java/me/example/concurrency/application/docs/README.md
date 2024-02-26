처음에는 기존에 optimized lock와 동일하게 callback으로 진행하려 했으나, 트랜젝션 전파수준이 달라서 실패 <br>

결국 Facade 패턴으로 구현하였다. <br>
service 단을 인터페이스로 미리 빼놨으면 코드 수정이 더 용이하고, 중복이 더 적었을 것 같은데,  <br>
일단은 그런 부분이 중요한 것이 아니니 패스 <br>

# Named Lock
고유한 이름으로 식별되는 잠금<br>
row나 table 단위로 락을 거는 passimistic lock과 달리, named lock은 metadata 단위로 락을 적용한다.<br>
mysql 레벨에서 지원 (native query) 즉, 추가 SW나 라이브러리가 필요 없고, mysql 서버 메모리에서 동작하기에 빠르나,<br>
user 측에서 락을 직접 관리해야한다는 부담이 있다.<br>
<br>
GET_LOCK 과 RELEASE_LOCK 을 통해 락을 잠금 및 해제한다.<br>
named lock 사용 시 propergation을 별도로 설정해주어야 하는데, <br>
부모의 트랜젝션과 동일한 범위로 묶인다면 DB에 commit 되기 전에 락이 풀리는 상황이 발생할 수 있다. <br>
따라서 메인 로직에는 REQUIRED_NEW를 설정하여 별도 트랜젝션으로 분리하는 것이 중요하다. <br>
