/**
 * Created by IntelliJ IDEA.
 * User: LiuWenqi
 * Date: 2017-12-04
 * Time: 08:47
 * Description:
 */
package com.example.jpa.service.impl;

import com.example.jpa.dao.CommentRepository;
import com.example.jpa.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;
}
