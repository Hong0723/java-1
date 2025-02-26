public interface IColliding { // IColliding 인터페이스는 충돌 검사를 위한 메소드를 정의
    boolean collideWith(Block other); // 다른 블록과의 충돌 여부를 확인하는 메소드
}
