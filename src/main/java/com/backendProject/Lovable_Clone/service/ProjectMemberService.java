package com.backendProject.Lovable_Clone.service;

import com.backendProject.Lovable_Clone.dto.member.InviteMemberRequest;
import com.backendProject.Lovable_Clone.dto.member.MemberResponse;
import com.backendProject.Lovable_Clone.dto.member.UpdateMemberRoleRequest;

import java.util.List;

public interface ProjectMemberService {
    List<MemberResponse> getProjectMembers(Long projectId, Long userId);

    MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId);

    MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId);

    void removeProjectMember(Long projectId, Long memberId, Long userId);
}
