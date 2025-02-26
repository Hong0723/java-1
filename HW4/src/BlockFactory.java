public class BlockFactory { // 블록 생성하는 클래스(메소드 포함) -> 블록빌더

    private BlockFactory() { } // 정적멤버만 존재하므로 private 생성자 사용
    public static Block getInstance(BlockType type, double x, double y) { // 주어진 블록 타입과 좌표에 따라 적절한 블록 인스턴스를 반환하는 정적 메소드
        return switch (type) {  // 타입에 따른 인스턴스 생성
            case RED_BLOCK -> new RedBlock(x, y); 
            case TEAL_BLOCK -> new TealBlock(x, y);
            case DOGERS_BLUE_BLOCK -> new DogersBlueBlock(x, y);
            case YELLOW_BLOCK -> new YellowBlock(x, y);
            case ORANGE_BLOCK -> new OrangeBlock(x, y);
            case PURPLE_BLOCK -> new PurpleBlock(x, y);
            case GREEN_BLOCK -> new GreenBlock(x, y);
            default -> null; // 위에 명시된 타입이 아닐 경우 null을 반환
        }; 
    }
}