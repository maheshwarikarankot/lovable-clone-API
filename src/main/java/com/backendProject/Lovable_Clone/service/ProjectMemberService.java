package com.backendProject.Lovable_Clone.service;

import com.backendProject.Lovable_Clone.dto.member.InviteMemberRequest;
import com.backendProject.Lovable_Clone.dto.member.MemberResponse;
import com.backendProject.Lovable_Clone.entity.ProjectMember;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface ProjectMemberService {
    List<ProjectMember> getProjectMembers(Long projectId, Long userId);

    MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId);

    MemberResponse updateMemberRole(Long projectId, Long memberId, InviteMemberRequest request, Long userId);

    MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId);
}
