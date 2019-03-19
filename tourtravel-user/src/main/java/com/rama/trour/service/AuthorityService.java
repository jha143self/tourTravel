package com.rama.trour.service;

import org.springframework.data.domain.Sort;

import com.rama.trour.model.Authority;

import java.util.List;

/**
 * @author Rakesh Jha
 */
public interface AuthorityService {

    Authority findByAuthority(String authority);

    List<Authority> getAuthorityList(int page, int size, Sort.Direction sort);

    Authority create(Authority authority);

    Authority update(Authority authority);

    void delete(Long authorityId);
}
