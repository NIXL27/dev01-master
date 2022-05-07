package com.fc.service.impl;

import com.fc.dao.MessageBoardMapper;
import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.service.MessageBoardService;
import com.fc.vo.DataVO;
import com.fc.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MessageBoardServiceImpl implements MessageBoardService {

    @Autowired
    private MessageBoardMapper messageBoardMapper;

    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize, String id) {
        ResultVO resultVO = null;
        List<MessageBoardWithBLOBs> messageBoards = new ArrayList<>();
        MessageBoardWithBLOBs messageBoard;
        try {
            if (id != null) {
                messageBoard = messageBoardMapper.selectByPrimaryKey(Long.parseLong(id));
                if (messageBoard != null) {
                    messageBoards.add(messageBoard);
                }
            }else {
                PageHelper.startPage(pageNum, pageSize);
                messageBoards = messageBoardMapper.selectByExampleWithBLOBs(null);
            }

            PageInfo<MessageBoardWithBLOBs> pageInfo = new PageInfo<>(messageBoards);
            DataVO dataVO = new DataVO(pageInfo.getTotal(), messageBoards, pageInfo.getPageNum(), pageInfo.getPageSize());
            resultVO = new ResultVO("查询成功", 200, true, dataVO);


        }catch (Exception e) {
            resultVO = new ResultVO("查询失败", -100, false, new DataVO());
        }

        return resultVO;
    }

    @Override
    public ResultVO insert(MessageBoardWithBLOBs messageBoard) {
        ResultVO resultVO = null;

        if (messageBoard != null) {
            messageBoard.setCreateTime(new Date());
        }

        int rows = messageBoardMapper.insertSelective(messageBoard);

        if (rows > 0) {
            resultVO = new ResultVO("添加成功", 200, true, messageBoard);
        }else {
            resultVO = new ResultVO("添加失败", -100, false, new DataVO());
        }
        return resultVO;
    }

    @Override
    public ResultVO delete(Long id) {
        ResultVO resultVO = null;

        int rows = messageBoardMapper.deleteByPrimaryKey(id);

        if (rows > 0) {
            resultVO = new ResultVO("删除成功", 200, true, new DataVO());
        }else {
            resultVO = new ResultVO("删除失败", -100, false, new DataVO());
        }

        return resultVO;
    }

}
