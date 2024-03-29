package kyh.hellospring.repository;

import kyh.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {

        //given
        Member member = new Member();
        member.setName("HNG");

        //when
        repository.save(member);

        //then
        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findByName() {
        Member member = new Member();
        member.setName("hng");
        repository.save(member);

        Member member2 = new Member();
        member2.setName("hng2");
        repository.save(member2);


        Optional<Member> hng    = repository.findByName("hng");
        Member           result = hng.get();

        assertThat(result).isEqualTo(member);

    }

    @Test
    public void findAll() {
        Member member = new Member();
        member.setName("hng");
        repository.save(member);

        Member member2 = new Member();
        member2.setName("hng2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }

}
