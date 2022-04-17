package kyh.hellospring.repository;

import kyh.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //공통화 불가능
    //규칙에 findBy{col명}을 사용하면,
    //JPQL select m from Member m where m.name = ?
    //로 자동 생성됨
    @Override
    Optional<Member> findByName(String name);
}
