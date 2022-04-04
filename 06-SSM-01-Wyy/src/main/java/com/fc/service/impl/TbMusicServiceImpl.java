package com.fc.service.impl;

import com.fc.dao.TbMusicMapper;
import com.fc.entity.TbMusic;
import com.fc.entity.TbMusicExample;
import com.fc.service.TbMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbMusicServiceImpl implements TbMusicService {
    // 声明dao层接口
    @Autowired
    private TbMusicMapper musicMapper;

    @Override
    public TbMusic findById(Integer id) {
        return musicMapper.selectByPrimaryKey(id);
    }

    @Override
    public TbMusic nextSong(Integer id) {
        int max = musicMapper.findMaxId();

        if (max != id) {
            id ++;
        }else{
            id = musicMapper.findMinId();
        }

        return musicMapper.selectByPrimaryKey(id);
    }

    @Override
    public TbMusic prevSong(Integer id) {

        if (!id.equals(musicMapper.findMinId())){
            id --;
        }else {
            id = musicMapper.findMaxId();
        }

        return musicMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TbMusic> search(String keyword) {
        TbMusicExample tbMusicExample = new TbMusicExample();

        TbMusicExample.Criteria criteria = tbMusicExample.createCriteria();

        criteria.andMusicAlbumNameLike("%" + keyword + "%");

        return musicMapper.selectByExample(tbMusicExample);
    }

    @Override
    public List<TbMusic> findAll() {
        // 不带条件查询全部
        return musicMapper.selectByExample(null);
    }
}
