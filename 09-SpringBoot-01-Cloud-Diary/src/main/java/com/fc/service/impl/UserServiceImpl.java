package com.fc.service.impl;

import com.fc.dao.TbUserMapper;
import com.fc.entity.TbUser;
import com.fc.entity.TbUserExample;
import com.fc.service.UserService;
import com.fc.util.FileUploadUtil;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TbUserMapper userMapper;

    @Override
    public ResultVO login(String username, String password) {
        ResultVO resultVO = null;

        TbUserExample tbUserExample = new TbUserExample();

        TbUserExample.Criteria criteria = tbUserExample.createCriteria();

        criteria.andUsernameEqualTo(username);

        List<TbUser> users = userMapper.selectByExample(tbUserExample);

        if (users != null && !users.isEmpty()) {
            if (users.get(0).getPassword().equals(password)) {
                resultVO = new ResultVO(200, "登录成功", true, users.get(0));
            } else {
                resultVO = new ResultVO(0, "登录失败", false, null);
            }
        }
        return resultVO;
    }

    @Override
    public Integer chekNick(String nick) {
        TbUserExample tbUserExample = new TbUserExample();

        TbUserExample.Criteria criteria = tbUserExample.createCriteria();

        criteria.andNickEqualTo(nick);

        List<TbUser> tbUsers = userMapper.selectByExample(tbUserExample);

        return tbUsers.size();
    }

    @Override
    public ResultVO update(MultipartFile img, TbUser user) {
        ResultVO resultVO = new ResultVO();

        String fileName = null;

        if (!img.isEmpty() && img != null) {
            fileName = FileUploadUtil.fileUpload(img);
            if (!fileName.equals("") && fileName != null) {
                user.setHead(fileName);
            }else {
                resultVO.setCode(0);
                resultVO.setSuccess(false);
                resultVO.setMessage("头像上传失败");
                return resultVO;
            }
        }

        int rows = userMapper.updateByPrimaryKeySelective(user);

        if (rows > 0) {
            resultVO.setCode(1);
            resultVO.setMessage("更新个人信息成功！");

            user = userMapper.selectByPrimaryKey(user.getId());

            resultVO.setData(user);
        } else {
            resultVO.setMessage("头像上传成功，但是修改失败");
            resultVO.setCode(0);
            resultVO.setSuccess(false);
        }

        return resultVO;
    }
}
