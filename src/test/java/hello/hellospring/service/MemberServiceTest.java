package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    private MemberService memberService;
    private MemoryMemberRepository memberRepository;

    @BeforeEach
    void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join() {
        Member member = new Member();
        member.setName("spring1");

        Long saveId = memberService.join(member);

        Member findMember = memberService.member(saveId).get();

        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void duplicateMemberException() {
        Member member1 = new Member();
        Member member2 = new Member();

        member1.setName("spring1");
        member2.setName("spring1");

        memberService.join(member1);
        IllegalStateException error = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertThat(error.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    void members() {
    }

    @Test
    void member() {
    }
}