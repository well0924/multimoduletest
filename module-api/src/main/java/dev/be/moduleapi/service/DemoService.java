package dev.be.moduleapi.service;

import dev.be.moduleapi.Exception.CustomException;
import dev.be.modulecommon.domain.Member;
import dev.be.modulecommon.enums.CodeEnum;
import dev.be.modulecommon.repository.MemberRepository;
import dev.be.modulecommon.service.CommonDemoService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DemoService {

    private final CommonDemoService commonDemoService;
    private final MemberRepository memberRepository;

    public String save(){
        memberRepository.save(Member
                .builder()
                .name(Thread.currentThread().getName())
                .build());
        System.out.println(CodeEnum.SUCCESS.getCode());
        System.out.println(CodeEnum.SUCCESS.getMessage());
        System.out.println(commonDemoService.commonService());
        return "save";
    }

    public String find(){
        int size =memberRepository.findAll().size();
        System.out.println("db size:"+size);
        return "find";
    }

    public String handleCustomException() {
        if (true) {
            System.out.println("Throw CustomException");
            throw new CustomException(CodeEnum.ERROR_CODE);
        }

        return "exception";
    }
}
