package hello.core.member;

public interface MemberService {

    void joint(Member member);

    Member findMember(Long memberId);
}
