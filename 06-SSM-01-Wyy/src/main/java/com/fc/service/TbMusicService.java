package com.fc.service;

import com.fc.entity.TbMusic;

import java.util.List;

public interface TbMusicService {

    TbMusic findById(Integer id);

    TbMusic nextSong(Integer id);

    TbMusic prevSong(Integer id);

    List<TbMusic> search(String keyword);

    List<TbMusic> findAll();
}
