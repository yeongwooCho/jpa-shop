package com.jpabook.jpashop.api;


import com.jpabook.jpashop.api.dto.CreateMemberRequest;
import com.jpabook.jpashop.api.dto.CreateMemberResponse;
import com.jpabook.jpashop.api.dto.UpdateMemberRequest;
import com.jpabook.jpashop.domain.Member;
import com.jpabook.jpashop.service.MemberService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/api/v1/members")
    public CreateMemberResponse saveMemberV1(@RequestBody @Valid Member member) {
        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    @PostMapping("/api/v2/members")
    public CreateMemberResponse saveMemberV2(@RequestBody @Valid CreateMemberRequest request) {
        Member member = new Member();
        member.setName(request.getName());
        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

}
