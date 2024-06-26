package hello.hellospring.domain;

public class Member {

    private Long id; // 임의의 값 (시스템이 저장한 값) = 고유
    private String name; // 이름

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}