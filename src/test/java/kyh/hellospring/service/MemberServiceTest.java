package kyh.hellospring.service;

import kyh.hellospring.domain.Member;
import kyh.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class MemberServiceTest {

    MemberService          memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring1");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberRepository.findById(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복회원예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        Member member2 = new Member();
        member2.setName("spring1");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> {
            memberService.join(member2);
        });

        assertThat(e.getMessage()).isEqualTo("Already Exists Member");

    }

    @Test
    void 멤버들찾기() {
    }

    @Test
    void 한멤버찾기() {
    }
}