import java.util.List;
public class BlockEvent {
 
    private String name; // 블록 이름 
    private BlockType type; // 블록 타입
    private List<String> actions; // 블록 관련 액션 목록

    // 생성자
    public BlockEvent(String name, BlockType type, List<String> actions) { 
        this.name = name;
        this.type = type;
        this.actions = actions;
    }


    public String getName() { // 블록 이름 반환 메소드
        return this.name;
    }

    public void setName(String name) { // 블록 이름 설정 메소드
        this.name = name;
    }

    public BlockType getType() { // 블록 타입 반환 메소드
        return this.type;
    }

    public void setType(BlockType type) { // 블록 타입 설정 메소드
        this.type = type;
    }

    public List<String> getActions() { // 액션 목록 반환 메소드
        return this.actions;
    }

    public void setActions(List<String> actions) { // 액션 목록 설정 메소드
        this.actions = actions;
    }

    // 객체의 문자열 표현을 반환하는 메소드
    @Override
    public String toString() {
        String typestr = (type == null) ? "null" : type.name();
        String actionstr = (actions == null) ? "null" : String.join(", ", actions);
        return "{name='" + name + "', type = '" + typestr + "', actions='" + actionstr + "'}";    
    }
    
}
