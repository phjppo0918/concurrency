synchronized를 적용했음에도 불구하고, increase와 decrease에는 동시성 문제를 해결하지 못한다.

원인은 @Transactional 에 있다.

해당 에너테이션을 붙이면 스프링에서는 AOP를 이용해 아예 새로운 클래스에서 매서드를 새로 선언하여 구현하기에
synchronized가 적용되지 않는 것이다.

만약 재고 개수 변동 메서드에 synchronized를 사용하려면 @Transactional를 지운 후 별도 저장하는 로직을 추가하여 구현해야 할 것이다.