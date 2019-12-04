package com.pg.vhrpg.service;

import com.pg.vhrpg.entity.Hr;
import com.pg.vhrpg.mapper.HrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: HrService
 * @Description:
 * @Author: pg
 * @Date: 2019/12/3 14:04
 * @Version: 1.0
 **/
@Service
@Transactional
public class HrService implements UserDetailsService {
    @Autowired
    private HrMapper hrMapper;

    public Hr findById(Hr hr) {
       return hrMapper.findOneByHrId(hr.getId());
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadHrByUserName(userName);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名错误！");
        }
        return hr;
    }
}
